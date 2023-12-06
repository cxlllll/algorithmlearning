package com.teacherMAN.chapterOne;


/**
 * 删除倒数第N个节点
 */
public class RemoveIndexNode {
    public static int removeTargetIndexNode(ListNode node,int target){
        if(node.next == null){
            return 0;
        }
        int i = removeTargetIndexNode(node.next, target)+1;
        if(i == target){
            node.next = node.next.next;
        }
        return i;
    }

    public static ListNode remove(ListNode node,int target){
        ListNode shaoBing  = new ListNode(Integer.MIN_VALUE,node);
        if (node == null){
            return node;// 空的话就返回空
        }
        removeTargetIndexNode(shaoBing,target);
        return  shaoBing.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2,null);

        ListNode head1 = new ListNode(9,null);

        ListNode head2 = new ListNode(12,null);

        ListNode head3 = new ListNode(28,null);

        ListNode head4 = new ListNode(10,null);

        ListNode head5 = new ListNode(5,null);

        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        ListNode remove = remove(head, 6);
        System.out.println(remove);
    }
}


