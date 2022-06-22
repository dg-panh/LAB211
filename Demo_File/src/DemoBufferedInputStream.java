
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
public class DemoBufferedInputStream {
    public static void main(String[] args) throws Exception {
      
      InputStream inStream = null;
      BufferedInputStream bis = null;
      
      try{
         // open input stream test.txt for reading purpose.
         inStream = new FileInputStream("output.txt");
         // input stream is converted to buffered input stream
         bis = new BufferedInputStream(inStream);
         // read until a single byte is available
         while(bis.available()>0)
         {
             // read the byte and convert the integer to character
            char c = (char)bis.read();
            // print the characters
            System.out.println("Char: "+c);;
         }
      }catch(Exception e){
         // if any I/O error occurs
         e.printStackTrace();
      }finally{		
         // releases any system resources associated with the stream
         if(inStream!=null)
            inStream.close();
         if(bis!=null)
            bis.close();
      }
   }
}
