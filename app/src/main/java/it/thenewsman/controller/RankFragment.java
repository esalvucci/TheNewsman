package it.thenewsman.controller;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

import it.thenewsman.R;
import it.thenewsman.controller.user.UserAdapter;
import it.thenewsman.model.user.User;

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

        DAOFactory daoFactory = DAOFactory.getDaoFactory(DAOFactory.DAOType.SQLITE);
        this.users.addAll(daoFactory.getUserDAO().selectMany());

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
