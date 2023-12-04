class LinkedList
{
    Node top;
    public static class Node
    {
        public int data;
        public Node next;

        public Node(int data)
        {
            this.data = data;
        }
    }
    public void insertFirst(int data)
    {
        Node n = new Node(data);
        n.next = top;
        top = n;
    }
    public Node deleteFirst()
    {
        Node temp = top;
        top = top.next;
        return temp;
    }
    public void displayList()
    {
        Node curr = top;
        while(curr != null)
        {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }
}
class LinkedListStack
{
    LinkedList l1 = new LinkedList();

    public void push(int element)
    {
        l1.insertFirst(element);
    }
    public void pop()
    {
        l1.deleteFirst();
    }
    public void displayStack()
    {
        System.out.println("  ");
        l1.displayList();
    }
}
class LLStackClient
{
    public static void main(String[] args) {
        LinkedListStack s1 = new LinkedListStack();


        s1.push(69);
        s1.push(50);
        s1.push(70);
        s1.push(190);


        System.out.println("1. Stack after push operation: ");
        s1.displayStack();
        System.out.println("\n2. Stack after pop operation: ");
        s1.pop();
        s1.pop();
        s1.pop();
        s1.displayStack();

    }
}