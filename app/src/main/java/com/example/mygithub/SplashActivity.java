package com.example.mygithub;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {
    private CountDownTimer countDownTimer = new CountDownTimer(3200, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            mSpJumpBtn.setText("跳过(" + millisUntilFinished / 1000 + "s)");
        }

        @Override
        public void onFinish() {
            mSpJumpBtn.setText("跳过(" + 0 + "s)");
            gotoLoginOrMainActivity();
        }
    };
    private Button mSpJumpBtn;

    private void gotoLoginOrMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    private void startClock() {
        mSpJumpBtn.setVisibility(View.VISIBLE);
        countDownTimer.start();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
        startClock();
    }

    private void initView() {
        mSpJumpBtn = findViewById(R.id.sp_jump_btn);
    }

    @Override
    public void finish() {
        super.finish();
        if (countDownTimer != null)
            countDownTimer.cancel();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sp_jump_btn:
                gotoLoginOrMainActivity();
                break;
            case R.id.sp_bg:
                gotoWebActivity();
                break;
        }
    }

    private void gotoWebActivity() {

    }
}
