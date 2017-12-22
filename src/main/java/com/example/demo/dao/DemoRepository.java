package com.example.demo.dao;

import com.example.demo.bean.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/11/29.
 */
public interface DemoRepository extends JpaRepository<User,Integer> {

    /**
     * 查询User集合
     * @param types
     * @return
     */
    List<User> findByTypes(String types);

    /**
     * 带参数的分页
     * @param types
     * @param pageable
     * @return
     */
    Page<User> findByTypes(String types,Pageable pageable);

    @Cacheable(value = "user",key = "#p0")
    User findById(String id);

    @Cacheable(value = "user")
    List<User> findAll();

//    User findOne(String id);

//    User getOne(String id);


//    Page<User> findAll(Specification<T> spec, Pageable pageable);

}
