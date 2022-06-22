/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class FileDAO {
    public static void loadDataInjection(String filename, ArrayList<Injection> list) throws Exception {
        FileReader f = new FileReader(filename);
        BufferedReader bf = new BufferedReader(f);
        
        while(bf.ready()) {
            String s = bf.readLine();
            String[] tmp = s.split(", ");
            if (tmp.length == 7) {
                StudentList sList = new StudentList();
                Student stu = sList.searchStudentReturnObj(tmp[1].trim());
                VaccineList vList = new VaccineList();
                Vaccine vac = vList.searchVaccineReturnObj(tmp[2].trim());
                Injection inj = new Injection(tmp[0], stu, vac, tmp[3], tmp[4], tmp[5], tmp[6]);
                list.add(inj);
            }
        }

    }
    
    public static void saveDataInjection(String filename, ArrayList<Injection> list) throws Exception{
        PrintWriter w = new PrintWriter(filename);
        for (Injection injection : list) {
            w.println(injection);
        }
        w.close();
    }
    
    public static void loadDataStudent(String filename, ArrayList<Student> list) throws Exception {
        FileReader f = new FileReader(filename);
        BufferedReader bf = new BufferedReader(f);
 
        while(bf.ready()) {
            String s = bf.readLine();
            String[] tmp = s.split(", ");
            if (tmp.length == 2) {
                Student stu = new Student(tmp[0], tmp[1]);
                list.add(stu);
            }
        }
    }
    
    public static void saveDataStudent(String filename, ArrayList<Student> list) throws Exception {
        PrintWriter w = new PrintWriter(filename);
        for (Student student : list) {
            w.println(student);
        }
        w.close();
    }
    
    public static void loadDataVaccine(String filename, ArrayList<Vaccine> list) throws Exception {
        FileReader f = new FileReader(filename);
        BufferedReader bf = new BufferedReader(f);

        while(bf.ready()) {
            String s = bf.readLine();
            String[] tmp = s.split(", ");
            if (tmp.length == 2) {
                Vaccine v = new Vaccine(tmp[0], tmp[1]);
                list.add(v);
            }
        }
    }
    
    public static void saveDataVaccine(String filename, ArrayList<Vaccine> list) throws Exception {
        PrintWriter w = new PrintWriter(filename);
        for (Vaccine vaccine : list) {
            w.println(vaccine);
        }
        w.close();
    }
}
