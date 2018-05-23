package com.geo.geostats;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.imagezoom.ImageAttacher;
import com.imagezoom.ImageAttacher.OnMatrixChangedListener;
import com.imagezoom.ImageAttacher.OnPhotoTapListener;
import com.squareup.picasso.Picasso;
import com.viewpagerindicator.TabPageIndicator;

import java.util.Locale;

public class FragmentEurope extends Fragment {

	ViewPager vp;
	private vpAdapter miAdapter;
	TextView tvTitle;
    ImageView ivMap, ivMapBasic;
	//public final int limit = 0;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

		View v = inflater.inflate(R.layout.fragment_continent, container, false);
		
		vp = (ViewPager) v.findViewById(R.id.viewpager);
        miAdapter = new vpAdapter();
        vp.setAdapter(miAdapter);

		
        //vp.setCurrentItem(2); skip to a particular tab
        //vp.setOffscreenPageLimit(limit);
		
        TabPageIndicator indicator = (TabPageIndicator)v.findViewById(R.id.indicator);
        indicator.setViewPager(vp);
        //indicator.setCurrentItem(2); skip to a particular tab

        Button btD10O = (Button) v.findViewById(R.id.btDialog10);
        Button btD11O = (Button) v.findViewById(R.id.btDialog11);
        btD10O.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                final Dialog d = new Dialog(FragmentEurope.this.getActivity(), R.style.DialogContinents);
                d.setCancelable(true);
                d.setContentView(R.layout.dialog_europe);
                d.setCanceledOnTouchOutside(true);
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
        btD11O.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                final Dialog d1 = new Dialog(FragmentEurope.this.getActivity(), R.style.DialogContinents);
                d1.setCancelable(true);
                d1.setContentView(R.layout.dialog_europe_maps);
                d1.setCanceledOnTouchOutside(true);

                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(d1.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.MATCH_PARENT;
                Button btClose = (Button) d1.findViewById(R.id.btClose);
                ivMap = (ImageView)d1.findViewById(R.id.ivMap);
                Picasso.with(FragmentEurope.this.getActivity().getApplicationContext()).load(R.drawable.map_europe_physical).resize(1169, 1500).into(ivMap);

                btClose.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        d1.cancel();
                    }
                });

                usingSimpleImage(ivMap);
                d1.show();
                d1.getWindow().setAttributes(lp);
            }
        });

        Display disp = FragmentEurope.this.getActivity().getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        disp.getMetrics(metrics);
        ImageView ivMapBasic = (ImageView) v.findViewById(R.id.ivMapBasic);
        ivMapBasic.setVisibility(View.INVISIBLE);

        //Log.e("com.geo.geostats:Width", Integer.toString(metrics.widthPixels));
        //Log.e("com.geo.geostats:Height", Integer.toString(metrics.heightPixels));

        if((metrics.widthPixels >= 600 && metrics.heightPixels >= 1000) || FragmentEurope.this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            ivMapBasic.setVisibility(View.VISIBLE);
            Picasso.with(FragmentEurope.this.getActivity().getApplicationContext()).load(R.drawable.map_europe_basic).into(ivMapBasic);
            ivMapBasic.setContentDescription(getString(R.string.Europe));
        } else {

        }

      return v;

	}

    public void usingSimpleImage(ImageView imageView) {
        ImageAttacher mAttacher = new ImageAttacher(imageView);
        ImageAttacher.MAX_ZOOM = 3.5f; // Double the current Size
        ImageAttacher.MIN_ZOOM = 0.8f; // Half the current Size
        MatrixChangeListener mMaListener = new MatrixChangeListener();
        mAttacher.setOnMatrixChangeListener(mMaListener);
        PhotoTapListener mPhotoTap = new PhotoTapListener();
        mAttacher.setOnPhotoTapListener(mPhotoTap);
    }

    private class PhotoTapListener implements OnPhotoTapListener {

        @Override
        public void onPhotoTap(View view, float x, float y) {
        }
    }

    private class MatrixChangeListener implements OnMatrixChangedListener {

        @Override
        public void onMatrixChanged(RectF rect) {

        }
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
				v = inflater.inflate(R.layout.vp_europe_countries, null);
							
				Button btD1O = (Button) v.findViewById(R.id.btDialog);
				Button btD2O = (Button) v.findViewById(R.id.btDialog2);

				if(btD1O != null){
					btD1O.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							
							// OK version with AlertDialog 
							/*AlertDialog.Builder d = new AlertDialog.Builder(FragmentEurope.this.getActivity());
							LayoutInflater inflater = FragmentEurope.this.getActivity().getLayoutInflater();
							d.setView(inflater.inflate(R.layout.dialog_europe_countries, null))
							.setIcon(R.drawable.navigation_cancel)
							.setMessage(R.string.MostPopulatedCountries)
								.setPositiveButton(getString(R.string.Close), new DialogInterface.OnClickListener() {
									
									@Override
									public void onClick(DialogInterface dialog, int id) {
										// TODO Auto-generated method stub
										
									}
								}).create();
							d.show();*/
													
							final Dialog d = new Dialog(FragmentEurope.this.getActivity(), R.style.DialogContinents);
							d.setCancelable(true);
							d.setContentView(R.layout.dialog_europe_countries);
							d.setCanceledOnTouchOutside(true);
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
				if(btD2O != null){
					btD2O.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							final Dialog d = new Dialog(FragmentEurope.this.getActivity(), R.style.DialogContinents);
							d.setCancelable(true);
							d.setContentView(R.layout.dialog_europe_eu_countries);
							d.setCanceledOnTouchOutside(true);

							//tvChart2 is for testing purpose, there is a button instead of textview, changed also in dialog_europe_eu_countries.xml
							/*tvChart2 = (Button)d.findViewById(R.id.chartNo);
							tvChart2.append(" 3");
							tvChart2.setOnClickListener(new OnClickListener() {
								
								@Override
								public void onClick(View v) {
									Intent b = new Intent("com.geo.geostats.INFO_REFERENCES");
									startActivity(b);
									
								}
							});*/
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
				v = inflater.inflate(R.layout.vp_europe_population, null);
				Button btD3O = (Button) v.findViewById(R.id.btDialog3);
				Button btD4O = (Button) v.findViewById(R.id.btDialog4);
				
				if(btD3O != null){
					btD3O.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							final Dialog d = new Dialog(FragmentEurope.this.getActivity(), R.style.DialogContinents);
							d.setCancelable(true);
							d.setContentView(R.layout.dialog_europe_population);
							d.setCanceledOnTouchOutside(true);
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
							final Dialog d = new Dialog(FragmentEurope.this.getActivity(), R.style.DialogContinents);
							d.setCancelable(true);
							d.setContentView(R.layout.dialog_europe_eu_population);
							d.setCanceledOnTouchOutside(true);
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
				v = inflater.inflate(R.layout.vp_europe_cities, null);
				
				Button btD5O = (Button) v.findViewById(R.id.btDialog5);
				Button btD6O = (Button) v.findViewById(R.id.btDialog6);
				Button btD9O = (Button) v.findViewById(R.id.btDialog9);
				
				if(btD5O != null){
					btD5O.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							final Dialog d = new Dialog(FragmentEurope.this.getActivity(), R.style.DialogContinents);
							d.setCancelable(true);
							d.setContentView(R.layout.dialog_europe_cities);
							d.setCanceledOnTouchOutside(true);
							tvTitle = (TextView)d.findViewById(R.id.dTitle);
							tvTitle.append("\n" + getString(R.string.LargestCitiesAd1));
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
				
				if(btD6O != null){
					btD6O.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							final Dialog d = new Dialog(FragmentEurope.this.getActivity(), R.style.DialogContinents);
							d.setCancelable(true);
							d.setContentView(R.layout.dialog_europe_urban_areas);
							d.setCanceledOnTouchOutside(true);
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
				
				if(btD9O != null){
					btD9O.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							final Dialog d = new Dialog(FragmentEurope.this.getActivity(), R.style.DialogContinents);
							d.setCancelable(true);
							d.setContentView(R.layout.dialog_europe_capitals);
							d.setCanceledOnTouchOutside(true);
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
				v = inflater.inflate(R.layout.vp_europe_mountains, null);
				
				Button btD7O = (Button) v.findViewById(R.id.btDialog7);
				Button btD8O = (Button) v.findViewById(R.id.btDialog8);
				
				if(btD7O != null){
					btD7O.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							final Dialog d = new Dialog(FragmentEurope.this.getActivity(), R.style.DialogContinents);
							d.setCancelable(true);
							d.setContentView(R.layout.dialog_europe_mountains_kmd);
							d.setCanceledOnTouchOutside(true);
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
				
				if(btD8O != null){
				btD8O.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						final Dialog d = new Dialog(FragmentEurope.this.getActivity(), R.style.DialogContinents);
						d.setCancelable(true);
						d.setContentView(R.layout.dialog_europe_mountains_cc);
						d.setCanceledOnTouchOutside(true);
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
				v = inflater.inflate(R.layout.vp_europe_islands, null);
				break;
			case 5:
				v = inflater.inflate(R.layout.vp_europe_rivers, null);
				break;
			case 6:
				v = inflater.inflate(R.layout.vp_europe_lakes, null);
				break;
			case 7:
				v = inflater.inflate(R.layout.vp_europe_weather, null);
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

