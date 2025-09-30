public class Node<E extends Comparable>
{
    //instance data  (you can remove the visibility modifier private, if you want to access this directly from IntegerLinkedList class.
    private E val;
    private Node<E> next;
    private Node<E> prev;

    //Constructor
    public Node (E value)
    {
        val = value;
        next =  null;
        prev = null;
    }

    public Node (E value, Node<E> next)
    {
        val = value;
        this.next = next;
        this.prev = prev;
    }

    //Two Accessor methods
    public Node<E> getNext()
    {
        return next;
    }
    public Node<E> getPrev()
    {
        return prev;
    }
    public E getValue()
    {
        return val;
    }

    //Two Mutator methods
    public void setNext(Node<E> n)
    {
        this.next = n;
    }
    public void setPrev(Node<E> n)
    {
        this.prev = n;
    }

    public void setValue(E value)
    {
        this.val = value;
    }
}
