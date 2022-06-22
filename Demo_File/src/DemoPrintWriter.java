
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
public class DemoPrintWriter {
    public static void main(String[] args) throws IOException {
	  try {

             BufferedReader in = new BufferedReader( new InputStreamReader( System.in ) );
             System.out.println( "File name : " );
             String fileName = in.readLine();
             PrintWriter out = new PrintWriter( new FileWriter( fileName ) );

             System.out.println( "Enter some wordings : [ Enter  'stop' to quit ]" );
             String textLine = in.readLine();
             while ( !textLine.equals("stop") ) {
                 out.println( textLine );
                 textLine = in.readLine();
             }
             out.close();
             in.close();
         }
         catch (IOException error ) {
             System.err.println( "Error making file:" );
             System.err.println( "\t" + error );
         }
  }
}
