package com.example.pc_ocho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton jrbHP, jrbLenovo, jrbAsus;
    TextView jtvPrecio, jtvDisco, jtvIVA, jtvTotal;
    EditText jetCantidad;
    CheckBox jcbDisco;
    Button jbtCalc,jbtLimp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        jrbHP = findViewById(R.id.rbHP);
        jrbLenovo = findViewById(R.id.rbLenovo);
        jrbAsus = findViewById(R.id.rbAsus);
        jtvPrecio = findViewById(R.id.tvPrecio);
        jtvDisco = findViewById(R.id.tvDisco);
        jtvIVA = findViewById(R.id.tvIVA);
        jtvTotal = findViewById(R.id.tvTotal);
        jetCantidad = findViewById(R.id.etCantidad);
        jcbDisco = findViewById(R.id.cbDisco);
        jbtCalc = findViewById(R.id.btCalc);
        jbtLimp = findViewById(R.id.btLimp);
    }

    public void calc_tot(){
        String qty;
        qty = jetCantidad.getText().toString();

        if(qty.isEmpty()){
            Toast.makeText(this, "Cantidad de equipos requerdida", Toast.LENGTH_SHORT).show();
            jetCantidad.requestFocus();
        }else{
            int vlr_qty, vlr_pc, vlr_disc;
            double pc, vlr_iva, des, vlr_tot;

            vlr_qty = Integer.parseInt(qty);
            vlr_pc = Integer.parseInt(jtvPrecio.getText().toString());
            pc = vlr_pc * vlr_qty;
            des = pc * 0.15;

            if(vlr_qty > 10){
                 pc = pc - des;
            }

            vlr_iva = pc * 0.19;
            vlr_disc = Integer.parseInt(jtvDisco.getText().toString());
            vlr_tot = pc + vlr_disc + vlr_iva;
            jtvIVA.setText(String.valueOf(vlr_iva));
            jtvTotal.setText(String.valueOf(vlr_tot));
        }
    }

    public void calc(View view){
        calc_tot();
    }

    public void hp(View view){
        jtvPrecio.setText("1900000");
    }

    public void lenovo(View view){
        jtvPrecio.setText("2100000");
    }

    public void asus(View view){
        jtvPrecio.setText("1700000");
    }

    public void disco(View view){
        if(jcbDisco.isChecked()){
            jtvDisco.setText("300000");
        }else{
            jtvDisco.setText("0");
        }
    }

    public void limpiar(View view){
        jetCantidad.setText("");
        jtvPrecio.setText("0");
        jtvDisco.setText("0");
        jtvIVA.setText("0");
        jtvTotal.setText("0");
        jrbHP.setChecked(true);
        jcbDisco.setChecked(false);
        jetCantidad.requestFocus();
    }
}