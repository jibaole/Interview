package com.设计模式.builder;

/**
 * @description：具体的产品---房子
 * @author：JBL
 * @date：2018/4/24
 */


public class Product {
    //地基
    private String basic;
    //墙
    private String wall;
    //楼顶
    private String roofed;

    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic = basic;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getRoofed() {
        return roofed;
    }

    public void setRoofed(String roofed) {
        this.roofed = roofed;
    }

}
