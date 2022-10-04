package com.geo.geostats;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.imagezoom.ImageAttacher;
import com.squareup.picasso.Picasso;

import java.util.Locale;

public class FragmentNAmerica extends Fragment {

    ViewPager vp;
    private vpAdapter miAdapter;
    TextView tvTitle;
    ImageView ivMap, ivMapBasic;
    RadioGroup rg;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

		View v = inflater.inflate(R.layout.fragment_continent, container, false);
		
		vp = (ViewPager) v.findViewById(R.id.viewpager);
        miAdapter = new vpAdapter();
        vp.setAdapter(miAdapter);

//        TabPageIndicator indicator = (TabPageIndicator)v.findViewById(R.id.indicator);
//        indicator.setViewPager(vp);

        Button btD10O = (Button) v.findViewById(R.id.btDialog10);
        Button btD11O = (Button) v.findViewById(R.id.btDialog11);
        btD10O.setOnClickListener(v1 -> {
			final Dialog d = new Dialog(FragmentNAmerica.this.getActivity(), R.style.DialogContinents);
			d.setCancelable(true);
			d.setContentView(R.layout.dialog_namerica);
			d.setCanceledOnTouchOutside(true);
			Button btClose = (Button) d.findViewById(R.id.btClose);
			btClose.setOnClickListener(v11 -> d.cancel());
			d.show();
		});
        btD11O.setOnClickListener(v12 -> {
			final Dialog d1 = new Dialog(FragmentNAmerica.this.getActivity(), R.style.DialogContinents);
			d1.setCancelable(true);
			d1.setContentView(R.layout.dialog_namerica_maps);
			d1.setCanceledOnTouchOutside(true);

			WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
			lp.copyFrom(d1.getWindow().getAttributes());
			lp.width = WindowManager.LayoutParams.MATCH_PARENT;
			lp.height = WindowManager.LayoutParams.MATCH_PARENT;
			Button btClose = (Button) d1.findViewById(R.id.btClose);
			ivMap = (ImageView)d1.findViewById(R.id.ivMap);
			Picasso.with(FragmentNAmerica.this.getActivity().getApplicationContext()).load(R.drawable.map_namerica_physical).resize(1169, 1500).into(ivMap);
			rg = (RadioGroup) d1.findViewById(R.id.rgMap);

			rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
				@Override
				public void onCheckedChanged(RadioGroup rg, int checkedId) {
					switch(checkedId){
						case R.id.rbMap1:
							Picasso.with(FragmentNAmerica.this.getActivity().getApplicationContext()).load(R.drawable.map_namerica_physical).resize(1169, 1500).into(ivMap);
							break;
						case R.id.rbMap2:
							Picasso.with(FragmentNAmerica.this.getActivity().getApplicationContext()).load(R.drawable.map_camerica_physical).resize(1500,1124).into(ivMap);
							break;
					}
				}
			});

			btClose.setOnClickListener(v121 -> d1.cancel());

			usingSimpleImage(ivMap);
			d1.show();
			d1.getWindow().setAttributes(lp);
		});

        Display disp = getActivity().getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        disp.getMetrics(metrics);
        ImageView ivMapBasic = (ImageView) v.findViewById(R.id.ivMapBasic);
        ivMapBasic.setVisibility(View.INVISIBLE);

        if((metrics.widthPixels >= 600 && metrics.heightPixels >= 1000) || FragmentNAmerica.this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            ivMapBasic.setVisibility(View.VISIBLE);
            Picasso.with(FragmentNAmerica.this.getActivity().getApplicationContext()).load(R.drawable.map_namerica_basic).into(ivMapBasic);
            ivMapBasic.setContentDescription(getString(R.string.NorthAmerica));
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
				break;
			case 5:
				v = inflater.inflate(R.layout.vp_namerica_rivers, null);
				break;
			case 6:
				v = inflater.inflate(R.layout.vp_namerica_lakes, null);
				break;
			case 7:
				v = inflater.inflate(R.layout.vp_namerica_weather, null);
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

