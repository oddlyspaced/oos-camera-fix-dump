package com.oplus.permission;

import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CheckStuff {

    public static void check() {
        try {
            Class<?> c = Class.forName("android.hardware.camera2.CameraDevice");
            Class[] cArg = new Class[1];
            cArg[0] = int.class;
            Method method = c.getMethod("setVendorStreamConfigMode", cArg);
            Object ret = method.invoke(null);
            Log.e("OUTPUT", ret)
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public static void hello() {
        Log.e("TESTING", "WORKING");
    }

}
