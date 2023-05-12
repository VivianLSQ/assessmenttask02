package sg.edu.nus.iss;

import java.io.File;

public class fileDirSetup 
{
    //Recursive Print?
    public static void main( String[] args)
    {
        //Create File Object for main directory/folder
        File mainDir = new File("Users/Vivian/Downloads/texts"); 

        //1. Get array of files for main folder
        //2. Print filenname if array is file
        //3. If array is directory, print directory name, then get array of files for sub-directory 1
        //4. Repeat for second sub-directory 
        if(mainDir.exists() && mainDir.isDirectory()){
            mainDir.listFiles();
            System.out.println("Files from main folder are: " + mainDir); 
        }
        displaySubDirectoryFiles(mainDir); 
    }
    //Note: directory name is to be the Text folder --> Aim is to know how to read sub directory 
    //Use getCanonicalPath to read txt files in sub-directories 
    public static void displaySubDirectoryFiles(File dir){
        try{
            File[] files = dir.listFiles();
            for (File file: files){
                if(file.isDirectory()){
                    System.out.println("Directory: " + file.getCanonicalPath());
                } else {
                    System.out.println("file:" +file.getCanonicalPath()); 
                }
            }
           
        }catch (Exception e){
            e.printStackTrace();

        }
    }
    }


    
