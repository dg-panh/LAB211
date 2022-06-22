/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author PC
 */
public class Vaccine {
    final String vaccineID;
    String name;

    public Vaccine(String vaccineID, String name) {
        this.vaccineID = vaccineID;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVaccineID() {
        return vaccineID;
    }

    @Override
    public String toString() {
        return vaccineID + ", " + name;
    }

    
}
