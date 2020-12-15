package com.geo.geostats;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;

public class IndicatorsDoublePaneNewsView implements IndicatorsAbstractNewsView {

	   private final FragmentActivity fragmentActivity;

	   public IndicatorsDoublePaneNewsView(FragmentActivity fragmentActivity) {
	      this.fragmentActivity = fragmentActivity;
	   }

	   @Override public void onCreate(Bundle savedInstanceState) {
	   }

	   @Override public void onArticleSelected(int position) {
	      ((FragmentIndicatorsRecords) fragmentActivity.getSupportFragmentManager().findFragmentById(
	         R.id.fRecord)).updateArticleView(position);
	   }

	}