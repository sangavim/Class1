
/**
 * Created by IceBreakers on 2/5/17.
 * Build Browser stack() - browser back which was discussed in Saran class
 *
 * Implement your OWN DYNAMICALLY GROWING STACK using SIMPLE ARRAY and the following basic stack operations
 *      DONT USE ANY JAVA COLLECTIONS LIKE STACK
 *
 *         push()       - pushes the element in this case its a url (String)
 *         pop()        - pops the element from the stack
 *         search()     - searches the element in the stack
 *         peek()       - peeks the element without pop
 *         printStack() - prints the Stack preserving all its values
 *         size()       - returns the length of the stack
 *         isEmpty()    - return true if stack is not empty else false
 *
 */
public class BrowserStack {

    String[] myStack;
    int top;
    int STACK_SIZE = 16; //INITIAL STACK SIZE, GROW IF ITS NEEDED

    //Constructor to initialize your stack
    BrowserStack(){
        this.myStack = new String[STACK_SIZE];
        this.top = -1;
    }


    public static void myassert(boolean  x) {
        //CANNOT CHANGE CODE BELOW. MUST USE AS IS
        if (!x) {
            throw new IllegalArgumentException("Assert fail") ;
        }
    }
    
    //push() - pushes the element in this case its a url (String)
    private  void push(String url){
        top++;
        myStack[top] = url;
    }

    //pop()- pops the element from the stack
    private String pop(){
        String popElement = myStack[top];
        top--;
        return popElement;

    }
    
    //print stack elements
    private void printStack(){
        int i;
        System.out.println("Stack Elements: ");
        for(i = top; i >=0; i--){
            System.out.println(myStack[i]);
        }
    }

    //peek at the top element
    private  String peek(){
        System.out.println("Peek: "+myStack[top]);
        System.out.println("After peek: ");
        printStack();
        return myStack[top];
    }
    
    //size of the stack
    private  int size(){
        int i,count = 0;
        for(i = 0; i <= top; i++){
            count++;
        }
        return count;
    }
    
    //check whether the stack is Empty
    private  boolean isEmpty(){
        int stackSize = size();
        boolean empty = false;
        if(stackSize == 0){
            System.out.println("Empty Stack");
            empty = true;
        }
        else{
            System.out.println("Stack is not empty.");
        }
        return empty;
    }

    //Search an element 
    private boolean search(String url){
        int i = 0, j = 0;
        String[] tempStack = new String[16];
        boolean found = false;
        while(top >= 0) {
            if (myStack[top].equals(url)) {
                found = true;
                System.out.printf("%s is at %d index", url,top);
                System.out.println();
                break;
            } else {
                tempStack[i] = pop();
                i++;
            }
        }
        if (!found){
            System.out.println(url+" is not in stack");
        }
        for (j = i-1; j >= 0; j--){
            top++;
            myStack[top] = tempStack[j];
        }
        return found;
    }
    
    private static void testBench(BrowserStack browserStack){
        //CANNOT CHANGE CODE BELOW. MUST USE AS IS
        browserStack.push("g.co");
        browserStack.push("y.be");
        browserStack.push("f.bk");
        browserStack.push("y.ho");
        browserStack.printStack();
        myassert(browserStack.search("y.be"));
        myassert(!browserStack.search("y.be1"));
        browserStack.printStack();
        myassert(browserStack.size() == 4);
        browserStack.pop();
        myassert(browserStack.pop().equals("f.bk"));
        browserStack.peek();
        browserStack.isEmpty();
        browserStack.pop();browserStack.pop();
        browserStack.printStack();
        myassert(browserStack.size() == 0);
    }
    public static void main(String args[]){
        //CANNOT CHANGE CODE BELOW. MUST USE AS IS
        System.out.println("BrowserStack.java");
        BrowserStack testBrowser = new BrowserStack();
        testBench(testBrowser);
        System.out.println("DONE");
    }
}
