package com.example.photo.initate;

import com.alibaba.fastjson.JSON;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * 解析json数据包
 */
@Service
public class JsonResourceUtils {
    public JSONObject getJsonObjFromConfiguration(String s){
        String FILENAME = s;
        return getJsonObjFromResource(FILENAME);
    }

    public JSONObject getJsonObjFromResource(String filename){
        com.alibaba.fastjson.JSONObject json = null;

        if (!filename.contains(".json")){
            filename += ".json";
        }

        try{
            InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
            if (inputStream != null){
                StringBuilder sb = new StringBuilder();
                InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                BufferedReader bfReader = new BufferedReader(reader);
                String content = null;
                while((content = bfReader.readLine()) != null){
                    sb.append(content);
                }
                bfReader.close();
                json = JSON.parseObject(sb.toString());
            }else{
//                Log.info("[{}] file not exist",filename);
            }

        }catch (Exception e){
//            Log.error("read file to string error",e);
        }

        return json;
    }
}
