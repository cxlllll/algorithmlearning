package com.teacherMAN.chapterOne;

/**
 * 链表反转
 */
public class ListReverse {
    /**
     * 遍历旧列表 每得到一个元素就可以存入新列表的头部
     * @param listNode
     */
    public static  ListNode reverse(ListNode listNode){
        ListNode newList = null;
        ListNode p1  = listNode;// 借助指针
        while(p1 != null){
            newList = new ListNode(p1.val,newList);
            p1 = p1.next;
        }
        return  newList;
    }

    /**
     * 使用递归进行反转
     * @return
     */
    public static  ListNode reverse2(ListNode head){
        // 递归找出了最后一个元素 因为链表用起始节点来代表整个链表
        if(head == null || head.next == null ){
            return head;
        }
        ListNode listNode = reverse2(head.next);
        // 反转之后进行操作 （如果是反转之前进行操作 就会找不到下一元素，递归不会正常到底）
        head.next.next = head;
        head.next= null;
        return listNode;
    }
}

