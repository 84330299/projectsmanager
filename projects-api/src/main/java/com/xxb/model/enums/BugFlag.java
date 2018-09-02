package com.xxb.model.enums;
public enum BugFlag {
    /**
     * bug的当前状态
     */
    未解决(0), 已暂缓(1),已解决(2);

    int code;

    BugFlag(int code) {
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
        throw new RuntimeException("状态【" + code + "】不是BUG的有效类型！");
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
