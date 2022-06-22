
import java.io.*;
import java.util.*;

/**
 *
 * @author MichaelLake
 */
public class DemoMethodFile_1 {
    
    public static void main(String[] args){
        File fileObj = new File("hello.txt"); 
        System.out.println("Path is: " +fileObj.getPath()); 
        System.out.println("Obsolute Path is: " +fileObj.getAbsolutePath()); 
        System.out.println("Name is: " +fileObj.getName()); 
        System.out.println("File exists is: " +fileObj.exists()); 
        System.out.println("File is: " +fileObj.isFile()); 
        System.out.println("Size is : " +fileObj.length()+" bytes");
        System.out.println("Last modified : " + new Date(fileObj.lastModified()));
        System.out.println("Hidden  : " +fileObj.isFile());
        System.out.println("Can read : " +fileObj.canRead());
        
    }    
}
