package com.hr.model;

import java.io.Serializable;

public class Train implements Serializable {
    private Integer id;
    private String content;
    private String request;
    private String beginTime;
    private String endTime;
    private Integer isPublish;

    public Train() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getIsPublish() {
        return isPublish;
    }

    public void setIsPublish(Integer isPublish) {
        this.isPublish = isPublish;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", request='" + request + '\'' +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", isPublish=" + isPublish +
                '}';
    }
}
