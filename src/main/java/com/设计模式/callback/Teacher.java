package com.���ģʽ.callback;

/**
 * @description��
 * @author��JBL
 * @date��2018/4/24
 */

public class Teacher implements Callback {
    private Student student;

    public Teacher(Student student) {
        this.student = student;
    }

    public void askQuestion() {
        student.resolveQuestion( this );
    }

    @Override
    public void tellAnswer(int answer) {
        System.out.println( "֪���ˣ���Ĵ���" + answer );
    }
}
