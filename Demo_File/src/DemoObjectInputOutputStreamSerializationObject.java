
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
class Employee implements Serializable{
    String lastName;
    String firstName;
    double sal;
}
public class DemoObjectInputOutputStreamSerializationObject {
    public static void main(String[] args) {
    FileInputStream fIn = null;
    FileOutputStream fOut = null;
    ObjectInputStream oIn = null;
    ObjectOutputStream oOut = null;
    try {
        String fileName = "NewEmplyee.ser";
        fOut = new FileOutputStream(fileName);
        oOut = new ObjectOutputStream(fOut);
        Employee e = new Employee();
        e.lastName = "Smith";
        e.firstName = "John";
        e.sal = 5000.00;
        oOut.writeObject(e);
        oOut.close();
        fOut.close();
        
        fIn = new FileInputStream(fileName);
        oIn = new ObjectInputStream(fIn);
        //de-serializing employee 
        Employee emp = (Employee) oIn.readObject();
        System.out.println("First Name :" +emp.firstName );      
        System.out.println("Last Name :" +emp.lastName );
        System.out.println("Salary :" +emp.sal );
        
        fIn.close();
        oIn.close();        
    } catch (IOException e) {
         e.printStackTrace();
    } catch (ClassNotFoundException e) {
         e.printStackTrace();
    } 
   }
}
