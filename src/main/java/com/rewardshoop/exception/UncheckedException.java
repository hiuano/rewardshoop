package com.rewardshoop.exception;

public class UncheckedException extends RuntimeException {
    /**
     * 错误Key，用于唯一标识错误类型
     */
    private String errorCode = null;
    /**
     * 错误信息
     */
    private String errorMessage;
    /**
     * 传递给变量的错误值
     */
    private Object[] errorParam = null;

    /**
     * 构造函数
     *
     * @param errorCode 异常编码
     */
    public UncheckedException(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * 构造函数
     *
     * @param errorCode  异常编码
     * @param errorParam Object[] 异常信息用到的参数
     */
    public UncheckedException(String errorCode, Object[] errorParam) {
        this.errorCode = errorCode;
        this.errorParam = errorParam;
    }

    /**
     * 重载构造函数
     *
     * @param errorCode  异常编码
     * @param errorParam 异常信息用到的参数
     * @param t          异常实例
     */
    public UncheckedException(String errorCode, Object[] errorParam, Throwable t) {
        super(t);
        this.errorCode = errorCode;
        this.errorParam = errorParam;
    }

    /**
     * 重载构造函数
     *
     * @param message 异常信息
     * @param t       异常实例
     */
    public UncheckedException(String message, Throwable t) {
        super(message, t);
        setErrorMessage(message);
    }


    /**
     * 异常编码
     *
     * @return String
     */
    public String getErrorCode() {
        return this.errorCode;
    }

    /**
     * 异常信息用到的参数
     *
     * @return Object[]
     */
    public Object[] getErrorParam() {
        return this.errorParam;
    }

    /**
     * 错误信息
     *
     * @return
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * 错误信息
     *
     * @param errorMessage
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * 覆盖方法：getMessage
     *
     * @return String
     */
    @Override
    public String getMessage() {
        if (errorMessage != null) {
            return errorMessage;
        }

//        //异常信息以资源文件的形式保存，并且支持国际化，此处通过errorCode去读取国际化异常信息
//        if (errorCode != null && !errorCode.trim().equals("")) {
//            setErrorMessage(AppLang.getLU().getMessage(errorCode, errorParam, Locale.SIMPLIFIED_CHINESE));
//        }

        return getErrorMessage();
    }
}
