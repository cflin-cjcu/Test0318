package com.example.test0318;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class ShowBMIActivity extends AppCompatActivity {

    private TextView name;
    private ImageView view1;
    private TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bmi);
        name = (TextView) findViewById(R.id.tv_name);
        view1 = (ImageView) findViewById(R.id.iv_pic);
        info = (TextView) findViewById(R.id.tv_info);

        Bundle bundle = this.getIntent().getExtras();
        String h = bundle.getString("height");
        String w = bundle.getString("weight");
        String n = bundle.getString("name");

//        Toast.makeText(this, h+w+n, Toast.LENGTH_SHORT).show();
        double bmi = Double.parseDouble(w)  / (Double.parseDouble(h) /100.0 * Double.parseDouble(h)/100.0);
        DecimalFormat df = new DecimalFormat("#.#");

        name.setText(n);
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
        info.setText(name.getText().toString()+"您的'BMI是" + df.format(bmi));

    }
}
