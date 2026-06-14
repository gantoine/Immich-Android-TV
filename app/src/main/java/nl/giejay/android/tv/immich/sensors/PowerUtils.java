package nl.giejay.android.tv.immich.sensors;

import android.content.Context;
import android.os.PowerManager;

public class PowerUtils {
    private final PowerManager.WakeLock wakeLock;
    private final PowerManager powerManager;

    public PowerUtils(Context context) {
        // Use the String-based overload: getSystemService(Class) is API 23+ and crashes on
        // API 19 (KitKat) with NoSuchMethodError.
        powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP, "Immich:PowerUtils");
        wakeUp();
    }

    public void goToSleep() {
        if (wakeLock.isHeld()) {
            wakeLock.release();
        }
    }

    public void wakeUp() {
        if(!wakeLock.isHeld()) {
            wakeLock.acquire(10 * 60 * 1000L /*10 minutes*/);
        }
    }
}
