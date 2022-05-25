package com.example.karad1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class objectDisplay extends AppCompatActivity {
    ImageView imageView,home;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_display);
        imageView=findViewById(R.id.Productimg);
        textView=findViewById(R.id.Productprice);
        imageView.setImageResource(getIntent().getIntExtra("image name",0));
        String pt=getIntent().getStringExtra("Shirt no");
        textView.setText(pt);
        home=findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(objectDisplay.this,Dashboard.class);
                startActivity(intent);
            }
        });
    }
}