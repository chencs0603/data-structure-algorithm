package personal.chencs.practice.linked;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: chencs
 * @date: 2020/4/19 10:41
 */
public class SingleLinkedList<T> {

    private SingleLinkedNode<T> head;

    public SingleLinkedNode<T> getHead() {
        return head;
    }

    public void insertToTail(T data) {
        SingleLinkedNode<T> newNode = new SingleLinkedNode<T>(data, null);

        if (null == head) {
            head = newNode;
        } else {
            SingleLinkedNode<T> tail = findTailNode();
            tail.setNext(newNode);
        }
    }

    public void insertToHead(T data) {
        SingleLinkedNode<T> newNode = new SingleLinkedNode<T>(data, null);
        if (null == head) {
            head = newNode;
        } else {
            SingleLinkedNode<T> tmpNode = head;
            head = newNode;
            head.setNext(tmpNode);
        }
    }

    public void deleteByData(T data) {
        SingleLinkedNode<T> targetBeforeNode = findByDataReturnBeforeNode(data);
        if (null == targetBeforeNode) {
            return;
        }
        SingleLinkedNode<T> targetNode = targetBeforeNode.getNext();
        targetBeforeNode.setNext(targetNode.getNext());
    }

    // 找到指定数据的前一个结点
    public SingleLinkedNode<T> findByDataReturnBeforeNode(T data) {
        SingleLinkedNode<T> targetBeforeNode = head;
        if (null == targetBeforeNode) {
            return null;
        }

        while (null != targetBeforeNode.getNext()) {
            if (targetBeforeNode.getNext().getData() != data) {
                targetBeforeNode = targetBeforeNode.getNext();
            } else {
                break;
            }
        }

        if (null == targetBeforeNode.getNext()) {
            return null;
        }

        return targetBeforeNode;
    }

    public void printAll() {
        List<T> dataList = getDataList();
        System.out.println(dataList);
    }

    public void removeTail() {
        SingleLinkedNode<T> tailBeforeNode = head;
        if (null == tailBeforeNode) {
            return;
        }
        while (null != tailBeforeNode.getNext().getNext()) {
            tailBeforeNode = tailBeforeNode.getNext();
        }
        // 删除尾结点
        tailBeforeNode.setNext(null);
    }

    private List<T> getDataList() {
        List<T> dataList = new ArrayList<T>();
        SingleLinkedNode<T> tmpNode = head;
        if (null == tmpNode) {
            return dataList;
        }

        while (null != tmpNode) {
            dataList.add(tmpNode.getData());
            tmpNode = tmpNode.getNext();
        }

        return dataList;
    }

    private SingleLinkedNode<T> findTailNode() {
        SingleLinkedNode<T> tmpNode = head;
        if (null == tmpNode) {
            return null;
        }
        while (null != tmpNode.getNext()) {
            tmpNode = tmpNode.getNext();
        }
        return tmpNode;
    }
}
