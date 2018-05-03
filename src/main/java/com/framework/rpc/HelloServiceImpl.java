package com.framework.rpc;

/**
 * @description£º
 * @author£ºJBL
 * @date£º2018/5/1
 */

public class HelloServiceImpl implements HelloService {
    @Override
        public String hello(String name) {
            return "Hello " + name;
        }
    }
