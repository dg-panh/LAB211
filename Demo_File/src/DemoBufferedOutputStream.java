
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MichaelLake
 */
public class DemoBufferedOutputStream {
     public static void main(String[] args) {       
       String filename = "output.txt";
       String output = "Java Code Geeks - Java Examples";    
       BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        try {        
           // create FileOutputStream from filename
            fos = new FileOutputStream(filename); 
           // create BufferedOutputStream for FileOutputStream
            bos = new BufferedOutputStream(fos);
            bos.write(output.getBytes());          
        }
        catch (FileNotFoundException fnfe) {
            System.out.println("File not found" + fnfe);
        }
        catch (IOException ioe) {
            System.out.println("Error while writing to file" + ioe);
        }
        finally {
            try {
                if (bos != null) {
                    bos.flush();
                    bos.close();
                }
            }
            catch (Exception e) {
                System.out.println("Error while closing streams" + e);
            }
        }
    }   
}
