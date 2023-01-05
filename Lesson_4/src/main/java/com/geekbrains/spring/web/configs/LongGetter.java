package com.geekbrains.spring.web.configs;

public interface LongGetter {

    default Long getLong(String newString, Long value) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value;
    }
}
