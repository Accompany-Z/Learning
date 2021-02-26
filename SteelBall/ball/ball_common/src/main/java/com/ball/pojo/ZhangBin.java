package com.ball.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @discription: 张斌
 * @Author: 张文峰
 * @Date: 2021-02-23 21:30:47
 */
public class ZhangBin implements Serializable {

    private String id;
    /**
     * 日期
     */
    private String date;
    /**
     * 拔丝
     */
    private String bs;
    /**
     * 毛坯
     */
    private String mp;
    /**
     * 余条
     */
    private String yt;
    /**
     * 加工费
     */
    private String tcrc;

    /**
     * 备注
     */
    private String textarea;


    public ZhangBin() {
    }

    public ZhangBin(String id, String date, String bs, String mp, String yt, String tcrc, String textarea) {
        this.id = id;
        this.date = date;
        this.bs = bs;
        this.mp = mp;
        this.yt = yt;
        this.tcrc = tcrc;
        this.textarea = textarea;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    public String getMp() {
        return mp;
    }

    public void setMp(String mp) {
        this.mp = mp;
    }

    public String getYt() {
        return yt;
    }

    public void setYt(String yt) {
        this.yt = yt;
    }

    public String getTcrc() {
        return tcrc;
    }

    public void setTcrc(String tcrc) {
        this.tcrc = tcrc;
    }

    public String getTextarea() {
        return textarea;
    }

    public void setTextarea(String textarea) {
        this.textarea = textarea;
    }

}
