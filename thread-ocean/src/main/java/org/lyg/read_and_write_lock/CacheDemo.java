package org.lyg.read_and_write_lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author :lyg
 * @time :2018/5/25 0025
 */
public class CacheDemo {
    private Object data = null;
    Map<String,Object> cache = new HashMap<String,Object>();
    private ReadWriteLock rwl = new ReentrantReadWriteLock();
    public Object getData(String key){
        rwl.readLock().lock();
        try{
            data = cache.get(key);
            if(data == null){
                rwl.readLock().unlock();
                rwl.writeLock().lock();
                try{
                    if(data == null){
                        data = "data get from database";//get from database
                        //加入缓存？
                    }
                }finally {
                    rwl.writeLock().unlock();
                }
                rwl.readLock().lock();
            }
        }finally {
            rwl.readLock().unlock();
        }


        return data;
    }
}
