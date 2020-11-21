package com.example.photo.initate;

import com.example.photo.ResponseUtil;
import com.example.photo.bean.User_Info;
import com.example.photo.mapper.UserInfo_Repository;
import com.example.photo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户信息操作类
 */
@Service
public class Info {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserInfo_Repository userInfo_repository;
    public Object hrsign_change(String id_unique, String hr_sign) {
        User_Info user_info = userMapper.id_unique_userInfo(id_unique);
        if (user_info!=null){
            user_info.setHr_sign(hr_sign);
            userInfo_repository.save(user_info);
            return ResponseUtil.ok("操作成功");

        }else {
            return ResponseUtil.fail(402,"无此用户");
        }
    }
}
