package it.thenewsman.controller.challengeTypeCard;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import it.thenewsman.R;
import it.thenewsman.model.challenge.Challenge;

/**
 * Created by Ravi Tamada on 18/05/16.
 */
public class ChallengeTypeAdapter extends RecyclerView.Adapter<ChallengeTypeAdapter.MyViewHolder> {

    private Context mContext;
    private List<Challenge> challengeTypes;

    public ChallengeTypeAdapter(Context mContext, List<Challenge> challengeTypes) {
        this.mContext = mContext;
        this.challengeTypes = challengeTypes;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.challenge_type_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Challenge c = challengeTypes.get(position);
        Resources resources = mContext.getResources();
        holder.title.setText(resources.getText(c.getLabel()));

        // loading user avatar using Glide library
        Glide.with(mContext).load(c.getBadge())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(holder.card_thumbnail);
    }

    @Override
    public int getItemCount() {
        return challengeTypes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private ImageView card_thumbnail;

        private MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.card_title);
            card_thumbnail = (ImageView) view.findViewById(R.id.card_thumbnail);
        }
    }

}