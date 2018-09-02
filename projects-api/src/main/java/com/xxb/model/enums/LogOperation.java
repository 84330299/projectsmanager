package com.xxb.model.enums;

/**
 * 日志操作
 *
 * @author zhenghe
 * @date 2018/7/11  9:56
 */
public enum LogOperation {
    //0登录，1登出
    登录(0), 登出(1);

    int val;

    LogOperation(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public static LogOperation valueOf(Integer val) {
        for (LogOperation flag : LogOperation.values()) {
            if (flag.getVal() == val) {
                return flag;
            }
        }
        throw new RuntimeException("日志操作类型【" + val + "】不是有效类型！");
    }

    //判断是否是日志操作类型
    public static boolean isLogOperation(Integer val) {
        for (LogOperation flag : LogOperation.values()) {
            if (flag.getVal() == val) {
                return true;
            }
        }
        return false;
    }
}
