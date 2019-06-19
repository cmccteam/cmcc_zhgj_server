package com.cmcc.common.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.cmcc.qualification.entity.ProCompanyQua;
import com.cmcc.qualification.vo.UserInfoVo;


public class Sort {
	
	public static Map<String, List<UserInfoVo>> sortUser(Map<String, List<UserInfoVo>> map){
		Map<String, List<UserInfoVo>> resultMap = new LinkedHashMap<String, List<UserInfoVo>>();
		List<Map.Entry<String,List<UserInfoVo>>> list = new ArrayList<Map.Entry<String,List<UserInfoVo>>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,List<UserInfoVo>>>() {
            //升序排序
            public int compare(Map.Entry<String, List<UserInfoVo>> o1,
            		Map.Entry<String, List<UserInfoVo>> o2) {
                return o1.getKey().toString().compareTo(o2.getKey().toString());
            }
        });
        for (int i = 0; i < list.size(); i++) {  
            resultMap.put(list.get(i).getKey(), list.get(i).getValue()); 
        //    System.out.println("key:"+list.get(i).getKey());
        } 
		return resultMap;
		
	}
	public static Map<String, List<ProCompanyQua>> sortCampany(Map<String, List<ProCompanyQua>> map){
		Map<String, List<ProCompanyQua>> resultMap = new LinkedHashMap<String, List<ProCompanyQua>>();
		List<Map.Entry<String,List<ProCompanyQua>>> list = new ArrayList<Map.Entry<String,List<ProCompanyQua>>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String,List<ProCompanyQua>>>() {
            //升序排序
            public int compare(Map.Entry<String, List<ProCompanyQua>> o1,
            		Map.Entry<String, List<ProCompanyQua>> o2) {
                return o1.getKey().toString().compareTo(o2.getKey().toString());
            }
        });
        for (int i = 0; i < list.size(); i++) {  
            resultMap.put(list.get(i).getKey(), list.get(i).getValue()); 
        //    System.out.println("key:"+list.get(i).getKey());
        } 
		return resultMap;
		
	}

}
