package com.geo.geostats;

import androidx.appcompat.app.AppCompatActivity;

import com.ubikod.capptain.android.sdk.CapptainAgent;
import com.ubikod.capptain.android.sdk.CapptainAgentUtils;

/**
 * Implements common functionality for all activities.
 * <p/>
 * E.g. Capptain support
 */
public class GeostatsActivity extends AppCompatActivity {
    @Override
    protected void onResume() {
        super.onResume();
        String activityNameOnCapptain = CapptainAgentUtils.buildCapptainActivityName(((Object) this).getClass()); // Uses short class name and removes "Activity" at the end.
        CapptainAgent.getInstance(this).startActivity(this, activityNameOnCapptain, null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        CapptainAgent.getInstance(this).endActivity();
    }
}
