package com.cmcc.qualification.service.impl;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cmcc.common.bean.BaseUser;
import com.cmcc.common.service.SystemService;
import com.cmcc.common.utils.IdGenerateUtil;
import com.cmcc.common.utils.Sort;
import com.cmcc.qualification.dao.FileStoreDao;
import com.cmcc.qualification.dao.ProCompanyUserDao;
import com.cmcc.qualification.dao.ProPertificateDao;
import com.cmcc.qualification.dao.ProProjectUserDao;
import com.cmcc.qualification.dao.SysUserDao;
import com.cmcc.qualification.entity.FileStore;
import com.cmcc.qualification.entity.ProCompanyUser;
import com.cmcc.qualification.entity.ProPertificate;
import com.cmcc.qualification.entity.ProProjectUser;
import com.cmcc.qualification.entity.SysUser;
import com.cmcc.qualification.service.PersonalQualificationService;
import com.cmcc.qualification.vo.SysUserVo;
import com.cmcc.qualification.vo.UserInfoVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 资质信息业务层实现类
 * @author Administrator
 *
 */
@Service("personalQualificationService")
public class PersonalQualificationServiceImpl implements PersonalQualificationService{
	
	@Autowired
	private SysUserDao sysUserDao;
	
	@Autowired
	private ProPertificateDao proPertificateDao;
	
	@Autowired
	private ProProjectUserDao proProjectUserDao;
	
	@Autowired
	private FileStoreDao fileStoreDao;
	
	@Autowired
	private ProCompanyUserDao proCompanyUserDao;
	
	@Autowired
	private SystemService systemService;
	
	private Logger log =  LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Map<String, String> getList(String userNameAndPinyin) {
		return sysUserDao.selectByUserName(userNameAndPinyin);
	}

	@Override
	public SysUserVo getUserinfo(String userId) {
		SysUserVo sysUserVo = new SysUserVo();
		Map<String, Object> userInfo = sysUserDao.selectUserinfoByUserId(userId);
		List<ProPertificate> proPertificateList = proPertificateDao.selectAllProPertificateByUserId(userId);
		if (userInfo != null) {
			sysUserVo.setSysUser(userInfo);
		}
		if (proPertificateList.size() > 0) {
			sysUserVo.setProPertificateLists(proPertificateList);
		}
		
		return sysUserVo;
	}

