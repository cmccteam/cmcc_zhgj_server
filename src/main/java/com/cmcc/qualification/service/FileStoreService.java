package com.cmcc.qualification.service;

/**
 * 文件存储管理业务层
 * @author Administrator
 *
 */
public interface FileStoreService {

	/**
	 * 根据图片id删除对应图片
	 * @param fileId 文件或图片id
	 * @return
	 */
	Integer delPic(String fileId);
	
	
	
	
}
