package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.commons.JsonResult;
import com.example.demo.commons.Page.PageInfo;
import com.example.demo.commons.Page.PageableTools;
import com.example.demo.dao.DemoRepository;
import com.example.demo.dao.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2017/11/16.
 */
@RestController
public class HelloController {
    @Autowired
    DemoRepository demoRepository;
    @Autowired
    RedisRepository redisRepository;
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public JsonResult<Object> hello(HttpServletRequest request, HttpServletResponse response){
        JsonResult<Object> res =new JsonResult<>();
        List<User> list = null;
        String types = "101001";
        boolean flag =  redisRepository.getHasKey("userList");
        if (flag){
            Long size = redisRepository.getListOperations().size("userList");
            list  =(List<User>)redisRepository.getListOperations().range("userList",0,size);
            System.out.println("有缓存");
        }else {
             list  = demoRepository.findByTypes(types);
            redisRepository.getListOperations().leftPush("userList",list);

        }
        res.setResult(list);
        return res;
    }

    /**
     * 不带参数的分页
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "userList",method = RequestMethod.GET)
    public JsonResult userPageList(HttpServletRequest request,HttpServletResponse response){
        JsonResult<Object> res =new JsonResult<>();
        PageRequest pr = new PageRequest(2,3);
        Page<User> stus = demoRepository.findAll(pr);
        PageInfo<User> pageInfo = new PageInfo<User>(stus);
        res.setResult(pageInfo);
        return  res;
    }
    @RequestMapping(value = "userListByParam",method = RequestMethod.GET)
    public JsonResult userListByParam(HttpServletRequest request,HttpServletResponse response){
        JsonResult<Object> res =new JsonResult<>();
        String types = "101001";
        //查询第一页
        Page<User> stus = demoRepository.findByTypes(types,PageableTools.basic(0));
        PageInfo<User> pageInfo = new PageInfo<User>(stus);
        res.setResult(pageInfo);
        return  res;
    }
}
