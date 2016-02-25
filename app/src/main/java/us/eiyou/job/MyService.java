package us.eiyou.job;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Vibrator;
import android.util.Log;

public class MyService extends Service {
    Handler handler;
    String s="";
    Vibrator vibrator;
    MyThread myThread=new MyThread();
    Thread thread=new Thread(myThread);
    public MyService() {
    }



    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("onCreate", "MyService");
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                return false;
            }
        });
        thread.start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    public class MyThread implements Runnable {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            while (true) {
                try {
                    if(s.equals(Utils.getContext("http://task.zbj.com/t-ydyykf/m3w2s5o7.html"))){
                        s=Utils.getContext("http://task.zbj.com/t-ydyykf/m3w2s5o7.html");
                    }else {
                        s=Utils.getContext("http://task.zbj.com/t-ydyykf/m3w2s5o7.html");
                        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                        long[] pattern = {777, 777, 777, 777}; // OFF/ON/OFF/ON...
                        vibrator.vibrate(pattern, -1);
                        new NewMessageNotification().notify(getApplicationContext(), s, 1);
                        if(s.contains("套")||s.contains("封装")){
                            long[] pattern2 = {1777, 1777, 1777, 1777}; // OFF/ON/OFF/ON...
                            vibrator.vibrate(pattern2, -1);
                        }
                    }
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
