package com.xxb.model.enums;

/**
 * @author zhenghe
 * @date 2018/7/9  9:07
 */
public enum DeleteFlag {
    已删除(0), 未删除(1);

    int val;

    DeleteFlag(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public static DeleteFlag valueOf(Integer val) {
        for (DeleteFlag flag : DeleteFlag.values()) {
            if (flag.getVal() == val) {
                return flag;
            }
        }
        throw new RuntimeException("删除标志类型【" + val + "】不是有效类型！");
    }

    //判断是否是删除标志
    public static boolean isDeleteFlag(Integer val) {
        for (DeleteFlag flag : DeleteFlag.values()) {
            if (flag.getVal() == val) {
                return true;
            }
        }
        return false;
    }
}
