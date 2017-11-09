package it.thenewsman.controller;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.imangazaliev.circlemenu.CircleMenu;
import com.imangazaliev.circlemenu.CircleMenuButton;

import java.util.Random;

import it.thenewsman.R;
import it.thenewsman.controller.question.AnswerActivity;
import it.thenewsman.controller.question.BooleanAnswerActivity;
import it.thenewsman.controller.question.MultipleAnswerActivity;
import it.thenewsman.model.Question;
import it.thenewsman.model.challenge.Challenge;
import it.thenewsman.model.challenge.UserChallenge;
import it.thenewsman.model.dao.DAOFactory;
import it.thenewsman.model.user.User;
import it.thenewsman.model.user.UserImpl;

public class MainFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private ListView mListView;
    private User user;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.DAOType.SQLITE);
        this.user = daoFactory.getUserDAO().select();
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        final CircleMenu circleMenu = (CircleMenu) view.findViewById(R.id.circleMenu);

        circleMenu.setOnItemClickListener(new CircleMenu.OnItemClickListener() {
            @Override
            public void onItemClick(CircleMenuButton menuButton) {

                Challenge challenge = null;

                switch (menuButton.getId()) {
                    case R.id.title :
                        challenge = Challenge.TITLE;
                        break;
                    case R.id.photo :
                        challenge = Challenge.PHOTO;
                        break;
                    case R.id.url :
                        challenge = Challenge.URL;
                        break;
                    case R.id.content :
                        challenge = Challenge.CONTENT;
                        break;
                    case R.id.bonus :
                        challenge = Challenge.BONUS;
                        break;

                    default:
                        break;
                }

                Intent intent;
                if (challenge.equals(Challenge.URL)) {
                    intent = new Intent(getContext()
                            , MultipleAnswerActivity.class);
                } else {
                    intent = new Random().nextBoolean() ?
                            new Intent(getContext(), MultipleAnswerActivity.class) :
                            new Intent(getContext(), BooleanAnswerActivity.class);
                }

                intent.putExtra("UserChallengeIntent", new UserChallenge(user, challenge));
                startActivity(intent);
            }
        });

        circleMenu.setStateUpdateListener(new CircleMenu.OnStateUpdateListener() {
            @Override
            public void onMenuExpanded() {

            }

            @Override
            public void onMenuCollapsed() {

            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
