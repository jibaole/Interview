package com.设计模式.factory;

/**
 * @description：
 * @author：JBL
 * @date：2018/4/21
 */

abstract class BenzCar{
    private String name;

    public abstract void drive();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
//具体产品（Bmw和Audi同理）
class BenzSportCar extends BenzCar{
    @Override
    public void drive(){
        System.out.println(this.getName()+"----BenzSportCar-----------------------");
    }
}
class BenzBusinessCar extends BenzCar{
    @Override
    public void drive(){
        System.out.println(this.getName()+"----BenzBusinessCar-----------------------");
    }
}

abstract class BmwCar{
    private String name;

    public abstract void drive();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
class BmwSportCar extends BmwCar{
    @Override
    public void drive(){
        System.out.println(this.getName()+"----BmwSportCar-----------------------");
    }
}
class BmwBusinessCar extends BmwCar{
    @Override
    public void drive(){
        System.out.println(this.getName()+"----BmwBusinessCar-----------------------");
    }
}

abstract class AudiCar{
    private String name;

    public abstract void drive();

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
class AudiSportCar extends AudiCar{
    @Override
    public void drive(){
        System.out.println(this.getName()+"----AudiSportCar-----------------------");
    }
}
class AudiBusinessCar extends AudiCar{
    @Override
    public void drive(){
        System.out.println(this.getName()+"----AudiBusinessCar-----------------------");
    }
}


/**
 * 抽象工厂
 */
abstract class Driver3{
    public abstract BenzCar createBenzCar(String car) throws Exception;

    public abstract BmwCar createBmwCar(String car) throws Exception;

    public abstract AudiCar createAudiCar(String car) throws Exception;
}

/**
 * 具体工厂
 */
class SportDriver extends Driver3{
    @Override
    public BenzCar createBenzCar(String car) throws Exception {
        return new BenzSportCar();
    }
    @Override
    public BmwCar createBmwCar(String car) throws Exception {
        return new BmwSportCar();
    }
    @Override
    public AudiCar createAudiCar(String car) throws Exception {
        return new AudiSportCar();
    }
}
class BusinessDriver extends Driver3{
    @Override
    public BenzCar createBenzCar(String car) throws Exception {
        return new BenzBusinessCar();
    }
    @Override
    public BmwCar createBmwCar(String car) throws Exception {
        return new BmwBusinessCar();
    }
    @Override
    public AudiCar createAudiCar(String car) throws Exception {
        return new AudiBusinessCar();
    }
}

//老板
public class BossAbstractFactory {

    public static void main(String[] args) throws Exception {

        Driver3 d = new BusinessDriver();
        AudiCar car = d.createAudiCar("");
        car.drive();
    }
}
