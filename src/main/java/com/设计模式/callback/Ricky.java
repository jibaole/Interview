package com.���ģʽ.callback;

/**
 * @description��
 * @author��JBL
 * @date��2018/4/24
 */

public class Ricky implements Student {

    @Override
    public void resolveQuestion(Callback callback) {
        // ģ��������
        try {
            Thread.sleep( 3000 );
        } catch (InterruptedException e) {

        }

        // �ص���������ʦ��ҵд�˶��
        callback.tellAnswer( 3 );
    }
}
