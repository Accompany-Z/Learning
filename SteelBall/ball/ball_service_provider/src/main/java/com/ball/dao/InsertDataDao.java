package com.ball.dao;

import com.ball.pojo.ZhangBin;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

/**
 * @discription: personnel-1 新增数据层
 * @Author: 张文峰
 * @Date: 2021-02-25 22:40:20
 */
public interface InsertDataDao {
    /**
     * 新增
     *
     * @param zb
     * @return : void
     * @Date 21.2.25 - 22:48
     */
    void add(ZhangBin zb);

    /**
     * 分页查询
     *
     * @param queryParam
     * @return : com.github.pagehelper.Page<com.ball.pojo.ZhangBin>
     * @Date 21.2.26 - 21:59
     */
    Page<ZhangBin> findPage(@Param("queryParam") String queryParam);

    /**
     * 编辑页回显
     *
     * @param id
     * @return : com.ball.pojo.ZhangBin
     * @Date 21.2.27 - 01:27
     */
    ZhangBin showEdit(@Param("id") String id);

    /**
     * 编辑
     *
     * @param zb
     * @return : void
     * @Date 21.2.27 - 01:37
     */
    void edit(ZhangBin zb);

    /**
     * 删除
     *
     * @param id
     * @return : void
     * @Date 21.2.27 - 02:17
     */
    void delete(@Param("id") String id);
}
