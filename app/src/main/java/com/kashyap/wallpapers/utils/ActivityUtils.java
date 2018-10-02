package com.kashyap.wallpapers.utils;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class ActivityUtils {

    public static void attachFragmentToActivity(FragmentManager fragmentManager, @IdRes int layoutId, Fragment fragment) {
        fragmentManager.beginTransaction().replace(layoutId, fragment, fragment.getClass().getSimpleName()).commit();
    }
}
