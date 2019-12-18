package com.example.animationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button tween,frame,attr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tween=findViewById(R.id.bt_tween);
        frame=findViewById(R.id.bt_frame);
        attr=findViewById(R.id.bt_attr);

        tween.setOnClickListener(this);
        frame.setOnClickListener(this);
        attr.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_tween:
                Intent intent=new Intent(MainActivity.this,TweenAnimationActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_frame:
                intent=new Intent(MainActivity.this,FrameAnimationActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_attr:
                intent=new Intent(MainActivity.this,AttrAnimationActivity.class);
                startActivity(intent);
                break;
        }
    }
}
