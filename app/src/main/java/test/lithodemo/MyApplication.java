package test.lithodemo;

import android.app.Application;

import com.facebook.soloader.SoLoader;
import com.facebook.stetho.Stetho;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, false);
        Stetho.initializeWithDefaults(this);
    }
}
