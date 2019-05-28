package com.fxp.skinlib;

import android.app.Application;
import android.content.Context;

import com.fxp.skinlib.util.SkinSPUtil;

import skin.support.SkinCompatManager;
import skin.support.app.SkinCardViewInflater;
import skin.support.constraint.app.SkinConstraintViewInflater;
import skin.support.design.app.SkinMaterialViewInflater;

/**
 * Title:       SkinManager
 * <p>
 * Package:     com.fxp.skinlib
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2019-05-28 11:39
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2019-05-28    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class SkinManager {

    public static String[] SKINS = new String[]{"default", "night"};

    public static void init(Application application){
        // 基础控件换肤初始化
        SkinCompatManager.withoutActivity(application)
                // material design 控件换肤初始化[可选]
                .addInflater(new SkinMaterialViewInflater())
                // ConstraintLayout 控件换肤初始化[可选]
                .addInflater(new SkinConstraintViewInflater())
                // CardView v7 控件换肤初始化[可选]
                .addInflater(new SkinCardViewInflater())
                // 关闭状态栏换肤，默认打开[可选]
                .setSkinStatusBarColorEnable(true)
                // 关闭windowBackground换肤，默认打开[可选]
                .setSkinWindowBackgroundEnable(true)
                .loadSkin();

        int which = SkinSPUtil.getInstance(application).getInt("skin_index", 0);
        if (which == 0) {
            // 恢复应用默认皮肤
            SkinCompatManager.getInstance().restoreDefaultTheme();
        } else {
            if (which < SKINS.length){
                // 后缀加载
                SkinCompatManager.getInstance().loadSkin(SKINS[which], SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN);
            }
        }
    }

    public static void loadSkinBuildIn(Context context, int index){
        if (index < SKINS.length){
            // 后缀加载
            SkinCompatManager.getInstance().loadSkin(SKINS[index], SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN);
            SkinSPUtil.getInstance(context).putInt("skin_index", index);
        }
    }
}
