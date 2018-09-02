package com.xxb.model.enums;

public enum  BugOperate {
    /**
     * 对BUG的操作
     */
    创建(0), 指派(1),暂缓(2),解决(3),激活(4);

    int code;

    BugOperate(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static DeleteFlag codeueOf(Integer code) {
        for (DeleteFlag flag : DeleteFlag.values()) {
            if (flag.getVal() == code) {
                return flag;
            }
        }
        throw new RuntimeException("【" + code + "】不是BUG操作的有效类型！");
    }

    public static boolean isDeleteFlag(Integer code) {
        for (DeleteFlag flag : DeleteFlag.values()) {
            if (flag.getVal() == code) {
                return true;
            }
        }
        return false;
    }

}
