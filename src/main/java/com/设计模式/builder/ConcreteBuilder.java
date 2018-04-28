package com.���ģʽ.builder;

/**
 * @description�����彨����
 * @author��JBL
 * @date��2018/4/24
 */

public class ConcreteBuilder implements Builder {
    private Product product;

    public ConcreteBuilder() {
        product = new Product();
    }

    @Override
    public void buildBasic() {
        product.setBasic( "��û���" );
    }

    @Override
    public void buildWalls() {
        product.setWall( "��ǽ" );
    }

    @Override
    public void roofed() {
        product.setRoofed( "�ⶥ��" );
    }

    @Override
    public Product buildProduct() {
        return product;
    }

}
