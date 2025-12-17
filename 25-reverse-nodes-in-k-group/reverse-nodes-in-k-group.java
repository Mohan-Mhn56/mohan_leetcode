/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p=new ListNode();
        p=null;
        ListNode c=head;
        ListNode n=c.next;
        int repeatition=0;
        int length=0;
        ListNode node=head;
        while(node!=null)
        {
            length++;
            node=node.next;
        }
        ListNode first=new ListNode();
        ListNode lastf=new ListNode();
        ListNode lasts=new ListNode();
        lastf=head;
        int x=length%k;
        int y=length-x;
        int times=y/k;
        while(repeatition<times)
        {
            for(int i=0; i<k; i++)
            {
                if(c!=null) c.next=p;
                p=c;
                c=n;
                if(n!=null) n=n.next;
            }
            if(repeatition==0)
            {
                head=p;
                first=c;
            }
            else if(repeatition>0)
            {
                lasts=p;
                lastf.next=lasts;
                lastf=first;
                first=c;
            }
            repeatition++;
        }
        lastf.next=c;
        return head;
    }
}