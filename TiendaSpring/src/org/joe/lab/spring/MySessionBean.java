package org.joe.lab.spring;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MySessionBean {

    private List<String> products;
    private int productCounter = 0;
    private boolean sessionActive;

    public MySessionBean() {
        System.out.println("Creating session bean!!");
        products = new ArrayList<>();
        sessionActive = false;
    }

    void startSession(){
        sessionActive = true;
    }
    boolean getSession() {
        return sessionActive;
    }

    List<String> getProducts() {
        return products;
    }

    void addToList(String p) {
        if(productCounter == 5)
            productCounter = 0;

        products.add(productCounter, p);

        productCounter++;
    }
}
