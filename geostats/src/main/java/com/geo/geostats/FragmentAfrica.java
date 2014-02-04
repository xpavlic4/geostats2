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
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.geo.viewpagerindicator.TabPageIndicator;

import java.util.Locale;

public class FragmentAfrica extends Fragment{
	
	ViewPager vp;
	private vpAdapter miAdapter;
	TextView tvChart, tvTitle;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

		View v = inflater.inflate(R.layout.fragment_continent, container, false);
		
		vp = (ViewPager) v.findViewById(R.id.viewpager);
        miAdapter = new vpAdapter();
        vp.setAdapter(miAdapter);

        TabPageIndicator indicator = (TabPageIndicator)v.findViewById(R.id.indicator);
        indicator.setViewPager(vp);

        Button btD10O = (Button) v.findViewById(R.id.btDialog10);
        btD10O.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                final Dialog d = new Dialog(FragmentAfrica.this.getActivity(), R.style.DialogContinents);
                d.setCancelable(true);
                d.setContentView(R.layout.dialog_africa);
                d.setCanceledOnTouchOutside(true);
                tvChart = (TextView)d.findViewById(R.id.chartNo);
                tvChart.append(" 26");
                Button btClose = (Button) d.findViewById(R.id.btClose);
                btClose.setOnClickListener(new OnClickListener() {
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
			return 8;
		}
		
		public CharSequence getPageTitle(int position) {
            return Constants.CONTENT[position % Constants.CONTENT.length].toUpperCase(Locale.getDefault());
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
				v = inflater.inflate(R.layout.vp_africa_countries, null);

                Button btD6O = (Button) v.findViewById(R.id.btDialog);

                if(btD6O != null){
                    btD6O.setOnClickListener(new OnClickListener() {
                        public void onClick(View v) {
                            final Dialog d = new Dialog(FragmentAfrica.this.getActivity(), R.style.DialogContinents);
                            d.setCancelable(true);
                            d.setContentView(R.layout.dialog_africa_countries);
                            d.setCanceledOnTouchOutside(true);
                            tvChart = (TextView)d.findViewById(R.id.chartNo);
                            tvChart.append(" 27");
                            Button btClose = (Button) d.findViewById(R.id.btClose);
                            btClose.setOnClickListener(new OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    d.cancel();
                                }
                            });
                            d.show();
                        }
                    });
                }else{

                }

				break;
			case 1:
				v = inflater.inflate(R.layout.vp_africa_population, null);
				
				Button btD1O = (Button) v.findViewById(R.id.btDialog1);
				
				if(btD1O != null){
					btD1O.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							final Dialog d = new Dialog(FragmentAfrica.this.getActivity(), R.style.DialogContinents);
							d.setCancelable(true);
							d.setContentView(R.layout.dialog_africa_population);
							d.setCanceledOnTouchOutside(true);
							tvChart = (TextView)d.findViewById(R.id.chartNo);
							tvChart.append(" 28 - 2010");
							Button btClose = (Button) d.findViewById(R.id.btClose);
							btClose.setOnClickListener(new OnClickListener() {
								@Override
								public void onClick(View v) {
									d.cancel();
								}
							});
							d.show();
						}
					});
				}else{
					
				}
				break;
			case 2:
				v = inflater.inflate(R.layout.vp_africa_cities, null);
				
				Button btD2O = (Button) v.findViewById(R.id.btDialog2);
				Button btD3O = (Button) v.findViewById(R.id.btDialog3);
				Button btD4O = (Button) v.findViewById(R.id.btDialog4);
				
				if(btD2O != null){
					btD2O.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							final Dialog d = new Dialog(FragmentAfrica.this.getActivity(), R.style.DialogContinents);
							d.setCancelable(true);
							d.setContentView(R.layout.dialog_africa_cities);
							d.setCanceledOnTouchOutside(true);
							tvTitle = (TextView)d.findViewById(R.id.dTitle);
							tvTitle.append("\n" + getString(R.string.LargestCitiesAd1));
							tvChart = (TextView)d.findViewById(R.id.chartNo);
							tvChart.append(" 29");
							Button btClose = (Button) d.findViewById(R.id.btClose);
							btClose.setOnClickListener(new OnClickListener() {
								@Override
								public void onClick(View v) {
									d.cancel();
								}
							});
							d.show();
						}
					});	
				}else{
					
				}
				
				if(btD3O != null){
					btD3O.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							final Dialog d = new Dialog(FragmentAfrica.this.getActivity(), R.style.DialogContinents);
							d.setCancelable(true);
							d.setContentView(R.layout.dialog_africa_urban_areas);
							d.setCanceledOnTouchOutside(true);
							tvChart = (TextView)d.findViewById(R.id.chartNo);
							tvChart.append(" 30 - 2013");
							Button btClose = (Button) d.findViewById(R.id.btClose);
							btClose.setOnClickListener(new OnClickListener() {
								@Override
								public void onClick(View v) {
									d.cancel();
								}
							});
							d.show();
						}
					});
				}else{
					
				}
				
				if(btD4O != null){
					btD4O.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							final Dialog d = new Dialog(FragmentAfrica.this.getActivity(), R.style.DialogContinents);
							d.setCancelable(true);
							d.setContentView(R.layout.dialog_africa_capitals);
							d.setCanceledOnTouchOutside(true);
							tvChart = (TextView)d.findViewById(R.id.chartNo);
							tvChart.append(" 31");
							Button btClose = (Button) d.findViewById(R.id.btClose);
							btClose.setOnClickListener(new OnClickListener() {
								@Override
								public void onClick(View v) {
									d.cancel();
								}
							});
							d.show();
						}
					});
				}else{
					
				}
				
				break;
			case 3:
				v = inflater.inflate(R.layout.vp_africa_mountains, null);

                Button btD5O = (Button) v.findViewById(R.id.btDialog1);

                if(btD5O != null){
                    btD5O.setOnClickListener(new OnClickListener() {
                        public void onClick(View v) {
                            final Dialog d = new Dialog(FragmentAfrica.this.getActivity(), R.style.DialogContinents);
                            d.setCancelable(true);
                            d.setContentView(R.layout.dialog_africa_mountains);
                            d.setCanceledOnTouchOutside(true);
                            tvChart = (TextView)d.findViewById(R.id.chartNo);
                            tvChart.append(" 32");
                            Button btClose = (Button) d.findViewById(R.id.btClose);
                            btClose.setOnClickListener(new OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    d.cancel();
                                }
                            });
                            d.show();
                        }
                    });
                }else{

                }

				break;
			case 4:
				v = inflater.inflate(R.layout.vp_africa_islands, null);
				tvChart = (TextView)v.findViewById(R.id.chartNo);
				tvChart.append(" 33");
				break;
			case 5:
				v = inflater.inflate(R.layout.vp_africa_rivers, null);
				tvChart = (TextView)v.findViewById(R.id.chartNo);
				tvChart.append(" 34");
				break;
			case 6:
				v = inflater.inflate(R.layout.vp_africa_lakes, null);
				tvChart = (TextView)v.findViewById(R.id.chartNo);
				tvChart.append(" 35");
				break;
			case 7:
				v = inflater.inflate(R.layout.vp_africa_weather, null);
				tvChart = (TextView)v.findViewById(R.id.chartNo);
				tvChart.append(" 36");
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

