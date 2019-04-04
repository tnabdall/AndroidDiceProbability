package com.example.kingoftokyoprobabilitycalculator;

public class Die {

    // 1 = 1, 2 = 2, 3 = 3, attack = 4, heal = 5, energy = 6, any = 7 (for desired roll purpose)

    private int face;

    public int getDie(){
        return face;
    }

    public void rollDie(){
        face = (int) (1+Math.random()*6);
    }

    public void setDie(int num){
        if (num>0 && num<8){
            face = num;
        }
    }

    public void printDie(){
        System.out.println(face);
    }
}
