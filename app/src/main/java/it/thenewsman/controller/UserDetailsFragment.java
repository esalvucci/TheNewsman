package it.thenewsman.controller;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import it.thenewsman.R;
import it.thenewsman.controller.challengeTypeCard.ChallengeTypeAdapter;
import it.thenewsman.controller.challengeTypeCard.GridSpacingItemDecoration;
import it.thenewsman.model.challenge.Challenge;
import it.thenewsman.model.dao.DAOFactory;
import it.thenewsman.model.user.User;
import it.thenewsman.model.user.UserDAO;

public class UserDetailsFragment extends Fragment {

    private User user;

    public UserDetailsFragment() {
        // Required empty public constructor
    }

    public static UserDetailsFragment newInstance() {
        return new UserDetailsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.DAOType.SQLITE);
        UserDAO userDAO = daoFactory.getUserDAO();
        this.user = userDAO.select();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_details, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        List<Challenge> challengeTypes = new LinkedList<>(this.user.getChallenges());
        RecyclerView.Adapter<ChallengeTypeAdapter.MyViewHolder> adapter =
                new ChallengeTypeAdapter(this.getContext(), challengeTypes);

        adapter.notifyDataSetChanged();

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this.getContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,
                this.getContext(), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
