package thanhtung.example.baikt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

import thanhtung.example.baikt.databinding.ActivityListBinding;
import thanhtung.example.baikt.databinding.ActivityMainBinding;

public class List extends AppCompatActivity {

    ActivityListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        int[] imageId = {R.drawable.huycan, R.drawable.macngon, R.drawable.shakespeare,
                R.drawable.hemingway, R.drawable.tohuu, R.drawable.nguyendu};
        String[] name =  {"Huy Cận", "Mạc Ngôn", "Shakespeare", "Hemingway",
                "Tố Hữu", "Nguyễn Du","Kim Lân"};
        String[] lastMessage = {"là nhà văn nổi tiếng", "là nhà văn nổi tiếng", "là nhà văn nổi tiếng",
                "là nhà văn nổi tiếng", "là nhà văn nổi tiếng", "là nhà văn nổi tiếng",};
        String[] country = {"Việt Nam", "Trung Quốc", "Anh", "Mỹ", "Việt Nam", "Việt Nam", "Việt Nam"};
//        int[] imageId = {R.drawable.logo_ute, R.drawable.logo_ute, R.drawable.logo_ute,
//                R.drawable.logo_ute, R.drawable.logo_ute, R.drawable.logo_ute};
//        String[] name =  {"Tràng giang", "Đoàn thuyền đánh cá", "Ta viết bài thơ gọi biển", "Ngậm ngùi",
//                "Con chim chiền chiện", "kgjl" };
//        String[] lastMessage = {"n trong tập “Lửa thiêng”, “Tràng Giang” là một trong những bài thơ xuất sắc nhất của nền văn học Việt Nam. Bài thơ thể hiện nỗi sầu của thi nhân trước thiên nhiên rộng lớn, của một cái tôi cô đơn trống vắng trước sự rộng lớn của cảnh vật. Qua đó thể hiện nỗi buồn lẩn khuất của cả một thời đại.", "là tác phầm văn học hay", "là tác phầm văn học hay",
//                "là tác phầm văn học hay", "là tác phầm văn học hay","là tác phầm văn học hay"};
//        String[] country = {"5★", "4★", "4.5★", "5★", "4.5★", "3★"};
        String[] phoneNo = {"22/01/1917", "17/02/1955", "23/4/1616", "21/7/1899", "4/10/1920", "3/1/1766", "1/8/1920"};
        String[] lastmsgTime = {"8:45 pm", "8:45 pm", "8:45 pm", "8:45 pm", "8:45 pm", "8:45 pm", "8:45 pm",};

        ArrayList<User> userArrayList = new ArrayList<>();

        for (int i = 0; i < imageId.length; i++){
            User user = new User(name[i], lastMessage[i], lastmsgTime[i], phoneNo[i], country[i],imageId[i]);
            userArrayList.add(user);
        }

        ListAdapter listAdapter = new ListAdapter(List.this, userArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent kk =new Intent(List.this, UserActivity.class);
                kk.putExtra("name",name[position]);
                kk.putExtra("lastMessage",lastMessage[position]);
                kk.putExtra("country",country[position]);
                kk.putExtra("phoneNo",phoneNo[position]);
                kk.putExtra("lastmsgTime",lastmsgTime[position]);
                kk.putExtra("imageId",imageId[position]);
                startActivity(kk);

            }
        });
    }
}