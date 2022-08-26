package vn.hunghd.flutterdownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.work.WorkManager;

import java.util.UUID;

public class CancelBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("cancel_download")) {
            String taskId = intent.getStringExtra("task_id");
            WorkManager.getInstance(context).cancelWorkById(UUID.fromString(taskId));
        }
    }
}
