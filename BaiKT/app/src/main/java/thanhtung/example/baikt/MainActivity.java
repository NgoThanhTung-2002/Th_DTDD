package thanhtung.example.baikt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView textViewRegister, textViewUser, textViewPass;
    CheckBox checkBox;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences =getSharedPreferences("dataLogin",MODE_PRIVATE);

        // find ID
        textViewUser = (TextView) findViewById(R.id.etUserName);
        textViewPass =(TextView) findViewById(R.id.etPass);
        button = (Button) findViewById(R.id.btnLogin);
        checkBox = (CheckBox) findViewById(R.id.cbSaveAccount);


        // get form data
        textViewUser.setText(sharedPreferences.getString("taikhoan",""));
        textViewPass.setText(sharedPreferences.getString("matkhau",""));
        checkBox.setChecked(sharedPreferences.getBoolean("checked",false));


        button.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                String user = "admin";
                String pass = "admin";
                //dang nhap tu lam them cai password di de hieu k
                if (textViewUser.getText().toString().equals(user) && textViewPass.getText().toString().equals(pass)){
                    Intent i = new Intent(MainActivity.this, List.class);
                    Toast.makeText(MainActivity.this, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                    if(checkBox.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("taikhoan",textViewUser.getText().toString().trim());
                        editor.putString("matkhau",textViewPass.getText().toString().trim());
                        editor.putBoolean("checked",true);
                        editor.commit();
                    }
                    else{
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("taikhoan");
                        editor.remove("matkhau");
                        editor.remove("checked");
                        editor.commit();
                    }

                    startActivity(i);
                }
                else{
                    // hien loi
                    Toast.makeText(MainActivity.this, "Thong tin: ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}