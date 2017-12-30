package resep.masakan.jepang.analytics;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import resep.masakan.jepang.R;
import resep.masakan.jepang.json.AnalyticsConfig;

public class Analytics extends Application {

    private Tracker mTracker;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public synchronized Tracker getTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            analytics.setDryRun(!AnalyticsConfig.ANALYTICS);
            mTracker = analytics.newTracker(R.xml.analytics_app_tracker);
        }
        return mTracker;
    }
}