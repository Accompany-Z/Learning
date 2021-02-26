package com.ball.service.impl;

import com.ball.dao.InsertDataDao;
import com.ball.entity.PageResult;
import com.ball.entity.QueryPageBean;
import com.ball.pojo.ZhangBin;
import com.ball.service.InsertDataService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @discription: personnel-1 新增接口实现
 * @Author: 张文峰
 * @Date: 2021-02-25 22:38:29
 */
@Service(interfaceClass = InsertDataService.class)
@Transactional
public class InsertDataServiceImpl implements InsertDataService {
    @Autowired
    private InsertDataDao insertDataDao;

    /**
     * 分页查询
     *
     * @param queryPageBean
     * @return : com.ball.entity.PageResult
     * @Date 21.2.26 - 21:59
     */
    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        Integer page = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryParam = queryPageBean.getQueryString();

        PageHelper.startPage(page, pageSize);

        Page<ZhangBin> pager = insertDataDao.findPage(queryParam);

        return new PageResult(pager.getTotal(), pager.getResult());
    }

    /**
     * 新增
     *
     * @param zb
     * @return : void
     * @Date 21.2.25 - 22:39
     */
    @Override
    public void add(ZhangBin zb) {
        String id = UUID.randomUUID().toString();
        zb.setId(id);
        insertDataDao.add(zb);
    }

    /**
     * 编辑页回显
     *
     * @param id
     * @return : com.ball.pojo.ZhangBin
     * @Date 21.2.27 - 01:27
     */
    @Override
    public ZhangBin showEdit(String id) {
        return insertDataDao.showEdit(id);
    }

    /**
     * 编辑
     *
     * @param zb
     * @return : void
     * @Date 21.2.27 - 01:36
     */
    @Override
    public void edit(ZhangBin zb) {
        insertDataDao.edit(zb);
    }

    /**
     * 删除
     *
     * @param id
     * @return : void
     * @Date 21.2.27 - 02:16
     */
    @Override
    public void delete(String id) {
        insertDataDao.delete(id);
    }
}
