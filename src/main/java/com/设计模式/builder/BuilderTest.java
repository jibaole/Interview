package com.设计模式.builder;

/**
 * @description：
 * @author：JBL
 * @date：2018/4/24
 */

public class BuilderTest {
    public static void main(String[] args) {
        Director cb =new Director();
        Product product = cb.constructProduct( new ConcreteBuilder() );
        System.out.println(product.getBasic());
        System.out.println(product.getWall());
        System.out.println(product.getRoofed());

    }
}
