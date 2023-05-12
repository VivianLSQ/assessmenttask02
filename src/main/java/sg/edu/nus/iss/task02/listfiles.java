package sg.edu.nus.iss.task02;

import java.io.File;

public class listfiles {
    public static void main (String[] args){
        try{
            //create file
            File f = new File("/Users/Vivian/Downloads/texts");
            File[] files = f.listFiles();
           
            System.out.println("Files are:");
            //Get file names using for loop
            for (int i =0; i <files.length; i++){
                System.out.println(files[i]. getName()); 
            }
        }catch (Exception e){
            System.err.println(e.getMessage()); 

        }
    }
    
}
