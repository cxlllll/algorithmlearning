package com.teacherMAN.chapterOne;

/**
 * 循环链表
 */
public class DoublyLinkedListSentienl {
    private  Node sentienl=new Node(null,Integer.MIN_VALUE,null);

    public DoublyLinkedListSentienl(){
         // 烧饼节点在没有其他结点的时候 他的下指针和前指针都指向自己
       sentienl.prev = sentienl;
       sentienl.next  = sentienl;
    }

    private  static  class Node{
        Node prev;
        Node next;
        int value;
        public Node(Node prev,int value,Node next){
            this.next = next;
            this.prev =prev;
            this.value = value;
        }
    }

    // 能处理边界情况
    public void addLast(int value){
        Node lastNode = sentienl.prev;
        Node node = new Node(lastNode, value, sentienl);
        sentienl.prev = node;
        lastNode.next = node;
    }
    // 能处理边界情况
    public void addFirst(int value){
        Node next = sentienl.next;
        Node node = new Node(sentienl, value, next);
        sentienl.next  = node;
        next.prev = node;
    }

    public Node removeFirst(){
        Node next = sentienl.next;
        if(next == sentienl){
            throw new IllegalArgumentException("没有元素 不能删除");
        }
        Node nextNextNode = next.next;
        sentienl.next = nextNextNode;
        nextNextNode.prev = sentienl;
        return next;
    }

    public Node removeLast(){
        Node lastNode = sentienl.prev;
        if(lastNode == sentienl){
            throw new IllegalArgumentException("没有元素 不能删除");
        }
        Node prevNode = lastNode.prev;
        sentienl.prev = prevNode;
        prevNode.next = sentienl;
        return  lastNode;
    }

    /**
     *根据值删除元素
     * @param value
     */
    public void removeByvalue(int value){
//        Node  node = sentienl.next;
//        while (node !=  sentienl){
//            if(node.value == value){
//                node.prev.next = node.next;
//                node.next.prev = node.prev;
//            }
//            node = node.next;
//        }
        // 上面是我自己写的版本 下面是满老师版本
        Node byValue = findByValue(value);
        if(byValue == null){
            throw new IllegalArgumentException("参数不合法");
        }
        Node next = byValue.next;
        Node prev = byValue.prev;
        prev.next = next;
        next.prev = prev;
    }

    private  Node findByValue(int value){
        Node node = sentienl.next;
        while(node !=sentienl){
            if(node.value == value){
                return  node;
            }
            node = node.next;
        }
        return  null;
    }

}
