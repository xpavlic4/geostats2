package com.geo.geostats;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.core.app.NavUtils;
import androidx.appcompat.app.ActionBar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.geo.geostats.FragmentIndicatorsList.OnHeadlineSelectedListener;

public class TopicsFragmentManager extends GeostatsActivity implements OnHeadlineSelectedListener {
	IndicatorsAbstractNewsView indicatorsAbstractNewsView;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.topics_fragment_manager);
		
		indicatorsAbstractNewsView = new IndicatorsAbstractNewsViewProvider(this).get();
	    indicatorsAbstractNewsView.onCreate(savedInstanceState);
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        
        ActionBar actionbar = getSupportActionBar();
        
        Bundle bag = getIntent().getExtras();
        
        if(bag.getString("GEO").equals("G1")){
        	actionbar.setTitle(getString(R.string.PhysicalGeography));
        }else if(bag.getString("GEO").equals("G2")){
        	actionbar.setTitle(getString(R.string.PoliticalUrbanGeography));
        }else if(bag.getString("GEO").equals("G3")){
        	actionbar.setTitle(getString(R.string.EconomicGeography));
        }
        
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
				NavUtils.navigateUpFromSameTask(this);
			}
            return true;
        case R.id.iRefs:
            Intent b = new Intent("com.geo.geostats.INFO_REFERENCES");
            b.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(b);
            break;
		}	
		
		return true;
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_references, menu);
        return true;
    }
	
}
