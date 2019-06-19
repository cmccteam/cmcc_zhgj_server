package com.cmcc.qualification.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cmcc.qualification.entity.FileStore;


@Mapper
public interface FileStoreDao {
    int deleteByPrimaryKey(String fileId);

    int insert(FileStore record);

    int insertSelective(FileStore record);

    FileStore selectByPrimaryKey(String fileId);

    int updateByPrimaryKeySelective(FileStore record);

    int updateByPrimaryKey(FileStore record);

    /**
     * 批量插如图片信息
     * @param listFileStore
     * @return
     */
	Boolean insertObj(List<FileStore> listFileStore);
}