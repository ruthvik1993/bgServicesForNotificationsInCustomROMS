package com.ruthvik.bgservicesfornotifications.Services;


import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.GcmTaskService;
import com.google.android.gms.gcm.TaskParams;


/**
 * Created by Ruthvik on 11/13/17.
 */

public class NotificationTaskService extends GcmTaskService {

    public NotificationTaskService() {
        super();
    }

    @Override
    public int onRunTask(TaskParams taskParams) {
        try {
            /*Api request to get Notifications from Backend*/

        } catch (Exception e) {
        }
        return GcmNetworkManager.RESULT_SUCCESS;
    }

}
