package com.xxb.model.enums;

/**
 * @author zhenghe
 * @date 2018/7/9  9:15
 */
public enum UseStatus {
    禁用(0), 启用(1);

    int val;

    UseStatus(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public static UseStatus valueOf(Integer val) {
        for (UseStatus flag : UseStatus.values()) {
            if (flag.getVal() == val) {
                return flag;
            }
        }
        throw new RuntimeException("删除标志类型【" + val + "】不是有效类型！");
    }

    //判断是否是使用状态标志
    public static boolean isUseStatus(Integer val) {
        for (UseStatus flag : UseStatus.values()) {
            if (flag.getVal() == val) {
                return true;
            }
        }
        return false;
    }
}
