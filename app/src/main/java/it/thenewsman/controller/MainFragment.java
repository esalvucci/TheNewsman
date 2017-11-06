package it.thenewsman.controller;

import android.animation.StateListAnimator;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ListView;

import com.imangazaliev.circlemenu.CenterMenuButton;
import com.imangazaliev.circlemenu.CircleMenu;
import com.imangazaliev.circlemenu.CircleMenuButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import it.thenewsman.R;
import it.thenewsman.controller.challengeTypeCard.ChallengeTypeAdapter;
import it.thenewsman.controller.challengeTypeCard.GridSpacingItemDecoration;
import it.thenewsman.model.challenge.Challenge;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private ListView mListView;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        final CircleMenu circleMenu = (CircleMenu) view.findViewById(R.id.circleMenu);

        final Intent intent = new Intent(getContext(), BooleanQuestionActivity.class);

        circleMenu.setOnItemClickListener(new CircleMenu.OnItemClickListener() {
            @Override
            public void onItemClick(CircleMenuButton menuButton) {

                switch (menuButton.getId()) {
                    case R.id.title :
                        intent.putExtra("ChallengeIntent", Challenge.TITLE);
                        break;
                    case R.id.photo :
                        intent.putExtra("ChallengeIntent", Challenge.PHOTO);
                        break;
                    case R.id.url :
                        intent.putExtra("ChallengeIntent", Challenge.URL);
                        break;
                    case R.id.source :
                        intent.putExtra("ChallengeIntent", Challenge.SOURCE);
                        break;
                    case R.id.bonus :
                        intent.putExtra("ChallengeIntent", Challenge.BONUS);
                        break;

                    default:
                        break;
                }

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
