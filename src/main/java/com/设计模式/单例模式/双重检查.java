package com.���ģʽ.����ģʽ;

/**
 * @description��
 * @author��JBL
 * @date��2018/5/1
 */

public class ˫�ؼ�� {
    private static volatile ˫�ؼ�� singleton;

    private ˫�ؼ��() {}

    public static ˫�ؼ�� getInstance() {
        if (singleton == null) {
            synchronized (˫�ؼ��.class) {
                if (singleton == null) {
                    singleton = new ˫�ؼ��();
                }
            }
        }
        return singleton;
    }
}
