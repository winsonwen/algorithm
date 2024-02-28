import org.junit.jupiter.api.Test;

public class ListLeetCode {


    @Test
    public void removeElements203() {
    }

    @Test
    public void reverseList206(){

    }

    @Test
    public void MyLinkedList27() {
        /*
         * 初步思路   单链表 或  双向链表
         *  思路： 设置一个虚拟头结点作为初始值，让后续的所有操作进行一个统一
         *  如果不让操作进行一个统一，就很容易出现要考虑n种情况的情景，如何：  会有多余的思考空间
         *         1. 是否头结点
         *         2. 是否中间部位。。。
         * */

//        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.addAtHead(7);
//        myLinkedList.addAtHead(2);
//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtIndex(3, 0);
//        myLinkedList.deleteAtIndex(2);
//        myLinkedList.addAtHead(6);
//        myLinkedList.addAtTail(4);
//        myLinkedList.get(4);
//        myLinkedList.addAtHead(4);
//        myLinkedList.addAtIndex(5, 0);
//        myLinkedList.addAtHead(6);

//        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.addAtHead(1);
//        myLinkedList.addAtTail(3);
//        myLinkedList.addAtIndex(1, 2);
//        myLinkedList.get(1);
//        myLinkedList.deleteAtIndex(0);
//        myLinkedList.get(0);

        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(1);
        myLinkedList.addAtIndex(1, 2);
        myLinkedList.get(1);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.get(1);
        myLinkedList.get(3);

        myLinkedList.deleteAtIndex(3);
        myLinkedList.deleteAtIndex(0);
        myLinkedList.get(0);
        myLinkedList.deleteAtIndex(0);
        myLinkedList.get(0);


    }

    /*
     * 初步思路
     *  -> 查看每个next的val，在进行 List.next = List.next.next;
     *
     * 优化思路：
     *
     * */
    public ListNode removeElements203(ListNode head, int val) {
        ListNode tempList = head;
        while (tempList != null && tempList.next != null) {
            if (tempList.next.val == val) {
                tempList.next = tempList.next.next;
                continue;
            }
            tempList = tempList.next;
        }
        if (head != null && head.val == val) {
            head = head.next;
        }
        return head;
    }





    /*
     * 初步思路   设置三点，头
     *              prev 用来定位上一元素
     *              cur  用来定位要reverse的操作
     *              next 用来定位还没有reverse的节点
     *
     * 另一种思路 递归
     *  需巩固
     * */
    public ListNode reverseList206(ListNode head) {

        ListNode prev = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;// 保存下一个节点
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;

//        if(head ==null || head.next==null){
//            return head;
//        }
//        ListNode prev = head;
//        ListNode cur = head.next;
//        while(true){
//            ListNode next = cur.next;
//            if(next==null){
//                cur.next = prev;
//                prev =cur;
//                break;
//            }else{
//                cur.next = prev;
//                prev=cur;
//                cur = next;
//            }
//        }
//        head.next = null;
//        head =prev;
//        return head;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;

    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class MyLinkedList {
    ListNode head;
    int size;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode currentNode = head;
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        ListNode currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = currentNode.next;
        currentNode.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0 && size == 1) {
            head.next = null;
            size--;
            return;
        }
        ListNode currentNode = head;
        size--;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;


    }
}