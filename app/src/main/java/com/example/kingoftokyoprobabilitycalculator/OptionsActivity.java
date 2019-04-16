package com.example.kingoftokyoprobabilitycalculator;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class OptionsActivity extends AppCompatActivity {

    SetOptions opt = new SetOptions();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options);
        Toast.makeText(this, "lel", Toast.LENGTH_SHORT).show();

    }


    @Override
    public void finish() {
        Intent opInt = new Intent();
        opt.setNumberDice(Integer.parseInt(((Spinner) findViewById(R.id.diceSpinner) ).getSelectedItem().toString()));
        opt.setNumberSims(Integer.parseInt(((TextView) findViewById(R.id.simsInput) ).getText().toString()));
        opt.setSumMode(((Switch) findViewById(R.id.modeSwitch) ).isChecked());
        opt.setMaxFace(Integer.parseInt(((Spinner) findViewById(R.id.faceSpinner) ).getSelectedItem().toString()));
        opInt.putExtra("optionSet",opt);
        setResult(MainActivity.OPTIONS_REQUEST, opInt);
        super.finish();
    }
}
