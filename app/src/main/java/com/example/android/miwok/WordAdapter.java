package com.example.android.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

public WordAdapter(Activity context, ArrayList<Word> words, int ColorResourceId) {
    super(context, 0, words);
    mColorResourceId = ColorResourceId;
}

@NonNull
@Override
public View getView(int position, View convertView, ViewGroup parent) {
    View listItemView = convertView;
    if (listItemView == null) {
        listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

    Word currentWord = getItem(position);

    TextView miwokTextView = listItemView.findViewById(R.id.miwok_text_view);
    miwokTextView.setText(currentWord.getMiwokTranslation());

    TextView defaultTextView = listItemView.findViewById(R.id.default_text_view);
    defaultTextView.setText(currentWord.getDefaultTranslation());

    ImageView image = listItemView.findViewById(R.id.image);
    if (currentWord.hasImage()) {
        image.setImageResource(currentWord.getImageResourceId());
        image.setVisibility(View.VISIBLE);
    } else {
        image.setVisibility(View.GONE);
    }

    View textContainer = listItemView.findViewById(R.id.text_container);
    textContainer.setBackgroundResource(mColorResourceId);

    return listItemView;
    }
}