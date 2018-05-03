package com.��.rbtree;

/**
 * @description��
 * @author��JBL
 * @date��2018/5/3
 */

import javax.swing.*;
import java.awt.*;

/**
 * Java ����: ���������
 *
 * @author skywang
 * @date 2013/11/07
 * @editor KnIfER
 * @date 2017/11/18
 */
public class RBTreeTest {
    static RBTree<Integer> tree;
    private static final int a[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120};
    private static final boolean mDebugInsert = false;    // "����"�����ļ�⿪��(false���رգ�true����)
    private static final boolean mDebugDelete = false;    // "ɾ��"�����ļ�⿪��(false���رգ�true����)

    public static void main(String[] args) {
        int i, ilen = a.length;
        tree = new RBTree<Integer>();

        System.out.printf( "== ԭʼ����: " );
        for (i = 0; i < ilen; i++)
            System.out.printf( "%d ", a[i] );
        System.out.printf( "\n" );

        for (i = 0; i < ilen; i++) {
            tree.insert( a[i] );
            // ����mDebugInsert=true,����"��Ӻ���"
            if (mDebugInsert) {
                System.out.printf( "== ��ӽڵ�: %d\n", a[i] );
                System.out.printf( "== ������ϸ��Ϣ: \n" );
                tree.print();
                System.out.printf( "\n" );
            }
        }

        System.out.printf( "== ǰ�����: " );
        tree.preOrder();

        System.out.printf( "\n== �������: " );
        tree.inOrder();

        System.out.printf( "\n== �������: " );
        tree.postOrder();
        System.out.printf( "\n" );

        System.out.printf( "== min: %s\n", tree.minimum() );
        System.out.printf( "== max: %s\n", tree.maximum() );
        System.out.printf( "== details: \n" );
        tree.print();
        System.out.printf( "\n" );

        // ����mDebugDelete=true,test remove func
        if (mDebugDelete) {
            for (i = 0; i < ilen; i++) {
                tree.remove( a[i] );

                System.out.printf( "== ɾ���ڵ�: %d\n", a[i] );
                System.out.printf( "== ������ϸ��Ϣ: \n" );
                tree.print();
                System.out.printf( "\n" );
            }
        }

        System.out.println( tree.search( 100 ).key + "" );
        System.out.println( tree.xxing( 99 ).key + "" );
        System.out.println( tree.xxing( 90 ).key + "" );
        System.out.println( tree.xxing( 89 ).key + "" );
        //draw our RnB Tree ~��~
        drawTree();
        //don't do this here����
        //tree.clear();
    }


    private static void drawTree() {
        EventQueue.invokeLater( new Runnable() {
            public void run() {
                // �������ڶ���
                MyFrame frame = new MyFrame();
                // ��ʾ����
                frame.setVisible( true );

            }
        } );
    }


    public static class MyFrame extends JFrame {
        public static final String TITLE = "���������";
        public static final int HEIGHT = 500;
        public static final int WIDTH = (int) (HEIGHT / 0.618);

        public MyFrame() {
            super();
            initFrame();
        }

        private void initFrame() {
            // ���� ���ڱ��� �� ���ڴ�С
            setTitle( TITLE );
            setSize( WIDTH, HEIGHT );
            // ���ô��ڹرհ�ť��Ĭ�ϲ���(����ر�ʱ�˳�����)
            setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
            // �Ѵ���λ�����õ���Ļ������
            setLocationRelativeTo( null );
            // ���ô��ڵ��������
            MyPanel panel = new MyPanel( this );
            setContentPane( panel );
        }

    }

    public static class MyPanel extends JPanel {
        private MyFrame frame;

        //����
        public MyPanel(MyFrame frame) {
            super();
            this.frame = frame;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent( g );
            ((Graphics2D) g).setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
            ((Graphics2D) g).setColor( Color.RED );
            ((Graphics2D) g).drawLine( 0, 25, 1366, 25 );
            ((Graphics2D) g).drawLine( 25, 768, 25, 0 );
            //((Graphics2D)g).drawLine(50, 50, 200, 50);
            final Graphics2D g2 = (Graphics2D) g.create();
            final float ratio = frame.getWidth() * .8f / (tree.maximum() - tree.minimum());
            final float offset = tree.minimum() * ratio - 25;
            //final float ratioVertival = frame.getHeight()*1.f/(tree.maximum() - tree.minimum());
            g2.setFont( new Font( null, Font.ITALIC, 25 ) );
            tree.SetInOrderDo( new RBTree.inOrderDo() {

                @Override
                public void dothis(RBTNode n) {
                    RBTNode<Integer> n2 = ((RBTNode<Integer>) n);
                    if (n2.color == true)
                        g2.setColor( Color.black );
                    else g2.setColor( Color.red );
                    g2.drawString( n2.key + "", n2.key * ratio - offset, tree.inorderCoounter2 * 100 );
                    g2.setColor( Color.BLUE );
                    //draw relationship line
                    if (n2.parent != null)
                        g2.drawLine( (int) (n2.key * ratio - offset), tree.inorderCoounter2 * 100, (int) (n2.parent.key * ratio - offset), (tree.inorderCoounter2 - 1) * 100 );
                }
            } );
            tree.inOrderDo();
        }

    }

}