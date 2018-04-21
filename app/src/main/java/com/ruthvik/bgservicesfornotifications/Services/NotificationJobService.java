package com.ruthvik.bgservicesfornotifications.Services;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RemoteViews;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.newsdistill.mobile.AppBase.AppContext;
import com.newsdistill.mobile.R;
import com.newsdistill.mobile.appdb.DB_Constants;
import com.newsdistill.mobile.appdb.PreferencesDB;
import com.newsdistill.mobile.community.model.CommunityLocation;
import com.newsdistill.mobile.community.question.QuestionDetailActivity;
import com.newsdistill.mobile.constants.IntentsConstants;
import com.newsdistill.mobile.constants.NotificationConstatnts;
import com.newsdistill.mobile.cricketviews.SummaryScoreBoardActivity;
import com.newsdistill.mobile.detailed.GenreDetailedPage;
import com.newsdistill.mobile.facebook.UserSharedPref;
import com.newsdistill.mobile.follows.FollowsDetailedActivity;
import com.newsdistill.mobile.home.HomeNewsHeavyWeightActivity;
import com.newsdistill.mobile.map.NewsMapActivity;
import com.newsdistill.mobile.myfeeds.PreferenceHanlder;
import com.newsdistill.mobile.photos.PhotosFullscreenActivity;
import com.newsdistill.mobile.preferences.CountrySharedPreference;
import com.newsdistill.mobile.profile.user.UserProfileActivity;
import com.newsdistill.mobile.settings.UpdateActivity;
import com.newsdistill.mobile.settings.WelcomeActivity;
import com.newsdistill.mobile.utils.ApiUrls;
import com.newsdistill.mobile.utils.DetailedConstants;
import com.newsdistill.mobile.utils.Util;
import com.newsdistill.mobile.utils.Utils;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import timber.log.Timber;

/**
 * Created by Ruthvik on 11/13/17.
 */

public class NotificationJobService extends JobService {


    public NotificationJobService() {
        super();
    }

    @Override
    public boolean onStartJob(JobParameters params) {
        try {
            /*Api to get Notifications from the backend*/

        } catch (Exception e) {
        }

        return false;
    }


    @Override
    public boolean onStopJob(JobParameters params) {
        Log.d("service stopped", "NOTIFIACTION SERVICE");
        return true;
    }

}
