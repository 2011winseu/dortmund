package com.dortmund.westfalen.vipbox;

import com.google.common.base.Optional;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by mingwei.smw on 2016/4/8.
 */
public class LocalCacheClient {
    private static Logger logger = LoggerFactory.getLogger(LocalCacheClient.class);
    /** cache中允许的最大尺寸 **/
    private Long MAX_CACHE_SIZE = 100000L;
    /** 失效时间 **/
    private Long expire = 5L;
    /** cache对象 **/
    private LoadingCache<Object, Object> localCache;

    public void init(){
        localCache = CacheBuilder.newBuilder().maximumSize(MAX_CACHE_SIZE).refreshAfterWrite(expire, TimeUnit.MINUTES).build(new CacheLoader<Object, Object>() {
            public Object load(Object key){
                return null;
            }
        });
    }

    public boolean putWithFiveMinutes(Serializable key, Serializable value ){
        localCache.put(key, value);
        return true;
    }

    public <T> Optional<T> get(Serializable key ){
        T result = (T)localCache.getIfPresent(key);
        if (result != null){
            return Optional.fromNullable(result);
        }
        return Optional.fromNullable(null);
    }

    public void invalid(Serializable key){
        localCache.invalidate(key);
    }

    /** 注意callable中需要判定结果为空时需要抛出异常 **/
    public <T> Optional<T> getValueWithUpdateMode(Serializable key, Callable<T> callable){
        try {
            T result = (T)localCache.get(key, callable );
            if (result != null){
                return Optional.fromNullable(result);
            }
        } catch (Exception e){
            logger.error("get-value-with-update-mode-exception:"+e, e);
        }
        return Optional.fromNullable(null);
    }


}
