package com.设计模式.builder;

/**
 * @description：组装者
 * @author：JBL
 * @date：2018/4/24
 */

public class Director {

    public Product constructProduct(ConcreteBuilder concreteBuilder){
        concreteBuilder.buildBasic();
        concreteBuilder.buildWalls();
        concreteBuilder.roofed();
        return concreteBuilder.buildProduct();
    }
}
