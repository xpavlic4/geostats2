package com.geo.geostats;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;


public class IndicatorsSinglePaneNewsView implements IndicatorsAbstractNewsView {

	   private final FragmentActivity fragmentActivity;

	   public IndicatorsSinglePaneNewsView(FragmentActivity fragmentActivity) {
	      this.fragmentActivity = fragmentActivity;
	   }

	   @Override public void onCreate(Bundle savedInstanceState) {
	      // However, if we're being restored from a previous state,
	      // then we don't need to do anything and should return or else
	      // we could end up with overlapping fragments.
	      if (savedInstanceState != null) {
	         return;
	      }

	      // Create an instance of ExampleFragment
	      FragmentIndicatorsList firstFragment = new FragmentIndicatorsList();

	      // In case this activity was started with special instructions from an
	      // Intent,
	      // pass the Intent's extras to the fragment as arguments
	      firstFragment.setArguments(fragmentActivity.getIntent().getExtras());

	      // Add the fragment to the 'fragment_container' FrameLayout
	      fragmentActivity.getSupportFragmentManager().beginTransaction()
	            .add(R.id.fragment_container, firstFragment).commit();
	   }

	   @Override public void onArticleSelected(int position) {
	      // If the frag is not available, we're in the one-pane layout and must
	      // swap frags...

	      // Create fragment and give it an argument for the selected article
	      FragmentIndicatorsRecords newFragment = new FragmentIndicatorsRecords();
	      Bundle args = new Bundle();
	      args.putInt(FragmentIndicatorsRecords.ARG_POSITION, position);
	      newFragment.setArguments(args);
	      FragmentTransaction transaction =
	            fragmentActivity.getSupportFragmentManager().beginTransaction();

	      // Replace whatever is in the fragment_container view with this fragment,
	      // and add the transaction to the back stack so the user can navigate back
	      transaction.replace(R.id.fragment_container, newFragment);
	      transaction.addToBackStack(null);

	      // Commit the transaction
	      transaction.commit();
	   }

	}
