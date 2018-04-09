package cn.edu.gdmec.android.boxuegu.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by apple on 18/4/3.
 */

public class AnalysisUtils {
    public static String readLoginUserName(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("loginInfo", Context.MODE_PRIVATE);
        String userName=sharedPreferences.getString("loginUserName","");
        return userName;
    }
    public static boolean readLoginStatus(Context context){
        SharedPreferences sharedPreferences=context.getSharedPreferences("LoginInfo",Context.MODE_PRIVATE);
        boolean isLogin=sharedPreferences.getBoolean("isLogin",false);
        return isLogin;
    }

    public static void clearLoginStatus(Context context){
        SharedPreferences sp=context.getSharedPreferences("loginInfo",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putBoolean("isLogin",false);
        editor.putString("loginUserName","");
        editor.commit();
    }
}
