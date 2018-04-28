package com.设计模式.callback;

import org.junit.Test;

/**
 * @description：
 * @author：JBL
 * @date：2018/4/24
 */

public class CallbackTest {
    @Test
    public void testCallback() {
        Student student = new Ricky();
        Teacher teacher = new Teacher( student );

        teacher.askQuestion();

    }
}
