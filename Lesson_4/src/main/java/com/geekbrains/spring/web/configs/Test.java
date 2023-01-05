package com.geekbrains.spring.web.configs;


public class Test {

    public static void main(String[] args) {

        LongGetter getter = new LongGetter() {};

        LongGetter proxy = new LongGetterCached(getter);

        for (int i = 0; i < 5; i++) {
            System.out.println(proxy.getLong("Testttttt", 1L));
        }

    }
}
