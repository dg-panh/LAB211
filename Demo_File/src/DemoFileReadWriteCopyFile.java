import java.io.*;

/**
 *
 * @author MichaelLake
 */
public class DemoFileReadWriteCopyFile {
   public static void main(String[] args) throws IOException {
    FileReader inObjStream = null;
    FileWriter outObjStream = null;
    try {
        inObjStream = new FileReader("hello.txt");
        outObjStream = new FileWriter("outhello.txt");
        int ch;
        while ((ch = inObjStream.read()) != -1) {
           outObjStream.write(ch);
        }
        } finally {
        if (inObjStream != null) {
            inObjStream.close();
            outObjStream.close();
        }
      }
    }
}