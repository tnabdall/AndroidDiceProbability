package com.example.kingoftokyoprobabilitycalculator;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calculateButton = (Button) findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });

        setDesRollSpinners();
        calculate();


    }

    public void setDesRollSpinners(){
        ArrayList<Spinner> DesRolls = new ArrayList<Spinner>();
        DesRolls.add((Spinner) findViewById(R.id.spinner));
        DesRolls.add((Spinner) findViewById(R.id.spinner2));
        DesRolls.add((Spinner) findViewById(R.id.spinner3));
        DesRolls.add((Spinner) findViewById(R.id.spinner4));
        DesRolls.add((Spinner) findViewById(R.id.spinner5));
        DesRolls.add((Spinner) findViewById(R.id.spinner6));
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.diceOptions,R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        for (int i = 0; i<6; i++){
            DesRolls.get(i).setAdapter(adapter);
            //DesRolls.get(i).setOnItemSelectedListener(this);
        }
    }

    public void calculate(){
        EditText sims = (EditText) findViewById(R.id.sims);
        String simsS = sims.getText().toString();
        EditText rolls = (EditText) findViewById(R.id.rolls);
        String rollsS = rolls.getText().toString();

        String desRollStr = "";


        ArrayList<Spinner> DesRolls = new ArrayList<Spinner>();
        DesRolls.add((Spinner) findViewById(R.id.spinner));
        DesRolls.add((Spinner) findViewById(R.id.spinner2));
        DesRolls.add((Spinner) findViewById(R.id.spinner3));
        DesRolls.add((Spinner) findViewById(R.id.spinner4));
        DesRolls.add((Spinner) findViewById(R.id.spinner5));
        DesRolls.add((Spinner) findViewById(R.id.spinner6));

        for (int i = 0; i< DesRolls.size(); i++){
            String n = DesRolls.get(i).getSelectedItem().toString();
            switch(n){
                case "attack": n = "a"; break;
                case "heal": n = "h"; break;
                case "energy": n = "e"; break;
                case "any": n = "w"; break;

            }
            desRollStr = desRollStr.concat(n);
        }



        Probability prob = new Probability(desRollStr,Integer.parseInt(rollsS));
        float result = prob.Calculate(Integer.parseInt(simsS));
        rolls.setText(Float.toString(result));


        /*
        EditText sims = findViewById(R.id.sims);
        EditText rolls = findViewById(R.id.rolls);
        System.out.print("Number of sims is: ".concat(sims.getText().toString()));
        rolls.setText(sims.getText());
        */
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
