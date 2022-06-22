/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author PC
 */
public class FileDAO {
    public static void writeBinaryFile(String filename, FoodList data) throws Exception {
        FileOutputStream f = new FileOutputStream(filename);
        ObjectOutputStream of = new ObjectOutputStream(f);
        of.writeObject(data);
        f.close();
        of.close();
    }
    
    public static FoodList readBinaryFile(String filename) throws Exception {
        FileInputStream f = new FileInputStream(filename);
        ObjectInputStream of = new ObjectInputStream(f);
        FoodList list = (FoodList) of.readObject();
        f.close();
        of.close();
        return list;
   }
}
