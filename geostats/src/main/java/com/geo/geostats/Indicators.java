package com.geo.geostats;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

import com.geo.geostats.FragmentIndicatorsList.OnHeadlineSelectedListener;

public class Indicators extends GeostatsActivity implements OnHeadlineSelectedListener {
	IndicatorsAbstractNewsView indicatorsAbstractNewsView;
	
	@Override public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.indicators);
	      indicatorsAbstractNewsView = new IndicatorsAbstractNewsViewProvider(this).get();
	      indicatorsAbstractNewsView.onCreate(savedInstanceState);
	      
	      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	      getSupportActionBar().setHomeButtonEnabled(true);
	        
	      ActionBar actionbar = getSupportActionBar();
	      actionbar.setTitle(getString(R.string.Indicators));
	      actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
	      
	   }

	   @Override public void onArticleSelected(int position) {
		   indicatorsAbstractNewsView.onArticleSelected(position);
	   }

	   @Override
		public boolean onOptionsItemSelected(MenuItem item){
			super.onOptionsItemSelected(item);
			
			switch(item.getItemId()){
			case android.R.id.home:
				FragmentManager fm= getSupportFragmentManager();
				 if(fm.getBackStackEntryCount()>0){
				   fm.popBackStack();
				}else{
					NavUtils.navigateUpFromSameTask(Indicators.this);
				}
		        return true;
			}	

			return true;
		}
	}
