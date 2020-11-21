package com.example.photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
    @Autowired
    private File_init fileInit;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //和页面有关的静态目录都放在项目的static目录下
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");

        registry.addResourceHandler("/apk/**").addResourceLocations("file:"+ fileInit.getUploadFolder_apk());
        registry.addResourceHandler("/article/**").addResourceLocations("file:"+ fileInit.getUploadFolder_art());

        //上传的图片在D盘下的OTA目录下，访问路径如：http://114.55.249.135:8888/touxiang/a.png
        //其中image_file表示访问的前缀。"file:/home/tomuser/apps/pinche/pas_card/"是文件真实的存储路径
        super.addResourceHandlers(registry);
    }
}
