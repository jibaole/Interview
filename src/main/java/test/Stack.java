package test;

/**
 * @description��
 * @author��JBL
 * @date��2018/4/17
 */

public class Stack {
    static class MysTack{
        int key;
        int stack[];

       public MysTack(int num){
            key=-1;
            stack=new int[num];
        }

        /**
         * ��ջ
         * @param x
         */
        void push(int x){
            key++;
            stack[key]=x;
        }

        /**
         * ��ջ
         */
        void pop(){
            key--;
        }

        /**
         * �ж��Ƿ�Ϊ��
         * @return
         */
        Boolean isEmtoy(){
            if(key == -1){
                return true;
            }else{
                return false;
            }
        }

        /**
         * ȡջ��
         * @return
         */
        int peek(){
            return stack[key];
        }

        /**
         * ��С
         * @return
         */
        int size(){
            return key+1;
        }
    }


    public static void main(String[] args) {
        MysTack m=new MysTack( 10 );

        m.push( 1 );
        m.push( 2 );
        m.push( 3 );
        m.push( 4 );
        System.out.println(m.size());

        for(int i=m.size();i>0;i--){
            int get =m.peek();
            m.pop();
            System.out.println(get);
        }
    }
}
