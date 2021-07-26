package com.example.simp_clicker.ui;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
public class Data {

    public static Integer numOfPoints = 0; // The main points

    // Declare all the Workstations below:
    public static Workstation Work1 = new Workstation("Twatch Account",50,1,0);

    // Add all Workstations to this list of workstations and if you have a better solution then please change this, it hurts my eyes
    public  static List<Workstation> listOfWorkstations = new ArrayList<Workstation>();
    public static void addStationToList(){
        listOfWorkstations.add(Work1);
    }


    public static Integer getTotalWorkPps(){

        Integer sum = 0;

        for(int i = 0; i<listOfWorkstations.size();i++){
            sum += listOfWorkstations.get(i).getTotalPps();
        }
        return sum;
    }
}
