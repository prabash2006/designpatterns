package com.play.proxy.core;

public class DatabaseFactory {

    public static DatabaseAPI getDatabaseApi(){
        return new DatabaseProxy(new MongoDbAPI());
    }
}
