
/**
 * Created by IceBreakers on 2/4/17.
 * Reverse a sentence
 * Url Parser
 * Input:
 */
public class StringUtil {

       private static String[] URLParser(String url){
        //WRITE YOUR CODE HERE.

       String result = "hi";
       String[] splittedUrl = url.split("[\\?\\&]");
       String[] resultArray = new String[5];
       for(int i = 1;i < splittedUrl.length; i++ ){

           resultArray[i-1] = String.valueOf(splittedUrl[i].split("="));


       }
       System.out.println(resultArray[1]);
       String sys = "{"+ "client_id:SS}";

       return resultArray;




        //parse the url and get all the get parameters and return an array of Strings
        //Input: google.com/api?param1=value1&param2=value2
        //Output: array of strings [] = { {param1:value1}, {param2:value2} }

    }
    private static String reverseWords(String sentence){
        //WRITE YOUR CODE HERE..
        Stack wordStack = new Stack();
        String result = "";
        if(sentence == null){
            return sentence;
        }
        else {
            String[] splittedWords = sentence.split(" ");
            int splitLength = splittedWords.length - 1;
            for (int i = 0; i <= splitLength; i++) {
                wordStack.push(splittedWords[i]);
                if (i < splitLength) {
                    wordStack.push(" ");
                }
            }
            while (!(wordStack.empty())) {
                result += wordStack.pop();
            }
            return result;
        }
    }

    private static String reverseString(String sentence) {
        Stack stringStack = new Stack();
        Queue stringQueue = new LinkedBlockingQueue();
        String result = "";
        String[] splittedStrings = sentence.split(" ");
        int splitLength = splittedStrings.length - 1;
        for (int i = 0; i <= splitLength; i++) {
            stringQueue.add((new StringBuffer(splittedStrings[i]).reverse().toString()));
            if (i<splitLength){
                stringQueue.add(" ");
            }
        }
        while (!(stringQueue.isEmpty())){
            result += stringQueue.remove();
        }
        return result;
    }
    public static void myassert(boolean  x) {
        //CANNOT CHANGE CODE BELOW. MUST USE AS IS
        if (!x) {
            throw new IllegalArgumentException("Assert fail") ;
        }
    }

    private static void testBench(){
        //CANNOT CHANGE CODE BELOW. MUST USE AS IS
        String input = "God is great";
        String output = null;
        System.out.println("Input 1: " + input);
        output = reverseWords(input);
        System.out.println("Output 1: " + output);
        myassert(output.equals("great is God"));

        System.out.println("Input 2: " + input);
        output = reverseString(input);
        System.out.println("Output 2: " + output);
        myassert(output.equals("doG si taerg"));

        input = null;
        System.out.println("Input 3: " + input);
        output = reverseWords(input);
        System.out.println("Output 3: " + output);
        myassert(input == output);

        String url = "https://google.com.ua/oauth/authorize?client_id=SS&response_type=code&scope=N_FULL&access_type=offline&redirect_uri=http://localhost/Callback";
        String getParams[] = URLParser(url);
        myassert(getParams.length == 5);
        myassert(getParams[0].equals("{client_id:SS}"));

    }
    public static void main(String args[]){
        //CANNOT CHANGE CODE BELOW. MUST USE AS IS
        System.out.println("ReverseSentence.java");
        testBench();
        System.out.println("DONE");
    }
}
