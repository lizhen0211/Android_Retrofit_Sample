package com.lz.retrofit_sample.postdemo;

import com.google.gson.annotations.SerializedName;

public class ResponseBean {
    @SerializedName("args")
    private Args args;
    @SerializedName("data")
    private String data;
    @SerializedName("files")
    private Files files;
    @SerializedName("form")
    private Form form;
    @SerializedName("headers")
    private Headers headers;
    @SerializedName("json")
    private Json json;
    @SerializedName("origin")
    private String origin;
    @SerializedName("url")
    private String url;

    public void setArgs(Args args) {
        this.args = args;
    }

    public Args getArgs() {
        return args;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setFiles(Files files) {
        this.files = files;
    }

    public Files getFiles() {
        return files;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public Form getForm() {
        return form;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setJson(Json json) {
        this.json = json;
    }

    public Json getJson() {
        return json;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return origin;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public class Args {

    }

    public class Files {

    }

    public class Form {

    }

    public class Headers {
        @SerializedName("Accept")
        private String accept;
        @SerializedName("Accept-Encoding")
        private String acceptEncoding;
        @SerializedName("Cache-Control")
        private String cacheControl;
        @SerializedName("Content-Length")
        private String contentLength;
        @SerializedName("Content-Type")
        private String contentType;
        @SerializedName("Host")
        private String host;
        @SerializedName("Postman-Token")
        private String postmanToken;
        @SerializedName("User-Agent")
        private String userAgent;

        public String getAccept() {
            return accept;
        }

        public void setAccept(String accept) {
            this.accept = accept;
        }

        public String getAcceptEncoding() {
            return acceptEncoding;
        }

        public void setAcceptEncoding(String acceptEncoding) {
            this.acceptEncoding = acceptEncoding;
        }

        public String getCacheControl() {
            return cacheControl;
        }

        public void setCacheControl(String cacheControl) {
            this.cacheControl = cacheControl;
        }

        public String getContentLength() {
            return contentLength;
        }

        public void setContentLength(String contentLength) {
            this.contentLength = contentLength;
        }

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getPostmanToken() {
            return postmanToken;
        }

        public void setPostmanToken(String postmanToken) {
            this.postmanToken = postmanToken;
        }

        public String getUserAgent() {
            return userAgent;
        }

        public void setUserAgent(String userAgent) {
            this.userAgent = userAgent;
        }
    }

    public class Json {

        private int age;
        private int gender;
        private String name;

        public void setAge(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getGender() {
            return gender;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }
}
