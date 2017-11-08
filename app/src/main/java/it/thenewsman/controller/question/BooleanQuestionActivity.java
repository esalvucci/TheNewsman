package it.thenewsman.controller.question;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.flexbox.FlexboxLayout;

import it.thenewsman.R;
import it.thenewsman.controller.ToolbarActivity;
import it.thenewsman.model.challenge.Challenge;
import it.thenewsman.model.challenge.UserChallenge;
import it.thenewsman.model.news.News;

public class BooleanQuestionActivity extends ToolbarActivity {

    @Override
    public void setContentLayout() {
        setContentView(R.layout.activity_boolean_question);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UserChallenge userChallenge = (UserChallenge) getIntent().getSerializableExtra("UserChallengeIntent");

        News news = userChallenge.getFilteredNews();

        this.setQuestionFormulation(userChallenge.getChallenge().getFormulation());
        this.setCategoryLinearLayout(userChallenge.getChallenge(), news);
        this.setButtons(news);



    }

    public void setQuestionFormulation(int formulation) {
        String formulationString = getResources().getString(formulation);
        TextView textView = (TextView) findViewById(R.id.question_formulation);
        textView.setText(formulationString);
    }

    public void setCategoryLinearLayout(Challenge challenge, News news) {

        ViewGroup viewGroup = findViewById(R.id.challenge_category_linear_layout);
        View layout = null;
        switch (challenge) {
            case TITLE:
                TextView title = new TextView(this.getApplicationContext());
                title.setText(news.getTitle());
                layout = title;
                break;
            case URL:
                TextView url = new TextView(this.getApplicationContext());
                url.setText(news.getUrl());
                layout = url;
                break;

            case PHOTO:
                ImageView image = new ImageView(this.getApplicationContext());
                Glide.with(this.getApplicationContext()).load(news.getImage())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .centerCrop()
                        .into(image);
                layout = image;
                break;

            case CONTENT:
                TextView source = new TextView(this.getApplicationContext());
                source.setText(news.getText());
                layout = source;

                break;

            case BONUS:
                TextView bonus = new TextView(this.getApplicationContext());
                bonus.setText("bonus");
                layout = bonus;

                break;

            default:
        }
        viewGroup.addView(layout);
    }

    public void setButtons(News news) {

        FlexboxLayout layout = (FlexboxLayout) findViewById(R.id.content_answer);

        Button trueButton = new Button(this);
        trueButton.setBackgroundResource(R.drawable.rounded_button);
        trueButton.setTextColor(getResources().getColor(R.color.colorAccent));
        trueButton.setText(R.string.boolean_true);
        layout.addView(trueButton);

        Button falseButton = new Button(this.getApplicationContext());
        trueButton.setBackgroundResource(R.drawable.rounded_button);
        falseButton.setTextColor(getResources().getColor(R.color.colorAccent));
        falseButton.setText(R.string.boolean_false);
        layout.addView(falseButton);

    }
}
