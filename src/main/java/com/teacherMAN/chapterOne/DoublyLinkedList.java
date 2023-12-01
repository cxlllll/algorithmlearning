package com.teacherMAN.chapterOne;

import java.util.Iterator;

/**
 * 双向链表 头哨兵 尾哨兵
 */
public class DoublyLinkedList implements Iterable{
    private final Node head;
    private final Node tail;

    public DoublyLinkedList(){
        head  = new Node(Integer.MIN_VALUE,null,null);
        tail  = new Node(Integer.MIN_VALUE,null,null);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 遍历
     * @return
     */
    @Override
    public Iterator iterator() {
        return new Iterator() {
            Node node = head.next;
            @Override
            public boolean hasNext() {
                return node == tail;
            }

            @Override
            public Object next() {
                return node = node.next;
            }
        };
    }

    private static class Node{
        int value;
        Node prev;
        Node next;

        public Node(int value,Node prev,Node next){
            this.value = value;
            this.prev = prev;
            this.next  = next;
        }
    }

    /**
     * 找某个索引的节点 找不到返回空
     * @param index
     * @return
     */
    private  Node findIndexNode(int index){
        // 这里-1是关键！！！
        int i = -1;
        Node node = head;
        while(node != tail){
            if(i == index){
                return node;
            }
            node = node.next;
            i++;
        }
        return null;
    }

    private  void insert(int index,int vavlue){
        // 先找到前一节点（-1的情况也能处理 返回的是头节点）
        Node prevNode = findIndexNode(index-1);
        // 因为index可能不合法 所以可能出现返回为null的情况
        if(prevNode==null){
            throw  new IllegalArgumentException("参数不合法");
        }
        Node next = prevNode.next;
        Node node = new Node(vavlue, prevNode, next);
        prevNode.next = node;
        next.prev = node;
    }

    /**
     * 按照索引删除元素
     */
    public Node remove(int index){
        Node node = findIndexNode(index);
        if(node == null){
            throw  new IllegalArgumentException("索引参数不合法");
        }
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        return node;
    }

    /**
     * 因为它存在为尾节点 所以可以进行尾节点相关的操作。
     * @param value
     */
    public void addLst(int value){
        Node prev = tail.prev;
        Node node = new Node(value, prev, tail);
        prev.next = node;
        tail.prev = node;
    }

    public void removeLast(){
        Node removeNode = tail.prev;
        // 如果 链表里没有元素 则不能进行删除 这个我没有考虑到
        if(removeNode == head){
            throw new IllegalArgumentException("不能删除");
        }
        Node prev = removeNode.prev;
        prev.next = tail;
        tail.prev = prev;
    }


}
