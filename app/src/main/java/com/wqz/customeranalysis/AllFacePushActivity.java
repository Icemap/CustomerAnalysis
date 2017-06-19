package com.wqz.customeranalysis;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.wqz.base.BaseImmersiveActivity;
import com.wqz.pojo.AllFacePojo;
import com.wqz.pojo.ExtraPojo;
import com.wqz.pojo.OtherLabel;
import com.wqz.utils.ScreenUtils;
import com.wqz.utils.StatusBarUtils;
import com.wqz.view.TitleBar;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AllFacePushActivity extends BaseImmersiveActivity
{
    TitleBar titleBar;
    ImageView ivHead;
    TextView tvLastTime;
    TextView tvRec1,tvRec2,tvRec3;

    @Override
    protected void onInitUI()
    {
        setContentView(R.layout.activity_all_face_push);
        titleBar = (TitleBar)findViewById(R.id.title_bar);
        ivHead = (ImageView)findViewById(R.id.iv_head);
        tvLastTime = (TextView)findViewById(R.id.tv_last_time);
        tvRec1 = (TextView)findViewById(R.id.tv_rec1);
        tvRec2 = (TextView)findViewById(R.id.tv_rec2);
        tvRec3 = (TextView)findViewById(R.id.tv_rec3);
        setTitleBarParm();
        onSetDataLogic(null);
    }

    @Override
    protected void onSetListener()
    {
        titleBar.addAction(new TitleBar.TextAction("查看完毕")
        {
            @Override
            public void performAction(View view)
            {
                startActivity(new Intent(AllFacePushActivity.this,MainActivity.class));
                AllFacePushActivity.this.finish();
            }
        });
    }

    @Override
    protected void onSetDataLogic(Object data)
    {
        Intent intent = getIntent();
        String json = intent.getStringExtra("json");
        AllFacePojo allFacePojo = new Gson().fromJson(json,AllFacePojo.class);
        Picasso.with(AllFacePushActivity.this).load(allFacePojo.getPic()).into(ivHead);

        Long[] timeStramp = new Gson().fromJson(allFacePojo.last_list, Long[].class);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(timeStramp != null && timeStramp.length == 1)
            tvRec1.setText(format.format(new Date(timeStramp[0])));
        if(timeStramp != null && timeStramp.length == 2)
        {
            tvRec1.setText(format.format(new Date(timeStramp[0])));
            tvRec2.setText(format.format(new Date(timeStramp[1])));
        }
        if(timeStramp != null && timeStramp.length == 3)
        {
            tvRec1.setText(format.format(new Date(timeStramp[0])));
            tvRec2.setText(format.format(new Date(timeStramp[1])));
            tvRec3.setText(format.format(new Date(timeStramp[2])));
        }
    }

    private void setTitleBarParm()
    {
        titleBar.setBackgroundColor(AllFacePushActivity.this.getResources().getColor(R.color.colorTitleBar));
        StatusBarUtils.setWindowStatusBarColor(AllFacePushActivity.this, R.color.colorTitleBar);
        titleBar.setImmersive(true);
        titleBar.setTitleColor(Color.WHITE);
        titleBar.setHeight(ScreenUtils.getScreenHeight(AllFacePushActivity.this) / 12);
        titleBar.setActionTextColor(Color.WHITE);
        titleBar.setTitle("推送消息");
    }
}