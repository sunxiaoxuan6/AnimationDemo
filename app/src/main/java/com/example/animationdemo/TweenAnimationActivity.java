package com.example.animationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class TweenAnimationActivity extends AppCompatActivity {
    private ImageView inside;
    private ImageView outer;
    private TextView view;

    private Animation insideCircle,outerCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);

        inside=findViewById(R.id.iv_inside_circle);
        outer=findViewById(R.id.iv_outer_circle);

        view=findViewById(R.id.tv_view);

        insideCircle=AnimationUtils.loadAnimation(this,R.anim.anim_in_rotate);
        insideCircle.setInterpolator(new LinearInterpolator());//差值器

        outerCircle=AnimationUtils.loadAnimation(this,R.anim.anim_out_rotate);
        outerCircle.setInterpolator(new LinearInterpolator());

        inside.startAnimation(insideCircle);
        outer.startAnimation(outerCircle);

//        inside.clearAnimation();//停止动画



    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_translation:

//                根据anim/xml创建
//                Animation animation= AnimationUtils.loadAnimation(this,R.anim.anim_translate);
//                view.startAnimation(animation);

//                动态创建，完成跟xml动画一样的效果
                Animation animation= new TranslateAnimation(0,100,0,300);
                animation.setDuration(3000);
                view.startAnimation(animation);
                break;
            case R.id.btn_scale:
//                animation=AnimationUtils.loadAnimation(this,R.anim.anim_scale);
//                view.startAnimation(animation);
//
//                动态创建
                animation= new ScaleAnimation(0,2,0,2,
                        Animation.RELATIVE_TO_SELF,0.5f,
                        Animation.RELATIVE_TO_SELF,0.5f);
                animation.setDuration(3000);
                view.startAnimation(animation);
                break;
            case R.id.btn_rotate:
                animation=AnimationUtils.loadAnimation(this,R.anim.anim_in_rotate);
                view.startAnimation(animation);

                break;
            case R.id.btn_alpha:
                animation=AnimationUtils.loadAnimation(this,R.anim.anim_alpha);
                view.startAnimation(animation);
                break;
            case R.id.btn_set:
                animation=AnimationUtils.loadAnimation(this,R.anim.anim_set);
                view.startAnimation(animation);
                break;
            case R.id.btn_compose:
                animation = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
                view.startAnimation(animation);

                final Animation second = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        view.startAnimation(second);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                break;
            case R.id.btn_flash:
                AlphaAnimation alpha = new AlphaAnimation(0.1f, 1.0f);
                alpha.setDuration(100);
                alpha.setRepeatCount(10);
                alpha.setRepeatMode(Animation.REVERSE);
                view.startAnimation(alpha);
                break;
            case R.id.btn_change:
                Intent intent = new Intent(TweenAnimationActivity.this, SecondActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
                break;
        }
    }
    private void startAnimation() {
        inside.startAnimation(insideCircle);
        outer.startAnimation(outerCircle);

    }

    private void stopAnimation() {
        inside.clearAnimation();
        outer.clearAnimation();
    }
}
