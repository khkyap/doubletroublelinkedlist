import java.util.Objects;

public class DoubleLinkedList implements IntegerList //do not remove implements List.
{
    private Node<Integer> head;
    private int size;
    private Node<Integer> tail;


    public DoubleLinkedList()
    {
       this.head = null;
       this.size = 0;
       this.tail = null;
    }
    @Override
    public void add(Integer value)
    {
        add(size, value);
    }
    @Override
    public void add(int index, Integer value)
    {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Bad index at: " + index);
        }
        Node<Integer> n = new Node<Integer>(value);

        if (index == 0) {
            if (isEmpty()) {
                head = n;
                tail = n;
            }
             else {
             n.setNext(head);
             head.setPrev(n);
             head = n;
         }
        }
        else if (index == size){
            tail.setNext(n);
            n.setPrev(tail);
            tail = n;
        }
        else {
            if (index < (size / 2)) {
                Node<Integer> current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.getNext();
                }
                Node<Integer> second = current.getNext();
                n.setPrev(current);
                n.setNext(second);
                current.setNext(n);
                second.setPrev(n);
            } else {
                Node<Integer> current = tail;
                for (int i = size - 1; i > index; i--) {
                    current = current.getPrev();
                }
                Node<Integer> second = current.getPrev();
                second.setNext(n);
                n.setPrev(second);
                n.setNext(current);
                current.setPrev(n);
            }
        }
        size++;
    }

    @Override
    public void set(int index, Integer val) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index invalid: " + index);
        }

        Node<Integer> current;
        if (index < (size / 2)) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
        }
        else {
            current = tail;
            for (int i = size - 1; i > index; i--){
                current = current.getPrev();
            }
        }
        current.setValue(val);


    }
    @Override
    public void clear()
    {
        head = null;
        size = 0;
        tail = null;

    }

    @Override
    public Integer remove(int index) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Bad Index: " + index);
        }
            Integer removedValue;
            if (size == 1){
                removedValue = head.getValue();
                head = null;
                tail = null;
            }
            else if (index == 0){
                removedValue = head.getValue();
                head = head.getNext();
                head.setPrev(null);
            }
            else if (index == size - 1){
                removedValue = tail.getValue();
                tail = tail.getPrev();
                tail.setNext(null);
            }
            else {
                if (index < (size / 2)){
                    Node<Integer> prevNode = head;
                    for (int i = 0; i < index - 1; i++) {
                        prevNode = prevNode.getNext();
                    }
                    Node<Integer> nodeRemove = prevNode.getNext();
                    removedValue = nodeRemove.getValue();
                    Node<Integer> afterNode = nodeRemove.getNext();
                    prevNode.setNext(afterNode);
                    afterNode.setPrev(prevNode);
                }
                else {
                    Node<Integer> nodeToRemove = tail;
                    for (int i = size - 1; i > index; i--){
                        nodeToRemove = nodeToRemove.getPrev();
                    }

                    removedValue = nodeToRemove.getValue();
                    Node<Integer> nodeBefore = nodeToRemove.getPrev();
                    Node<Integer> nextNode = nodeToRemove.getNext();
                    nodeBefore.setNext(nextNode);
                    nextNode.setPrev(nodeBefore);
                }
            }
        size--;
        return removedValue;
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("invalid index: " + index);
        }
        Node<Integer> current;
        if (index < (size / 2)) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.getPrev();
            }
        }
        return current.getValue();
    }

    @Override
    public int size()
    {
        return size;
    }
    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public boolean contains(Integer val) {
        Node<Integer> current = head;
        while (current != null){
            if (Objects.equals(val, current.getValue())){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public int indexOf(Integer val) {
        int index = 0;
        Node<Integer> current = head;
        while (current != null){
            if (Objects.equals(val, current.getValue())){
                return index;
            }
            index++;
            current = current.getNext();
        }
        return -1;
    }

    @Override
    public String toString()
    {
        String finished = "";
        Node<Integer> current = head;
        while (current != null){
            finished += current.getValue();
            if (current.getNext() != null){
                finished += ", ";
            }
            current = current.getNext();
        }
        return finished;
    }

    public boolean equals(DoubleLinkedList otherList)
    {
        if (otherList == null){
            return false;
        }
        if (this.size != otherList.size) {
                return false;
            }
            Node<Integer> thisCurrent = this.head;
            Node<Integer> otherCurrent = otherList.head;
        while (thisCurrent != null){

            if (!Objects.equals(thisCurrent.getValue(), otherCurrent.getValue())){
                return false;
            }
            thisCurrent = thisCurrent.getNext();
            otherCurrent = otherCurrent.getNext();
           
        }

        return true;
    }

    //this method is complete.  It just calls the other equals method.  This method technically implements the method from List
    @Override
    public boolean equals(List<Integer> otherList)
    {
        return this.equals((DoubleLinkedList)otherList);
    }

}