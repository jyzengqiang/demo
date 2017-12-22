package com.example.demo.resources.redis;

import org.springframework.cache.annotation.CachingConfigurerSupport;

/**
 * @Author:曾强
 * @DATE 2017/12/4
 */
//@Configuration
//@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {
//    private static final Log log = LogFactory.getLog(RedisConfiguration.class);
//
//    @Autowired
//    RedisConfig redisConfig;
//    /**
//     * 配置JedisPoolConfig
//     * @return JedisPoolConfig实体
//     */
////    @Bean
////    public KeyGenerator keyGenerator() {
////        return new KeyGenerator() {
////            @Override
////            public Object generate(Object target, Method method, Object... params) {
////                StringBuilder sb = new StringBuilder();
////                sb.append(target.getClass().getName());
////                sb.append(method.getName());
////                for (Object obj : params) {
////                    sb.append(obj.toString());
////                }
////                return sb.toString();
////            }
////        };
////    }
//
//    @Bean(name = "jedisPoolConfig")
//    public JedisPoolConfig jedisPoolConfig() {
//        log.info("初始化JedisPoolConfig");
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        jedisPoolConfig.setMaxTotal(redisConfig.getMaxTotal());  //  连接池最大连接数（使用负值表示没有限制）
//        jedisPoolConfig.setMaxWaitMillis(redisConfig.getMaxWaitMillis());  // 连接池最大阻塞等待时间（使用负值表示没有限制）
//        jedisPoolConfig.setMaxIdle(redisConfig.getMaxIdle());  // 连接池中的最大空闲连接
//        jedisPoolConfig.setMinIdle(redisConfig.getMinIdle());  // 连接池中的最小空闲连接
////        jedisPoolConfig.setTestOnBorrow(true);
////        jedisPoolConfig.setTestOnCreate(true);
////        jedisPoolConfig.setTestWhileIdle(true);
//        return jedisPoolConfig;
//    }
//
//    /**
//     * 实例化 RedisConnectionFactory 对象
//     * @param poolConfig
//     * @return
//     */
//    @Bean(name = "jedisConnectionFactory")
//    public RedisConnectionFactory jedisConnectionFactory(@Qualifier(value = "jedisPoolConfig") JedisPoolConfig poolConfig) {
//        log.info("初始化RedisConnectionFactory");
//        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(poolConfig);
//        jedisConnectionFactory.setHostName(redisConfig.getHost());
//        jedisConnectionFactory.setPort(redisConfig.getPort());
//        jedisConnectionFactory.setDatabase(redisConfig.getDataBase());
//        return jedisConnectionFactory;
//    }
//
//    /**
//     *  实例化 RedisTemplate 对象
//     * @return
//     */
//    @Bean(name = "stringRedisTemplate")
//    public StringRedisTemplate functionDomainRedisTemplate(@Qualifier(value = "jedisConnectionFactory") RedisConnectionFactory factory) {
//        log.info("初始化StringRedisTemplate");
//        StringRedisTemplate stringRedisTemplate= new StringRedisTemplate();
////        RedisSerializer<String> redisSerializer = new StringRedisSerializer();//Long类型不可以会出现异常信息;
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        stringRedisTemplate.setConnectionFactory(factory);
//        stringRedisTemplate.setKeySerializer(jackson2JsonRedisSerializer);
//        stringRedisTemplate.setValueSerializer(new StringRedisSerializer());
//        stringRedisTemplate.setHashKeySerializer(new StringRedisSerializer());
//        stringRedisTemplate.setHashValueSerializer(new StringRedisSerializer());
//        stringRedisTemplate.afterPropertiesSet();
//        stringRedisTemplate.setEnableTransactionSupport(true);
//        return stringRedisTemplate;
//    }
}
