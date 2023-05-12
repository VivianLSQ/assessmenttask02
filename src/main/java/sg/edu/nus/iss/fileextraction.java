package sg.edu.nus.iss;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException; 
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

//Extract files in compressed zip archive

public class fileextraction {
    // set buffer size:
    private static final int bufferSize = 1024;

    public void unzip (String zipFilePath, String destDirectory) throws IOException{
        File destDir = new File(destDirectory); 
        if(!destDir.exists()){
            destDir.mkdir(); }
            zipFilePath = "/Users/Vivian/Downloads/VSC_Projects/assessmenttask02/src/main/java/sg/edu/nus/iss/texts_2023_05_07-08_53_44.zip"; 
            ZipInputStream zis= new ZipInputStream(new FileInputStream(zipFilePath)); 
            ZipEntry entry = zis.getNextEntry();
            //Iterate over file content 
            while(entry != null){
                String filePath = destDirectory + File.separator + entry.getName(); 
                if(!entry.isDirectory()){
                    extractFile(zis, filePath); 
                }else{
                    File dir = new File(filePath);
                    dir.mkdir();
                }
                zis.closeEntry();
                entry = zis.getNextEntry();
            } zis.close(); 

        }

    private void extractFile(ZipInputStream zis, String filePath) throws IOException{
        BufferedOutputStream bos = new BufferedOutputStream (new FileOutputStream(filePath));
        byte[]bytesIn = new byte[bufferSize]; 
        int read =0;
        while((read = zis.read(bytesIn)) != -1){
            bos.write(bytesIn, 0, read); 
        }
        bos.close(); 
        }

}
