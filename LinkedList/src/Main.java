public class Main {
    public static void main(String[] args) {
        final Solution solution = new Solution();
        // Example 1
        final ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        final ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        final ListNode mergedList1 = solution.mergeTwoLists(list1, list2);
        printList(mergedList1);

        // Example 2
        final ListNode list3 = null;
        final ListNode list4 = null;
        final ListNode mergedList2 = solution.mergeTwoLists(list3, list4);
        printList(mergedList2);

        // Example 3
        final ListNode list5 = null;
        final ListNode list6 = new ListNode(0);
        final ListNode mergedList3 = solution.mergeTwoLists(list5, list6);
        printList(mergedList3);
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
