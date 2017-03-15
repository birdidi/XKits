package com.cxy.android.xkits.activity;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cxy.android.xkits.R;
import com.cxy.android.xkits.ScreenUtil;
import com.cxy.android.xkits.TelephoneUtil;

/**
 * Author: xyc000
 * Description: </br>
 * Date: 2017/3/2 0002
 */
public class MainActivity extends Activity implements View.OnClickListener {

    private Button btnNetworkInfo;
    private TextView tvNetworkInfo;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNetworkInfo = (Button) findViewById(R.id.btn_network_state);
        tvNetworkInfo = (TextView) findViewById(R.id.tv_network_info);

        btnNetworkInfo.setOnClickListener(this);
    }


    /**
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_network_state:
                StringBuilder sb = new StringBuilder();
                sb.append("network enable : " + TelephoneUtil.isNetworkEnable(this) + "\n");
                sb.append("wifi enable : " + TelephoneUtil.isWifiEnable(this) + "\n");
                sb.append("mobile network enable : " + TelephoneUtil.isMobileEnable(this) + "\n");

                sb.append("\n>>>>screen info<<<<<\n");
                sb.append("screen width : " + ScreenUtil.getScreenWidth(this) + "\n");
                sb.append("screen height : " + ScreenUtil.getScreenHeight(this) + "\n");
                sb.append("screen real size : " + ScreenUtil.getRealScreenSize(this) + "\n");
                sb.append("screen density : " + ScreenUtil.getDensity(this) + "\n");

                sb.append("\n>>>>phone info<<<<\n");
                sb.append("imei : " + TelephoneUtil.getIMEI(this) + "\n");
                sb.append("imsi : " + TelephoneUtil.getIMSI(this) + "\n");

                ActivityManager.MemoryInfo memoryInfo = TelephoneUtil.getMemoryInfo(this);
                sb.append("\n>>>>memory info<<<<\n");
                sb.append("avail memory : " + memoryInfo.availMem + "\n");
                sb.append("total memory : " + memoryInfo.threshold + "\n");
                tvNetworkInfo.setText(sb.toString());
                break;
        }
    }
}
