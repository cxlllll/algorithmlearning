package com.teacherMAN.chapterOne;

/**
 * 假设是有哨兵元素的链表根据值删除链表的元素
 */
public class RemoveListNode {
    public static  ListNode  removeElements(ListNode head,int target){
        // 通过遍历进行删除元素
        ListNode shaoBing = new ListNode(-1,head);// 手动添加哨兵元素
        ListNode p1 = shaoBing;
        ListNode p2 =null;
        while((p2 =p1.next) != null){
            if(p2.val == target){
                p1.next = p2.next;
            }else {
                // 上面那种情况是不用平移的
                p1 = p1.next;
            }

        }
        return shaoBing.next;
    }

    /**
     * 递归方式实现
     * @param head
     * @param target
     * @return
     */
    public static  ListNode removeElement(ListNode head,int target){
        // 最底层返回null
        if(head == null){
            return null;

        }
        // 如果值相等 递归的归的时候直接不要这一层
        if(head.val == target){
            return removeElements(head.next,target);
        }else{
        //如果值不相等 递归的时候归的时候需要这一层
            head.next = removeElement(head.next,target);
            return  head;
        }

    }
}
