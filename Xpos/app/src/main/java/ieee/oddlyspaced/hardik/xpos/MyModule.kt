package ieee.oddlyspaced.hardik.xpos

import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage

/*
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import android.widget.TextView;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;
 */

class MyModule: IXposedHookLoadPackage {
    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam?) {
        XposedBridge.log("Loaded app: " + lpparam?.packageName)

        /*
        if (!lpparam.packageName.equals("com.android.systemui"))
            return;

   findAndHookMethod("com.android.systemui.statusbar.policy.Clock", lpparam.classLoader, "updateClock", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
             TextView tv = (TextView) param.thisObject;
             tv.setText(":)");

            }
 });
         */

        /*
        XposedHelpers.findAndHookMethod("com.android.systemui.statusbar.policy.Clock", lpparam.classLoader, "updateClock", new XC_MethodHook() {

    @Override
    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
        super.beforeHookedMethod(param);
    }

    @Override
    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
        super.afterHookedMethod(param);
    }
});
         */

        lpparam?.packageName?.equals("android.hardware.camera2.CameraDevice")?.let {
            if (it) { // CameraDevice being called
                XposedHelpers.findAndHookMethod("android.hardware.camera2.CameraDevice", lpparam.classLoader, "setVendorStreamConfigMode", object : XC_MethodHook() {
                    override fun afterHookedMethod(param: MethodHookParam?) {
//            byte[] theReturnVal= (byte[]) param.getResult();
                        param?.result = 200
                    }
                })
            }
        }
    }


}