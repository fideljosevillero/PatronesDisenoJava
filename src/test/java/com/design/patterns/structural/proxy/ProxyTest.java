package com.design.patterns.structural.proxy;

import org.junit.jupiter.api.Test;

public class ProxyTest {
    @Test
    void testProxy(){
        Internet internet = new ProxyInternet();
        try {
            internet.connectTo("udemy.com");
            internet.connectTo("facebook.com");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
