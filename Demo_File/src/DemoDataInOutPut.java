/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
/**
 *
 * @author MichaelLake
 */
public class DemoDataInOutPut {
    public static void main (String [] args) throws  IOException  { 
        //Ghi du lieu ra tap tin
        DataOutputStream out = new DataOutputStream(new FileOutputStream(
        "data.dat"));
        double[] prices = { 1.99, 2.99, 3.99, 4.99 };
        int[] units = { 10, 20, 30, 40 };
        String[] descs = { "Java", "SE 7 ", "and","Support."};

        for (int i = 0; i < prices.length; i++) {
            out.writeDouble(prices[i]);
            out.writeChar('\t');
            out.writeInt(units[i]);
            out.writeChar('\t');
            out.writeChars(descs[i]);
            out.writeChar('\n');
        }
        out.close();
        // Doc du lieu tu tap tin
        DataInputStream in = new DataInputStream(new FileInputStream(
        "data.dat"));
        double price;
        int unit;
        String desc;       
        double total = 0.0;
        try {
            while (true) {
                price = in.readDouble();
                in.readChar(); // throws out the tab
                unit = in.readInt();
                in.readChar(); // throws out the tab               
                desc = in.readLine();               
              
                System.out.println( price );
                System.out.println( unit );
                System.out.println( desc );
                total = total + unit * price;
              
            }    
         }
         catch (EOFException e) {
               //System.out.println(e.getMessage());                       
         }
        System.out.println(total);                
        in.close();
  }   
    
}
