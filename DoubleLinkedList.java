import java.util.Objects;

public class DoubleLinkedList implements IntegerList //do not remove implements List.
{
    private Node<Integer> head;
    private int size;
    private Node<Integer> tail;


    public DoubleLinkedList()
    {
       this.head = head;
       this.size = 0;
       this.tail = tail;
    }
    @Override
    public void add(Integer value)
    {
        add(size, value);
    }
    @Override
    public void add(int index, Integer value)
    {  //complete this method.  If statements are set up for some cases, but you still need to implement


        Node<Integer> n = new Node<Integer>(value);

        if (index == 0) {
            n.setNext(head);
            head = n;
            //handle case:  we are adding to position 0 of the list
			//make sure this also handles the case where we are adding to an empty list.  These two cases can be handled by the same code.
			size++;  //we are tracking size as an instance variable.  Don't forget to update it where you need to.
        }
        if (index == size){
            n.setPrev(tail);
            tail = n;
            size++;
        }
        if (0 < index && index < size) {
             if (index < (size - index)) {
                Node<Integer> current = head;
                for (int i = 0; i < index - 1 && current != null; i++) {
                    current = current.getNext();
                }
                Node<Integer> second = current.getNext();
                if (current != null) {
                    n.setPrev(current);
                    n.setNext(second);
                    current.setNext(n);
                    second.setPrev(n);
                }
                //write the code to insert into the list.  It will go between the node currently at position index, and after the node at position index-1
                //make sure this also handles the case where we are adding to the last index of the list (where index == size)  These two cases can be handled by the same code.
                size++; //we are tracking size as an instance variable.  Don't forget to update it where you need to.
            } else if (index > (size - index)){
                 Node<Integer> current = tail;
                 for (int i = size; i > index + 1 && current != null; i--){
                     current = current.getPrev();
                 }
                 Node<Integer> second = current.getNext();

                 if (current != null){
                     n.setPrev(current);
                     n.setNext(second);
                     current.setNext(n);
                     second.setPrev(n);
                 }
                 size++;
             }else
                throw new IndexOutOfBoundsException("index: " + index);
        }
    }

    @Override
    public void set(int index, Integer val) {
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index invalid: " + index);
        }
        if (index < (size - index)) {
            Node<Integer> current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            current.setValue(val);
        }
        else if (index > (size - index)){
            Node<Integer> current = tail;
            for (int i = size; i > index; i--){
                current = current.getPrev();
            }
            current.setValue(val);
        }



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

        if (head != null){
            if (index == 0){
                head = head.getNext();
                size--;
            }
            if (index == size){
                tail = tail.getPrev();
                size--;
            }
            if (index < (size - index)){
                Node<Integer> current = head;
                for (int i = 0; i < index - 1 && current != null; i++) {
                    current = current.getNext();
                }
                if (current != null && current.getNext() != null && index >= 0){
                    current.setNext(current.getNext().getNext());
                    size--;
                } else{
                    throw new IndexOutOfBoundsException("Index invalid, try again: " + index);
                }
            }
            else if (index > (size - index)){
                Node<Integer> current = tail;
                for (int i = size; i > index + 1 && current != null; i--){
                    current = current.getPrev();
                }
                if (current != null && current.getPrev() != null && index >= 0){
                    current.setPrev(current.getPrev().getPrev());
                    size--;
                } else{
                    throw new IndexOutOfBoundsException("Index invalid, try again: " + index);
                }
            }
        }

        return index;
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("invalid index: " + index);
        }
        if (index < (size - index)) {
            Node<Integer> current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return current.getValue();
        }
        if (index > (size - index)) {
            Node<Integer> current = tail;
            for (int i = size; i > index; i--) {
                current = current.getPrev();
            }
            return current.getValue();
        }

        return -1;
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
        int index = 0;
        Node<Integer> current = head;
        while (current != null){
            if (val.equals(current.getValue())){
                return true;
            }
            index++;
            current = current.getNext();
        }
        return false;
    }

    @Override
    public int indexOf(Integer val) {
        int index = 0;
        Node<Integer> current = head;
        while (current != null){
            if (val.equals(current.getValue())){
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
        String finished = "[";
        Node<Integer> current = head;
        while (current != null){
            finished += current.getValue();
            if (current.getNext() != null){
                finished += ", ";
            }
            current = current.getNext();
        }
        return finished + "]";
    }

    public boolean equals(DoubleLinkedList otherList)
    {
        int count = 0;
        Node<Integer> current = head;
        if (size == otherList.size) {
            for (int i = 0; i < size; i++) {
                if ((Objects.equals(current.getValue(), otherList.get(i)))){
                    count++;
                }
                current = current.getNext();
            }
        }
        return count == size;
    }

    //this method is complete.  It just calls the other equals method.  This method technically implements the method from List
    @Override
    public boolean equals(List<Integer> otherList)
    {
        return this.equals((DoubleLinkedList)otherList);
    }

}