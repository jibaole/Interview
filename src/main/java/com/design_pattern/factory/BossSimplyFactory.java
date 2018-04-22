/*
package com.design_pattern.factory;

import java.io.IOException;

*/
/**
 * @description��
 * @author��JBL
 * @date��2018/4/21
 *//*


*/
/**
 * �����Ʒ
 *//*

abstract class Car{
    private String name;

    public abstract void drive();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}

*/
/**
 * �����Ʒ
 *//*

class Benz extends Car{
    @Override
    public void drive(){
        System.out.println(this.getName()+"---Benz-go-----------------------");
    }
}

class Bmw extends Car{
    @Override
    public void drive(){
        System.out.println(this.getName()+"---Bmw-go-----------------------");
    }
}

*/
/**
 * �򵥹���
 *//*

class Driver{
    public static Car createCar(String car){
        Car c = null;
        if("Benz".equalsIgnoreCase(car))
            c = new Benz();
        else if("Bmw".equalsIgnoreCase(car))
            c = new Bmw();
        return c;
    }
}

*/
/**
 * �ϰ�
 *//*

public class BossSimplyFactory {

    public static void main(String[] args) throws IOException {
        //�ϰ����˾���ҽ���������
        Car car = Driver.createCar( "benz" );
        car.setName( "benz" );
        //˾�����ű��۳���
        car.drive();
    }
}
*/
