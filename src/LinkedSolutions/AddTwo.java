package LinkedSolutions;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*l1、l2和temp.next相加和为data和进位为carry,如果carry不为0,创建temp的下一个结点，并把进位的值设置为carry，
l1、l2指向下一个结点，进入下一次循环，首先判断temp.next是否存在，若不存在，创建temp的下一个结点temp.next，并把值设置为0，
继续求和，判断，指向下一个结点，直至l1和l2中有一个为null,然后对于只有一个为null的情况单独运算直至两个都为null
因为最后返回时要返回新链表的第一个结点，所有第一次计算放在了 循环外面，并记录结点start*/
public class AddTwo {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int addtwo = 0;
        int data = 0;
        int carry = 0;

        ListNode start = new ListNode(data);
        addtwo = l1.val + l2.val;
        if(addtwo!=0){
            data = addtwo%10;
            carry = addtwo/10;
        }
        start.val = data;
        if(carry!=0){
            ListNode l = new ListNode(carry);
            start.next = l;
        }
        l1 = l1.next;
        l2 = l2.next;
        ListNode temp = start;
        while((l1!=null)&&(l2!=null)){
            if(temp.next == null){
                ListNode m = new ListNode(0);
                temp.next = m;
            }
            addtwo = l1.val + l2.val + temp.next.val;
            if(addtwo!=0){
                data = addtwo%10;
                carry = addtwo/10;
            }else{
                data = 0;
                carry = 0;
            }
            temp.next.val = data;
            if(carry!=0){
                ListNode ll = new ListNode(carry);
                temp.next.next = ll;
            }
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if(l2 != null){
            while(l2!=null){
                if(temp.next == null){
                    ListNode m = new ListNode(0);
                    temp.next = m;
                }
                addtwo = l2.val + temp.next.val;
                if(addtwo!=0){
                    data = addtwo%10;
                    carry = addtwo/10;
                }else{
                    data = 0;
                    carry = 0;
                }
                temp.next.val = data;
                if(carry!=0){
                    ListNode ll = new ListNode(carry);
                    temp.next.next = ll;
                }
                temp = temp.next;

                l2 = l2.next;
            }

        }else{
            if(l1 != null){
                while(l1!=null){
                    if(temp.next == null){
                        ListNode m = new ListNode(0);
                        temp.next = m;
                    }
                    addtwo = l1.val + temp.next.val;
                    if(addtwo!=0){
                        data = addtwo%10;
                        carry = addtwo/10;
                    }else{
                        data = 0;
                        carry = 0;
                    }
                    temp.next.val = data;
                    if(carry!=0){
                        ListNode ll = new ListNode(carry);
                        temp.next.next = ll;
                    }
                    temp = temp.next;
                    l1 = l1.next;

                }
            }
        }
        return start;

    }
}
