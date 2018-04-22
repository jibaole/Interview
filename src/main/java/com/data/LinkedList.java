package com.data;

/**
 * @description：单链表
 * 参考地址：https://www.cnblogs.com/whgk/p/6589920.html
 * @author：JBL
 * @date：2018/4/13
 */

public class LinkedList<T> {
    /**链表的头节点*/
    private Node<T> head;
    /**链表的尾节点*/
    private Node<T> tail;

    /**
     * 构造一个空链表
     */
    public LinkedList() {
        head = tail = null;
    }

    /**
     * 链表内部的节点类
     */
    private static class Node<T> {
        /**节点的数据*/
        T data;
        /**该节点的指向下一个节点的指针*/
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }

    }

    /**
     * 为空链表增加头结点
     * @param point
     */
    public void addHead(T point) {
        this.head = new Node<T>(point);
        if(tail == null) {
            tail = head;
        }
    }

    /**
     * 为链表增加尾节点
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
     * 打印链表
     */
    public void printLinkList() {
        Node<T> curr = this.head;
        while(curr != null){
            System.out.print(curr.data+" ");
            curr = curr.next;
        }
    }

    /**
     * 删除某一节点
     * @param data
     */
    public void delete(T data){
        Node<T> curr = head, prev = null;
        /**是否删除成功标志*/
        boolean suc = false;
        while (curr != null) {
            if (curr.data.equals(data)) {
                //判断是什么节点
                ///如果删除的是头节点
                if (curr == head) {
                    System.out.println('\n'+"delete head node");
                    head = curr.next;
                    suc = true;
                    return;
                }
                //如果删除的是尾节点
                if (curr == tail) {
                    System.out.println('\n'+"delete tail node");
                    tail = prev;
                    prev.next = null;
                    suc = true;
                    return;
                } else {//如果删除的是中间节点（即非头节点或非尾节点）
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
            System.out.println('\n'+"没有这个数据");
        }

    }

    public boolean isEmpty(){//判断链表是否为空
        return this.head == null || this.tail == null;
    }

    public static void main(String[] args) {
        //构造一个空链表
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
