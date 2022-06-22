
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
public class DemoFilterOutputStream {
    public static void main(String[] args) throws Exception {
     OutputStream OutputStreamObj = null; 
     FilterOutputStream filterOutputStreamObj = null;
     FileInputStream filterInputStreamObj = null;
     byte[] bufObj = {65, 66, 67, 68, 69};
     int i=0;
     char c;
        try{
           // creates output stream objects 
         OutputStreamObj = new FileOutputStream("hi.txt");
         filterOutputStreamObj = new FilterOutputStream(OutputStreamObj);
         // writes to the output stream from bufObj
         filterOutputStreamObj.write(bufObj);
         // forces the byte contents to be written to the stream
         filterOutputStreamObj.flush();
         // creates an input stream object
         filterInputStreamObj = new FileInputStream("hi.txt");
         while((i=filterInputStreamObj.read())!=-1) { 
            c = (char)i;
            System.out.println("Character read after conversion is: "+ c);
         }
       }
       catch(IOException e){
           System.out.println(e.getMessage());
       }
       finally{
         if(OutputStreamObj!=null)
            OutputStreamObj.close();
         if(filterOutputStreamObj!=null)
            filterOutputStreamObj.close();
       }
     }
}

