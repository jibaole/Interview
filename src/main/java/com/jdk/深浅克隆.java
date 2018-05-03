package com.jdk;

/**
 * @description��
 * @author��JBL
 * @date��2018/4/28
 * @url:http://www.cnblogs.com/xing901022/p/4051097.html
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

class Wife implements Serializable{
    private String name;
    private Date birthday;

    public Wife(){
        name = "ܽ�ؽ��";
        birthday = new Date();
    }
    public Date getBirthday(){
        return birthday;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
class Husband implements Cloneable,Serializable{
    private Wife wife;
    private Date birthday;

    public Husband(){
        wife = new Wife();
        birthday = new Date();
    }

    public Wife getWife(){
        return wife;
    }

    public Date getBirthday(){
        return birthday;
    }
    /**
     * ǳ��¡һ������
     */
    @Override
    public Object clone() {
        Husband husband = null;
        try{
            husband = (Husband)super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }finally{
            return husband;
        }
    }
    /**
     * ���ô��л����¡һ�����󣬰Ѷ����Լ��������ö��������д�������Ķ���
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public Object deepClone() throws IOException,ClassNotFoundException {
        //������д������
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        //�����������
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }
}
public class ��ǳ��¡ {
    public static void main(String[] args){
        try{
            Husband husband = new Husband();
            System.out.println("husband birthday "+husband.getBirthday().getTime());
            System.out.println("wife birthday "+husband.getWife().getBirthday().getTime());
            System.out.println();
            Husband husband1 = (Husband)husband.clone();
            System.out.println("husband1 birthday "+husband1.getBirthday().getTime());
            System.out.println("wife birthday "+husband1.getWife().getBirthday().getTime());
            System.out.println();
            System.out.println("�Ƿ���ͬһ��husband "+(husband == husband1));
            System.out.println("�Ƿ���ͬһ��wife "+ (husband.getWife() == husband1.getWife()));
            System.out.println();
            Husband husband2 = (Husband)husband.deepClone();
            System.out.println("husband2 birthday "+husband2.getBirthday().getTime());
            System.out.println("wife birthday "+husband2.getWife().getBirthday().getTime());
            System.out.println();
            System.out.println("�Ƿ���ͬһ��husband "+(husband == husband2));
            System.out.println("�Ƿ���ͬһ��wife "+ (husband.getWife() == husband2.getWife()));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}