package org.arctic.redis.util;


import org.arctic.redis.common.RedisShardedPool;
import redis.clients.jedis.ShardedJedis;


/**
 * Created by Administrator on 2018/4/28 0028.
 */
public class RedisShardedPoolUtil {
    public static String set(String key,String value){
        ShardedJedis jedis = null;
        String result = null;
        try {
            jedis = RedisShardedPool.getJedis();
            result = jedis.set(key,value);
        } catch (Exception e) {
            e.printStackTrace();
            RedisShardedPool.returnBrokenResource(jedis);
            return result;
        }
        RedisShardedPool.returnResource(jedis);
        return result;
    }

    public static String get(String key){
        ShardedJedis jedis = null;
        String result = null;

        try {
            jedis = RedisShardedPool.getJedis();
            result = jedis.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            RedisShardedPool.returnBrokenResource(jedis);
            return  result;
        }
        RedisShardedPool.returnResource(jedis);
        return result;
    }

    //exTime单位是秒
    public static String setEx(String key,String value,int exTime){//设置有效期
        ShardedJedis jedis = null;
        String result = null;
        try {
            jedis = RedisShardedPool.getJedis();
            result = jedis.setex(key,exTime,value);
        } catch (Exception e) {
            e.printStackTrace();
            RedisShardedPool.returnBrokenResource(jedis);
            return result;
        }
        RedisShardedPool.returnResource(jedis);
        return result;
    }

    /**
     * 设置key的有效期，单位是秒
     * @param key
     * @param exTime
     * @return
     */
    public static Long expire(String key,int exTime){//重新设置有效期
        ShardedJedis jedis = null;
        Long result = null;
        try {
            jedis = RedisShardedPool.getJedis();
            result = jedis.expire(key,exTime);
        } catch (Exception e) {
            e.printStackTrace();
            RedisShardedPool.returnBrokenResource(jedis);
            return result;
        }
        RedisShardedPool.returnResource(jedis);
        return result;
    }

    /**
     * 删除key，value
     * @param key
     * @return
     */
    public Long del(String key){
        ShardedJedis jedis = null;
        Long result = null;
        try {
            jedis = RedisShardedPool.getJedis();
            result = jedis.del(key);
        } catch (Exception e) {
            e.printStackTrace();
            RedisShardedPool.returnBrokenResource(jedis);
            return result;
        }
        RedisShardedPool.returnResource(jedis);
        return result;
    }

    public static void main(String[] args){
        String arctic = RedisPoolUtil.get("arctic");
        RedisPoolUtil.expire("arctic",100);
        System.out.println(arctic);
    }
}
