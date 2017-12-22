package com.example.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @Author:曾强
 * @DATE 2017/12/5
 */
@Component
public class RedisRepository {
//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate ;
    @Autowired
    private StringRedisTemplate redisTemplate;


    public boolean getHasKey(String key){
        boolean flag = this.redisTemplate.hasKey(key);
        return  flag;
    }
    //string
    public ValueOperations getValueOperations(){
        ValueOperations<?, ?> ops = (ValueOperations) this.redisTemplate.opsForValue();
        return  ops;
    }
    //Hashes
    public HashOperations getHashOperations() {
        HashOperations<?, ?, ?> ops = (HashOperations)this.redisTemplate.opsForHash();
        return ops;
    }
    //list
    public ListOperations getListOperations() {
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        ListOperations<?, ?> ops = (ListOperations)this.redisTemplate.opsForList();
        return  ops;
    }
    //set
    public SetOperations getSetOperations(){
        SetOperations<?, ?> ops = (SetOperations)this.redisTemplate.opsForSet();
        return  ops;
    }
    //有序 set
    public ZSetOperations getZSetOperations(){
        ZSetOperations<?, ?> ops = (ZSetOperations)this.redisTemplate.opsForZSet();
        return  ops;
    }
}
