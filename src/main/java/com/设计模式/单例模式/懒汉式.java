package com.���ģʽ.����ģʽ;

/**
 * @description��
 * @author��JBL
 * @date��2018/5/1
 */

public class ����ʽ {
    private static ����ʽ singleton;

    private ����ʽ() {}

    public static ����ʽ getInstance() {
        if (singleton == null) {
            singleton = new ����ʽ();
        }
        return singleton;
    }
}
