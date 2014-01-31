package com.geo.geostats;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class Intro extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

        Thread logo = new Thread(){
            public void run(){
                try{

                    int time = 0;

                    while(time<3500){
                        sleep(100);
                        time = time + 100;
                    }

                    Intent i = new Intent("com.geo.geostats.MAIN");
                    startActivity(i);

                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    finish();
                }
            }
        };

        logo.start();
    }
}
