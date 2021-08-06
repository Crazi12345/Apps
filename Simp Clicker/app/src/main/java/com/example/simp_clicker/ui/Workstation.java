package com.example.simp_clicker.ui;

public class Workstation {
    // Constructor saves initial values to private values
    public Workstation(String a, int b,int c,int d){
        name = a;
        cost = b;
        pps = c;
        amount = d;
        workCost = 0;
    }
    public String getName(){
        return name;
    }

    public void addAmount(int numberAdded){
        this.amount +=numberAdded;
    }

    public int getTotalPps(){
        return amount*pps;
    }
    public int getAmount(){return amount;}
    public int getCost(){
      /*  if(workCost != cost){
            workCost = cost;
      for(int i = 0; i<Data.listOfWorkstations.get(index).getAmount();i++){
         // setCost();
          workCost = ((workCost*10)+workCost*2)/10;
      }
      this.cost = workCost;}*/
        return cost;
    }
    public void setCost(int num){
        this.cost = ((cost*10)+cost*num)/10;
    }





    // the private variables:
    private String name;
    private int cost;
    private int pps;
    private int amount;
    private int totalPps;
    private int workCost;
}
