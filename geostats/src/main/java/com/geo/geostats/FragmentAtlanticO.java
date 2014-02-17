package com.geo.geostats;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
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
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.geo.viewpagerindicator.TabPageIndicator;
import com.imagezoom.ImageAttacher;

import java.util.Locale;


public class FragmentAtlanticO extends Fragment{
	
	ViewPager vp;
	private vpAdapter miAdapter;
	TextView tvChart;
    ImageView ivMap, ivMapBasic;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

		View v = inflater.inflate(R.layout.fragment_ocean, container, false);
		
		vp = (ViewPager) v.findViewById(R.id.viewpager);
        miAdapter = new vpAdapter();
        vp.setAdapter(miAdapter);

        TabPageIndicator indicator = (TabPageIndicator)v.findViewById(R.id.indicator);
        indicator.setViewPager(vp);

        Button btD10O = (Button) v.findViewById(R.id.btDialog10);
        Button btD11O = (Button) v.findViewById(R.id.btDialog11);
        btD10O.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Dialog d = new Dialog(FragmentAtlanticO.this.getActivity(), R.style.DialogContinents);
                d.setCancelable(true);
                d.setContentView(R.layout.dialog_atlantic_o);
                d.setCanceledOnTouchOutside(true);
                tvChart = (TextView)d.findViewById(R.id.chartNo);
                tvChart.append(" 74");
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
        btD11O.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Dialog d1 = new Dialog(FragmentAtlanticO.this.getActivity(), R.style.DialogContinents);
                d1.setCancelable(true);
                d1.setContentView(R.layout.dialog_atlantic_o_maps);
                d1.setCanceledOnTouchOutside(true);

                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(d1.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                lp.height = WindowManager.LayoutParams.MATCH_PARENT;

                tvChart = (TextView)d1.findViewById(R.id.imageNo);
                tvChart.append(" 8");
                Button btClose = (Button) d1.findViewById(R.id.btClose);
                ivMap = (ImageView)d1.findViewById(R.id.ivMap);

                Bitmap bimtBitmap = BitmapFactory.decodeResource(getResources(),
                        R.drawable.map_atlantic_o);
                ivMap.setImageBitmap(bimtBitmap);
                usingSimpleImage(ivMap);

                btClose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        d1.cancel();
                    }
                });

                d1.show();
                d1.getWindow().setAttributes(lp);
            }
        });
        if(FragmentAtlanticO.this.getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            ivMapBasic = (ImageView) v.findViewById(R.id.ivMapBasic);
            ivMapBasic.setImageBitmap(com.geo.geostats.SampleBitmap.decodeSampledBitmapFromResource(getResources(), R.drawable.map_atlantic_o, 400, 400));
            ivMapBasic.setContentDescription(getString(R.string.AtlanticOcean));
        } else {

        }
		return v;
	}

    public void usingSimpleImage(ImageView imageView) {
        ImageAttacher mAttacher = new ImageAttacher(imageView);
        ImageAttacher.MAX_ZOOM = 2.0f; // Double the current Size
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
				v = inflater.inflate(R.layout.vp_atlantic_o_seas, null);
				tvChart = (TextView)v.findViewById(R.id.chartNo);
				tvChart.append(" 75");
				break;
			case 1:
				v = inflater.inflate(R.layout.vp_atlantic_o_gulfs, null);
				tvChart = (TextView)v.findViewById(R.id.chartNo);
				tvChart.append(" 76");
				break;
			case 2:
				v = inflater.inflate(R.layout.vp_atlantic_o_straits, null);
				tvChart = (TextView)v.findViewById(R.id.chartNo);
				tvChart.append(" 77");
				break;
			case 3:
				v = inflater.inflate(R.layout.vp_atlantic_o_currents, null);
				tvChart = (TextView)v.findViewById(R.id.chartNo);
				tvChart.append(" 78");
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
