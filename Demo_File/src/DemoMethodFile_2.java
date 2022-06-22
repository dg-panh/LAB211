
import java.io.*;

/**
 *
 * @author MichaelLake
 */

class FileFilter implements FilenameFilter { 
    String ext; 
    public FileFilter(String ext) { 
        this.ext = "." + ext; 
    } 
    public boolean accept (File dir, String fName) { 
        return fName.endsWith(ext); 
    } 
}
public class DemoMethodFile_2 {
   
    public static void main (String [] args) { 
        String dirName = "d:/testcode"; 
        File fileObj = new File (dirName); 
        FilenameFilter filterObj = new FileFilter("txt"); 
        String[] fileName = fileObj.list(filterObj); 
        System.out.println("Number of files found : " + fileName.length); 
        System.out.println(); 
        System.out.println("Names of the files are : " ); 
        System.out.println("------------------------- " ); 
        for(int ctr=0; ctr < fileName.length; ctr++) { 
            System.out.println(fileName[ctr]); 
        }
    }
}
