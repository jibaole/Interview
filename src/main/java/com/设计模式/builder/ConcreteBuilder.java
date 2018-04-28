package com.设计模式.builder;

/**
 * @description：具体建筑者
 * @author：JBL
 * @date：2018/4/24
 */

public class ConcreteBuilder implements Builder {
    private Product product;

    public ConcreteBuilder() {
        product = new Product();
    }

    @Override
    public void buildBasic() {
        product.setBasic( "打好基础" );
    }

    @Override
    public void buildWalls() {
        product.setWall( "砌墙" );
    }

    @Override
    public void roofed() {
        product.setRoofed( "封顶大吉" );
    }

    @Override
    public Product buildProduct() {
        return product;
    }

}
