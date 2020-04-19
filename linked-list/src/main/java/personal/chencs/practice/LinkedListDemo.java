package personal.chencs.practice;

import personal.chencs.practice.linked.SingleLinkedList;

/**
 * @author: chencs
 * @date: 2020/4/19 10:19
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<Integer>();

        for (int i = 0; i < 10; i++) {
//            linkedList.insertToTail(i);
            linkedList.insertToHead(i);
        }

        System.out.println("-------原始数据-------");
        linkedList.printAll();

        System.out.println("-------删除后的数据-------");
        linkedList.deleteByData(5);
        linkedList.printAll();

        System.out.println("-------删除尾结点后的数据-------");
        linkedList.removeTail();
        linkedList.printAll();
    }
}