	@Override 
	@Transactional
	public Integer saveUserinfo(UserInfoVo userInfoVo) {
		Integer t = 0;
		if (userInfoVo != null) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			ProProjectUser proProjectUser = new ProProjectUser();
			SysUser sysUser = new SysUser();
			
			if (StringUtils.isNotEmpty(userInfoVo.getPost())) {
				proProjectUser.setPost(userInfoVo.getPost());
			}
            if (StringUtils.isNotEmpty(userInfoVo.getProjectId())) {
            	proProjectUser.setProjectId(userInfoVo.getProjectId());
			}
            if (StringUtils.isNotEmpty(userInfoVo.getUserId())) {
            	proProjectUser.setUserId(userInfoVo.getUserId());
			}
            if (StringUtils.isNotEmpty(userInfoVo.getProjectName())) {
            	proProjectUser.setProjectName(userInfoVo.getProjectName());
            }
            if (StringUtils.isNotEmpty(userInfoVo.getId())) {
            	proProjectUser.setId(userInfoVo.getId());
            }
            
            if (StringUtils.isNotEmpty(userInfoVo.getAvatarUrl())) {
            	sysUser.setAvatarUrl(userInfoVo.getAvatarUrl());
            }
            if (StringUtils.isNotEmpty(userInfoVo.getUserId())) {
            	sysUser.setUserId(userInfoVo.getUserId());
            }
            if (StringUtils.isNotEmpty(userInfoVo.getPostId())) {
            	sysUser.setPostId(userInfoVo.getPostId());
            }
            if (StringUtils.isNotEmpty(userInfoVo.getUserName())) {
            	sysUser.setUserName(userInfoVo.getUserName());
            }
            if (StringUtils.isNotEmpty(userInfoVo.getUserTel())) {
            	sysUser.setUserTel(userInfoVo.getUserTel());
            }
            if (StringUtils.isNotEmpty(userInfoVo.getOrgId())) {
            	sysUser.setOrgId(userInfoVo.getOrgId());
            }
            if (StringUtils.isNotEmpty(userInfoVo.getUserPinyin())) {
            	sysUser.setUserPinyin(userInfoVo.getUserPinyin());
            }
            
            try {
				Date projectTime = dateFormat.parse(userInfoVo.getIntoTime());
				proProjectUser.setIntoTime(projectTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
            /*判断是更新还是插入，用户没有用户id表示新增用户，否则修改*/
            if (StringUtils.isNotBlank(userInfoVo.getUserId())) {
            	sysUserDao.updateByPrimaryKeySelective(sysUser);
            	t = proProjectUserDao.updateByUserId(proProjectUser);
            }else {
            	sysUser.setUserId(IdGenerateUtil.uuid3());
            	if (StringUtils.isNotEmpty(userInfoVo.getPostId())) {
                	sysUser.setPostId(userInfoVo.getPostId());
                }
            	proProjectUser.setId(IdGenerateUtil.uuid3());
            	t = sysUserDao.insertSelective(sysUser);
            	proProjectUser.setUserId(sysUser.getUserId());
            	proProjectUserDao.insertSelective(proProjectUser);
            }
		}
		
		return t;
	}


	@Override
	public Map<String, List<UserInfoVo>> allUserinfo() {
		Map<String, List<UserInfoVo>> resultMap = new HashMap<String, List<UserInfoVo>>();
		List<UserInfoVo> userList  = sysUserDao.selectAllSysUsers();
		if (userList.size() > 0) {
			for (UserInfoVo uInfo : userList) {
				// map中的key是否包含人员首字母，存在则直接添加,否则新建key然后添加进去
				if (resultMap.containsKey(String.valueOf(uInfo.getUserPinyin().charAt(0)).toUpperCase())) {
					resultMap.get(String.valueOf(uInfo.getUserPinyin().charAt(0)).toUpperCase()).add(uInfo);
				}else {
					List<UserInfoVo> tempList = new ArrayList<UserInfoVo>();
					tempList.add(uInfo);
					resultMap.put(String.valueOf(uInfo.getUserPinyin().charAt(0)).toUpperCase(), tempList);
				}
		    }
		 }
		return Sort.sortUser(resultMap);
	}
	
    @Transactional(readOnly = false,rollbackFor = Exception.class)
	@Override
	public Boolean batchImportUsers(String fileName, MultipartFile file) throws Exception {
		
    	boolean notNull = false;
        List<SysUser> userList = new ArrayList<SysUser>();
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new Exception("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if(sheet!=null){
            notNull = true;
        }
    	return null;
	}

	@Override
	public Integer addProPertificate(ProPertificate proPertificate, String userId) {
		String certificateId = IdGenerateUtil.uuid3();
		proPertificate.setCertificateId(certificateId);
		proPertificate.setFkcertId(userId);
		List<FileStore> listFileStore = new ArrayList<FileStore>();
		if (proPertificate.getFileUrl() != null) {
			String[] urls = proPertificate.getFileUrl().split("#");
			for (String url :urls) {
				FileStore fileStore = new FileStore();
				fileStore.setFileId(IdGenerateUtil.uuid3());
				fileStore.setToId(certificateId);
				fileStore.setFileUrl(url);
				fileStore.setFileType("图片");
				fileStore.setSendTime(new Date());
				fileStore.setStatus("0");
				listFileStore.add(fileStore);
			}
		}
		Integer f = proPertificateDao.addProPertificate(proPertificate);
		Boolean flag = false;
		if (listFileStore != null && !listFileStore.isEmpty()) {
			flag = fileStoreDao.insertObj(listFileStore);
		}
		log.info("批量更新图片是否成功："+flag);
		return f;
	}

	@Override
	public Map<String, String> getPersonalQualificationInfo(String certificateId) {
		return proPertificateDao.getPersonalQualificationInfo(certificateId);
	}

	@Override
	public Boolean delPersonalQualificationInfo(String certificateId) {
		return proPertificateDao.delPersonalQuaInfo(certificateId);
	}

	@Override
	public Page<com.cmcc.common.bean.SysUser> getPage(Integer pageNum, Integer pageSize, String orderBy, String companyId,
			BaseUser baseUser) {
		PageHelper.startPage(pageNum,pageSize,orderBy);
		Page<ProCompanyUser> page = proCompanyUserDao.selectPage(companyId);
		List<ProCompanyUser> list = page.getResult();
		List<com.cmcc.common.bean.SysUser> users = systemService.getZhgjUsers(baseUser);
		Page<com.cmcc.common.bean.SysUser> nowPage = new Page<com.cmcc.common.bean.SysUser>();
		for (ProCompanyUser pc : list) {
			for (com.cmcc.common.bean.SysUser user : users) {
				if(pc.getUserId().equals(user.getUserId())){
					nowPage.add(user);
				}
			}
		}
		nowPage.setTotal(page.getTotal());
		nowPage.setPageNum(page.getPageNum());
		nowPage.setPageSize(page.getPageSize());
		nowPage.setPages(page.getPages());
		return nowPage;
	}
	@Override
	public Integer addCpUser(ProCompanyUser proCompanyUser){
		proCompanyUser.setCpUserId(IdGenerateUtil.uuid3());
		return proCompanyUserDao.insertSelective(proCompanyUser);
	}

	@Override
	public Integer updateCpUser(ProCompanyUser proCompanyUser){
		return proCompanyUserDao.updateData(proCompanyUser);
	}

	@Override
	public Integer delCpUser(String comqId,String userId){
		return proCompanyUserDao.deleteData(comqId,userId);
	}
}