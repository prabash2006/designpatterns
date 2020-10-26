package com.play.proxy;

import com.play.proxy.core.DatabaseAPI;
import com.play.proxy.core.DatabaseFactory;
import com.play.proxy.dto.Person;

public class ProxyMain {
    public static void main(String[] args) {

        DatabaseAPI api = DatabaseFactory.getDatabaseApi();

        try {
            api.persistData(new Person("AA", 30));
        } catch (Exception e) {

        }

        try {
            api.updateData(new Person("AA", 30));
        } catch (Exception e) {

        }

        try {
            api.deleteData("");
        } catch (Exception e) {

        }
    }
}
