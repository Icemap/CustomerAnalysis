package com.wqz.customeranalysis;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.View;

import com.wqz.base.BaseImmersiveActivity;
import com.wqz.utils.ScreenUtils;
import com.wqz.utils.StatusBarUtils;
import com.wqz.view.TitleBar;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends BaseImmersiveActivity
{
    TitleBar titleBar;
    GifImageView giv;

    @Override
    protected void onInitUI()
    {
        setContentView(R.layout.activity_main);
        titleBar = (TitleBar)findViewById(R.id.title_bar);
        giv = (GifImageView)findViewById(R.id.gif_image);
        try
        {
            GifDrawable gifDrawable = new GifDrawable(getResources(), R.drawable.main_gif);
            giv.setImageDrawable(gifDrawable);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        setTitleBarParm();
    }

    @Override
    protected void onSetListener()
    {
        titleBar.addAction(new TitleBar.TextAction("退出账号")
        {
            @Override
            public void performAction(View view)
            {
                MainActivity.this.getBaseApplication().isClear = true;
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                MainActivity.this.finish();
            }
        });
    }

    @Override
    protected void onSetDataLogic(Object data)
    {

    }

    private void setTitleBarParm()
    {
        titleBar.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.colorTitleBar));
        StatusBarUtils.setWindowStatusBarColor(MainActivity.this, R.color.colorTitleBar);
        titleBar.setImmersive(true);
        titleBar.setTitleColor(Color.WHITE);
        titleBar.setHeight(ScreenUtils.getScreenHeight(MainActivity.this) / 12);
        titleBar.setActionTextColor(Color.WHITE);
        titleBar.setTitle("等待推送");
    }
}
