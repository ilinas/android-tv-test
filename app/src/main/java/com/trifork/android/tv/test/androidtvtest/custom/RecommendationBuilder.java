package com.trifork.android.tv.test.androidtvtest.custom;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;

import com.trifork.android.tv.test.androidtvtest.R;

import java.io.IOException;

/**
 * Created by ckp on 6/11/15.
 */
public class RecommendationBuilder {

    private int mId;
    private Context mContext;
    private String mTitle;
    private String mDescription;
    private String mImageUri;
    private String mBackgroundUri;
    private int mPriority;
    private Bitmap image;
    private int mSmallIcon;
    private PendingIntent mIntent;
    private Bundle extras;

    public int getId() {
        return mId;
    }

    public RecommendationBuilder setId(int mId) {
        this.mId = mId;
        return this;
    }

    public Context getContext() {
        return mContext;
    }

    public RecommendationBuilder setContext(Context mContext) {
        this.mContext = mContext;
        return this;
    }

    public Bundle getExtras() {
        return extras;
    }

    public RecommendationBuilder setExtras(Bundle extras) {
        this.extras = extras;
        return this;
    }

    public String getTitle() {
        return mTitle;
    }

    public RecommendationBuilder setTitle(String mTitle) {
        this.mTitle = mTitle;
        return this;
    }

    public String getDescription() {
        return mDescription;
    }

    public RecommendationBuilder setDescription(String mDescription) {
        this.mDescription = mDescription;
        return this;
    }

    public String getImageUri() {
        return mImageUri;
    }

    public RecommendationBuilder setImageUri(String mImageUri) {
        this.mImageUri = mImageUri;
        return this;
    }

    public String getBackgroundUri() {
        return mBackgroundUri;
    }

    public RecommendationBuilder setBackgroundUri(String mBackgroundUri) {
        this.mBackgroundUri = mBackgroundUri;
        return this;
    }

    public int getPriority() {
        return mPriority;
    }

    public RecommendationBuilder setPriority(int mPriority) {
        this.mPriority = mPriority;
        return this;
    }

    public Bitmap getImage() {
        return image;
    }

    public RecommendationBuilder setImage(Bitmap image) {
        image = image;
        return this;
    }

    public int getSmallIcon() {
        return mSmallIcon;
    }

    public RecommendationBuilder setSmallIcon(int mSmallIcon) {
        mSmallIcon = mSmallIcon;
        return this;
    }

    public PendingIntent getIntent() {
        return mIntent;
    }

    public RecommendationBuilder setIntent(PendingIntent mIntent) {
        mIntent = mIntent;
        return this;
    }

    public RecommendationBuilder setBackground(String uri) {
        mBackgroundUri = uri;
        return this;
    }

    public Notification build() throws IOException {

        Notification notification = new NotificationCompat.BigPictureStyle(
                new NotificationCompat.Builder(mContext)
                        .setContentTitle(mTitle)
                        .setContentText(mDescription)
                        .setPriority(mPriority)
                        .setLocalOnly(true)
                        .setOngoing(true)
                        .setColor(mContext.getResources().getColor(R.color.fastlane_background))
                        .setCategory(Notification.CATEGORY_RECOMMENDATION)
                        .setLargeIcon(image)
                        .setSmallIcon(mSmallIcon)
                        .setContentIntent(mIntent)
                        .setExtras(extras))
                .build();

        return notification;
    }

}
