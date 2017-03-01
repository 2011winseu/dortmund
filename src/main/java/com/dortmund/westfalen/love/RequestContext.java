package com.dortmund.westfalen.love;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by twinkle.macris on 17/2/28.
 */
public class RequestContext {
    private Map<String, Object> kvs = new HashMap<String, Object>(6);

    public void put(String key, Object value) {
        kvs.put(key, value);
    }

    public Object get(String key) {
        return kvs.get(key);
    }
}
