package com.example.helloworld.icebreakers;

import java.math.BigInteger;

/**
 * Created by IceBreakers on 1/29/17 HW 1 AddUtil.java
 * Add two numbers or two strings irrespective of the length of the input.
 */
public class AddUtil {

    public static void myassert(boolean  x) {
        //CANNOT CHANGE CODE BELOW. MUST USE AS IS
        if (!x) {
            throw new IllegalArgumentException("Assert fail") ;
        }
    }
    
  private static int add(int a, int b){
    return a + b;
  }

  private static Integer characterToInteger(Character c) {
    return Integer.parseInt(String.valueOf(c));
  }

  private static void stringNumberToIntegerQueue(Queue<Integer> queue,
      String number) {
    int idx = number.length() - 1;
    while (idx >= 0) {
      queue.add(characterToInteger(number.charAt(idx)));
      idx--;
    }
  }

  private static String integerStackToStringNumber(Stack<Integer> stack) {
    String result = "";
    while (stack.size() > 0) {
      result += stack.pop();
    }
    return result;
  }

  private static String add(String a, String b) {
    Queue<Integer> firstNumberQueue = new LinkedBlockingQueue<>();
    Queue<Integer> secondNumberQueue = new LinkedBlockingQueue<>();
    Stack<Integer> resultNumberStack = new Stack<>();

    stringNumberToIntegerQueue(firstNumberQueue, a);
    stringNumberToIntegerQueue(secondNumberQueue, b);

    boolean repeat = true;
    int firstNumberDigit, secondNumberDigit, carryDigit = 0;
    while (repeat) {
      firstNumberDigit = secondNumberDigit = 0;
      repeat = false;
      if (firstNumberQueue.size() > 0) {
        firstNumberDigit = firstNumberQueue.remove();
        repeat = true;
      }
      if (secondNumberQueue.size() > 0) {
        secondNumberDigit = secondNumberQueue.remove();
        repeat = true;
      }

      int sum = carryDigit + firstNumberDigit + secondNumberDigit;
      carryDigit = sum / 10;
      resultNumberStack.add(sum % 10);
    }

    return integerStackToStringNumber(resultNumberStack);
  }
    
  private static boolean testStringAdd(String a, String b){
        //CANNOT CHANGE CODE BELOW. MUST USE AS IS
        String s = add(a,b);
        BigInteger sum = new BigInteger(s);
        BigInteger a1 = new BigInteger(a);
        BigInteger b1 = new BigInteger(b);
        return (sum.equals(a1.add(b1)) );
    }

    private static boolean testIntAdd(int a, int b){
        //CANNOT CHANGE CODE BELOW. MUST USE AS IS
        int c = add(a,b);
        return (c == (a+b));
    }
    private static void testBench(){
        //CANNOT CHANGE CODE BELOW. MUST USE AS IS
        myassert(testIntAdd(10,20));
        System.out.println("Pass: 10+20");
        myassert(testStringAdd("11", "22"));
        System.out.println("Pass: 11+22");
        myassert(testStringAdd("1111", "22"));
        System.out.println("Pass: 1111+22");
        myassert(testStringAdd("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000",
                "93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000"));
        System.out.println("Pass: 100!+100!");
    }

    public static void main(String args[]){
        //CANNOT CHANGE CODE BELOW. MUST USE AS IS
        System.out.println("AddUtil.java");
        testBench();
        System.out.println("DONE");
    }
}
