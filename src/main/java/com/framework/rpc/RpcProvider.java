package com.framework.rpc;

/**
 * @description：生产者
 * @author：JBL
 * @date：2018/5/1
 */

public class RpcProvider {
    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        //暴露接口
        RpcFramework.export(service, 1234);
    }
}
