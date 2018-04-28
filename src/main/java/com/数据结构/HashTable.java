package com.数据结构;

/**
 * @description：哈希表
 * 参考地址：https://blog.csdn.net/laozhaokun/article/details/20604839
 * @author：JBL
 * @date：2018/4/14
 */

public class HashTable {
    Item[] hashArray;
    /**
     * 定义数组长度
     */
    int arraySize;

    /**
     * 构造器，初始化
     */
    public HashTable(int size) {
        arraySize = size;
        hashArray = new Item[arraySize];
    }

    /**哈希函数*/
    public int hash(int key) {
        return key % arraySize;
    }

    /**
     * 插入，这里假设是数组未满，即不能插入大于arraySize的数据数
     */
    public void insert(Item item) {
        int key = item.getKey();
        int hashCode = hash( key );
        /**若已存在同样的数据，则向下进一位，直到找到空的位置
          *为了简单，也可要求不准有重复数据*/
        while (hashArray[hashCode] != null) {
            ++hashCode;
            hashCode %= arraySize;
        }
        hashArray[hashCode] = item;
    }

    /**删除*/
    public Item delete(int key) {
        int hashCode = hash( key );
        while (hashArray[hashCode] != null) {
            if (hashArray[hashCode].getKey() == key) {
                Item temp = hashArray[hashCode];
                hashArray[hashCode] = null;
                return temp;
            }
            ++hashCode;
            hashCode %= arraySize;
        }
        return null;
    }

    /**
     * 查找
     */
    public Item find(int key) {
        int hashCode = hash( key );
        while (hashArray[hashCode] != null) {
            if (hashArray[hashCode].getKey() == key)
                return hashArray[hashCode];
            ++hashCode;
            hashCode %= arraySize;
        }
        return null;
    }

    /**
     * 列出全部数据
     */
    public void show() {
        for (int i = 0; i < arraySize; i++) {
            if (hashArray[i] != null) {
                System.out.print( hashArray[i].getKey() + " " );
            } else {
                System.out.print( "* " );
            }
        }
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable( 10 );
        ht.insert( new Item( 1 ) );
        ht.insert( new Item( 2 ) );
        ht.insert( new Item( 3 ) );
        ht.insert( new Item( 4 ) );
        ht.insert( new Item( 4 ) );
        ht.show();
        Item i = ht.find( 4 );
        System.out.println( "i = " + i.getKey() );
        Item di = ht.delete( 4 );
        System.out.println( "di = " + di.getKey() );
        ht.show();
    }
}

/**
 * 定义哈希表中存放的数据类型，可以为任意的类型
 */
class Item {
    int idata;

    public Item(int idata) {
        this.idata = idata;
    }

    public int getKey() {
        return idata;
    }
}