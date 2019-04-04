package com.example.kingoftokyoprobabilitycalculator;

public class Probability {

    private Dice dice = new Dice();
    private Dice desiredRoll = new Dice();
    private int numberOfRolls;
    private int turns = 0;
    private int successes = 0;
    private boolean setDice = false;
    private String setDiceStr = "";

    public Probability(String desRoll, int numberOfRolls){
        if (desRoll.length() == 6 && numberOfRolls>0){
            for (int i = 0; i < desRoll.length(); i++){
                desiredRoll.setDice(i,Legend.getInt(desRoll.substring(i,i+1)));
            }
            this.numberOfRolls = numberOfRolls;
        }
        else{
            System.exit(0);
        }
        //System.out.println(desiredRoll);
    }

    public Probability(String desRoll, int numberOfRolls, String setRoll){
        if (desRoll.length() == 6 && numberOfRolls>0 && setRoll.length()==6){
            for (int i = 0; i < desRoll.length(); i++){
                desiredRoll.setDice(i,Legend.getInt(desRoll.substring(i,i+1)));
                dice.setDice(i,Legend.getInt(setRoll.substring(i,i+1)));
            }
            this.numberOfRolls = numberOfRolls;
            this.setDice = true;
            this.setDiceStr = new String(setRoll);
        }
        else{
            System.exit(0);
        }
        //System.out.println(desiredRoll);
    }

    public float Calculate(int totalTurns){
        if (totalTurns<1) {
            return 0.0f;
        }
        while (turns<totalTurns){
            turns+=1;
            if (!setDice) {
                dice.rollDice(new boolean[]{true, true, true, true, true, true});
            }
            else{
                dice.rollDice(compareRolls());
            }
            for (int i = 0; i< numberOfRolls; i++){
                //System.out.println(i);
                //System.out.println(dice);
                boolean[] rollThis = compareRolls();
                if (isSuccess(rollThis)){
                    successes+=1;
                    break;
                }
                else{
                    dice.rollDice(rollThis);
                }
            }
            if(setDice == true) {
                for (int i = 0; i < 6; i++) {
                    dice.setDice(i, Legend.getInt(setDiceStr.substring(i, i + 1)));
                }
            }


        }
        float probability = (float) successes / (float) totalTurns;
        successes = 0;
        turns = 0;



        return probability;

    }

    public boolean isSuccess(boolean[] rollThis){
        for (int i = 0; i < rollThis.length; i++){
            if (rollThis[i]==true){
                return false;
            }
        }
        return true;
    }

    public boolean[] compareRolls(){
        boolean[] rollThis = new boolean[6];
        for (int i = 0; i<6; i++){
            rollThis[i] = true;
        }
        int onesDes = 0;
        int twosDes = 0;
        int threesDes = 0;
        int attDes = 0;
        int healDes = 0;
        int enerDes = 0;
        int[] desiredValues = desiredRoll.getDiceValues();
        int[] diceValues = dice.getDiceValues();
        // Establish how much of each face desired
        for (int i = 0; i<6;i++){
            switch(desiredValues[i]){
                case 1: onesDes+=1; break;
                case 2: twosDes+=1; break;
                case 3: threesDes+=1; break;
                case 4: attDes+=1; break;
                case 5: healDes+=1; break;
                case 6: enerDes+=1; break;
                case 7: break;
            }
        }
        // Check which dice to roll
        for (int i = 0; i<6; i++){
            if(diceValues[i] == 1 && onesDes>0){
                rollThis[i] = false;
                onesDes-=1;
            }
            else if(diceValues[i]==2 && twosDes>0){
                rollThis[i] = false;
                twosDes-=1;
            }
            else if(diceValues[i]==3 && threesDes>0){
                rollThis[i] = false;
                threesDes-=1;
            }
            else if(diceValues[i]==4 && attDes>0){
                rollThis[i] = false;
                attDes-=1;
            }
            else if(diceValues[i]==5 && healDes>0){
                rollThis[i] = false;
                healDes-=1;
            }
            else if(diceValues[i]==6 && enerDes>0){
                rollThis[i] = false;
                enerDes-=1;
            }

        }
        if(onesDes+twosDes+threesDes+attDes+healDes+enerDes==0){
            for (int k = 0; k<6; k++){
                rollThis[k]=false;
            }
        }

        return rollThis;

    }







}
