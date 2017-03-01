package com.dortmund.westfalen.lounge;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by sunmingwei on 16/6/27.
 */
public class ActionHolder implements ApplicationContextAware {

    //因为这个bean 定义在spring-context中,如果从controller 调用时会导致
    private static final Set<ApplicationContext> all = new HashSet<ApplicationContext>();

    private Map<String,Action> actions;

    public Action getAction(String actionName){
        if(null==actions){
            synchronized (this) {
                if(null==actions){
                    actions = new HashMap<String, Action>();
                    Map<String, Action> map = new HashMap<String, Action>();
                    for(ApplicationContext applicationContext : all) {
                        map.putAll(applicationContext.getBeansOfType(Action.class));
                    }
                    for(Action act:map.values()){
                        actions.put(act.getActionName(), act);
                    }
                }
            }
        }
        return actions.get(actionName);
    }

    public void setApplicationContext(ApplicationContext applicationContext)throws BeansException {
        synchronized (all) {
            all.add(applicationContext);
        }
    }

}
