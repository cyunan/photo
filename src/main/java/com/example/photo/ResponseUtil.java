package com.example.photo;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 响应操作结果
 * <pre>
 *  {
 *      status： 返回状态码
 *      msg：    返回信息
 *      data：   响应数据
 *  }
 * </pre>
 *
 * <p>
 * 错误码：
 * 401：用户已存在
 * 402：无此用户
 * 403：信息混乱
 * 404：位置错误
 * 405：用户名或密码错误
 * 412: 上传文件失败
 */
public class ResponseUtil {
    public static Object ok(String msg) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("status", 202);
        obj.put("msg", msg);
        return obj;
    }

    public static Object ok(Object data) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("status", 202);
        obj.put("msg", "请求成功");
        obj.put("data", data);
        return obj;
    }
    public static Object ok(String msg,Object data) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("status", 202);
        obj.put("msg", msg);
        obj.put("data", data);
        return obj;
    }


    public static Object fail(int errno, String errmsg) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("status", errno);
        obj.put("msg", errmsg);
        return obj;
    }
    public static Object fail(int errno, String errmsg,Object data) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("status", errno);
        obj.put("msg", errmsg);
        obj.put("data", data);
        return obj;
    }
    public static Object fail(int errno, String errmsg,List<Object> data) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("status", errno);
        obj.put("msg", errmsg);
        obj.put("data", data);
        return obj;
    }

    public static Object badArgument() {
        return fail(401, "参数不对");
    }

    public static Object badArgumentValue() {
        return fail(402, "参数值不对");
    }

    public static Object unlogin() {
        return fail(501, "请登录");
    }

    public static Object serious() {
        return fail(502, "系统内部错误");
    }

    public static Object unsupport() {
        return fail(503, "业务不支持");
    }

    public static Object updatedDateExpired() {
        return fail(504, "更新数据已经失效");
    }

    public static Object updatedDataFailed() {
        return fail(505, "更新数据失败");
    }

    public static Object unauthz() {
        return fail(506, "无操作权限");
    }
}

