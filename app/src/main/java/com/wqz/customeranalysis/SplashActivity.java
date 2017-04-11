package com.wqz.customeranalysis;

import android.content.Intent;
import android.os.Handler;

import com.wqz.base.BaseImmersiveActivity;

public class SplashActivity extends BaseImmersiveActivity
{
    @Override
    protected void onInitUI()
    {
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onSetListener()
    {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // login
                startActivity(new Intent(SplashActivity.this,
                        LoginActivity.class));
                SplashActivity.this.finish();
            }
        }, 2000);
    }

    @Override
    protected void onSetDataLogic(Object data)
    {

    }
}
