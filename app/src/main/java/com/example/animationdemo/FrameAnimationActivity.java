package com.example.animationdemo;

import android.graphics.drawable.AnimationDrawable;
        import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class FrameAnimationActivity extends AppCompatActivity {
    private ImageView progress;
    private AnimationDrawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);
        progress=findViewById(R.id.iv_progress);
//        第1种方式：静态设置属性
//        drawable= (AnimationDrawable) progress.getBackground();

//        第2种方式：静态设置属性
        progress.setImageResource(R.drawable.heart_anim);
        drawable= (AnimationDrawable) progress.getDrawable();

//        第3种方式：静态设置属性
//        drawable=createAnimation();
//        progress.setImageDrawable(drawable);
    }
//
//    private AnimationDrawable createAnimation() {
//        AnimationDrawable animationDrawable=new AnimationDrawable();
//        for (int i=0;i<8;i++){
//            int id=getResources().getIdentifier("wait"+i,"drawable",
//                    getPackageName());
//            Drawable drawable=getResources().getDrawable(id);
//            animationDrawable.addFrame(drawable,100);
//        }
//        return animationDrawable;
//    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_start:
//        启动帧动画
                drawable.start();
                break;
            case R.id.btn_stop:
//        停止帧动画
                drawable.stop();
                break;
        }
    }
}
