package com.cmcc.qualification.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cmcc.qualification.dao.FileStoreDao;
import com.cmcc.qualification.service.FileStoreService;


@Service
public class FileStoreServiceImpl implements FileStoreService{
	
	@Autowired
	private FileStoreDao fileStoreDao;

	@Override
	public Integer delPic(String fileId) {
		return fileStoreDao.deleteByPrimaryKey(fileId);
	}

}
