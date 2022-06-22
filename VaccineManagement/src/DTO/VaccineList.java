/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class VaccineList extends ArrayList<Vaccine>{

    final String filename = "Vaccine.txt";
    
    public VaccineList() {
        this.loadDataFromFile();
    }
    
    public int searchVaccineReturnPos(String id) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getVaccineID().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }
    
    public Vaccine searchVaccineReturnObj(String id) {
        for (Vaccine vaccine : this) {
            if (vaccine.getVaccineID().equalsIgnoreCase(id)) {
                return vaccine;
            }
        }
        return null;
    }
    
    public void addData() {
        this.add(new Vaccine("Covid-V001", "AstraZeneca"));
        this.add(new Vaccine("Covid-V002", "Sputnik V"));
        this.add(new Vaccine("Covid-V003", "Vero Cell"));
        this.add(new Vaccine("Covid-V004", "Pfizer"));
        this.add(new Vaccine("Covid-V005", "Moderna"));
        this.saveDataToFile();
    }
    
    private void saveDataToFile() {
        try {
            FileDAO.saveDataVaccine(filename, this);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private void loadDataFromFile() {
        try {
            FileDAO.loadDataVaccine(filename, this);
        } catch (FileNotFoundException e) {
            File file = new File(filename);
            this.addData();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
