package com.study.study_springboot_security.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.study.study_springboot_security.daos.SharedDao;
import java.util.Map;
public class MemberWithAuthorityService {

    @Autowired
    SharedDao sharedDao;

    @Autowired
    com.study.study_springboot_security.utils.CommonUtils CommonUtils;

    public Object insert(Object dataMap){
        String sqlMapId = "Memberwithauthority.insertWithUID";
        ((Map)dataMap).put("USER_UID", CommonUtils.getUniqueSequence());
        ((Map)dataMap).put("role", "ROLE_USER"); // 실제로 보면 정해져있는 값이 아니다. 
        Object result = sharedDao.insert(sqlMapId, dataMap);
        return result;
    }
}