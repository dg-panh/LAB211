
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

public class DataIOTextFileDemoByFileReadWriterClass {
     public static void main(String[] args) {
        try {
          File file = new File("example.txt");
          //Tao file
          BufferedWriter output = new BufferedWriter(new FileWriter(file));
          output.write("Hello world");
          output.write("\n");
          output.write("Java SE7");
          output.close();
          //Doc file
          BufferedReader reader = new BufferedReader(new FileReader(file));
          String s;
          while((s = reader.readLine()) != null){
              System.out.println(s);
          }
        } catch ( IOException e ) {
           e.printStackTrace();
        }
    }
}
