package test;

public class Linked_List
{
    public class node
    {
        private int val;
        public node next;
        public node(int n) {val = n; next = null;}
    }

    private node head;

    public Linked_List() {head = null;}


    public void insert(int n)
    {
        node newNode = new node(n);
        newNode.next = head;
        head = newNode;
    }


    public Linked_List mirror()
    {
        node slow = head.next;
        node prev = head.next;
        node fast = prev.next;

        while (true)
        {
            if (fast.next == null)
            {
                Linked_List ret = new Linked_List();
                ret.head = fast;
                while (true)
                {
                    fast.next = prev;
                    fast = prev;
                    if (fast == slow)
                    {
                        fast.next = null;
                        return ret;

                    }
                    prev.next = slow;
                    while(prev.next != fast) prev = prev.next;

                }


            }
            else { slow = slow.next; prev=prev.next.next; fast = fast.next.next; }
        }
    }

    public void printList()
    {
        node i = head;
        while(true)
        {
            System.out.print(i.val + " ");
            if (i.next == null) break;
            i = i.next;
        }
    }



}
