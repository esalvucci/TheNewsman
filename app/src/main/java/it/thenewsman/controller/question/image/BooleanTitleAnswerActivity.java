package it.thenewsman.controller.question.image;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import it.thenewsman.R;
import it.thenewsman.controller.question.AnswerActivity;
import it.thenewsman.model.Question;
import it.thenewsman.model.news.News;

/**
 * Created by enrico on 11/12/17.
 */
public class BooleanTitleAnswerActivity extends AnswerActivity {

    private final static String FORMULATION = "Seleziona il titolo della notizia che ritieni" +
            "più realistico";
    // Da mettere in R.string

    public BooleanTitleAnswerActivity() {
        super();
    }

    @Override
    public void setContentLayout() {
        setContentView(R.layout.activity_boolean_question);
    }

    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        this.setQuestionFormulation(FORMULATION);
    }

    @Override
    public void setAnswers() {

        LinearLayout firstLayout = (LinearLayout) findViewById(R.id.first_layout);
        firstLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        TextView firstTitle = new TextView(this);
        firstTitle.setTextSize(20);

        News firstNews = this.getUserChallenge().getFilteredNews();
        firstTitle.setText(firstNews.getTitle());
        firstTitle.setTextColor(getResources().getColor(R.color.colorAccent));


        firstLayout.addView(firstTitle);
        firstLayout.setOnClickListener(new OnBooleanClickListener(firstNews));

        LinearLayout secondLayout = (LinearLayout) findViewById(R.id.second_layout);
        secondLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

        TextView secondTitle = new TextView(this);
        secondTitle.setTextColor(getResources().getColor(R.color.colorAccent));

        News secondNews = this.getUserChallenge().getFilteredNews();
        secondTitle.setText(secondNews.getTitle());
        secondTitle.setTextSize(20);

        secondLayout.addView(secondTitle);
        secondLayout.setOnClickListener(new OnBooleanClickListener(secondNews));

    }

    private class OnBooleanClickListener implements View.OnClickListener {

        private News news;

        private OnBooleanClickListener(News news) {
            this.news = news;
        }

        @Override
        public void onClick(View v) {
            if (this.news.isTrue()) {
                getUserChallenge().getUser().addPoints(this.news.getDifficulty().getLevel());
            }

            startNextActivity();
        }
    }
}
