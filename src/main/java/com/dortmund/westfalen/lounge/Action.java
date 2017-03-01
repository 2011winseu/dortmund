package com.dortmund.westfalen.lounge;

import com.dortmund.westfalen.love.RequestContext;
import com.dortmund.westfalen.love.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by twinkle.macris on 17/2/28.
 */
public interface Action {

    public static Logger logger = LoggerFactory.getLogger(Action.class);

    public Result execute(RequestContext requestContext);

    public String getActionName();
}
