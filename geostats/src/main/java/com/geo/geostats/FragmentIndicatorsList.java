package com.geo.geostats;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FragmentIndicatorsList extends ListFragment {
	   OnHeadlineSelectedListener onHeadlineSelectedListener;

	   // The container Activity must implement this interface so the frag can
	   // deliver messages
	   public interface OnHeadlineSelectedListener {
	      /** Called by HeadlinesFragment when a list item is selected */
	      public void onArticleSelected(int position);
	   }

	   @Override public void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      
	      Bundle bag = getActivity().getIntent().getExtras();
	      
	      // We need to use a different list item layout for devices older than
	      // Honeycomb
	      int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
	            R.layout.my_simple_list_item_activated_1 : R.layout.my_simple_list_item_1;
	      
	      if(bag.getString("GEO").equals("G1")){
	    	
	    	// called when Physical geography is chosen
	    	String[] alist = new String[12];
			alist[0] = getString(R.string.HighestMountains);
			alist[1] = getString(R.string.LargestIslands);
			alist[2] = getString(R.string.LargestPeninsulas);
			alist[3] = getString(R.string.LongestRivers);
			alist[4] = getString(R.string.LargestLakes);
			alist[5] = getString(R.string.DeepestLakes);
			alist[6] = getString(R.string.LargestSeas);
			alist[7] = getString(R.string.MajorOceanicTrenches);
			alist[8] = getString(R.string.DeadliestEarthquakes);
			alist[9] = getString(R.string.LargestEarthquakes);
			alist[10] = getString(R.string.MajorVolcanicEruptions);
			alist[11] = getString(R.string.WeatherExtremes);

            setListAdapter(new ArrayAdapter<String>(getActivity(), layout, alist));
			
	      }else if(bag.getString("GEO").equals("G2")){
	    	
	    	// called when Political and Urban geography is chosen
	    	String[] alist = new String[5];
			alist[0] = getString(R.string.LargestCountries);
			alist[1] = getString(R.string.MostPopulatedCountries);
			alist[2] = getString(R.string.CountriesByPopulationDensity);
			alist[3] = getString(R.string.LargestCities);
			alist[4] = getString(R.string.LargestUrbanAreas);

			setListAdapter(new ArrayAdapter<String>(getActivity(), layout, alist));
			
	      }else if(bag.getString("GEO").equals("G3")){
	    	  
	    	// called when Economic geography is chosen
	    	String[] alist = new String[28];
			alist[0] = getString(R.string.CoalProduction);
			alist[1] = getString(R.string.OilProduction);
			alist[2] = getString(R.string.NaturalGasProduction);
			alist[3] = getString(R.string.ElectricityProduction);
			alist[4] = getString(R.string.SteelProduction);
			alist[5] = getString(R.string.MotorVehicleProduction);
			alist[6] = getString(R.string.WheatProduction);
			alist[7] = getString(R.string.RiceProduction);
			alist[8] = getString(R.string.MeatProduction);
			alist[9] = getString(R.string.BeefBuffaloProduction);
			alist[10] = getString(R.string.PigProduction);
			alist[11] = getString(R.string.SheepGoatProduction);
			alist[12] = getString(R.string.MilkProduction);
			alist[13] = getString(R.string.FishProduction);
			alist[14] = getString(R.string.RoundwoodProduction);
			alist[15] = getString(R.string.GNI);
			alist[16] = getString(R.string.GoldProduction);
			alist[17] = getString(R.string.SilverProduction);
			alist[18] = getString(R.string.DiamondProduction);
			alist[19] = getString(R.string.IronOreProduction);
			alist[20] = getString(R.string.AluminiumProduction);
			alist[21] = getString(R.string.CopperProduction);
			alist[22] = getString(R.string.SaltProduction);
			alist[23] = getString(R.string.MercuryProduction);
			alist[24] = getString(R.string.NickelProduction);
			alist[25] = getString(R.string.ZincProduction);
			alist[26] = getString(R.string.UraniumProduction);
			alist[27] = getString(R.string.KaolinProduction);

			setListAdapter(new ArrayAdapter<String>(getActivity(), layout, alist));
			
	      }else{
	    	
	    	// called when Indicators is chosen, this is a default call, all indicators are called
			String[] alist = new String[45];
			alist[0] = getString(R.string.LargestCountries);
			alist[1] = getString(R.string.MostPopulatedCountries);
			alist[2] = getString(R.string.CountriesByPopulationDensity);
			alist[3] = getString(R.string.LargestCities);
			alist[4] = getString(R.string.LargestUrbanAreas);
			alist[5] = getString(R.string.HighestMountains);
			alist[6] = getString(R.string.LargestIslands);
			alist[7] = getString(R.string.LargestPeninsulas);
			alist[8] = getString(R.string.LongestRivers);
			alist[9] = getString(R.string.LargestLakes);
			alist[10] = getString(R.string.DeepestLakes);
			alist[11] = getString(R.string.LargestSeas);
			alist[12] = getString(R.string.MajorOceanicTrenches);
			alist[13] = getString(R.string.DeadliestEarthquakes);
			alist[14] = getString(R.string.LargestEarthquakes);
			alist[15] = getString(R.string.MajorVolcanicEruptions);
			alist[16] = getString(R.string.WeatherExtremes);
			alist[17] = getString(R.string.CoalProduction);
			alist[18] = getString(R.string.OilProduction);
			alist[19] = getString(R.string.NaturalGasProduction);
			alist[20] = getString(R.string.ElectricityProduction);
			alist[21] = getString(R.string.SteelProduction);
			alist[22] = getString(R.string.MotorVehicleProduction);
			alist[23] = getString(R.string.WheatProduction);
			alist[24] = getString(R.string.RiceProduction);
			alist[25] = getString(R.string.MeatProduction);
			alist[26] = getString(R.string.BeefBuffaloProduction);
			alist[27] = getString(R.string.PigProduction);
			alist[28] = getString(R.string.SheepGoatProduction);
			alist[29] = getString(R.string.MilkProduction);
			alist[30] = getString(R.string.FishProduction);
			alist[31] = getString(R.string.RoundwoodProduction);
			alist[32] = getString(R.string.GNI);
			alist[33] = getString(R.string.GoldProduction);
			alist[34] = getString(R.string.SilverProduction);
			alist[35] = getString(R.string.DiamondProduction);
			alist[36] = getString(R.string.IronOreProduction);
			alist[37] = getString(R.string.AluminiumProduction);
			alist[38] = getString(R.string.CopperProduction);
			alist[39] = getString(R.string.SaltProduction);
			alist[40] = getString(R.string.MercuryProduction);
			alist[41] = getString(R.string.NickelProduction);
			alist[42] = getString(R.string.ZincProduction);
			alist[43] = getString(R.string.UraniumProduction);
			alist[44] = getString(R.string.KaolinProduction);

			setListAdapter(new ArrayAdapter<String>(getActivity(), layout, alist));

	      }
	   }

	   @Override public void onStart() {
		      super.onStart();

		      // When in two-pane layout, set the listview to highlight the selected
		      // list item
		      // (We do this during onStart because at the point the listview is
		      // available.)
		      if (getFragmentManager().findFragmentById(R.id.fRecord) != null) {
		         getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		      }
		   }

		   @Override public void onListItemClick(ListView l, View v, int position, long id) {
		      // Notify the listener of selected item
		      onHeadlineSelectedListener.onArticleSelected(position);

		      // Set the item as checked to be highlighted when in two-pane layout
               getListView().setItemChecked(position, true);
		   }

		   @Override public void onAttach(Activity activity) {
		      super.onAttach(activity);

		      // This makes sure that the container activity has implemented
		      // the callback interface. If not, it throws an exception.
		      try {
		         onHeadlineSelectedListener = (OnHeadlineSelectedListener) activity;
		      } catch (ClassCastException e) {
		         throw new ClassCastException(activity.toString()
		               + " must implement OnHeadlineSelectedListener");
		      }
		   }

		}