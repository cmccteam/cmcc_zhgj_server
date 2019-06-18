package com.cmcc.common.dao;

import org.apache.ibatis.annotations.Mapper;

import com.cmcc.common.entity.FileStore;

@Mapper
public interface FileStoreDao {
    int deleteByPrimaryKey(String fileId);

    int insert(FileStore record);

    int insertSelective(FileStore record);

    FileStore selectByPrimaryKey(String fileId);

    int updateByPrimaryKeySelective(FileStore record);

    int updateByPrimaryKey(FileStore record);
}