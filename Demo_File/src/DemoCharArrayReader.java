
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
public class DemoCharArrayReader {
    public static void main(String[] args) {

      CharArrayReader car = null;
      char[] ch = {'H', 'E', 'L', 'L', 'O'};
      try{         
         // create new character array reader
         car = new CharArrayReader(ch);         
         int value=0;         
         // read till the end of the file
         while((value = car.read())!=-1)
         {            
            char c = (char)value;            
            // print the character
            System.out.print(c+" : ");            
            // print the integer
            System.out.println(value);
         }
      }catch(IOException e){         
         e.printStackTrace();
      }finally{         
         if(car!=null)
            car.close();
      }
   }
}
