package com.geo.geostats;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.geo.viewpagerindicator.TabPageIndicator;

import java.util.Locale;


public class FragmentIndianO extends Fragment{
	
	ViewPager vp;
	private vpAdapter miAdapter;
	TextView tvChart;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

		View v = inflater.inflate(R.layout.fragment_ocean, container, false);
		
		vp = (ViewPager) v.findViewById(R.id.viewpager);
        miAdapter = new vpAdapter();
        vp.setAdapter(miAdapter);

        TabPageIndicator indicator = (TabPageIndicator)v.findViewById(R.id.indicator);
        indicator.setViewPager(vp);

        Button btD10O = (Button) v.findViewById(R.id.btDialog10);
        btD10O.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Dialog d = new Dialog(FragmentIndianO.this.getActivity(), R.style.DialogContinents);
                d.setCancelable(true);
                d.setContentView(R.layout.dialog_indian_o);
                d.setCanceledOnTouchOutside(true);
                tvChart = (TextView)d.findViewById(R.id.chartNo);
                tvChart.append(" 84");
                Button btClose = (Button) d.findViewById(R.id.btClose);
                btClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        d.cancel();
                    }
                });
                d.show();
            }
        });

		return v;
	}
	
	private class vpAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 4;
		}
		
		public CharSequence getPageTitle(int position) {
            return Constants.CONTENT_OCEANS[position % Constants.CONTENT_OCEANS.length].toUpperCase(Locale.getDefault());
        }

		@Override
		public boolean isViewFromObject(View view, Object object) {
			// TODO Auto-generated method stub
			return view == ((ScrollView)object);
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			((ViewPager)container).removeView((ScrollView)object);
		}

		@Override
		public void finishUpdate(ViewGroup container) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Object instantiateItem(View container, int position) {
			// TODO Auto-generated method stub
			
			LayoutInflater inflater = (LayoutInflater)container.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View v = null;
			switch(position){
			case 0:
				v = inflater.inflate(R.layout.vp_indian_o_seas, null);
				tvChart = (TextView)v.findViewById(R.id.chartNo);
				tvChart.append(" 85");
				break;
			case 1:
				v = inflater.inflate(R.layout.vp_indian_o_gulfs, null);
				tvChart = (TextView)v.findViewById(R.id.chartNo);
				tvChart.append(" 86");
				break;
			case 2:
				v = inflater.inflate(R.layout.vp_indian_o_straits, null);
				tvChart = (TextView)v.findViewById(R.id.chartNo);
				tvChart.append(" 87");
				break;
			case 3:
				v = inflater.inflate(R.layout.vp_indian_o_currents, null);
				tvChart = (TextView)v.findViewById(R.id.chartNo);
				tvChart.append(" 88");
				break;
			}
			((ViewPager)container).addView(v, 0);
			return v;
		}

		@Override
		public Parcelable saveState() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void startUpdate(ViewGroup container) {
			// TODO Auto-generated method stub
			
		}
		
	}

}

