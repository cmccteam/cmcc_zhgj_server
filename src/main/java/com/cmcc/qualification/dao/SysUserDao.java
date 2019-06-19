package com.cmcc.qualification.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cmcc.qualification.entity.SysUser;
import com.cmcc.qualification.vo.UserInfoVo;


/**
 * 系统用户dao接口
 * @author Administrator
 *
 */
@Mapper
public interface SysUserDao {
    int deleteByPrimaryKey(String userId);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    /**
     * 根据用户姓名查询用户
     * @param userName
     * @param userPinyin 
     * @return
     */
	Map<String, String> selectByUserName(String userNameAndPinyin);

	/**
	 * 查询人员列表
	 * @return
	 */
	List<UserInfoVo> selectAllSysUsers();

	/**
	 * 根据用户id查询用户信息
	 * @param userId
	 * @return
	 */
	Map<String, Object> selectUserinfoByUserId(String userId);
}