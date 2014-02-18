package com.geo.geostats;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class FragmentIndicatorsRecords extends Fragment {
	
	Context context;
    final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
        Bundle savedInstanceState) {

        // If activity recreated (such as from screen rotate), restore
        // the previous article selection set by onSaveInstanceState().
        // This is primarily necessary when in the two-pane layout.
        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.indicators_record_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        // During startup, check if there are arguments passed to the fragment.
        // onStart is a good place to do this because the layout has already been
        // applied to the fragment at this point so we can safely call the method
        // below that sets the article text.
        Bundle args = getArguments();
        if (args != null) {
            // Set article based on argument passed in
            updateArticleView(args.getInt(ARG_POSITION));
        } else if (mCurrentPosition != -1) {
            // Set article based on saved instance state defined during onCreateView
            updateArticleView(mCurrentPosition);
        }
    }

    public void updateArticleView(int position) {
		
		context = getActivity().getApplicationContext();
		LinearLayout article = (LinearLayout) getActivity().findViewById(R.id.tvRecordDetail);
		LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		Bundle bag = getActivity().getIntent().getExtras();
		
		if(bag.getString("GEO").equals("G1")){
	    	// called when Physical geography is chosen
			if(position == 0){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_highest_mountains, null);
				article.addView(vv);
			}else if(position == 1){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_islands, null);
				article.addView(vv);
			}else if(position == 2){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_peninsulas, null);
				article.addView(vv);
			}else if(position == 3){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_longest_rivers, null);
				article.addView(vv);
			}else if(position == 4){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_lakes, null);
				article.addView(vv);
			}else if(position == 5){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_deepest_lakes, null);
				article.addView(vv);
			}else if(position == 6){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_seas, null);
				article.addView(vv);
			}else if(position == 7){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_major_oceanic_trenches, null);
				article.addView(vv);
			}else if(position == 8){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_deadliest_earthquakes, null);
				article.addView(vv);
			}else if(position == 9){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_earthquakes, null);
				article.addView(vv);
			}else if(position == 10){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_major_volcanic_eruptions, null);
				article.addView(vv);
			}else if(position == 11){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_weather_extremes, null);
				article.addView(vv);
			}
			mCurrentPosition = position;
			
		}else if(bag.getString("GEO").equals("G2")){
	    	// called when Political and Urban geography is chosen
			if (position == 0) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_countries, null);
				article.addView(vv);
			}else if(position == 1){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_most_populated_countries, null);
				article.addView(vv);
			}else if(position == 2){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_countries_by_population_density, null);
				article.addView(vv);
			}else if(position == 3){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_cities, null);
				article.addView(vv);
			}else if(position == 4){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_urban_areas, null);
				article.addView(vv);
			}
			mCurrentPosition = position;
				
		}else if(bag.getString("GEO").equals("G3")){
			// called when Economic geography is chosen
			if (position == 0) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_coal_mining, null);
				article.addView(vv);
			}else if (position == 1) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_oil_production, null);
				article.addView(vv);
			}else if (position == 2) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_natural_gas_production, null);
				article.addView(vv);
			}else if (position == 3) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_electricity_production, null);
				article.addView(vv);
			}else if (position == 4) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_steel_production, null);
				article.addView(vv);
			}else if (position == 5) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_motor_vehicle_production, null);
				article.addView(vv);
			}else if (position == 6) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_wheat_production, null);
				article.addView(vv);
			}else if (position == 7) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_rice_production, null);
				article.addView(vv);
			}else if (position == 8) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_meat_production, null);
				article.addView(vv);
			}else if (position == 9) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_beef_cattle_production, null);
				article.addView(vv);
			}else if (position == 10) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_pork_production, null);
				article.addView(vv);
			}else if (position == 11) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_sheep_production, null);
				article.addView(vv);
			}else if (position == 12) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_milk_production, null);
				article.addView(vv);
			}else if (position == 13) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_fish_production, null);
				article.addView(vv);
			}else if (position == 14) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_logging, null);
				article.addView(vv);
			}else if (position == 15) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_gni, null);
				article.addView(vv);
			}else if (position == 16) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_gold, null);
				article.addView(vv);
			}else if (position == 17) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_silver, null);
				article.addView(vv);
			}else if (position == 18) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_diamond, null);
				article.addView(vv);
			}else if (position == 19) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_ironore, null);
				article.addView(vv);
			}else if (position == 20) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_aluminium, null);
				article.addView(vv);
			}else if (position == 21) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_copper, null);
				article.addView(vv);
			}else if (position == 22) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_salt, null);
				article.addView(vv);
			}else if (position == 23) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_mercury, null);
				article.addView(vv);
			}else if (position == 24) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_nickel, null);
				article.addView(vv);
			}else if (position == 25) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_zinc, null);
				article.addView(vv);
			}else if (position == 26) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_uranium, null);
				article.addView(vv);
			}else if (position == 27) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_kaolin, null);
				article.addView(vv);
			}
			
			mCurrentPosition = position;
			
		}else{
	    	
	    	// called when Indicators is chosen, this is a default call, all indicators are called
			
			if (position == 0) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_countries, null);
				article.addView(vv);
			}else if(position == 1){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_most_populated_countries, null);
				article.addView(vv);
			}else if(position == 2){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_countries_by_population_density, null);
				article.addView(vv);
			}else if(position == 3){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_cities, null);
				article.addView(vv);
			}else if(position == 4){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_urban_areas, null);
				article.addView(vv);
			}else if(position == 5){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_highest_mountains, null);
				article.addView(vv);
			}else if(position == 6){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_islands, null);
				article.addView(vv);
			}else if(position == 7){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_peninsulas, null);
				article.addView(vv);
			}else if(position == 8){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_longest_rivers, null);
				article.addView(vv);
			}else if(position == 9){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_lakes, null);
				article.addView(vv);
			}else if(position == 10){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_deepest_lakes, null);
				article.addView(vv);
			}else if(position == 11){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_seas, null);
				article.addView(vv);
			}else if(position == 12){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_major_oceanic_trenches, null);
				article.addView(vv);
			}else if(position == 13){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_deadliest_earthquakes, null);
				article.addView(vv);
			}else if(position == 14){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_earthquakes, null);
				article.addView(vv);
			}else if(position == 15){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_major_volcanic_eruptions, null);
				article.addView(vv);
			}else if(position == 16){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_weather_extremes, null);
				article.addView(vv);
			}else if (position == 17) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_coal_mining, null);
				article.addView(vv);
			}else if (position == 18) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_oil_production, null);
				article.addView(vv);
			}else if (position == 19) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_natural_gas_production, null);
				article.addView(vv);
			}else if (position == 20) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_electricity_production, null);
				article.addView(vv);
			}else if (position == 21) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_steel_production, null);
				article.addView(vv);
			}else if (position == 22) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_motor_vehicle_production, null);
				article.addView(vv);
			}else if (position == 23) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_wheat_production, null);
				article.addView(vv);
			}else if (position == 24) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_rice_production, null);
				article.addView(vv);
			}else if (position == 25) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_meat_production, null);
				article.addView(vv);
			}else if (position == 26) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_beef_cattle_production, null);
				article.addView(vv);
			}else if (position == 27) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_pork_production, null);
				article.addView(vv);
			}else if (position == 28) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_sheep_production, null);
				article.addView(vv);
			}else if (position == 29) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_milk_production, null);
				article.addView(vv);
			}else if (position == 30) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_fish_production, null);
				article.addView(vv);
			}else if (position == 31) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_logging, null);
				article.addView(vv);
			}else if (position == 32) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_gni, null);
				article.addView(vv);
			}else if (position == 33) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_gold, null);
				article.addView(vv);
			}else if (position == 34) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_silver, null);
				article.addView(vv);
			}else if (position == 35) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_diamond, null);
				article.addView(vv);
			}else if (position == 36) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_ironore, null);
				article.addView(vv);
			}else if (position == 37) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_aluminium, null);
				article.addView(vv);
			}else if (position == 38) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_copper, null);
				article.addView(vv);
			}else if (position == 39) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_salt, null);
				article.addView(vv);
			}else if (position == 40) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_mercury, null);
				article.addView(vv);
			}else if (position == 41) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_nickel, null);
				article.addView(vv);
			}else if (position == 42) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_zinc, null);
				article.addView(vv);
			}else if (position == 43) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_uranium, null);
				article.addView(vv);
			}else if (position == 44) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_kaolin, null);
				article.addView(vv);
			}
		}

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the current article selection in case we need to recreate the fragment
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }
}