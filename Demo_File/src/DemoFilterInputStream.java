/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MichaelLake
 */
import java.io.*;

public class DemoFilterInputStream {
    public static void main(String[] args) throws Exception {
    InputStream inputObj = null;
    FilterInputStream filterInputObj = null;
    try {
    // creates input stream objects
    inputObj = new FileInputStream("Hello.txt");
    filterInputObj = new BufferedInputStream(inputObj);
    // reads and prints from filter input stream
    System.out.println((char)filterInputObj.read());
    System.out.println((char)filterInputObj.read());
    // invokes mark at this position
    filterInputObj.mark(0); 
    System.out.println("mark() invoked");  
    System.out.println((char) filterInputObj.read());
    System.out.println((char) filterInputObj.read());    
    // reset() repositioned the stream to the mark
    filterInputObj.reset();
    System.out.println("reset() invoked");
    System.out.println((char)filterInputObj.read());
    System.out.println((char)filterInputObj.read());

    } catch (IOException e) {    
        e.printStackTrace();
    } finally {
    // releases system resources associated with the stream
    if (inputObj != null) {
        inputObj.close();
    }
    if (filterInputObj != null) {
        filterInputObj.close();
     } 
    }
  }
}
