package com.teacherMAN.chapterOne;

/**
 * 删除重复元素
 * 1. 解法一 ：两个指针 移动 如果指针值相等，删除元素并移动后一个指针 否则就两个指针都进行移动
 */
public class RemoveRepeatNode {
    public static void removeRepeatNode(ListNode node){
       ListNode p1 = node;
       ListNode p2 ;//先定义两个指针
        while((p2 = p1.next) != null){
            if(p1.val == p2.val){
                p1.next = p2.next;// 值一致就移动后一个指针
            }else{
                // 要是相邻值不一样 两个都指针都移动
                p1 = p1.next;
            }
        }
    }

    /**
     * 递归方式实现---需要在外层方法添加哨兵
     * @param node
     */
    public static  void removeRepeatNodeByDuiGui(ListNode node){
        if(node.next == null){
            return;
        }
        removeRepeatNodeByDuiGui(node.next);
        if(node.next.val == node.val){
            node.next = node.next.next;
        }
    }
    public static  ListNode remove(ListNode node){
        ListNode shaoBing = new ListNode(Integer.MIN_VALUE,node);
        removeRepeatNodeByDuiGui(shaoBing);
        return  shaoBing.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1,null);
        ListNode listNode2= new ListNode(2,null);
        ListNode listNode3= new ListNode(2,null);
        ListNode listNode4= new ListNode(2,null);
        ListNode listNode5= new ListNode(3,null);
        ListNode listNode6= new ListNode(6,null);
        ListNode listNode7= new ListNode(8,null);
        ListNode listNode8= new ListNode(8,null);
        ListNode listNode9= new ListNode(9,null);
        listNode1.next= listNode2;
        listNode2.next= listNode3;
        listNode3.next= listNode4;
        listNode4.next= listNode5;
        listNode5.next= listNode6;
        listNode6.next= listNode7;
        listNode7.next= listNode8;
        listNode8.next= listNode9;
        ListNode remove = remove(listNode1);
        System.out.println(remove);
    }
}
