package com.geo.geostats;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.geo.viewpagerindicator.TabPageIndicator;
import com.imagezoom.ImageAttacher;

import java.util.Locale;

public class FragmentNAmerica extends Fragment{
	
	ViewPager vp;
	private vpAdapter miAdapter;
	TextView tvChart, tvTitle;
    ImageView ivMap;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

		View v = inflater.inflate(R.layout.fragment_continent, container, false);
		
		vp = (ViewPager) v.findViewById(R.id.viewpager);
        miAdapter = new vpAdapter();
        vp.setAdapter(miAdapter);

        TabPageIndicator indicator = (TabPageIndicator)v.findViewById(R.id.indicator);
        indicator.setViewPager(vp);

        Button btD10O = (Button) v.findViewById(R.id.btDialog10);
        Button btD11O = (Button) v.findViewById(R.id.btDialog11);
        btD10O.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                final Dialog d = new Dialog(FragmentNAmerica.this.getActivity(), R.style.DialogContinents);
                d.setCancelable(true);
                d.setContentView(R.layout.dialog_namerica);
                d.setCanceledOnTouchOutside(true);
                tvChart = (TextView)d.findViewById(R.id.chartNo);
                tvChart.append(" 37");
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
        btD11O.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Dialog d1 = new Dialog(FragmentNAmerica.this.getActivity(), R.style.DialogContinents);
                d1.setCancelable(true);
                d1.setContentView(R.layout.dialog_namerica_maps);
                d1.setCanceledOnTouchOutside(true);

                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(d1.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.MATCH_PARENT;

                tvChart = (TextView)d1.findViewById(R.id.imageNo);
                tvChart.append(" 4");
                Button btClose = (Button) d1.findViewById(R.id.btClose);
                Button btMap1 = (Button) d1.findViewById(R.id.btMap1);
                Button btMap2 = (Button) d1.findViewById(R.id.btMap2);
                ivMap = (ImageView)d1.findViewById(R.id.ivMap);

                btMap1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bitmap bimtBitmap = BitmapFactory.decodeResource(getResources(),
                                R.drawable.map_namerica_physical);
                        ivMap.setImageBitmap(bimtBitmap);
                    }
                });
                btMap2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Bitmap bimtBitmap = BitmapFactory.decodeResource(getResources(),
                                R.drawable.map_camerica_physical);
                        ivMap.setImageBitmap(bimtBitmap);
                    }
                });
                btClose.setOnClickListener(new View.OnClickListener() {
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

    private class PhotoTapListener implements ImageAttacher.OnPhotoTapListener {

        @Override
        public void onPhotoTap(View view, float x, float y) {
        }
    }

    private class MatrixChangeListener implements ImageAttacher.OnMatrixChangedListener {

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
				v = inflater.inflate(R.layout.vp_namerica_countries, null);

                Button btD6O = (Button) v.findViewById(R.id.btDialog);

                if(btD6O != null){
                    btD6O.setOnClickListener(new OnClickListener() {
                        public void onClick(View v) {
                            final Dialog d = new Dialog(FragmentNAmerica.this.getActivity(), R.style.DialogContinents);
                            d.setCancelable(true);
                            d.setContentView(R.layout.dialog_namerica_countries);
                            d.setCanceledOnTouchOutside(true);
                            tvChart = (TextView)d.findViewById(R.id.chartNo);
                            tvChart.append(" 38");
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
				v = inflater.inflate(R.layout.vp_namerica_population, null);
				
				Button btD1O = (Button) v.findViewById(R.id.btDialog1);
				
				if(btD1O != null){
					btD1O.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							final Dialog d = new Dialog(FragmentNAmerica.this.getActivity(), R.style.DialogContinents);
							d.setCancelable(true);
							d.setContentView(R.layout.dialog_namerica_population);
							d.setCanceledOnTouchOutside(true);
							tvChart = (TextView)d.findViewById(R.id.chartNo);
							tvChart.append(" 39 - 2010");
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
				v = inflater.inflate(R.layout.vp_namerica_cities, null);
				
				Button btD2O = (Button) v.findViewById(R.id.btDialog2);
				Button btD3O = (Button) v.findViewById(R.id.btDialog3);
				Button btD4O = (Button) v.findViewById(R.id.btDialog4);
				
				if(btD2O != null){
					btD2O.setOnClickListener(new OnClickListener() {
						public void onClick(View v) {
							final Dialog d = new Dialog(FragmentNAmerica.this.getActivity(), R.style.DialogContinents);
							d.setCancelable(true);
							d.setContentView(R.layout.dialog_namerica_cities);
							d.setCanceledOnTouchOutside(true);
							tvTitle = (TextView)d.findViewById(R.id.dTitle);
							tvTitle.append("\n" + getString(R.string.LargestCitiesAd1));
							tvChart = (TextView)d.findViewById(R.id.chartNo);
							tvChart.append(" 40");
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
							final Dialog d = new Dialog(FragmentNAmerica.this.getActivity(), R.style.DialogContinents);
							d.setCancelable(true);
							d.setContentView(R.layout.dialog_namerica_urban_areas);
							d.setCanceledOnTouchOutside(true);
							tvChart = (TextView)d.findViewById(R.id.chartNo);
							tvChart.append(" 41 - 2013");
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
							final Dialog d = new Dialog(FragmentNAmerica.this.getActivity(), R.style.DialogContinents);
							d.setCancelable(true);
							d.setContentView(R.layout.dialog_namerica_capitals);
							d.setCanceledOnTouchOutside(true);
							tvChart = (TextView)d.findViewById(R.id.chartNo);
							tvChart.append(" 42");
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
				v = inflater.inflate(R.layout.vp_namerica_mountains, null);

                Button btD5O = (Button) v.findViewById(R.id.btDialog1);

                if(btD5O != null){
                    btD5O.setOnClickListener(new OnClickListener() {
                        public void onClick(View v) {
                            final Dialog d = new Dialog(FragmentNAmerica.this.getActivity(), R.style.DialogContinents);
                            d.setCancelable(true);
                            d.setContentView(R.layout.dialog_namerica_mountains);
                            d.setCanceledOnTouchOutside(true);
                            tvChart = (TextView)d.findViewById(R.id.chartNo);
                            tvChart.append(" 43");
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
				v = inflater.inflate(R.layout.vp_namerica_islands, null);
				tvChart = (TextView)v.findViewById(R.id.chartNo);
				tvChart.append(" 44");
				break;
			case 5:
				v = inflater.inflate(R.layout.vp_namerica_rivers, null);
				tvChart = (TextView)v.findViewById(R.id.chartNo);
				tvChart.append(" 45");
				break;
			case 6:
				v = inflater.inflate(R.layout.vp_namerica_lakes, null);
				tvChart = (TextView)v.findViewById(R.id.chartNo);
				tvChart.append(" 46");
				break;
			case 7:
				v = inflater.inflate(R.layout.vp_namerica_weather, null);
				tvChart = (TextView)v.findViewById(R.id.chartNo);
				tvChart.append(" 47");
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

