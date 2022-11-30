package thanhtung.example.baikt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import thanhtung.example.baikt.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {

    ActivityUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();
        if (intent !=null){
            String name = intent.getStringExtra("name");
            String lastMessage = intent.getStringExtra("lastMessage");
            String country = intent.getStringExtra("country");
            int imageId = intent.getIntExtra("imageId",R.drawable.logo_ute);
            String phoneNo = intent.getStringExtra("phoneNo");

            binding.title.setText(name);
            binding.content.setText(lastMessage);
//            binding.sosao.setText(phoneNo);
//            binding.img.setImageResource(imageId);
//            binding.quocGia.setText(country);
        }
    }
}