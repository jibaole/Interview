package com.���ģʽ.builder;

/**
 * @description����������
 * @author��JBL
 * @date��2018/4/24
 */

public interface Builder {

    /**
     * �����
     */
    public void  buildBasic();

    /**
     * ��ǽ
     */
    public void  buildWalls();

    /**
     * �ⶥ
     */
    public void  roofed();

    /**
     * �췿��
     * @return
     */
    public Product buildProduct();
}
