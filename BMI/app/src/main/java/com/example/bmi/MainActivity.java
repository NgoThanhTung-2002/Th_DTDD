package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txt_weight, txt_height;
    TextView tw_result;
    Button cal;
    Float w, h, rs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhxa();
        controlButton();

    }
    private void controlButton() {
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txt_weight.getText().length()  != 0 || txt_height.getText().length() !=0) {
                    w = Float.parseFloat(String.valueOf(txt_weight.getText()));
                    h = Float.parseFloat(String.valueOf(txt_height.getText()))/100;
                    rs = w /(h*h);
                    if (rs < 18) {
                        tw_result.setText(rs + "\nNgười gầy");
                    } else if (rs < 25)
                        tw_result.setText(rs + "\nNgười bình thường");
                    else if (rs < 30)
                        tw_result.setText(rs + "\nNgười béo phì độ I");
                    else if (rs < 35)
                        tw_result.setText(rs + " \nNgười béo phì giai đoạn II");
                    else
                        tw_result.setText(rs + "\nNgười béo phì giai doạn III");
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    tw_result.setText("");}
            }
        });
    }

    private void anhxa(){
        txt_weight = (EditText) findViewById(R.id.weight);
        txt_height = (EditText) findViewById(R.id.height);
        tw_result = (TextView) findViewById(R.id.result);
        cal = (Button) findViewById(R.id.btn_cal);
    }
}