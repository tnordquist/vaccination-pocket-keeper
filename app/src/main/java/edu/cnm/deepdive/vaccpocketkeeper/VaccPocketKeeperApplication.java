package edu.cnm.deepdive.vaccpocketkeeper;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.vaccpocketkeeper.service.VaccpocketkeeperDatabase;

/**
 * Initializes (in the {@link #onCreate()} method) application-level resources. This class
 * <strong>must</strong> be referenced in {@code AndroidManifest.xml}, or it will not be loaded and
 * used by the Android system.
 */
public class VaccPocketKeeperApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    VaccpocketkeeperDatabase.setContext(this);
  }

}
