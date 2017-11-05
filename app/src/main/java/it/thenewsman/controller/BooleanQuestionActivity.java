package it.thenewsman.controller;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.flexbox.FlexboxLayout;

import java.util.zip.Inflater;

import it.thenewsman.R;
import it.thenewsman.controller.button.CustomButton;
import it.thenewsman.model.challenge.Challenge;

/**
 * Created by enrico on 11/5/17.
 */

public class BooleanQuestionActivity extends QuestionActivity {

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        FlexboxLayout layout = (FlexboxLayout) findViewById(R.id.content_answer);

        for (int j = 0; j < 7; j++ ){
            Button btnTag = new Button(this);
            btnTag.setBackgroundResource(R.drawable.rounded_button);
            btnTag.setTextColor(getResources().getColor(R.color.colorAccent));
            btnTag.setText("Button " + j);
            layout.addView(btnTag);
        }

    }

}
