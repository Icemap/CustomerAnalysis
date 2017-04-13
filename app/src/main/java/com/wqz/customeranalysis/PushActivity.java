package com.wqz.customeranalysis;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.wqz.base.BaseImmersiveActivity;
import com.wqz.pojo.ExtraPojo;
import com.wqz.pojo.OtherLabel;
import com.wqz.utils.ScreenUtils;
import com.wqz.utils.StatusBarUtils;
import com.wqz.view.TitleBar;

public class PushActivity extends BaseImmersiveActivity
{
    TextView tvName,tvSex,tvAge,tvPhone;
    TitleBar titleBar;
    ImageView ivHead;

    @Override
    protected void onInitUI()
    {
        setContentView(R.layout.activity_push);
        titleBar = (TitleBar)findViewById(R.id.title_bar);
        tvName = (TextView)findViewById(R.id.tv_name);
        tvSex = (TextView)findViewById(R.id.tv_sex);
        tvAge = (TextView)findViewById(R.id.tv_age);
        tvPhone = (TextView)findViewById(R.id.tv_phone);
        ivHead = (ImageView) findViewById(R.id.iv_photo);
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
                startActivity(new Intent(PushActivity.this,MainActivity.class));
                PushActivity.this.finish();
            }
        });
    }

    @Override
    protected void onSetDataLogic(Object data)
    {
        Intent intent = getIntent();
        String json = intent.getStringExtra("json");
        ExtraPojo extraPojo = new Gson().fromJson(json,ExtraPojo.class);
        OtherLabel otherLabel = new Gson().fromJson(extraPojo.otherLabel,OtherLabel.class);
        tvName.setText(PushActivity.this.getResources().getString(R.string.name) + extraPojo.name);
        tvSex.setText(PushActivity.this.getResources().getString(R.string.sex) + otherLabel.sex);
        tvAge.setText(PushActivity.this.getResources().getString(R.string.age) + extraPojo.age);
        tvPhone.setText(PushActivity.this.getResources().getString(R.string.phone) + extraPojo.phone);
        Picasso.with(PushActivity.this).load(otherLabel.picUrl).into(ivHead);
    }

    private void setTitleBarParm()
    {
        titleBar.setBackgroundColor(PushActivity.this.getResources().getColor(R.color.colorTitleBar));
        StatusBarUtils.setWindowStatusBarColor(PushActivity.this, R.color.colorTitleBar);
        titleBar.setImmersive(true);
        titleBar.setTitleColor(Color.WHITE);
        titleBar.setHeight(ScreenUtils.getScreenHeight(PushActivity.this) / 12);
        titleBar.setActionTextColor(Color.WHITE);
        titleBar.setTitle("推送消息");
    }
}
