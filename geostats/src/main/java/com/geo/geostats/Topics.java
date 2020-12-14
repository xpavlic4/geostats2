package com.geo.geostats;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NavUtils;
import androidx.appcompat.app.ActionBar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Topics extends GeostatsActivity {

    ListView list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topics);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setTitle(getString(R.string.Topics));

        list = (ListView) findViewById(R.id.lvList);

        int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                R.layout.my_simple_list_item_activated_1 : R.layout.my_simple_list_item_1;

        final String[] alist = new String[3];
        alist[0] = getString(R.string.PhysicalGeography);
        alist[1] = getString(R.string.PoliticalUrbanGeography);
        alist[2] = getString(R.string.EconomicGeography);

        final ArrayAdapter<String> aa = new ArrayAdapter<String>(this, layout, alist);
        list.setAdapter(aa);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            String name1 = "G1";
            String name2 = "G2";
            String name3 = "G3";
            Bundle bag = new Bundle();
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int pos,long id) {
                if(pos == 0){
                    Intent i = new Intent("com.geo.geostats.TOPICS_FM");
                    bag.putString("GEO", name1);
                    i.putExtras(bag);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }else if(pos == 1){
                    Intent i2 = new Intent("com.geo.geostats.TOPICS_FM");
                    bag.putString("GEO", name2);
                    i2.putExtras(bag);
                    i2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i2);
                }else if(pos == 2){
                    Intent i3 = new Intent("com.geo.geostats.TOPICS_FM");
                    bag.putString("GEO", name3);
                    i3.putExtras(bag);
                    i3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i3);
                }
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.iRefs:
                Intent b = new Intent("com.geo.geostats.INFO_REFERENCES");
                b.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(b);
                break;
        }

        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_references, menu);
        return true;
    }

}
