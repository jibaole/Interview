package test;

/**
 * @description：
 * @author：JBL
 * @date：2018/4/17
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
         * 进栈
         * @param x
         */
        void push(int x){
            key++;
            stack[key]=x;
        }

        /**
         * 出栈
         */
        void pop(){
            key--;
        }

        /**
         * 判断是否为空
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
         * 取栈顶
         * @return
         */
        int peek(){
            return stack[key];
        }

        /**
         * 大小
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
