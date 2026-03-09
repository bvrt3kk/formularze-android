package com.example.formularzeapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText editTextImie, editTextGatunek, editTextWaga;
    Spinner spinnerGromada;
    CheckBox checkBoxWymarle, checkBoxMieso, checkBoxRosliny;
    RadioButton radioButtonDzien, radioButtonNoc;
    Switch aSwitch;
    SeekBar seekBar;
    Button dodaj;
    TextView textViewKomunikat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextGatunek = findViewById(R.id.editTextText);
        editTextImie = findViewById(R.id.editTextText2);
        editTextWaga = findViewById(R.id.editTextNumber);
        spinnerGromada = findViewById(R.id.spinner);
        checkBoxWymarle = findViewById(R.id.checkBox);
        checkBoxRosliny = findViewById(R.id.checkBox2);
        checkBoxMieso = findViewById(R.id.checkBox3);
        radioButtonDzien = findViewById(R.id.radioButtonDzienny);
        radioButtonNoc = findViewById(R.id.radioButtonNocny);
        aSwitch = findViewById(R.id.switch1);
        seekBar = findViewById(R.id.seekBar);
        dodaj = findViewById(R.id.button2);
        textViewKomunikat = findViewById(R.id.textViewKomunikat);

        dodaj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String imie = editTextImie.getText().toString();
                        String gromada = spinnerGromada.getSelectedItem().toString();
                        String gatunek = editTextGatunek.getText().toString();
                        String wymarle;
                        if(checkBoxWymarle.isChecked()){
                            wymarle = "tak";
                        }else{
                            wymarle = "nie";
                        }
                        int wiek = seekBar.getProgress();
                        int waga = Integer.parseInt(editTextWaga.getText().toString());

                        textViewKomunikat.setText("Imię: " + imie + " Gromada: " + gromada + " Gatunek: " + gatunek + " Czy wymarłe: " + wymarle + " Tryb życia: " + "" + " Wiek: " + wiek);
                    }
                }
        );
    }
}