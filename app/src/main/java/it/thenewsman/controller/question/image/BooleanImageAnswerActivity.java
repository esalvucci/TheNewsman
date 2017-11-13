package it.thenewsman.controller.question.image;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import it.thenewsman.R;
import it.thenewsman.controller.question.AnswerActivity;
import it.thenewsman.model.Question;
import it.thenewsman.model.news.News;

/**
 * Created by enrico on 11/12/17.
 */
public class BooleanImageAnswerActivity extends AnswerActivity {

    private Question question = Question.BOOLEAN;
    private final static String FORMULATION = "Seleziona l'immagine della notizia che ritieni " +
            "più realistica";
    // Da mettere in R.string

    public BooleanImageAnswerActivity() {
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
        ImageView firstImage = new ImageView(this);

        firstImage.setElevation(5);
        News firstNews = this.getUserChallenge().getFilteredNews();

        Glide.with(this.getApplicationContext()).load(
                firstNews.getImage())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(firstImage);

        firstLayout.addView(firstImage);
        firstLayout.setOnClickListener(new OnBooleanClickListener(firstNews));

        LinearLayout secondLayout = (LinearLayout) findViewById(R.id.second_layout);
        ImageView secondImage = new ImageView(this);
        secondImage.setElevation(5);

        News secondNews = this.getUserChallenge().getFilteredNews();
        while (firstNews.isTrue() && secondNews.isTrue()) {
            secondNews = this.getUserChallenge().getFilteredNews();
            // Da correggere che in tal caso avrò notizie in meno perchè ogni volta vengono
            // cancellate da userChallenge
        }
        Glide.with(this.getApplicationContext()).load(
                secondNews.getImage())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(secondImage);

        secondLayout.addView(secondImage);
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
