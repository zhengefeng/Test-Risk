package com.risk.integration.api;

/**
 * Created by li on 2015/11/9.
 */
public class RetBase {
    private boolean success = true;

    public ErrorMsg[] getErrors() {
        return errors;
    }

    public RetBase setErrors(ErrorMsg[] errors) {
        this.errors = errors;
        return this;
    }

    private ErrorMsg[] errors;

    public boolean isSuccess() {
        return success;
    }

    public RetBase setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String toString() {
        return new StringBuilder("success:").append(success).append(",errors:").append(toString(errors)).toString();
    }

    public String toString(Object[] objs) {
        if (objs == null)
            return null;
        StringBuilder sb = new StringBuilder("[");
        for(Object obj:objs) {
            sb.append("{").append(obj.toString()).append("}");
        }
        return sb.append("]").toString();
    }
}
