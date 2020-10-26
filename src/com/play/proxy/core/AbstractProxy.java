package com.play.proxy.core;

import java.lang.reflect.Method;

public abstract class AbstractProxy {

    public abstract void preCondition();

    public abstract void postCondition();

    public Object call(Object data, Object target) throws Exception {

        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        Object result = null;

        for (Method method : target.getClass().getDeclaredMethods()) {

            if (method.getName().equals(methodName)) {

                preCondition();

                if (method.isAnnotationPresent(LogAndRethrow.class)) {
                    try {
                        System.out.println("Handling Exceptions");
                        method.setAccessible(true);
                        result = method.invoke(target, data);
                    } catch (Exception e) {
                        System.out.println("Log and re throw the exception : " + method.getName());
                        throw e;
                    }
                } else {
                    result = method.invoke(target, data);
                }

                postCondition();
            }
        }
        return result;
    }
}