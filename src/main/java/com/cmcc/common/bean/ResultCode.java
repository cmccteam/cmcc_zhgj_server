package com.cmcc.common.bean;

public enum ResultCode {
	/* 成功状态码 */
    SUCCESS(0, "成功"),
    ERROR(1,"失败"),
    /* 参数错误：10001-19999 */
    PARAM_IS_INVALID(10001, "参数无效"),
    PARAM_IS_BLANK(10002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(10003, "参数类型错误"),
    PARAM_NOT_COMPLETE(10004, "参数缺失"),
    
    PARAM_FILE_FORMAT(10005, "文件格式不对"),
    PARAM_FILE_IOEX(10006, "文件读取异常"),
    
    
    /* 用户错误：20001-29999*/
    USER_NOT_LOGGED_IN(20001, "用户未登录"),
    USER_LOGIN_ERROR(20002, "账号不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN(20003, "账号已被禁用"),
    USER_NOT_EXIST(20004, "用户不存在"),
    USER_HAS_EXISTED(20005, "用户已存在"),
    USER_PASS_RES(20021, "旧密码不正确"),
    
    USER_AUTH_NULL(20006, "token为空"),
    USER_AUTH_ERROR(20007, "token认证失败"),
    USER_AUTH_OUTTIME(20008, "token认证过期"),
    USER_AUTH_TOKEN_ERROR(20009, "token被篡改"),
    USER_AUTH_TOKEN_RES(20010, "刷新token"),
    USER_AUTH_TOKEN_DEL(20011, "token注销成功"),
    
    USER_ACCOUNT_ERROR(20012, "账号信息异常"),
    
    USER_MOBILE_CODE_NULL(20013, "验证码为空"),
    USER_MOBILE_CODE_OUT(20014, "验证码过期"),
    USER_MOBILE_CODE_ERROR(20015, "验证码错误"),
    
    /* 业务错误：30001-39999 */
    SPECIFIED_QUESTIONED_USER_NOT_EXIST(30001, "某业务出现问题"),

    /* 系统错误：40001-49999 */
    SYSTEM_INNER_ERROR(40001, "系统繁忙，请稍后重试"),

    /* 数据错误：50001-599999 */
    RESULE_DATA_NONE(50001, "数据未找到"),
    DATA_IS_WRONG(50002, "数据有误"),
    DATA_ALREADY_EXISTED(50003, "数据已存在"),
    DATA_NOT_DEL(50004, "数据不允许删除"),
    DATA_NOT_UPDATE(50004, "数据不允许更新"),
    /* 接口错误：60001-69999 */
    INTERFACE_INNER_INVOKE_ERROR(60001, "内部系统接口调用异常"),
    INTERFACE_OUTTER_INVOKE_ERROR(60002, "外部系统接口调用异常"),
    INTERFACE_FORBID_VISIT(60003, "该接口禁止访问"),
    INTERFACE_ADDRESS_INVALID(60004, "接口地址无效"),
    INTERFACE_REQUEST_TIMEOUT(60005, "接口请求超时"),
    INTERFACE_EXCEED_LOAD(60006, "接口负载过高"),

    /* 权限错误：70001-79999 */
    PERMISSION_NO_ACCESS(70001, "无访问权限");

    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public static String getMessage(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }
}
