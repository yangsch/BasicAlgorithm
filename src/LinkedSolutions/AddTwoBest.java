package LinkedSolutions;
public class AddTwoBest {
/*最优解法*/
/*思路与自己的加法相同，通过一些技巧减少了代码量增快了速度
1.默认链表为循环链表，所以返回新链表的第一个结点，就是最后一个结点的next，所以不需要将第一个计算单独提出来
2.在相加前进行判断，若l1或l2为null，则将此加数设置为0，减少了l1和l2任一个单独为null时的代码
3.加法完成后记录只carry的值，不创建下一个结点，在下一次计算时直接使用它的值进行相加，余数作为新链表当前节点的值，并记录carry的值*/
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current = new ListNode(0);
        ListNode result = current;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        return result.next;
    }
}
