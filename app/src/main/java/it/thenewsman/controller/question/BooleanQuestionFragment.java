package it.thenewsman.controller.question;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.flexbox.FlexboxLayout;

import it.thenewsman.R;
import it.thenewsman.model.challenge.Challenge;
import it.thenewsman.model.news.News;

public class BooleanQuestionFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private Challenge userChallenge;

    public BooleanQuestionFragment() {
        // Required empty public constructor
    }

    public static BooleanQuestionFragment newInstance(Challenge userChallenge) {

        Log.d("POSITION", "newInstance: " + userChallenge.toString());
        BooleanQuestionFragment fragment = new BooleanQuestionFragment();
        Bundle args = new Bundle();
        args.putSerializable("UserChallengeBundle", userChallenge);

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        if (args == null) {
            Toast.makeText(getActivity(), "arguments is null " , Toast.LENGTH_LONG).show();
        } else {
            this.userChallenge = (Challenge) args.getSerializable("UserChallengeBundle");
            Toast.makeText(getActivity(), "text " + args , Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question, container, false);

        this.setQuestionFormulation(view, this.userChallenge.getFormulation());
//        this.setCategoryLinearLayout(view, this.userChallenge, this.userChallenge.);
//        this.setButtons(view, this.userChallenge.getFilteredNews());

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    // getActivity().getSupportFragmentManager().popBackStack();
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    public void setQuestionFormulation(View view, int formulation) {
        String formulationString = view.getResources().getString(formulation);
        TextView textView = (TextView) view.findViewById(R.id.question_formulation);
        textView.setText(formulationString);
    }

    public void setCategoryLinearLayout(View view, Challenge challenge, News news) {

        ViewGroup viewGroup = view.findViewById(R.id.challenge_category_linear_layout);
        View layout = null;
        switch (challenge) {
            case TITLE:
                TextView title = new TextView(this.getContext());
                title.setText(news.getTitle());
                layout = title;
                break;
            case URL:
                TextView url = new TextView(this.getContext());
                url.setText(news.getTitle());
                layout = url;
                break;

            case PHOTO:
                ImageView image = new ImageView(this.getContext());
                Glide.with(this.getContext()).load(news.getImage())
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .centerCrop()
                        .into(image);
                layout = image;
                break;

            case CONTENT:
                TextView source = new TextView(this.getContext());
                source.setText(news.getText());
                layout = source;

                break;

            case BONUS:
                TextView bonus = new TextView(this.getContext());
                bonus.setText("bonus");
                layout = bonus;

                break;

            default:
        }
        viewGroup.addView(layout);
    }

    public void setButtons(View view, News news) {

        FlexboxLayout layout = (FlexboxLayout) view.findViewById(R.id.content_answer);

        Button trueButton = new Button(this.getContext());
        trueButton.setBackgroundResource(R.drawable.rounded_button);
        trueButton.setTextColor(getResources().getColor(R.color.colorAccent));
        trueButton.setText(R.string.boolean_true);
        layout.addView(trueButton);

        Button falseButton = new Button(this.getContext());
        falseButton.setBackgroundResource(R.drawable.rounded_button);
        falseButton.setTextColor(getResources().getColor(R.color.colorAccent));
        falseButton.setText(R.string.boolean_true);
        layout.addView(falseButton);


    }
}
