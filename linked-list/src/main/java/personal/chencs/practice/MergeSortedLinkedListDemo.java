package personal.chencs.practice;

import personal.chencs.practice.linked.SingleLinkedList;
import personal.chencs.practice.linked.SingleLinkedNode;

/**
 * @author: chencs
 * @date: 2020/4/19 17:11
 */
public class MergeSortedLinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList<Integer> linkedList1 = new SingleLinkedList<Integer>();
        linkedList1.insertToTail(1);
        linkedList1.insertToTail(3);
        linkedList1.insertToTail(5);


        SingleLinkedList<Integer> linkedList2 = new SingleLinkedList<Integer>();
        linkedList2.insertToTail(2);
        linkedList2.insertToTail(4);
        linkedList2.insertToTail(6);
        linkedList2.insertToTail(8);

        SingleLinkedList<Integer> result = merge(linkedList1, linkedList2);
        result.printAll();
    }

    /**
     * 合并两个有序链表（从小到大排序），且合并后的链表仍然是有序的
     * 两个指针分别遍历两个链表，比较两个链表中的当前元素，将小的元素插入结果中
     *
     * @param linkedList1
     * @param linkedList2
     * @return
     */
    public static SingleLinkedList<Integer> merge(SingleLinkedList<Integer> linkedList1,
                                                  SingleLinkedList<Integer> linkedList2) {
        SingleLinkedNode<Integer> tmpNode1 = linkedList1.getHead();
        SingleLinkedNode<Integer> tmpNode2 = linkedList2.getHead();
        if (null == tmpNode1) {
            return linkedList2;
        }
        if (null == tmpNode2) {
            return linkedList1;
        }

        SingleLinkedList<Integer> result = new SingleLinkedList<Integer>();
        while (null != tmpNode1 && null != tmpNode2) {
            if (tmpNode1.getData() >= tmpNode2.getData()) {
                result.insertToTail(tmpNode2.getData());
                tmpNode2 = tmpNode2.getNext();
            } else {
                result.insertToTail(tmpNode1.getData());
                tmpNode1 = tmpNode1.getNext();
            }
        }

        // 将剩余元素直接插入到结果末尾
        SingleLinkedNode<Integer> remainNode = null != tmpNode1 ? tmpNode1 : tmpNode2;
        while (null != remainNode) {
            result.insertToTail(remainNode.getData());
            remainNode = remainNode.getNext();
        }

        return result;
    }

}
