package com.ball.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ball.entity.PageResult;
import com.ball.entity.QueryPageBean;
import com.ball.pojo.ZhangBin;
import com.ball.service.InsertDataService;
import com.ball.constant.MessageConstant;
import com.ball.entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @discription: personnel-1
 * @Author: 张文峰
 * @Date: 2021-02-25 22:01:07
 */
@RestController
@RequestMapping("/personnel-1")
public class InsertDataController {
    // 查找服务
    @Reference
    private InsertDataService insertDataService;

    /**
     * 分页查询
     *
     * @param queryPageBean
     * @return : com.ball.entity.PageResult
     * @Date 21.2.26 - 21:53
     */
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        return insertDataService.findPage(queryPageBean);
    }

    /**
     * 新增
     *
     * @param zb
     * @return : com.ball.entity.Result
     * @Date 21.2.25 - 22:25
     */
    @RequestMapping("/add")
    public Result add(@RequestBody ZhangBin zb) {
        try {
            insertDataService.add(zb);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.ADD_DATA_FAIL);
        }
        return new Result(true, MessageConstant.ADD_DATA_SUCCESS);
    }

    /**
     * 编辑页回显
     *
     * @param id
     * @return : com.ball.entity.Result
     * @Date 21.2.27 - 01:27
     */
    @RequestMapping("/showEdit")
    public Result showEdit(String id) {
        try {
            ZhangBin zb = insertDataService.showEdit(id);
            return new Result(true, MessageConstant.QUERY_DATA_SUCCESS, zb);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.QUERY_DATA_FAIL);
        }
    }

    /**
     * 编辑
     *
     * @param zb
     * @return : com.ball.entity.Result
     * @Date 21.2.27 - 01:35
     */
    @RequestMapping("/edit")
    public Result edit(@RequestBody ZhangBin zb) {
        try {
            insertDataService.edit(zb);
            return new Result(true, MessageConstant.EDIT_DATA_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.EDIT_DATA_FAIL);
        }
    }

    /**
     * 删除
     *
     * @param id
     * @return : com.ball.entity.Result
     * @Date 21.2.27 - 02:16
     */
    @RequestMapping("/delete")
    public Result delete(String id) {
        try {
            insertDataService.delete(id);
            return new Result(true, MessageConstant.DELETE_DATA_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.DELETE_DATA_FAIL);
        }
    }


}
