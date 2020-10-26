package com.play.proxy.core;

public interface DatabaseAPI {

    Object persistData(Object data) throws Exception;

    Object updateData(Object data) throws Exception;

    boolean deleteData(String primaryKey) throws Exception;
}
