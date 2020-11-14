package com.fm.api.web.util;

/**
 * 请求状态码
 */
public enum ResultCodes {

    SUCCESS(1, "success"),
    FAILED(0, "failed"),
    BAD_REQUEST(400, "Bad Request, Invalid param"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    LOCKED(423, "Locked"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable"),
    SERVICE_EXCEPTION(50000, "请求异常，请检查参数后重试！");

    private final int value;
    private final String reasonPhrase;

    ResultCodes(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public int value() {
        return this.value;
    }

    public String reason() {
        return this.reasonPhrase;
    }


    @Override
    public String toString() {
        return Integer.toString(this.value);
    }

    public static ResultCodes valueOf(int statusCode) {
        ResultCodes[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            ResultCodes status = var1[var3];
            if (status.value == statusCode) {
                return status;
            }
        }

        throw new IllegalArgumentException("No matching constant for [" + statusCode + "]");
    }
}
