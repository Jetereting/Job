package us.eiyou.job;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Handler handler;
    String s;
    Switch sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
        sw=(Switch)findViewById(R.id.sw);

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                tv.setText(s);
                return false;
            }
        });
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(sw.isChecked()) {
                    new Thread(new MyThread()).start();
                    startService(new Intent(getApplicationContext(),MyService.class));
                }else{
                    Intent iService=new Intent(getApplicationContext(),MyService.class);
                    iService.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getApplicationContext().stopService(iService);
                }
            }
        });
    }

    public class MyThread implements Runnable {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            while (true) {
                try {
                    s=Utils.getContext("http://task.zbj.com/t-ydyykf/m3w2s5o7.html");
                    Thread.sleep(10000);// 线程暂停10秒，单位毫秒
                    Message message = new Message();
                    message.what = 1;
                    handler.sendMessage(message);// 发送消息
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
