package com.example.kingoftokyoprobabilitycalculator;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class OptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options);
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void finish() {
        super.finish();
    }
}
