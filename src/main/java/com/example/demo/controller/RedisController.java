package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.commons.JsonResult;
import com.example.demo.dao.DemoRepository;
import com.example.demo.dao.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author:曾强
 * @DATE 2017/12/5
 */
@RestController
public class RedisController {
    @Autowired
    RedisRepository redisRepository;
    @Autowired
    DemoRepository demoRepository;

    @RequestMapping(value = "/redisString",method = RequestMethod.GET)
    public JsonResult<Object> redisString(){
        JsonResult<Object> res =new JsonResult<>();
        boolean flag = redisRepository.getHasKey("zengqiang");
        String val = "曾强";
        if (flag){
             val = (String) redisRepository.getValueOperations().get("zengqiang");
        }else {
            redisRepository.getValueOperations().set("zengqiang",val);
        }
        res.setResult(val);
        return res;
    }

    /**
     * Restful 风格 查一条记录
     * @param id
     * @return
     */
    @RequestMapping(value = "/api/user/{id}",method = RequestMethod.GET)
    public JsonResult<Object> find(@PathVariable("id") String id){
        JsonResult<Object> res =new JsonResult<>();
         User user = demoRepository.findById(id);
         res.setResult(user);
        return res;
    }

    /**
     * Restful 风格 查所有
     * @return
     */
    @RequestMapping(value = "/api/user",method = RequestMethod.GET)
    public JsonResult<Object> findAllCity() {
        JsonResult<Object> res =new JsonResult<>();
        List<User> list = demoRepository.findAll();
        res.setResult(list);
        return res;
    }

    @RequestMapping(value = "/api/user",method = RequestMethod.PUT)
    public JsonResult<Object> insertUser(@RequestBody  User user){
        JsonResult<Object> res =new JsonResult<>();
        User user1= demoRepository.save(user);
        res.setResult(user1);
        return res;
    }


}
