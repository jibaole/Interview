package com.设计模式.builder;

/**
 * @description：抽象建筑者
 * @author：JBL
 * @date：2018/4/24
 */

public interface Builder {

    /**
     * 打基础
     */
    public void  buildBasic();

    /**
     * 砌墙
     */
    public void  buildWalls();

    /**
     * 封顶
     */
    public void  roofed();

    /**
     * 造房子
     * @return
     */
    public Product buildProduct();
}
