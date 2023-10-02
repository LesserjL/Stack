
/**
 * Write a description of class ArrayStack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ArrayStack<T> implements StackInterface<T>
{
    private int size;
    private T[] log;
    /**
     * Constructor for objects of class ArrayStack
     */
    public ArrayStack()
    {
        size = 0;
        log = (T[]) new Object[4];
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
        else{
            return log[size-1];   
        }
    }
    public T pop() throws StackUnderflowException{
        if (size == 0 || log == null) {
        throw new StackUnderflowException();
        }
        else{
        T removedElement = log[size-1];
        log[size - 1] = null;
        size--;
        return removedElement;
        }
    }
    public boolean isFull()
    {
        return size == log.length;
    }
    public T push(T item){
        T[] log2 = (T[]) new Object[log.length*2];
        if(!isFull()){
            log[size++] = item;
        }
        else{
           for(int i = 0; i < size; i++){
               log2[i] = log[i];
           }
           log2[size] = item;
           size++;
           log = log2;
        }
        return item;
    }
    public void clear(){
        log = null;
        size =0;
    }
    public int search(Object o){
        for(int i = size-1; i >= 0; i--){
            if(log[i].equals(o)){
                return size - i;
            }
        }
        return -1;
    }
}
