package com.cmcc.common.service;

import com.cmcc.common.bean.Result;
import com.cmcc.common.bean.ResultCode;
import com.cmcc.common.dao.FileStoreDao;
import com.cmcc.common.entity.FileStore;
import com.cmcc.common.utils.IdGenerateUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
public class FileStoreService {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Environment env;
    @Autowired
    private FileStoreDao fileStoreDao;

    @Transactional
    public Result uploadFile(MultipartFile file) {
        //上传文件名
        String oldName = file.getOriginalFilename();
        String suffix = getFileSuffix(oldName);
        String nowName = IdGenerateUtil.uuid2() + suffix;

        String path = env.getProperty("cmcc.file.path");
        String url = path + nowName;
        File nowfile = new File(url);
        try {
            //判断路径是否存在，如果不存在就创建一个
            if (!nowfile.getParentFile().exists()) {
                nowfile.getParentFile().mkdirs();
            }
            file.transferTo(nowfile);

            //保存数据到库表
            FileStore store = new FileStore();
            store.setFileId(IdGenerateUtil.uuid3());
            store.setFileType(getFileSuffixs(oldName));
            store.setFileName(nowName);
            store.setFileOldName(oldName);
            store.setFileUrl("");
            store.setFileAddr(url);
            store.setFileSize(Long.toString(file.getSize()));
            store.setFileSuffix(getFileSuffixs(oldName));
            store.setSendTime(new Date());
            store.setStatus("0");
            store.setDelFlag("0");
            fileStoreDao.insertSelective(store);
            return Result.success(store);
        } catch (IllegalStateException e) {
            log.error("" + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            log.error("文件读取异常，" + e.getMessage());
            e.printStackTrace();
        }
        return Result.failure(ResultCode.PARAM_FILE_IOEX);
    }

    private String getFileSuffix(String fileName) {
        String suffix = "";
        if (StringUtils.isNotBlank(fileName)) {
            suffix = fileName.substring(fileName.lastIndexOf("."));
        }
        return suffix;
    }

    private String getFileSuffixs(String fileName) {
        String suffix = "";
        if (StringUtils.isNotBlank(fileName)) {
            suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        return suffix;
    }
}
