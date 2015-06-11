package com.trifork.android.tv.test.androidtvtest.custom;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import com.trifork.android.tv.test.androidtvtest.R;

import java.io.IOException;

public class UpdateRecommendationsService extends IntentService {
    private static final String TAG = "Update";
    private static final int MAX_RECOMMENDATIONS = 3;
    private NotificationManager mNotificationManager;

    public UpdateRecommendationsService() {
        super("RecommendationService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        if (mNotificationManager == null) {
            mNotificationManager = (NotificationManager) getApplicationContext()
                    .getSystemService(Context.NOTIFICATION_SERVICE);
        }

        int count = 0;

        try {
            RecommendationBuilder builder = new RecommendationBuilder()
                    .setContext(getApplicationContext())
                    .setSmallIcon(R.drawable.videos_by_google_icon);

            Notification notification = builder.setBackground("http://icons.iconarchive.com/icons/thegirltyler/brand-camp/256/Camp-Fire-Stories-icon.png")
                    .setId(count + 1)
                    .setPriority(MAX_RECOMMENDATIONS - count)
                    .setTitle("Home automation")
                    .setDescription("Recommendation from Android TV")
                    .setImage(((BitmapDrawable) getResources().getDrawable(R.drawable.icon_heat)).getBitmap())
                    //.setIntent(buildPendingIntent(movie))
                    .build();

            mNotificationManager.notify(1, notification);

            /*for (Map.Entry<String, List<Movie>> entry : recommendations.entrySet()) {
                for (Movie movie : entry.getValue()) {
                    Log.d(TAG, "Recommendation - " + movie.getTitle());

                    builder.setBackground(movie.getCardImageUrl())
                            .setId(count + 1)
                            .setPriority(MAX_RECOMMENDATIONS - count)
                            .setTitle(movie.getTitle())
                            .setDescription(getString(R.string.popular_header))
                            .setImage(movie.getCardImageUrl())
                            .setIntent(buildPendingIntent(movie))
                            .build();

                    if (++count >= MAX_RECOMMENDATIONS) {
                        break;
                    }
                }
                if (++count >= MAX_RECOMMENDATIONS) {
                    break;
                }
            }*/
        } catch (IOException e) {
            Log.e(TAG, "Unable to update recommendation", e);
        }
    }

    private PendingIntent buildPendingIntent(Device device) {
        Intent detailsIntent = new Intent(this, DeviceActivity.class);
        detailsIntent.putExtra("Device", device);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(DeviceActivity.class);
        stackBuilder.addNextIntent(detailsIntent);
        // Ensure a unique PendingIntents, otherwise all recommendations end up with the same
        // PendingIntent
        detailsIntent.setAction(device.getName());

        PendingIntent intent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        return intent;
    }
}