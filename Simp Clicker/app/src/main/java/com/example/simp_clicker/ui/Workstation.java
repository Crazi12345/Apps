package com.example.simp_clicker.ui;

public class Workstation {
    // Constructor saves initial values to private values
    public Workstation(String a, int b,int c,int d){
        name = a;
        cost = b;
        pps = c;
        amount = d;
    }

    public void addAmount(int numberAdded){
        this.amount +=numberAdded;
    }

    public int getTotalPps(){
        return amount*pps;
    }

    // the private variables:
    private String name;
    private int cost;
    private int pps;
    private int amount;
    private int totalPps;
}
