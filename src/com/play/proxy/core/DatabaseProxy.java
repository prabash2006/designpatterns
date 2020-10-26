package com.play.proxy.core;

class DatabaseProxy extends AbstractProxy implements DatabaseAPI {

    private DatabaseAPI baseApi;

    public DatabaseProxy(DatabaseAPI baseApi) {
        this.baseApi = baseApi;
    }

    @Override
    public Object persistData(Object data) throws Exception {
        return call(data, baseApi);
    }

    @LogAndRethrow
    @Override
    public Object updateData(Object data) throws Exception {
        return call(data, baseApi);
    }

    @Override
    public boolean deleteData(String primaryKey) throws Exception {
        return (boolean) call(primaryKey, baseApi);
    }

    @Override
    public void preCondition() {
        System.out.println("Pre condition called");
    }

    @Override
    public void postCondition() {
        System.out.println("Post condition called");
    }
}