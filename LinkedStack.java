/**
 * Write a description of class LinkedStack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LinkedStack<T> implements StackInterface<T>
{
    // instance variables - replace the example below with your own
    private int size;
    private Node<T> log;
    /**
     * Constructor for objects of class ArrayStack
     */
    public LinkedStack()
    {
        size = 0;
        log = null;
    }
    

    // Returns the logical size of this StringLog.
    public int size()
    {
        return size;
    }
    
    // Returns true if this list contains no elements.
    public boolean empty()
    {
        return size == 0;
    }
    // Returns true if this list is completely full.
    public T peek() throws StackUnderflowException{
         if (size == 0 || log == null) {
        throw new StackUnderflowException();
        }
        else {
        Node<T> currIndex = log;
        int count = 0;
        while (count < size - 1) {
            currIndex = currIndex.getNext();
            count++;
        }
        return currIndex.getData();   
    }
    }
    public T pop() throws StackUnderflowException{
        if (size == 0 || log == null) {
        throw new StackUnderflowException();
    } else {
        Node<T> currIndex = log;
        Node<T> prev = null;
        while (currIndex.getNext() != null) {
            prev = currIndex;
            currIndex = currIndex.getNext();
        }
        if (prev == null) {
            log = null;
        } else {
            prev.setNext(null);
        }
        size--;
        return currIndex.getData();
    }
    }
    public boolean isFull()
    {
        return false;
    }
    public T push(T item){
        Node<T> newNode = new Node<>(item);
    if (log == null) {
        log = newNode;
    } else {
        Node<T> currIndex = log;
        while (currIndex.getNext() != null) {
            currIndex = currIndex.getNext();
        }
        currIndex.setNext(newNode);
    }
    size++;
    return item;
    }
    public void clear(){
        log = null;
        size =0;
    }
    public int search(Object o){
        Node<T> currIndex = log;
        int count = 0;
    
        while (currIndex != null) {
            if (currIndex.getData().equals(o)) {
                return size - count;
            }
            currIndex = currIndex.getNext();
            count++;
        }
    
        return -1;
    }
}


