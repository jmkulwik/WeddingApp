package opaleski.jessie.weddingapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class GCM_ID_Listener extends Service {
    public GCM_ID_Listener() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
