package com.jdk.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @description��
 * @author��JBL
 * @date��2018/5/2
 */

public class FullGC {
    static class  Person{}

    public static void main(String[] args) {
        List<Person> list=new ArrayList<Person>(  );
        int count=0;
        while (true){
            list.add( new Person() );
            System.out.println("instents:"+(++count));
        }
    }

}
