package com.szg_tech.hearthfailure.activities.authentication;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.szg_tech.hearthfailure.BuildConfig;
import com.szg_tech.hearthfailure.R;

import java.util.Objects;


/**
 * Created by superlight on 7/22/2017 AD.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Objects.requireNonNull(getSupportActionBar()).hide();
        ((TextView) findViewById(R.id.txtVersion)).setText(BuildConfig.VERSION_NAME);

        startAnimation();
        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(3500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(getApplicationContext(), AuthenticationActivity.class));
                    finish();
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

    private void startAnimation() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        ImageView ivLogo = (ImageView) findViewById(R.id.iv_logo);
        ivLogo.clearAnimation();
        ivLogo.startAnimation(anim);
    }

}
