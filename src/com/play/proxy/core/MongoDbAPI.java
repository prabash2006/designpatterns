package com.play.proxy.core;

class MongoDbAPI implements DatabaseAPI {

    @Override
    public Object persistData(Object data) {
        System.out.println("Persisted");
        return data;
    }

    @LogAndRethrow
    @Override
    public Object updateData(Object data) {
        throw new RuntimeException("Test");
    }

    @Override
    public boolean deleteData(String primaryKey) {
        System.out.println("Deleted");
        return true;
    }
}