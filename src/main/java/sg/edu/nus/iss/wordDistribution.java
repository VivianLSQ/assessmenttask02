package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class wordDistribution {
    public static void main(String[] args) throws IOException{

    // Use BufferedReader to read .txt file
    //embed in try/catch later 
    
    try{
        BufferedReader br = new BufferedReader(new FileReader("/Users/Vivian/Downloads/texts")); 
        var sb = new StringBuilder();     
        String line;
        while((line = br.readLine())!=null){
                sb.append(line);
                sb.append(System.lineSeparator()); 
                }
        System.out.println(sb); 
      
        // One for Frost and One for Seuss

        Set<String> processedWordSet = new HashSet<String>();
       
        //Clean the data 
        Scanner wordScanner = new Scanner(br); 
        String word; 
        while(wordScanner.hasNext()){
            word = wordScanner.next();
            word= word.replaceAll("\\p{Punct}",""); 
            word = word.toLowerCase(); 
        
            processedWordSet.addAll(Arrays.asList(word.split("\\s+"))); 
        }

        // Analyse distribution
         // Use TreeMap + Comparator (or HashMap) and loop to count next word distribution 
                //key is first word; value is subsequent word 
                //Then use the compute() method to compute the value 
                //And calculate the probability of the next word occuring 
                    //Conditional probability (given first word, count 2nd word prob)
                    //if-else? 
                    //Markov's chain? 
        //Step 1: Randomly choose a word
            //Count word frequency in a String using a frequency class object
        //Step 2: Append word chosen from set of words and their probabilities
        //Step 3: Repeat process 
        String text = File.readString ("/Users/Vivian/Downloads/texts"); 
        Map<String, Integer> freqCounterMap = new TreeMap<>();
        Pattern pattern = Pattern.compile("[a-z]+");
        Matcher matcher = pattern.matcher(text); 

        while(matcher.find()){
            String word2 = matcher.group();
            if(freqCounterMap.containsKey(word2)){
               //word already exists
                Integer count = freqCounterMap.get(word2)+1;
               freqCounterMap.put(word2, count);   
            }else{
                //new word
                int count = 1; 
                freqCounterMap.put(word, count); 
            }
        }//end of while loop

        wordScanner.close(); 
        br.close(); 

    }catch(IOException e){
        System.out.println("An error occurred.");
        e.printStackTrace();
    } finally{
      
    }

}//end of main()
}
