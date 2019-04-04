package com.example.kingoftokyoprobabilitycalculator;

public class Dice {

    private Die[] dice = new Die[6];

    public Dice(){
        for (int i = 0; i< dice.length; i++){
            dice[i] = new Die();
            dice[i].rollDie();
        }
    }

    public void rollDice(boolean[] rollThis){
        for (int i = 0; i<dice.length; i++){
            if (rollThis[i]==true){
                dice[i].rollDie();
            }
        }
    }

    public void setDice(int diceNum, int diceValue){
        if (diceNum>-1&&diceNum<6&&diceValue>0&&diceValue<8){
            dice[diceNum].setDie(diceValue);
        }
    }

    public int[] getDiceValues(){
        int[] array = new int[dice.length];
        for (int i = 0; i<dice.length; i++){
            array[i] = dice[i].getDie();
        }
        return array;
    }

    @Override
    public String toString() {
        String x = "";
        for (int i = 0; i< dice.length; i++){
            x=x.concat(Integer.toString(dice[i].getDie())).concat(" ");
        }
        return x;
    }
}
