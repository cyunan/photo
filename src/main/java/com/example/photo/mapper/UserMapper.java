package com.example.photo.mapper;



import com.example.photo.bean.UpdateInfo;
import com.example.photo.bean.User;
import com.example.photo.bean.User_Info;
import com.example.photo.bean.art.Article;
import com.example.photo.bean.recommed.HR_ImageArr;
import com.example.photo.bean.vlog.Vlog;
import org.apache.ibatis.annotations.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * mapper的具体表达式
 */
@Component
@ConfigurationProperties(prefix = "limit")

@Mapper // 添加了@Mapper注解之后这个接口在编译时会生成相应的实现类
@Repository
public interface UserMapper {
    /**
     * user
     * @param phone 手机号码
     * @return
     */
    @Select(value = "select * from user u where u.phone=#{phone}")
    User findUserByPhone(@Param("phone") String phone);
    /**
     * user
     * 登录
     * @param phone 手机号码
     * @param password 手机号码
     * @return
     *
     */
    @Select("select * from user u where u.phone = #{phone} and password = #{password}")
    User login(@Param("phone") String phone,@Param("password") String password);



    /**
     * hr_imagearr
     * @return
     */
    @Select("select * from hr_image_arr")
    List<HR_ImageArr> getImagearr();


    /**
     *update_info
     * @param version apk版本号
     * @return 指定版本号的apk文件
     */
    @Select("select * from update_info u where u.version=#{version}")
    UpdateInfo find_apkversion(@Param("version") String version);

    /**
     * update_info
     * @return所有apk版本信息
     */
    @Select("select * from update_info")
    List<UpdateInfo> apk_history();

    /**
     *update_info
     * @return 最新版本的apk文件
     */
    @Select("select * from update_info ORDER BY time DESC LIMIT 1")
    UpdateInfo apk_newest();

    /**
     * user_info
     * @return 指定id_unique的用户信息
     */
    @Select("select * from user_info u where u.id_unique=#{id_unique}")
    User_Info id_unique_userInfo(@Param("id_unique") String id_unique);
//    Store_DataInfo getdata();

    /**
     * article
     *
     */
    @Select("select * from article u where u.id=#{id}")
    Article find_artid(@Param("id") String id);

    /**
     * vlog
     *
     */
    @Select("select * from vlog u where u.id=#{id}")
    Vlog find_vlogid(@Param("id") String id);

}
