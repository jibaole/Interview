package com.���ݽṹ;

/**
 * @description����ϣ��
 * �ο���ַ��https://blog.csdn.net/laozhaokun/article/details/20604839
 * @author��JBL
 * @date��2018/4/14
 */

public class HashTable {
    Item[] hashArray;
    /**
     * �������鳤��
     */
    int arraySize;

    /**
     * ����������ʼ��
     */
    public HashTable(int size) {
        arraySize = size;
        hashArray = new Item[arraySize];
    }

    /**��ϣ����*/
    public int hash(int key) {
        return key % arraySize;
    }

    /**
     * ���룬�������������δ���������ܲ������arraySize��������
     */
    public void insert(Item item) {
        int key = item.getKey();
        int hashCode = hash( key );
        /**���Ѵ���ͬ�������ݣ������½�һλ��ֱ���ҵ��յ�λ��
          *Ϊ�˼򵥣�Ҳ��Ҫ��׼���ظ�����*/
        while (hashArray[hashCode] != null) {
            ++hashCode;
            hashCode %= arraySize;
        }
        hashArray[hashCode] = item;
    }

    /**ɾ��*/
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
     * ����
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
     * �г�ȫ������
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
 * �����ϣ���д�ŵ��������ͣ�����Ϊ���������
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