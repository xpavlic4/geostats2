package com.geo.geostats;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Main extends GeostatsActivity implements android.view.View.OnClickListener {

    Button btWorld, btContinents, btOceans, btTopics, btInfoRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btWorld = (Button) findViewById(R.id.btIndicators);
        btContinents = (Button) findViewById(R.id.btContinents);
        btOceans = (Button) findViewById(R.id.btOceans);
        btTopics = (Button) findViewById(R.id.btTopics);
        btInfoRef = (Button) findViewById(R.id.btInfoRef);

        btWorld.setOnClickListener(this);
        btContinents.setOnClickListener(this);
        btOceans.setOnClickListener(this);
        btTopics.setOnClickListener(this);
        btInfoRef.setOnClickListener(this);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setLogo(getResources().getDrawable(R.drawable.logo_main));
        actionbar.setDisplayShowTitleEnabled(false);


    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch(v.getId()){
            case R.id.btIndicators:
                Intent in = new Intent("com.geo.geostats.INDICATORS");

                String name0 = "G0";
                Bundle bag = new Bundle();
                bag.putString("GEO", name0);
                in.putExtras(bag);
                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(in);
                break;

            case R.id.btTopics:
                Intent b = new Intent("com.geo.geostats.TOPICS");
                b.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(b);
                break;

            case R.id.btContinents:
                Intent c = new Intent("com.geo.geostats.CONTINENTS");
                c.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(c);
                break;

            case R.id.btOceans:
                Intent o = new Intent("com.geo.geostats.OCEANS");
                o.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(o);
                break;

            case R.id.btInfoRef:
                Intent i = new Intent("com.geo.geostats.ABOUT");
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch(item.getItemId()){
            case R.id.iAbout:
                Intent a = new Intent("com.geo.geostats.ABOUT");
                a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(a);
                break;

            case R.id.iRefs:
                Intent b = new Intent("com.geo.geostats.INFO_REFERENCES");
                b.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(b);
                break;

        }
        return false;
    }





}
