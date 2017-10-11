package com.example.android.newsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mj0o0oD on 10/10/2017.
 */

public class StoryAdapter extends ArrayAdapter<Story> {


    private static final String Date_SEPARATOR = "T";
    private static final String Time_SEPARATOR = "Z";

    /**
     * Constructs a new {@link StoryAdapter}.
     *
     * @param context of the app
     * @param stories is the list of stories, which is the data source of the adapter
     */
    public StoryAdapter(Context context, ArrayList<Story> stories) {
        super(context, 0, stories);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = LayoutInflater.from(getContext()).inflate(R.layout.story_item, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        // Find the story at the given position
        Story currentStory = getItem(position);

        // Display the type of the current story in that TextView
        holder.typeTextView.setText(currentStory.getType());

        // Display the title of the current story in that TextView
        holder.titleTextView.setText(currentStory.getTitle());

        if (currentStory.hasAuthor()) {
            // Get author name and concat it  with "by" word
            String allAuthors = "by " + String.valueOf(currentStory.getAuthorName());
            // Display the author of the current story in that TextView
            holder.authorsTextView.setText(allAuthors);
        } else {
            // hide the story author name of the current story in that TextView
            holder.authorsTextView.setVisibility(View.GONE);
        }

        String publicationDate = currentStory.getPublicationDate();

        if(publicationDate.contains(Date_SEPARATOR)){
            String[] splitPublicationDate = publicationDate.split(Date_SEPARATOR);
            holder.dateTextView.setText(splitPublicationDate[0]);

            if(splitPublicationDate[1].contains(Time_SEPARATOR)){
                String[] splitPublicationTime = splitPublicationDate[1].split(Time_SEPARATOR);
                holder.timeTextView.setText(splitPublicationTime[0]);
            }

        }

        // Return the view that is now showing the appropriate data
        return view;
    }

    static class ViewHolder {
        @BindView(R.id.type_text_view) TextView typeTextView;
        @BindView(R.id.title_text_view) TextView titleTextView;
        @BindView(R.id.authors_text_view) TextView authorsTextView;
        @BindView(R.id.date) TextView dateTextView;
        @BindView(R.id.time) TextView timeTextView;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
