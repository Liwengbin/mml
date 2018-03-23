package com.mml.domain;

public class TResponse {
    public String etag;
    public String lang;
    public Object data;
    public boolean success;

    public TResponse(String etag, String lang, Object data, boolean success) {
        this.etag = etag;
        this.lang = lang;
        this.data = data;
        this.success = success;
    }

    public TResponse() {
        super();
    }

    /**
     * 初始化TResponse
     * @param etag
     * @param lang
     * @param data
     * @param success
     * @return
     */
    public TResponse getTResponse(String etag, String lang, Object data, boolean success){
        this.etag = etag;
        this.lang = lang;
        this.data = data;
        this.success = success;
        return this;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "TResponse{" +
                "etag='" + etag + '\'' +
                ", lang='" + lang + '\'' +
                ", data=" + data +
                ", success=" + success +
                '}';
    }
}
