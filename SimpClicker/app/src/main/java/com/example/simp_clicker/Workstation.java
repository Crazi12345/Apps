package com.example.simp_clicker;

public class Workstation {
    public Workstation(String a, int b,int c,int d){
        name = a;
        cost = b;
        pps = c;
        amount =d;
    }
    private String name;
    private int cost;
    private int pps;
    private int amount;
    private int totalPps;

    public int getAllPps(){
        return totalPps;
    }
    public  void setAllPps(){
        this.totalPps = pps*amount;
    }
    public int getAmount(){
        return amount;
    }
    public void setAmount(){
        this.amount+=1;
    }
    public String getName(){
        return name;
    }
    public int getPps(){
        return pps;
    }

    public void setCost(){
        this.cost = ((cost*10)+cost*2)/10;

    }
    public int getCost(){
        return this.cost;
    }

}
