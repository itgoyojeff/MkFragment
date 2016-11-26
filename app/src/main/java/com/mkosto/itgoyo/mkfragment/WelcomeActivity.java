package com.mkosto.itgoyo.mkfragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by itgoyo on 16-11-26.
 */

public class WelcomeActivity extends Activity {
    @InjectView(R.id.welecome_image)
    ImageView welecomeImage;
    @InjectView(R.id.count_down)
    TextView countDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);
        ButterKnife.inject(this);
//        ButterKnife.inject(this);
        initView();
    }

    private void initView() {
        Picasso.with(this).load(R.drawable.welcome_img).into(welecomeImage);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        },3000);
    }
}
