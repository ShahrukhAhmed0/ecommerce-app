package com.example.karad1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {
    ViewFlipper flipper;
    RecyclerView recyclerView, recyclerView1;
    ArrayList<MainModel> mainModels;
    MainAdapter mainAdapter;
    ArrayList<MainModel3> mainModels1;
    MainAdapter2 mainAdapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        int imgarray[] = {R.drawable.d1, R.drawable.d2, R.drawable.d4};
        flipper = findViewById(R.id.flipper);
        for (int k = 0; k < imgarray.length; k++) {
            showimage(imgarray[k]);
        }
        recyclerView = findViewById(R.id.recycle_view);
        Integer[] langLogo = {R.drawable.gears, R.drawable.dear1, R.drawable.fea1};
        String[] langName = {"RS-4000", "RS-5000", "RS-4500"};
        mainModels = new ArrayList<>();
        for (int i = 0; i < langLogo.length; i++) {
            MainModel model = new MainModel(langLogo[i], langName[i]);
            mainModels.add(model);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                Dashboard.this, LinearLayoutManager.HORIZONTAL, false
        );
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        mainAdapter = new MainAdapter(Dashboard.this, mainModels);
        recyclerView.setAdapter(mainAdapter);


        recyclerView1 = findViewById(R.id.recycle_view1);
       // Integer[] langLogo1 = {R.drawable.gears, R.drawable.dear1, R.drawable.fea1};
        Integer[] langLogo1 = {R.drawable.ge, R.drawable.dq, R.drawable.dqo};

        String[] langName1 = {"RS-4000", "RS-5000","RS-4500"};
        mainModels1 = new ArrayList<>();
        for (int j = 0; j < langLogo1.length; j++) {
            MainModel3 model1 = new MainModel3(langLogo1[j], langName1[j]);
            mainModels1.add(model1);
        }LinearLayoutManager layoutManager1 = new LinearLayoutManager(
                Dashboard.this, LinearLayoutManager.HORIZONTAL, false
        );

        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());
        mainAdapter2 = new MainAdapter2(Dashboard.this, mainModels1);
        recyclerView1.setAdapter(mainAdapter2);

    }

    public void showimage(int img)
    {
        ImageView imageView=new ImageView(this);
        imageView.setBackgroundResource(img);
        flipper.addView(imageView);
        flipper.setFlipInterval(3000);
        flipper.setAutoStart(true);
        flipper.setInAnimation(this,R.anim.slide_in_left);
        flipper.setInAnimation(this,R.anim.slide_out_right);
    }
}