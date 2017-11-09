package it.thenewsman.controller.question;

import android.view.ContextThemeWrapper;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.flexbox.FlexboxLayout;

import it.thenewsman.R;
import it.thenewsman.model.news.CategoryNews;
import it.thenewsman.model.news.News;

/**
 * Created by enrico on 11/8/17.
 */

public class MultipleAnswerActivity extends AnswerActivity {

    @Override
    public void setButtons(News news) {
        FlexboxLayout layout = (FlexboxLayout) findViewById(R.id.content_answer);

        for (String s : this.getUserChallenge().getFilteredNews().getEmotions()) {
            Button trueButton = new Button(new ContextThemeWrapper(this, R.style.MyButtonStyle));

            trueButton.setText(s);
            layout.addView(trueButton);
        }

    }
}
