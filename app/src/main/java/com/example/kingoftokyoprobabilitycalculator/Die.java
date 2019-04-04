package com.example.kingoftokyoprobabilitycalculator;

public class Die {

    // 1 = 1, 2 = 2, 3 = 3, attack = 4, heal = 5, energy = 6, any = 7 (for desired roll purpose)

    private int face;

    /**
     * Gets the value of the die
     * @return value of die
     */
    public int getDie(){
        return face;
    }

    /**
     * Rolls the die between 1 and 6 inclusive
     */
    public void rollDie(){
        face = (int) (1+Math.random()*6);
    }

    /**
     * Sets die value to number allowed (1-7)
     * @param num Number to set (1-7)
     */
    public void setDie(int num){
        if (num>0 && num<8){
            face = num;
        }
    }

    /**
     * Prints value of die to console
     */
    public void printDie(){
        System.out.println(face);
    }
}
