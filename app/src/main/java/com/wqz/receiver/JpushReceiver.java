package com.wqz.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.wqz.customeranalysis.AllFacePushActivity;
import com.wqz.customeranalysis.PushActivity;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by WangQiZhi on 2017/3/30.
 */

public class JpushReceiver extends BroadcastReceiver
{
    private static final String TAG = "JpushReceiver";

    @Override
    public void onReceive(Context context, Intent intent)
    {
        if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction()))
        {
            String json = intent.getExtras().getString(JPushInterface.EXTRA_EXTRA);

            Intent i ;

            if(json.contains("vip"))
            {
                i = new Intent(context, PushActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("json",json);
                context.startActivity(i);
            }
            else if(json.contains("face"))
            {
                i = new Intent(context, AllFacePushActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("json",json);
                context.startActivity(i);
            }
        }
    }
}
