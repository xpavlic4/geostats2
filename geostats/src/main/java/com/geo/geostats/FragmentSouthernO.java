package com.geo.geostats;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentSouthernO extends Fragment{
	
	TextView tvChart;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

		View v = inflater.inflate(R.layout.fragment_ocean, container, false);

        Button btD10O = (Button) v.findViewById(R.id.btDialog10);
        btD10O.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Dialog d = new Dialog(FragmentSouthernO.this.getActivity(), R.style.DialogContinents);
                d.setCancelable(true);
                d.setContentView(R.layout.dialog_southern_o);
                d.setCanceledOnTouchOutside(true);
                tvChart = (TextView)d.findViewById(R.id.chartNo);
                tvChart.append(" 94");
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

}

