package com.framework.rpc;

/**
 * @description��������
 * @author��JBL
 * @date��2018/5/1
 */

public class RpcProvider {
    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        //��¶�ӿ�
        RpcFramework.export(service, 1234);
    }
}
