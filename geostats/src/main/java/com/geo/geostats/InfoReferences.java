package com.geo.geostats;

import android.graphics.Color;
import android.os.Bundle;
import androidx.core.app.NavUtils;
import androidx.appcompat.app.ActionBar;
import android.text.Html;
import android.text.util.Linkify;
import android.view.MenuItem;
import android.widget.TextView;

public class InfoReferences extends GeostatsActivity {

	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info_references);
		
		 getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	     getSupportActionBar().setHomeButtonEnabled(true);
	        
	     ActionBar actionbar = getSupportActionBar();
	     actionbar.setTitle(getString(R.string.References));
	     actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
	     
	     tv = (TextView) findViewById(R.id.tvInfoRefs);
	     tv.setText(Html.fromHtml(ResourceHelper.readRawTextFile(this, R.raw.references)));
         tv.setTextColor(Color.rgb(97, 97, 97));
	     tv.setLinkTextColor(Color.rgb(97, 97, 97));
	     Linkify.addLinks(tv, Linkify.ALL);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		super.onOptionsItemSelected(item);
		
		switch(item.getItemId()){
		case android.R.id.home:
            NavUtils.navigateUpFromSameTask(this);
	        return true;
		}	

		return true;
	}

	
}
