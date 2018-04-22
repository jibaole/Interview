package com.data;

/**
 * @description��������
 * �ο���ַ��https://www.cnblogs.com/whgk/p/6589920.html
 * @author��JBL
 * @date��2018/4/13
 */

public class LinkedList<T> {
    /**�����ͷ�ڵ�*/
    private Node<T> head;
    /**�����β�ڵ�*/
    private Node<T> tail;

    /**
     * ����һ��������
     */
    public LinkedList() {
        head = tail = null;
    }

    /**
     * �����ڲ��Ľڵ���
     */
    private static class Node<T> {
        /**�ڵ������*/
        T data;
        /**�ýڵ��ָ����һ���ڵ��ָ��*/
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }

    }

    /**
     * Ϊ����������ͷ���
     * @param point
     */
    public void addHead(T point) {
        this.head = new Node<T>(point);
        if(tail == null) {
            tail = head;
        }
    }

    /**
     * Ϊ��������β�ڵ�
     * @param point
     */
    public void addTail(T point){
        tail = new Node<T>(point);
        head.next = tail;
    }

    public void insert(T point) {
        if (this.head == null) {
            addHead(point);

        } else if (this.tail == this.head) {
            addTail(point);

        } else {
            Node<T> preNext = head.next;
            Node<T> newNode = new Node(point);
            preNext = head.next;
            this.head.next = newNode;
            newNode.next = preNext;
        }

    }

    /**
     * ��ӡ����
     */
    public void printLinkList() {
        Node<T> curr = this.head;
        while(curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }

    /**
     * ɾ��ĳһ�ڵ�
     * @param data
     */
    public void delete(T data){
        Node<T> curr = head, prev = null;
        /**�Ƿ�ɾ���ɹ���־*/
        boolean suc = false;
        while (curr != null) {
            if (curr.data.equals(data)) {
                //�ж���ʲô�ڵ�
                ///���ɾ������ͷ�ڵ�
                if (curr == head) {
                    System.out.println('\n'+"delete head node");
                    head = curr.next;
                    suc = true;
                    return;
                }
                //���ɾ������β�ڵ�
                if (curr == tail) {
                    System.out.println('\n'+"delete tail node");
                    tail = prev;
                    prev.next = null;
                    suc = true;
                    return;
                } else {//���ɾ�������м�ڵ㣨����ͷ�ڵ���β�ڵ㣩
                    System.out.println('\n'+"delete center node");
                    prev.next = curr.next;
                    suc = true;
                    return;
                }
            }
            prev = curr;
            curr = curr.next;
        }

        if(suc == false) {
            System.out.println('\n'+"û���������");
        }

    }

    public boolean isEmpty(){//�ж������Ƿ�Ϊ��
        return this.head == null || this.tail == null;
    }

    public static void main(String[] args) {
        //����һ��������
        LinkedList<Integer> mylist = new LinkedList<Integer>();
        mylist.insert(5);
        mylist.insert(6);
        mylist.insert(7);
        mylist.insert(3);
        mylist.printLinkList();
        mylist.delete(1);
        mylist.printLinkList();
        mylist.delete(5);
        mylist.printLinkList();
        mylist.delete(6);
        mylist.printLinkList();
    }

}
