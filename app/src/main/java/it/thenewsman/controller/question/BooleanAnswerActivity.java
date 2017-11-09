package it.thenewsman.controller.question;

import android.view.ContextThemeWrapper;
import android.widget.Button;

import com.google.android.flexbox.FlexboxLayout;

import it.thenewsman.R;
import it.thenewsman.model.news.News;

/**
 * Created by enrico on 11/8/17.
 */

public class BooleanAnswerActivity extends AnswerActivity {

    @Override
    public void setButtons(News news) {
        FlexboxLayout layout = (FlexboxLayout) findViewById(R.id.content_answer);

        Button trueButton = new Button(new ContextThemeWrapper(this, R.style.MyButtonStyle));

        trueButton.setTextColor(getResources().getColor(R.color.colorAccent));
        trueButton.setText(R.string.boolean_true);
        layout.addView(trueButton);

        Button falseButton = new Button(new ContextThemeWrapper(this, R.style.MyButtonStyle));

        falseButton.setTextColor(getResources().getColor(R.color.colorAccent));
        falseButton.setText(R.string.boolean_false);
        layout.addView(falseButton);

    }
}
