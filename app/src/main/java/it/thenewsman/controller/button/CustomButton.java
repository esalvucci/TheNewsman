package it.thenewsman.controller.button;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.view.Gravity;

import com.google.android.flexbox.FlexboxLayout;

import it.thenewsman.R;

/**
 * Created by enrico on 11/5/17.
 */

public class CustomButton extends AppCompatButton {

    private static CustomButton SINGLETON = null;

    private CustomButton(Context context) {
        super(context);
    }

    public static CustomButton getInstance(int resource, int gravity, Context context) {
        if (SINGLETON == null) {
            synchronized (CustomButton.class) {
                if (SINGLETON == null) {
                    SINGLETON = new CustomButton(context);
                }
            }
        }

        SINGLETON.setBackgroundResource(resource);
        SINGLETON.setGravity(gravity);

        return SINGLETON;
    }
}
