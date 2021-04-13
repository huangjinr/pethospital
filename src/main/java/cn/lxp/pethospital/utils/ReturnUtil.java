package cn.lxp.pethospital.utils;

import org.springframework.ui.ModelMap;

/**
 * JSON统一返回数据格式
 */
public class ReturnUtil {

    public static ModelMap Success(String msg, Object obj) {
        msg = msg != null || !"".equals(msg) ? "操作成功" : msg;
        ModelMap mp = new ModelMap();
        mp.put("code", 0);
        mp.put("state", "success");
        mp.put("msg", msg);
        mp.put("data", obj);
        return mp;
    }

    public static ModelMap Success(String msg) {
        msg = msg != null || !"".equals(msg) ? "操作成功" : msg;
        ModelMap mp = new ModelMap();
        mp.put("code", 200);
        mp.put("state", "success");
        mp.put("msg", msg);
        mp.put("data", null);
        return mp;
    }

    public static ModelMap Error(String msg) {
        msg = msg != null || !"".equals(msg) ? "操作失败" : msg;
        ModelMap mp = new ModelMap();
        mp.put("code", 500);
        mp.put("state", "error");
        mp.put("msg", msg);
        mp.put("data", null);
        return mp;
    }
}
