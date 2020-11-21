package com.example.photo.initate;

import com.example.photo.ResponseUtil;
import com.example.photo.bean.init.UserBean;
import com.example.photo.bean.User_Info;
import com.example.photo.mapper.UserInfo_Repository;
import com.example.photo.mapper.UserMapper;
import com.example.photo.bean.User;
import com.example.photo.mapper.User_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * 注册-登录-完善信息封装
 */

@Service
public class Reg_Login {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private User_Repository user_repository;
    @Autowired
    private UserInfo_Repository userInfo_repository;
    //注册
    public Object register(String phone,String password) {//todo 可能造成id_unique重名
        try {
            User existUser = userMapper.findUserByPhone(phone);
            if (existUser != null) {
                //如果用户手机号存在
                User_Info user_info = userMapper.id_unique_userInfo(1+phone.substring(phone.length()-6));
                if (user_info!=null){
                    UserBean userBean = new UserBean(existUser,user_info);
                    return ResponseUtil.fail(401,"用户已存在",userBean);
                }else {
                    return ResponseUtil.fail(403,"信息混乱");
                }
            } else {
                //登录注册表
                User user = new User();
                user.setPhone(phone);
                user.setPassword(password);
                user.setId_unique(1+phone.substring(phone.length()-6));
                //用户信息表
                User_Info user_info = new User_Info();
                user_info.setId_unique(user.getId_unique());
                user_info.setHead_url("http://114.55.249.135:8888/touxiang/a.png");
                user_info.setName(user.getId_unique());
//                user_info.setHr_sign();默认主页标识
                //将数据存入数据库
                build_user(user,user_info);
                //封装数据
                UserBean userBean = new UserBean(user,user_info);

                return ResponseUtil.ok("注册成功",userBean);

            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.fail(404,e.getMessage());
        }
    }
    @Transactional//要么都成功，要么都失败
    void build_user(User user, User_Info user_info) {
        user_repository.save(user);
        userInfo_repository.save(user_info);
    }

    //登录
    public Object login(String phone, String password) {
        try {
            User existUser = userMapper.login(phone,password);
            if (existUser == null) {
                return ResponseUtil.fail(405,"用户名或密码错误");

            } else {
                User_Info user_info = userMapper.id_unique_userInfo(1+phone.substring(phone.length()-6));
                if (user_info!=null){//有数据
                    UserBean userBean = new UserBean(existUser,user_info);
                    return ResponseUtil.ok("登录成功",userBean);
                }else {
                    return ResponseUtil.fail(403,"信息混乱");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.fail(404,e.getMessage());

        }
    }
    //修改密码
    public Object amend(String phone, String password) {
        User existUser = userMapper.findUserByPhone(phone);
        if (existUser != null){
            existUser.setPassword(password);
            user_repository.save(existUser);
            return ResponseUtil.ok("修改成功",existUser);

        }else {
            return ResponseUtil.fail(402,"无此用户");
        }
    }
}
