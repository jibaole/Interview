package com.framework.rpc;

/**
 * @description��
 * @author��JBL
 * @date��2018/5/1
 */

public class HelloServiceImpl implements HelloService {
    @Override
        public String hello(String name) {
            return "Hello " + name;
        }
    }
