package com.example.test0318;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText height;
    private EditText weight;
    private EditText name;
    private TextView b;
    private ImageView view1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.ed_name);
        height = (EditText) findViewById(R.id.ed_height);
        weight = (EditText) findViewById(R.id.ed_weight);
        b = (TextView) findViewById(R.id.tv_showbmi);
        view1 = (ImageView) findViewById(R.id.imageView);
    }

    public void show(View view) {

        String h = height.getText().toString();
        String w = weight.getText().toString();
        double bmi = Double.parseDouble(w)  / (Double.parseDouble(h) /100.0 * Double.parseDouble(h)/100.0);
        DecimalFormat df = new DecimalFormat("#.#");


        String msg="";
        if(bmi<18.5) {
            msg ="過輕";
            view1.setImageResource(R.drawable.a1);
        } else if (bmi>25) {
            msg = "過重";
            view1.setImageResource(R.drawable.a3);
        } else {
            msg = "標準";
            view1.setImageResource(R.drawable.a2);
        }
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        b.setText(name.getText().toString()+"您的'BMI是" + df.format(bmi));
    }

    public void nextPage(View view) {
        String h = height.getText().toString();
        String w = weight.getText().toString();
        String name1 = name.getText().toString();
        Bundle bundle =new Bundle();
        bundle.putString("height",h);
        bundle.putString("weight",w);
        bundle.putString("name",name1);

        Intent intent = new Intent(this, ShowBMIActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
