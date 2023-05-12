package sg.edu.nus.iss;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipEntry; 

public class unzip {
    public static void main(String[] args) throws IOException{
        String zipFilePath = "/Users/Vivian/Downloads/VSC_Projects/assessmenttask02/src/main/java/sg/edu/nus/iss/texts_2023_05_07-08_53_44.zip";
        
        String destDir = "Users/Vivian/Downloads/VSC_Projects/assessmenttask02/src/main/java/sg/edu/nus/iss/";
        
        unzipFile (zipFilePath, destDir);
    }

    private static void unzipFile (String zipFilePath, String destDir){
        File dir = new File(destDir);
        // create output directory if it doesn't exist
        if(!dir.exists()) dir.mkdirs();
        FileInputStream fis;
        //buffer for read and write data to file
        byte[] buffer = new byte[1024];
        try {
            fis = new FileInputStream(zipFilePath);
            ZipInputStream zis = new ZipInputStream(fis);
            ZipEntry ze = zis.getNextEntry();
            while(ze != null){
                String fileName = ze.getName();
                File newFile = new File(destDir + File.separator + fileName);
                System.out.println("Unzipping to "+newFile.getAbsolutePath());

                //create directories for sub directories in zip
                new File(newFile.getParent()).mkdirs();
                FileOutputStream fos = new FileOutputStream(newFile);
                int read;
                while ((read = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, read);
                }
                fos.close();

                //close this ZipEntry
                zis.closeEntry();
                ze = zis.getNextEntry();
            }
            //close last ZipEntry
            zis.closeEntry();
            zis.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    
}
