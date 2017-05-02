package com.wqz.customeranalysis;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.wqz.base.BaseImmersiveActivity;
import com.wqz.pojo.BoughtPojo;
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
    TextView tv11,tv12,tv13,tv14;
    TextView tv21,tv22,tv23,tv24;
    TextView tv31,tv32,tv33,tv34;

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
        tv11 = (TextView)findViewById(R.id.tv1_1);
        tv12 = (TextView)findViewById(R.id.tv1_2);
        tv13 = (TextView)findViewById(R.id.tv1_3);
        tv14 = (TextView)findViewById(R.id.tv1_4);
        tv21 = (TextView)findViewById(R.id.tv2_1);
        tv22 = (TextView)findViewById(R.id.tv2_2);
        tv23 = (TextView)findViewById(R.id.tv2_3);
        tv24 = (TextView)findViewById(R.id.tv2_4);
        tv31 = (TextView)findViewById(R.id.tv3_1);
        tv32 = (TextView)findViewById(R.id.tv3_2);
        tv33 = (TextView)findViewById(R.id.tv3_3);
        tv34 = (TextView)findViewById(R.id.tv3_4);
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
        setList(new Gson().fromJson(extraPojo.bought,BoughtPojo[].class));
    }

    private void setTitleBarParm()
    {
        titleBar.setBackgroundColor(PushActivity.this.getResources().getColor(R.color.colorTitleBar));
        StatusBarUtils.setWindowStatusBarColor(PushActivity.this, R.color.colorTitleBar);
        titleBar.setImmersive(true);
        titleBar.setTitleColor(Color.WHITE);
        titleBar.setHeight(ScreenUtils.getScreenHeight(PushActivity.this) / 12);
        titleBar.setActionTextColor(Color.WHITE);
        titleBar.setTitle("推荐方案");
    }

    private void setList(BoughtPojo[] boughtPojoList)
    {
        if(boughtPojoList.length == 0)
        {
            data0Gone();
        }
        else if(boughtPojoList.length == 1)
        {
            data1Gone();
            data1Set(boughtPojoList);
        }
        else if(boughtPojoList.length == 2)
        {
            data2Gone();
            data1Set(boughtPojoList);
            data2Set(boughtPojoList);
        }
        else
        {
            BoughtPojo[] list3 = new BoughtPojo[3];
            list3[0] = boughtPojoList[boughtPojoList.length - 3];
            list3[1] = boughtPojoList[boughtPojoList.length - 2];
            list3[2] = boughtPojoList[boughtPojoList.length - 1];
            data1Set(list3);
            data2Set(list3);
            data3Set(list3);
        }
    }

    private void data0Gone()
    {
        tv11.setVisibility(View.GONE);
        tv12.setVisibility(View.GONE);
        tv13.setVisibility(View.GONE);
        tv14.setVisibility(View.GONE);
        tv21.setVisibility(View.GONE);
        tv22.setVisibility(View.GONE);
        tv23.setVisibility(View.GONE);
        tv24.setVisibility(View.GONE);
        tv31.setVisibility(View.GONE);
        tv32.setVisibility(View.GONE);
        tv33.setVisibility(View.GONE);
        tv34.setVisibility(View.GONE);
    }

    private void data1Gone()
    {
        tv21.setVisibility(View.GONE);
        tv22.setVisibility(View.GONE);
        tv23.setVisibility(View.GONE);
        tv24.setVisibility(View.GONE);
        tv31.setVisibility(View.GONE);
        tv32.setVisibility(View.GONE);
        tv33.setVisibility(View.GONE);
        tv34.setVisibility(View.GONE);
    }

    private void data2Gone()
    {
        tv31.setVisibility(View.GONE);
        tv32.setVisibility(View.GONE);
        tv33.setVisibility(View.GONE);
        tv34.setVisibility(View.GONE);
    }

    private void data1Set(BoughtPojo[] boughtPojoList)
    {
        tv11.setText(boughtPojoList[0].getDatetime());
        tv12.setText(boughtPojoList[0].getIsBought() == 1 ? "是" : "否");
        tv13.setText(boughtPojoList[0].getBoughtMoney());
        tv14.setText(boughtPojoList[0].getBoughtList());
    }

    private void data2Set(BoughtPojo[] boughtPojoList)
    {
        tv21.setText(boughtPojoList[1].getDatetime());
        tv22.setText(boughtPojoList[1].getIsBought() == 1 ? "是" : "否");
        tv23.setText(boughtPojoList[1].getBoughtMoney());
        tv24.setText(boughtPojoList[1].getBoughtList());
    }

    private void data3Set(BoughtPojo[] boughtPojoList)
    {
        tv31.setText(boughtPojoList[2].getDatetime());
        tv32.setText(boughtPojoList[2].getIsBought() == 1 ? "是" : "否");
        tv33.setText(boughtPojoList[2].getBoughtMoney());
        tv34.setText(boughtPojoList[2].getBoughtList());
    }
}
