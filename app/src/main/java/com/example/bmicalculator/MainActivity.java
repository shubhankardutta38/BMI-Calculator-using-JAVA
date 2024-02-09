package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn1_0115, btn2_0115;
    EditText ed1_0115, ed2_0115;
    TextView ed3_0115, ed4_0115;
    Double h, w, res;
    RadioGroup rg1;
    RadioButton rb1_0115, rb2_0115, rb3_0115;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1_0115 = findViewById(R.id.button);
        btn2_0115 = findViewById(R.id.button5); // clear btn
        ed1_0115 = findViewById(R.id.editTextText);
        ed2_0115 = findViewById(R.id.editTextText2);
        ed3_0115 = findViewById(R.id.textView2);
        ed4_0115 = findViewById(R.id.textView3);
        rb1_0115 = findViewById(R.id.radioButton1);
        rb2_0115 = findViewById(R.id.radioButton2);
        rb3_0115 = findViewById(R.id.radioButton3);

        btn1_0115.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                h = Double.parseDouble(ed1_0115.getText().toString());
                w = Double.parseDouble(ed2_0115.getText().toString());
                //double H = 0 ;
                if (rb1_0115.isChecked()) {
                    h = h ;
                } else if (rb2_0115.isChecked()) {
                    h = h*0.01;
                } else if (rb3_0115.isChecked()) {
                    h = h*0.0254;
                }
                res =(w)/(h * h);

                // Display the calculated BMI
                ed3_0115.setText(String.format("%.2f", res));

                // Determine the BMI category
                if (res < 18.5) {
                    ed4_0115.setText("Underweight");
                } else if (res < 25) {
                    ed4_0115.setText("Normal");
                } else if (res < 30) {
                    ed4_0115.setText("Overweight");
                } else {
                    ed4_0115.setText("Obese");
                }
            }
        });
        btn2_0115.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear the input fields and result TextViews
                ed1_0115.setText("");
                ed2_0115.setText("");
                ed3_0115.setText("");
                ed4_0115.setText("");
                // Uncheck radio buttons
                rb1_0115.setChecked(false);
                rb2_0115.setChecked(false);
                rb3_0115.setChecked(false);
            }
        });
    }
}
