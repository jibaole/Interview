package com.���ģʽ.builder;

/**
 * @description����װ��
 * @author��JBL
 * @date��2018/4/24
 */

public class Director {

    public Product constructProduct(ConcreteBuilder concreteBuilder){
        concreteBuilder.buildBasic();
        concreteBuilder.buildWalls();
        concreteBuilder.roofed();
        return concreteBuilder.buildProduct();
    }
}
