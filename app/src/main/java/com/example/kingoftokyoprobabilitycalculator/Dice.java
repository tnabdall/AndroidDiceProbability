package com.example.kingoftokyoprobabilitycalculator;

public class Dice {

    private Die[] dice = new Die[6];

    /**
     * Creates an array of 6 dice
     */
    public Dice(){
        for (int i = 0; i< dice.length; i++){
            dice[i] = new Die();
            dice[i].rollDie();
        }
    }

    /**
     * Rolls the dice specified by the boolean array
     * @param rollThis An array specifying which dice to reroll
     */
    public void rollDice(boolean[] rollThis){
        for (int i = 0; i<dice.length; i++){
            if (rollThis[i]==true){
                dice[i].rollDie();
            }
        }
    }

    /**
     * Allows us to set the value of a die
     * @param diceNum index in Array
     * @param diceValue 1,2,3, 4 for att, 5 for he, 6 for en, 7 for any
     */
    public void setDice(int diceNum, int diceValue){
        if (diceNum>-1&&diceNum<6&&diceValue>0&&diceValue<8){
            dice[diceNum].setDie(diceValue);
        }
    }

    /**
     * Gives an array of all dice values (1-7)
     * @return integer array of all dice values
     */
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
