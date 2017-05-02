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

public class AllFacePushActivity extends BaseImmersiveActivity
{
    TitleBar titleBar;
    ImageView ivHead;
    TextView tvLastTime;

    @Override
    protected void onInitUI()
    {
        setContentView(R.layout.activity_all_face_push);
        titleBar = (TitleBar)findViewById(R.id.title_bar);
        ivHead = (ImageView)findViewById(R.id.iv_head);
        tvLastTime = (TextView)findViewById(R.id.tv_last_time);

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
        tvLastTime.setText("上次到店时间：" + allFacePojo.getDatetime());
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