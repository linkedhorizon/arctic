package org.arctic.redis.common;

import org.arctic.redis.util.PropertiesUtil;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.util.Hashing;
import redis.clients.util.Sharded;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/4/28 0028.
 */
/**
 * Created by Administrator on 2018/4/28 0028.
 */
public class RedisShardedPool {
    private static ShardedJedisPool shardedJedisPool;//sharded jedis连接池
    private static Integer maxTotal = Integer.parseInt(PropertiesUtil.getProperty("redis.max.total","20"));//最大连接数
    private static Integer maxIdle = Integer.parseInt(PropertiesUtil.getProperty("redis.max.idle","10"));//在jedispool中最大的idle状态（空闲的）的jedis实例的个数
    private static Integer minIdle = Integer.parseInt(PropertiesUtil.getProperty("redis.min.idle","2"));//在jedispool中最小的idle状态（空闲的）的jedis实例的个数
    private static Boolean testOnBorrow = Boolean.parseBoolean(PropertiesUtil.getProperty("redis.test.borrow","true"));//在borrow一个jedis实例的时候，是否要进行验证操作，如果赋值true，则得到的jedis实例是可以用的
    private static Boolean testOnReturn = Boolean.parseBoolean(PropertiesUtil.getProperty("redis.test.return","true"));//在return一个jedis实例的时候，是否要进行验证操作，如果赋值true，则得到的jedis实例是可以用的

    private static String ip1 = PropertiesUtil.getProperty("redis.ip1");
    private static Integer port1 = Integer.parseInt(PropertiesUtil.getProperty("redis.port1"));

    private static String ip2 = PropertiesUtil.getProperty("redis.ip2");
    private static Integer port2= Integer.parseInt(PropertiesUtil.getProperty("redis.port2"));
    private static void initPool(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();

        jedisPoolConfig.setMaxTotal(maxTotal);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);

        jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        jedisPoolConfig.setTestOnReturn(testOnReturn);

        jedisPoolConfig.setBlockWhenExhausted(true);//连接耗尽的时候，是否阻塞，false会抛出异常，true阻塞直到超时

        JedisShardInfo info1 = new JedisShardInfo(ip1,port1,1000*2);
        JedisShardInfo info2 = new JedisShardInfo(ip2,port2,1000*2);

        List<JedisShardInfo> jedisShardInfoList = new ArrayList<JedisShardInfo>(2);
        jedisShardInfoList.add(info1);
        jedisShardInfoList.add(info2);
        shardedJedisPool = new ShardedJedisPool(jedisPoolConfig, jedisShardInfoList, Hashing.MURMUR_HASH, Sharded.DEFAULT_KEY_TAG_PATTERN);
    }
    static {
        initPool();
    }

    public static ShardedJedis getJedis(){
        return shardedJedisPool.getResource();
    }

    public static void returnBrokenResource(ShardedJedis resource){
        shardedJedisPool.returnBrokenResource(resource);
    }

    public static void returnResource(ShardedJedis resource){
        shardedJedisPool.returnResource(resource);
    }

    public static void main(String[] args){
        ShardedJedis shardedJedis = RedisShardedPool.getJedis();
        for(int i = 0;i<10;i++){
            shardedJedis.set("key"+i,"value"+i);
        }
        returnResource(shardedJedis);

        //jedisPool.destroy();//临时调用，销毁连接池中的所有连接
        System.out.println("program is end");

    }
}

