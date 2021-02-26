package com.ball.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @discription: 分页结果封装对象
 * @Author: 张文峰
 * @Date: 2021-02-24 21:07:36
 */
public class PageResult implements Serializable {
    private Long total;//总记录数
    private List rows;//当前页结果

    public PageResult(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
