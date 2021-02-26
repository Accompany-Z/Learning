package com.ball.service;

import com.ball.entity.PageResult;
import com.ball.entity.QueryPageBean;
import com.ball.pojo.ZhangBin;

/**
 * @discription: personnel-1 新增接口
 * @Author: 张文峰
 * @Date: 2021-02-25 22:31:01
 */
public interface InsertDataService {
    /**
     * 分页查询
     *
     * @param queryPageBean
     * @return : com.ball.entity.PageResult
     * @Date 21.2.26 - 21:53
     */
    PageResult findPage(QueryPageBean queryPageBean);

    /**
     * 新增
     *
     * @param zb
     * @return : void
     * @Date 21.2.25 - 22:34
     */
    void add(ZhangBin zb);


    /**
     * 编辑页回显
     *
     * @param id
     * @return : com.ball.pojo.ZhangBin
     * @Date 21.2.27 - 01:26
     */
    ZhangBin showEdit(String id);

    /**
     * 编辑
     *
     * @param zb
     * @return : void
     * @Date 21.2.27 - 01:35
     */
    void edit(ZhangBin zb);

    /**
     * 删除
     *
     * @param id
     * @return : void
     * @Date 21.2.27 - 02:16
     */
    void delete(String id);
}
