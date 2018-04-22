package com.design_pattern.factory;

/**
 * @description��
 * @author��JBL
 * @date��2018/4/21
 */

//�����Ʒ
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

/**
 * �����Ʒ
 */
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


/**
 * ���󹤳�
 */
abstract class Driver{
    public abstract Car createCar(String car) throws Exception;
}

/**
 * ���幤����ÿ�����幤������һ�������Ʒ��
 */
class BenzDriver extends Driver{
    @Override
    public Car createCar(String car) throws Exception {
        return new Benz();
    }
}
class BmwDriver extends Driver{
    @Override
    public Car createCar(String car) throws Exception {
        return new Bmw();
    }
}

/**
 * �ϰ�
  */
public class Boss{

    public static void main(String[] args) throws Exception {
        Driver d = new BenzDriver();
        Car c = d.createCar("benz");
        c.setName("benz");
        c.drive();
    }
}
