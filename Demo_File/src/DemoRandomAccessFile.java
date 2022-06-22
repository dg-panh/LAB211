
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MichaeLake
 */
public class DemoRandomAccessFile {
    public static void main(String[] args) {
        String fName="RandomAccessFileDemo.txt";
        String S1= "Hello world"; 
        boolean b=true; 
        int n= 1234;
        double x= 37.456;
        String S2="tom & jerry";
        byte[] ar= new byte[100]; 
        // for reading ASCII characters
        try 
        {
            RandomAccessFile f= new  RandomAccessFile(fName, "rw");
            // Write data , positions: 0,1,2,3,4
            f.writeUTF(S1); 
            f.writeBoolean(b);
            f.writeInt(n);
            f.writeDouble(x); 
            f.writeBytes(S2);
            // Read data
            f.seek(0);
            // seek to BOF
            System.out.println(f.readUTF());
            System.out.println(f.readBoolean());
            System.out.println(f.readInt());
            System.out.println(f.readDouble());
            f.read(ar);
            System.out.println(new String (ar));
            System.out.println("File length: " + f.length());
            f.close();
        }
        catch(Exception e){
            System.out.println(e);

        }
    }
}
