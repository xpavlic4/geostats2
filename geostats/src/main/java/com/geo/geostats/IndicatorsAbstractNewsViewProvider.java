package com.geo.geostats;

import android.support.v4.app.FragmentActivity;


public class IndicatorsAbstractNewsViewProvider {
	   private final FragmentActivity fragmentActivity;
	   public IndicatorsAbstractNewsViewProvider(FragmentActivity activity) {
	      this.fragmentActivity = activity;
	   }
	   public IndicatorsAbstractNewsView get() {
	      if (fragmentActivity.findViewById(R.id.fragment_container) != null) {
	           return new IndicatorsSinglePaneNewsView(fragmentActivity);
	        } else {
	           return new IndicatorsDoublePaneNewsView(fragmentActivity);
	        }
	   }
	}
