package com.geo.geostats;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class About extends Activity implements android.view.View.OnClickListener {

    TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.about);

        tv = (TextView) findViewById(R.id.tvInfoAbout);
        tv.setText(Html.fromHtml(ResourceHelper.readRawTextFile(this, R.raw.about)));
        tv.setTextColor(Color.rgb(97, 97, 97));
        tv.setLinkTextColor(Color.rgb(97, 97, 97));
        Linkify.addLinks(tv, Linkify.ALL);
		
		Button b = (Button)findViewById(R.id.btClose);
        Button c = (Button)findViewById(R.id.btRefs);
		b.setOnClickListener(this);
        c.setOnClickListener(this);
    }
    public void onClick(View v) {
            // TODO Auto-generated method stub
            switch(v.getId()){
                case R.id.btClose:
                    finish();
                    break;

                case R.id.btRefs:
                    Intent i = new Intent("com.geo.geostats.INFO_REFERENCES");
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                    break;
            }

    }

}
