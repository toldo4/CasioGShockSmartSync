package org.avmedia.gshockGoogleSync.utils

import android.app.Activity
import android.app.Application
import android.os.Bundle
import java.lang.ref.WeakReference

object ActivityProvider {
    private var currentActivity: WeakReference<Activity>? = null

    /**
     * Number of currently resumed activities. currentActivity alone cannot answer "is the app
     * in front?" -- it is only cleared on destroy, so it stays set for a backgrounded app.
     */
    @Volatile
    private var resumedActivities: Int = 0

    /** True while any activity of this app is resumed, i.e. the user is looking at it. */
    fun isInForeground(): Boolean = resumedActivities > 0

    fun initialize(application: Application) {
        application.registerActivityLifecycleCallbacks(object :
            Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                currentActivity = WeakReference(activity)
            }

            override fun onActivityStarted(activity: Activity) {
                currentActivity = WeakReference(activity)
            }

            override fun onActivityResumed(activity: Activity) {
                currentActivity = WeakReference(activity)
                resumedActivities++
            }

            override fun onActivityPaused(activity: Activity) {
                if (resumedActivities > 0) resumedActivities--
            }
            override fun onActivityStopped(activity: Activity) {
                // Needed to satisfy Interface, but not used here
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
                // Needed to satisfy Interface, but not used here
            }

            override fun onActivityDestroyed(activity: Activity) {
                if (currentActivity?.get() == activity) {
                    currentActivity = null
                }
            }
        })
    }

    fun getCurrentActivity(): Activity? = currentActivity?.get()
}