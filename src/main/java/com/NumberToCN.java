package com;

/**
 * ����ת��Ϊ����������ҵĴ�д<br>
 *
 * @author hongten
 * @contact hongtenzone@foxmail.com
 * @create 2013-08-13
 */
public class NumberToCN {
    private static String[] num = {"��", "һ", "��", "��", "��", "��", "��", "��", "��", "��", "ʮ"};

    private static String[] unit = {"", "ʮ", "��", "ǧ", "��", "ʮ", "��", "ǧ", "��"};

    private static String[] result;



    public static String transfer(String input) {
        int length = input.length();
        result = new String[length];
        //��String[]����
        for (int i = 0; i < length; i++) {
            result[i] = String.valueOf( input.charAt( i ) );
        }

        String out = "";
        for (int i = 0; i < length; i++) {
            if (!result[i].equals( "0" )) {
                int back = length - i - 1;
                out += num[Integer.parseInt( result[i] )];
                out += unit[back];
            } else {
                //���һλ������
                if (i == (length - 1)) {
                    if (length > 4 && result[length - 1].equals( "0" ) && result[length - 2].equals( "0" ) && result[length - 3].equals( "0" ) && result[length - 4].equals( "0" )) {
                        out += unit[4];
                    }
                } else {
                    //��λ����ǧ�򣬰���ʮ����λ��Ϊ0���򲻼ӡ���
                    if (length == 9 && result[1].equals( "0" ) && result[2].equals( "0" ) && result[3].equals( "0" ) && result[4].equals( "0" )) {
                    } else {
                        //������λ�����ŵ���������Ϊ0����λ����0����ϡ���
                        if (length > 4 && !result[i + 1].equals( "0" ) && result[length - 5].equals( "0" )) {
                            out += unit[4];
                        }
                    }
                    //��λ֮�������ʾ
                    if (i == length - 4 && !result[i + 1].equals( "0" )) {
                        out += num[0];
                    }
                }
            }
        }
        return out;
    }

    public static void main(String[] args) {

        System.out.println( transfer( "12300456" ) );
    }
}
