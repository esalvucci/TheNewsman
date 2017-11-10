package it.thenewsman.controller.user;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import it.thenewsman.R;
import it.thenewsman.controller.user.avatar.CircleTransform;
import it.thenewsman.model.user.User;

/**
 * Created by enrico on 11/8/17.
 */

public class UserAdapter extends ArrayAdapter<User> {

        private List<User> dataSet;
        Context mContext;

        // View lookup cache
        private static class ViewHolder {
            TextView name;
            TextView points;
            TextView level;
            ImageView avatar;
        }

        public UserAdapter(List<User> data, Context context) {
            super(context, R.layout.user_row_item, data);
            this.dataSet = data;
            this.mContext=context;

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            User dataModel = this.dataSet.get(position);
            // Check if an existing view is being reused, otherwise inflate the view
            ViewHolder viewHolder; // view lookup cache stored in tag

            final View result;

            if (convertView == null) {

                viewHolder = new ViewHolder();
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.user_row_item, parent, false);
                viewHolder.name = (TextView) convertView.findViewById(R.id.rank_name);
                viewHolder.points = (TextView) convertView.findViewById(R.id.rank_points);
                viewHolder.level = (TextView) convertView.findViewById(R.id.rank_level);
                viewHolder.avatar = (ImageView) convertView.findViewById(R.id.rank_avatar);

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            Glide.with(getContext())
                    .load(Uri.parse(dataModel.getAvatar()))
                    .placeholder(R.drawable.ic_person_24dp)
                    .bitmapTransform(new CircleTransform(getContext()))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(viewHolder.avatar);

            viewHolder.name.setText(dataModel.getName());
            viewHolder.points.setText(String.valueOf(dataModel.getPoints()) + " punti");
            viewHolder.level.setText(dataModel.getLevel().getName());

            return convertView;
        }

}
