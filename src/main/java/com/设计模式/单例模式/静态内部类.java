package com.���ģʽ.����ģʽ;

/**
 * @description��
 * @author��JBL
 * @date��2018/5/1
 */

public class ��̬�ڲ��� {

        private ��̬�ڲ���() {}

        private static class SingletonInstance {
            private static final ��̬�ڲ��� INSTANCE = new ��̬�ڲ���();
        }

        public static ��̬�ڲ��� getInstance() {
            return SingletonInstance.INSTANCE;
        }
    }


