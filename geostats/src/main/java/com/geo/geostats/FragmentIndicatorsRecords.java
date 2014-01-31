package com.geo.geostats;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FragmentIndicatorsRecords extends Fragment {
	
	Context context;
    final static String ARG_POSITION = "position";
    TextView tvChart;
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
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 100");
				article.addView(vv);
			}else if(position == 1){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_islands, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 101");
				article.addView(vv);
			}else if(position == 2){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_peninsulas, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 101");
				article.addView(vv);
			}else if(position == 3){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_longest_rivers, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 103");
				article.addView(vv);
			}else if(position == 4){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_lakes, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 104");
				article.addView(vv);
			}else if(position == 5){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_deepest_lakes, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 105");
				article.addView(vv);
			}else if(position == 6){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_seas, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 106");
				article.addView(vv);
			}else if(position == 7){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_major_oceanic_trenches, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 107");
				article.addView(vv);
			}else if(position == 8){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_deadliest_earthquakes, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 108");
				article.addView(vv);
			}else if(position == 9){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_earthquakes, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 109");
				article.addView(vv);
			}else if(position == 10){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_major_volcanic_eruptions, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 110");
				article.addView(vv);
			}else if(position == 11){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_weather_extremes, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 111");
				article.addView(vv);
			}
			mCurrentPosition = position;
			
		}else if(bag.getString("GEO").equals("G2")){
	    	// called when Political and Urban geography is chosen
			if (position == 0) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_countries, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 95");
				article.addView(vv);
			}else if(position == 1){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_most_populated_countries, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 96 - 2010");
				article.addView(vv);
			}else if(position == 2){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_countries_by_population_density, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 97 - 2010");
				article.addView(vv);
			}else if(position == 3){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_cities, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 98");
				article.addView(vv);
			}else if(position == 4){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_urban_areas, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 99 - 2013");
				article.addView(vv);
			}
			mCurrentPosition = position;
				
		}else if(bag.getString("GEO").equals("G3")){
			// called when Economic geography is chosen
			if (position == 0) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_coal_mining, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 112 - 2011");
				article.addView(vv);
			}else if (position == 1) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_oil_production, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 113 - 2012");
				article.addView(vv);
			}else if (position == 2) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_natural_gas_production, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 114 - 2012");
				article.addView(vv);
			}else if (position == 3) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_electricity_production, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 115 - 2012");
				article.addView(vv);
			}else if (position == 4) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_steel_production, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 116 - 2012");
				article.addView(vv);
			}else if (position == 5) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_motor_vehicle_production, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 117 - 2012");
				article.addView(vv);
			}else if (position == 6) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_wheat_production, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 118 - 2010");
				article.addView(vv);
			}else if (position == 7) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_rice_production, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 119 - 2010");
				article.addView(vv);
			}else if (position == 8) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_meat_production, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 120 - 2010");
				article.addView(vv);
			}else if (position == 9) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_beef_cattle_production, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 121 - 2010");
				article.addView(vv);
			}else if (position == 10) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_pork_production, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 122 - 2010");
				article.addView(vv);
			}else if (position == 11) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_sheep_production, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 123 - 2010");
				article.addView(vv);
			}else if (position == 12) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_milk_production, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 124 - 2010");
				article.addView(vv);
			}else if (position == 13) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_fish_production, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 125 - 2010");
				article.addView(vv);
			}else if (position == 14) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_logging, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 126 - 2011");
				article.addView(vv);
			}else if (position == 15) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_gni, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 127 - 2011");
				article.addView(vv);
			}else if (position == 16) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_gold, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 128 - 2011");
				article.addView(vv);
			}else if (position == 17) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_silver, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 129 - 2011");
				article.addView(vv);
			}else if (position == 18) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_diamond, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 130 - 2011");
				article.addView(vv);
			}else if (position == 19) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_ironore, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 131 - 2011");
				article.addView(vv);
			}else if (position == 20) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_aluminium, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 132 - 2011");
				article.addView(vv);
			}else if (position == 21) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_copper, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 133 - 2011");
				article.addView(vv);
			}else if (position == 22) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_salt, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 134 - 2011");
				article.addView(vv);
			}else if (position == 23) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_mercury, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 135 - 2011");
				article.addView(vv);
			}else if (position == 24) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_nickel, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 136 - 2011");
				article.addView(vv);
			}else if (position == 25) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_zinc, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 137 - 2011");
				article.addView(vv);
			}else if (position == 26) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_uranium, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 138 - 2011");
				article.addView(vv);
			}else if (position == 27) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_kaolin, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 139 - 2011");
				article.addView(vv);
			}
			
			mCurrentPosition = position;
			
		}else{
	    	
	    	// called when Indicators is chosen, this is a default call, all indicators are called
			
			if (position == 0) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_countries, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 95");
				article.addView(vv);
			}else if(position == 1){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_most_populated_countries, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 96 - 2010");
				article.addView(vv);
			}else if(position == 2){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_countries_by_population_density, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 97 - 2010");
				article.addView(vv);
			}else if(position == 3){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_cities, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 98");
				article.addView(vv);
			}else if(position == 4){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_urban_areas, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 99 - 2013");
				article.addView(vv);
			}else if(position == 5){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_highest_mountains, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 100");
				article.addView(vv);
			}else if(position == 6){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_islands, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 101");
				article.addView(vv);
			}else if(position == 7){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_peninsulas, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 102");
				article.addView(vv);
			}else if(position == 8){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_longest_rivers, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 103");
				article.addView(vv);
			}else if(position == 9){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_lakes, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 104");
				article.addView(vv);
			}else if(position == 10){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_deepest_lakes, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 105");
				article.addView(vv);
			}else if(position == 11){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_seas, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 106");
				article.addView(vv);
			}else if(position == 12){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_major_oceanic_trenches, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 107");
				article.addView(vv);
			}else if(position == 13){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_deadliest_earthquakes, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 108");
				article.addView(vv);
			}else if(position == 14){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_largest_earthquakes, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 109");
				article.addView(vv);
			}else if(position == 15){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_major_volcanic_eruptions, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 110");
				article.addView(vv);
			}else if(position == 16){
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_weather_extremes, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 111");
				article.addView(vv);
			}else if (position == 17) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_coal_mining, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 112 - 2011");
				article.addView(vv);
			}else if (position == 18) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_oil_production, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 113 - 2012");
				article.addView(vv);
			}else if (position == 19) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_natural_gas_production, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 114 - 2012");
				article.addView(vv);
			}else if (position == 20) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_electricity_production, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 115 - 2012");
				article.addView(vv);
			}else if (position == 21) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_steel_production, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 116 - 2012");
				article.addView(vv);
			}else if (position == 22) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_motor_vehicle_production, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 117 - 2012");
				article.addView(vv);
			}else if (position == 23) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_wheat_production, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 118 - 2010");
				article.addView(vv);
			}else if (position == 24) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_rice_production, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 119 - 2010");
				article.addView(vv);
			}else if (position == 25) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_meat_production, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 120 - 2010");
				article.addView(vv);
			}else if (position == 26) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_beef_cattle_production, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 121 - 2010");
				article.addView(vv);
			}else if (position == 27) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_pork_production, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 122 - 2010");
				article.addView(vv);
			}else if (position == 28) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_sheep_production, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 123 - 2010");
				article.addView(vv);
			}else if (position == 29) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_milk_production, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 124 - 2010");
				article.addView(vv);
			}else if (position == 30) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_fish_production, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 125 - 2010");
				article.addView(vv);
			}else if (position == 31) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_logging, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 126 - 2011");
				article.addView(vv);
			}else if (position == 32) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_gni, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 127 - 2011");
				article.addView(vv);
			}else if (position == 33) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_gold, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 128 - 2011");
				article.addView(vv);
			}else if (position == 34) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_silver, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 129 - 2011");
				article.addView(vv);
			}else if (position == 35) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_diamond, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 130 - 2011");
				article.addView(vv);
			}else if (position == 36) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_ironore, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 131 - 2011");
				article.addView(vv);
			}else if (position == 37) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_aluminium, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 132 - 2011");
				article.addView(vv);
			}else if (position == 38) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_copper, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 133 - 2011");
				article.addView(vv);
			}else if (position == 39) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_salt, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 134 - 2011");
				article.addView(vv);
			}else if (position == 40) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_mercury, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 135 - 2011");
				article.addView(vv);
			}else if (position == 41) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_nickel, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 136 - 2011");
				article.addView(vv);
			}else if (position == 42) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_zinc, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 137 - 2011");
				article.addView(vv);
			}else if (position == 43) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_uranium, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 138 - 2011");
				article.addView(vv);
			}else if (position == 44) {
				article.removeAllViews();
				View vv = vi.inflate(R.layout.vp_world_kaolin, null);
				tvChart = (TextView)vv.findViewById(R.id.chartNo);
				tvChart.append(" 139 - 2011");
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