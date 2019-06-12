package com.fxp.skinlib.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import com.fxp.skinlib.R;

import skin.support.content.res.SkinCompatResources;
import skin.support.widget.SkinCompatCheckBox;

/**
 * Title:       SkinCheckBox
 * <p>
 * Package:     com.fxp.skinlib.widget
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2019-06-12 10:45
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2019-06-12    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class SkinCheckBox extends SkinCompatCheckBox {
    public SkinCheckBox(Context context) {
        super(context);
    }

    public SkinCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public SkinCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr){

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        skinImageView();
    }

    @Override
    public void setBackground(Drawable background) {
        super.setBackground(background);
        skinImageView();
    }


    @Override
    public void applySkin() {
        super.applySkin();
        skinImageView();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        skinImageView();
        super.onDraw(canvas);
    }

    private void skinImageView(){
        Drawable drawable = getButtonDrawable();
        if (drawable != null) {
            drawable.clearColorFilter();

            drawable.setColorFilter(isClickable() ? SkinCompatResources.getInstance().getColor(R.color.skin)
                    : getResources().getColor(R.color.checkbox_text_right), PorterDuff.Mode.SRC_ATOP);
        }
    }
}
