package org.arctic.redis.common;

import org.arctic.redis.util.PropertiesUtil;
import redis.clients.jedis.*;
import redis.clients.util.Hashing;
import redis.clients.util.Sharded;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/25 0025.
 */
public class RedisPool {
    private static JedisPool jedisPool;//jedis连接池
    private static Integer maxTotal = Integer.parseInt(PropertiesUtil.getProperty("redis.max.total","20"));//最大连接数
    private static Integer maxIdle = Integer.parseInt(PropertiesUtil.getProperty("redis.max.idle","10"));//在jedispool中最大的idle状态（空闲的）的jedis实例的个数
    private static Integer minIdle = Integer.parseInt(PropertiesUtil.getProperty("redis.min.idle","2"));//在jedispool中最小的idle状态（空闲的）的jedis实例的个数
    private static Boolean testOnBorrow = Boolean.parseBoolean(PropertiesUtil.getProperty("redis.test.borrow","true"));//在borrow一个jedis实例的时候，是否要进行验证操作，如果赋值true，则得到的jedis实例是可以用的
    private static Boolean testOnReturn = Boolean.parseBoolean(PropertiesUtil.getProperty("redis.test.return","true"));//在return一个jedis实例的时候，是否要进行验证操作，如果赋值true，则得到的jedis实例是可以用的

    private static String ip = PropertiesUtil.getProperty("redis.ip");
    private static Integer port = Integer.parseInt(PropertiesUtil.getProperty("redis.port"));
    private static void initPool(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);

        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        jedisPoolConfig.setTestOnReturn(testOnReturn);

        jedisPoolConfig.setBlockWhenExhausted(true);//连接耗尽的时候，是否阻塞，false会抛出异常，true阻塞直到超时

        jedisPool = new JedisPool(jedisPoolConfig,ip,port,1000*2);
    }
    static {
        initPool();
    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }

    public static void returnBrokenResource(Jedis resource){
            jedisPool.returnBrokenResource(resource);
    }

    public static void returnResource(Jedis resource){
            jedisPool.returnResource(resource);
    }

    public static void main(String[] args){
        Jedis jedis = RedisPool.getJedis();
        jedis.set("arctic","北冰洋");

        returnResource(jedis);

        jedisPool.destroy();//临时调用，销毁连接池中的所有连接
        System.out.println("program is end");

    }
}
