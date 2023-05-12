package sg.edu.nus.iss.task02;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

     //HashMap + Streams
     //key is first word; value is subsequent word 
     //Use MultiSet? 

public class nextWordStats {

    public static String getNextWord(String str, String word) {
        String nextWord = "";
        str = str.trim().replaceAll("\\p{Punct}", " ");
        int totalLength = str.length();
        int wordStartIndex = str.indexOf(word);
        if (wordStartIndex != -1) {
            int startPos = wordStartIndex + word.length() + 1;
            if (startPos < totalLength) {
                int nextSpaceIndex = str.substring(startPos).indexOf(" ");
                int endPos = 0;
                if (nextSpaceIndex == -1) {
                    // Reach end of line 
                    endPos = totalLength;
                } else {
                    endPos = startPos + nextSpaceIndex;
                }
                nextWord = str.substring(startPos, endPos);
            }
        }
        return nextWord;
    }

HashMap<String, TreeMap<String, Float>> chain; 
    Set<String> known_wordSet;
    Random rand; 

private String generateNextWord(HashMap<String, TreeMap<Double,String>> words,String currentWord){
    TreeMap<Double, String> probMap = words.get(currentWord); 
    double d = Math.random(); 
    return probMap.ceilingEntry(d).getValue(); 
}

public nextWordStats (InputStream is){

    try{
        ObjectInputStream ois = new ObjectInputStream(is);
        chain =  (HashMap<String, TreeMap<String, Float>>)ois.readObject(); 
        known_wordSet = chain.keySet();
        ois.close(); 
        is.close(); 
    
    int freqNextWord;
    int totalCount;
    double nextWordProbability = freqNextWord/totalCount; 

    }catch (Exception e){
        System.out.println("An error occurred.");
        e.printStackTrace();
    }finally{

    }
}

}
    
