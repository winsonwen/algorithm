import org.junit.jupiter.api.Test;

public class ListLeetCode2 {


    @Test
    public void swapPairs24() {
        ListNode listNode4 = new ListNode(4);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        swapPairs24(listNode1);

    }

    @Test
    public void removeNthFromEnd19() {
    }


    @Test
    public void detectCycle142() {
    }

    @Test
    public void getIntersectionNode160() {


    }


    /*
     * 设置一个虚拟头结点
     *      prev 上一个结尾
     *      cur 需要操作的前节点
     *      next 需要操作的后节点
     *
     *  */
    public ListNode swapPairs24(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = new ListNode(-1, head);
        ListNode cur = head;
        ListNode next;
        head = prev;

        while (cur != null && cur.next != null) {
            next = cur.next;
            prev.next = next;
            cur.next = next.next;
            next.next = cur;
            prev = cur;
            cur = cur.next;
        }
        return head.next;
    }



    /*
     * 配置一个虚拟节点
     * 并配置快慢指针即可
     * */
    public ListNode removeNthFromEnd19(ListNode head, int n) {
        head = new ListNode(-1, head);

        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return head.next;
    }



    /*
    * detectCycle142
    * 只用快慢指针来判断圆是否循环
    *        fast=fast.next.next;
            slow=slow.next;
    *      根据以上： 慢指针并不会在环内走超过一圈
    *
    * 如果有环，如何找到这个环的入口
    *        x为非环内长度
    *       y为slow指针在环内走的步数
    *       z为环内slow还未走的步数
    *       那么相遇时： slow指针走过的节点数为: x + y， fast指针走过的节点数：x + y + n (y + z)，n为fast指针在环内走了n圈才遇到slow指针， （y+z）为 一圈内节点的个数A。
    *           因为fast指针是一步走两个节点，slow指针一步走一个节点， 所以 fast指针走过的节点数 = slow指针走过的节点数 * 2：
    *           (x + y) * 2 = x + y + n (y + z)
    *           x = (n - 1) (y + z) + z
    *           针对于 n大于1和等于1其实一样效果，因为slow永远只用x+y步，并不会在环内走一圈以上
    *       得出 x= z，再根据此公式得出环入口
    * */
    public ListNode detectCycle142(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow == fast){
                ListNode index1 = head;
                ListNode index2 = fast;
                while(index1 != index2){
                    index1=index1.next;
                    index2=index2.next;
                }
                return index1;
            }
        }
        return null;
    }



    /*
    * getIntersectionNode160
    * 思路： 先找到各数组的长度  ->  A = a + z   B= b+z
    *           先定位到一样的长度，在进行比较遍历
    * */
    public ListNode getIntersectionNode160(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;

        int sizeA = 0, sizeB = 0;
        while (curA != null) {
            sizeA++;
            curA = curA.next;
        }
        while (curB != null) {
            sizeB++;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;
        if (sizeA > sizeB) {
            for (int i = 0; i < sizeA - sizeB; i++) {
                curA = curA.next;
            }
        } else if (sizeB > sizeA) {
            for (int i = 0; i < sizeB - sizeA; i++) {
                curB = curB.next;
            }
        }

        while (curA != null && curB != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }

        return null;

    }
}