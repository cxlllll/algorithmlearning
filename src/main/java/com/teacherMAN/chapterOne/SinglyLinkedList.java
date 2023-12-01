package com.teacherMAN.chapterOne;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 单项链表
 */
public class SinglyLinkedList<U> implements Iterable{
    private Node<U> head;

    public void addFirst(U value){
        // 链表为空
//        head=new Node<U>(value,null);
        // 链表不为空
        head = new Node<U>(value,head);
    }

    @Override
    public Iterator iterator() {
        return  new Iterator() {
            Node node  = head;
            @Override
            public boolean hasNext() {
                return node == null;
            }

            @Override
            public Object next() {
                Object value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    /**
     * 私有内部类的原因：就是不能暴漏内部实现
     */
    private static  class Node<T>{
          T value;
          Node next;

        public Node(T value,Node next){
            this.value = value;
            this.next=next;
        }

        public Node getNext() {
            return next;
        }

        public T getValue() {
            return value;
        }
    }

    private void loop(Consumer<U> consumer){
        Node node = head;
        while(node != null){
            consumer.accept((U)node.value);
            node = node.next;
        }
    }

    private void loop2(Consumer<U> consumer){

        for(Node node = head;node != null;node = node.next){
            consumer.accept((U) node.value);
        }
    }


    private Node findLast(){
        Node node = head;
        if(node == null){
//            return node;
        }else {
            while (node.next != null) {
                node = node.next;
            }
        }
        return node;
    }

    public void addLast(U value){
        Node last = findLast();
        last.next = new Node(value,null);
    }

    private Node findIndexNode(int index){
        int i = 0;
        for(Node node = head;node != null;node= node.next,i++){
            if(index == i){
                return  node;
            }
        }
        return  null;
    }

    public Node get(int index){
        Node indexNode = findIndexNode(index);
        if(indexNode == null){
            throw new IllegalArgumentException("参数异常");
        }
        return  indexNode;
    }

    public Node removeFirst(){
        Node indexNode = head;
        if(head == null){
            throw  new IllegalArgumentException("链表长度为0");
        }
        head = head.next;
        return indexNode;
    }

    public Node removeIndex(int index){
        // 先寻找前节点
        Node node  = findIndexNode(index-1);
        if(node == null){
            throw new IllegalArgumentException("参数不合法");
        }
        // 删除位置的节点
        Node removeNode = node.next;
        if(removeNode == null){
            throw new IllegalArgumentException("参数不合法");
        }
        node.next = removeNode.next;
        return removeNode;
    }
}
