import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by IceBreakers on 2/11/17.
 * "Each monday, I get a new shipment of jackets, which I need to add to the rack.
 * I start by putting them on the end of the rack, so that they won't sit on the floor and get wrinkled.
 * Anyway, after I put them on the rack, I have N sorted jackets at one end and then M new unsorted jackets after them.
 * So I take each of the new jackets and insert it into the already sorted set of jackets.
 * After inserting the first jacket, I have N+1 sorted jackets and M-1 unsorted jackets.
 * I keep doing this until everything is inserted.
 *
 * 1. Try to visualize the problem, go thru the testbench()
 * 2. Choose your sorting technique, insertion or selection or bubble sort???
 * 3. Do minimum comparisons and return the resultant array
 */
public class TailorSort {

    private static void printArray(Integer[] printArray){
        //CANNOT CHANGE CODE BELOW. MUST USE AS IS
        for(int i = 0; i < printArray.length; i++){
            System.out.print(printArray[i] + ",");
        }
        System.out.println();
    }
    public static void myassert(boolean  x) {
        //CANNOT CHANGE CODE BELOW. MUST USE AS IS
        if (!x) {
            throw new IllegalArgumentException("Assert fail") ;
        }
    }
    private static boolean isArraySorted(Integer[] a){
        //CANNOT CHANGE CODE BELOW. MUST USE AS IS
        for(int i = 0; i < a.length - 1; i ++){
            if (a[i] > a[i+1]) {
                return false;
            }
        }
        return true;
    }

    private static Integer[] addCoats(Integer[] inputCoats, int index) {
        int last = inputCoats.length;
        int j, k;
       for (int i = index; i < last; i++){
            j = i - 1;
            k = inputCoats[i];
           while ((j>=0) && (k < inputCoats[j])){
               inputCoats[j + 1] =  inputCoats[j];
               j--;
           }
           inputCoats[j + 1] = k;
       }
        return inputCoats;

    }

    private static void testBench(){
        //CANNOT CHANGE CODE BELOW. MUST USE AS IS
        System.out.println("########## Sorted Coats Array###############");
        Integer[] sCoats1 = new Integer[7];
        for(int i = 0; i < 7; i++){
            sCoats1[i] = i * 5;
        }
        printArray(sCoats1);
        System.out.println("########## New Coats Array ###############");

        Integer[] nCoats1 = new Integer[3];
        for(int i = 0; i < 3; i++){
            nCoats1[i] = (int) (Math.random() * 35);
        }
        printArray(nCoats1);

        int totalLen = nCoats1.length + sCoats1.length;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.addAll(Arrays.asList(sCoats1));
        temp.addAll(Arrays.asList(nCoats1));
        Integer[] inputCoats = temp.toArray(new Integer[totalLen]);

        System.out.println("########## Input Coats Array###############");

        printArray(inputCoats);

        Integer[] output = addCoats(inputCoats, 7);
        System.out.println("########## Output Coats Array###############");

        printArray(output);

        myassert(isArraySorted(output));
    }

    public static void main(String args[]){
        System.out.println("TailorSort.java");
        testBench();
        System.out.println("DONE");
    }
}
