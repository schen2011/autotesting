/*
 * Copyright (c) 2016, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */
package com.lmig.uscm.cl.predictivemodel.service.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * @author SamirKeco
 *
 */
public abstract class BaseModel
{
    /**
     * Help for debugging/logging.  This method is fairly expensive given
     * the heavy reflective nature, and should be used very sparingly at 
     * runtime (or should always be wrapped in debug statements, etc.)
     */
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        
        sb.append(getClass().getSimpleName());
        sb.append('[');
        
        Object[] emptyParams = new Object[0];
       
        Method[] methods = getClass().getMethods();
        for (Method method : methods)
        {
            String name = method.getName();
            try
            {                
                // check for simple "getters", i.e. starts with get and
                // takes no parameters
                if (name.startsWith("get") && 
                    method.getParameterTypes().length == 0)
                {
                    Object data = method.invoke(this, emptyParams);

                    String attributeName = name.substring(3);
                    
                    sb.append(attributeName);
                    sb.append('=');
                    if (data != null)
                    {
                        sb.append(data.toString());
                    }
                    else
                    {
                        sb.append("null");
                    }
                    sb.append("; ");
                }                
            }
            catch (IllegalAccessException e)
            {
            }
            catch (IllegalArgumentException e)
            {
            }            
            catch (InvocationTargetException e)
            {         
            }
        }
        
        sb.append(']');
       
        return sb.toString();
    }
}
