package com.xxb.model.enums;

/**
 * @author zhenghe
 * @date 2018/7/11  10:01
 */
public enum SuccessFlag {
    不成功(0), 成功(1);

    int val;

    SuccessFlag(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public static SuccessFlag valueOf(Integer val) {
        for (SuccessFlag flag : SuccessFlag.values()) {
            if (flag.getVal() == val) {
                return flag;
            }
        }
        throw new RuntimeException("日志操作类型【" + val + "】不是有效类型！");
    }

    //判断是否是成功标志
    public static boolean isSuccessFlag(Integer val) {
        for (SuccessFlag flag : SuccessFlag.values()) {
            if (flag.getVal() == val) {
                return true;
            }
        }
        return false;
    }
}
