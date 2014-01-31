package com.geo.geostats;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Branches extends ActionBarActivity implements View.OnClickListener{

	Button btB1, btB2, btB3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.branches);
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        
        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle(getString(R.string.Branches));
        
        btB1 = (Button)findViewById(R.id.btPhyG);
        btB2 = (Button)findViewById(R.id.btPolUrbG);
        btB3 = (Button)findViewById(R.id.btEconG);
        btB1.setOnClickListener(this);
        btB2.setOnClickListener(this);
        btB3.setOnClickListener(this);
                
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		getMenuInflater().inflate(R.menu.menu_indicators, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		super.onOptionsItemSelected(item);
		switch(item.getItemId()){
		case R.id.menu_indicators:
			
			Intent i = new Intent("com.geo.geostats.INDICATORS");
			
			String name0 = "G0";
			Bundle bag = new Bundle();
			bag.putString("GEO", name0);
			i.putExtras(bag);
			
			startActivity(i);
			break;
			
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
	        return true;
		}	
		
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String name1 = "G1";
		String name2 = "G2";
		String name3 = "G3";
		Bundle bag = new Bundle();
		switch(v.getId()){
			case R.id.btPhyG:
				Intent i = new Intent("com.geo.geostats.BRANCHES_FM");
				
    			bag.putString("GEO", name1);
    			i.putExtras(bag);
    			
				startActivity(i);
			break;
			
			case R.id.btPolUrbG:
				Intent i2 = new Intent("com.geo.geostats.BRANCHES_FM");

    			bag.putString("GEO", name2);
    			i2.putExtras(bag);
    			
				startActivity(i2);
			break;
			
			case R.id.btEconG:
				Intent i3 = new Intent("com.geo.geostats.BRANCHES_FM");

    			bag.putString("GEO", name3);
    			i3.putExtras(bag);
    			
				startActivity(i3);
			break;
		}
		
	}

}
