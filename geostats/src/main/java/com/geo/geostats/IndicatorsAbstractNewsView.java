package com.geo.geostats;

import android.os.Bundle;

import com.geo.geostats.FragmentIndicatorsList.OnHeadlineSelectedListener;

interface IndicatorsAbstractNewsView extends OnHeadlineSelectedListener {
	   public void onCreate(Bundle savedInstanceState);
	   @Override public void onArticleSelected(int position);
	}
