[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=20675107)
# DOUBLE LINKED LIST

Look at the reading pp 36 - 37 in the "Advanced Computer Science" text.

A double-linked list data structure keeps track of both the first, and last nodes of the list.
Every node connects to the node after it (next), and also the node before it(prev)
The first node, doesn't have a node before it, so its prev value is NULL
The last node, doesn't have a node after it, so its next value is NULL
Make a new github repository.

Put a copy of the LIst.java interface, and the IntegerLIst.java interface (and optionally your Test.java class) in the repository.

Make a class called IntegerDoubleLinkedList

You might want to start by copying the code out of your IntegerLinkedList class so that you can revise it instead of starting from scratch.  

Some things to keep in mind:

Your Node class needs to have a .prev as well as a .next
You now have head and tail.  This comes into consideration in a lot of methods, including the Constructors, add, remove, clear, etc.  Just like there are special cases where you have to reset head, there are now special cases where you have to reset tail.  
Refactor get(index), set(index, item), add(index, item), and remove(index) so that they make a choice of whether to start at the beginning and work forward, or start at the end and work backward, depending upon whether the index is in the first half or the last half of the list.
Provide a good test method (or class) that

tests each of your methods
demonstrates that you have thought about and handled appropriate edge cases.

LinkedLists have some disadvantages.  For one thing, you find yourself traversing them linearly frequently.  For example, to get to the end of the list, you might do something like this:

            Node current = first;
            while (current.next() != null)
            {
                current = current.next();
            }
Note that adding to the BEGINNING of the list, is a much faster operation than adding to the end of the list.
