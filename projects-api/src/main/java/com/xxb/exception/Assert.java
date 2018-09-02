package com.xxb.exception;

/**
 * @author 张玉
 * @Date 2018/7/25.
 */
public abstract class Assert {

    /**
     * 不为空
     *
     * @param object
     *            判断对象
     * @param message
     *            为空抛出异常信息
     */
    public static void notNull(Object object, String message) {
        if (object == null) {
            throw new MyException(message, 601);
        }
    }

    /**
     * 为真
     *
     * @param expression
     *            判断条件
     * @param message
     *            expression = false，抛出异常信息
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new MyException(message,602);
        }
    }

    /**
     * 为空
     *
     * @param object
     *            判断对象
     * @param message
     *            为空抛出异常信息
     */
    public static void isNull(Object object, String message) {
        if (object != null) {
            throw new MyException(message, 603);
        }
    }
}
