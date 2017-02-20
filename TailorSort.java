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

     private static Integer[] sortRight(Integer[] unsorted) {
        boolean changed = true;
        int i = 0, temp;
        while (changed == true){
            changed = false;
            for (i = 0; i < unsorted.length - 1; i++) {
                if (unsorted[i] > unsorted[i + 1]){
                    temp = unsorted[i];
                    unsorted[i] = unsorted[i + 1];
                    unsorted [i + 1] = temp;
                    changed = true;
                }
            }
        }
        System.out.println("########## Sorted Right Array ##########");
        printArray(unsorted);
        return unsorted;
    }
    
    private static Integer[] merge(Integer[] sortedLeft, Integer[] sortedRight){
        Integer[] resultArray = new Integer[10];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < sortedLeft.length && j < sortedRight.length) {
            if (sortedLeft[i] < sortedRight[j]) {
                resultArray[k] = sortedLeft[i];;
                i++;
            }
            else{
                resultArray[k] = sortedRight[j];
                j++;
            }
            k++;
        }
        while (i < sortedLeft.length) {
            resultArray[k] = sortedLeft[i];
            i++;
            k++;
        }
        while (j < sortedRight.length) {
            resultArray[k] = sortedRight[j];
            j++;
            k++;
        }
        return resultArray;
    }
    
    private static Integer[] addCoats(Integer[] inputCoats, int index) {
        int last = inputCoats.length;
        Integer[] sortedLeft = Arrays.copyOf(inputCoats, index);
        Integer[] unsorted = Arrays.copyOfRange(inputCoats, index, last);
        Integer[] sortedRight = sortRight(unsorted);
        Integer[] result = merge(sortedLeft, sortedRight);
        return result;
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
