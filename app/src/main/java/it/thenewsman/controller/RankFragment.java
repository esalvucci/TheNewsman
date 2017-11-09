package it.thenewsman.controller;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.imangazaliev.circlemenu.CircleMenu;
import com.imangazaliev.circlemenu.CircleMenuButton;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import it.thenewsman.R;
import it.thenewsman.controller.question.BooleanAnswerActivity;
import it.thenewsman.controller.question.MultipleAnswerActivity;
import it.thenewsman.controller.user.UserAdapter;
import it.thenewsman.model.Level;
import it.thenewsman.model.challenge.Challenge;
import it.thenewsman.model.challenge.UserChallenge;
import it.thenewsman.model.user.User;
import it.thenewsman.model.user.UserImpl;

public class RankFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private ListView mListView;
    private List<User> users = new LinkedList<>();

    public RankFragment() {
        // Required empty public constructor
    }

    public static RankFragment newInstance() {
        return new RankFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        User enrico = new UserImpl("Enrico", "https://pbs.twimg.com/profile_images/464390622820847616/ao7pTGUB_400x400.jpeg", 10, null);
        enrico.setLevel(Level.EDITORIALIST);

        User francesca = new UserImpl("Francesca", "https://0.academia-photos.com/41918860/11334377/12644318/s200_francesca.rissotto.jpg_oh_71db60db1ab08c646fcc89816b73bb43_oe_5743ceb7",
                7, null);
        francesca.setLevel(Level.REPORTER);

        this.users.add(enrico);
        this.users.add(francesca);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rank, container, false);

        ListAdapter userAdapter = new UserAdapter(this.users, this.getContext());

        mListView = (ListView) view.findViewById(R.id.rank);
        mListView.setAdapter(userAdapter);

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

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
