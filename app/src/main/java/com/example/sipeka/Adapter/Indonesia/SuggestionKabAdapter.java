package com.example.sipeka.Adapter.Indonesia;

import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sipeka.Model.Indonesia.Kabupaten;
import com.example.sipeka.Util.JsonParse;

import java.util.ArrayList;
import java.util.List;

public class SuggestionKabAdapter extends ArrayAdapter<String> {

    private static final String TAG = SuggestionKabAdapter.class.getSimpleName();
    private List<String> suggestKab;
    String namaProv;
    Context mContext;

    public SuggestionKabAdapter(Activity context, String namaProv, String namaFilter){
        super(context, android.R.layout.simple_dropdown_item_1line);
        this.mContext = context;
        suggestKab = new ArrayList<>();
        this.namaProv = namaProv;
    }

    @Override
    public int getCount() {
        return suggestKab.size();
    }

    @Nullable
    @Override
    public String getItem(int index) {
        return suggestKab.get(index);
    }

    @NonNull
    @Override
    public Filter getFilter() {
        Filter myFilter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                JsonParse jp = new JsonParse(mContext);
                if (constraint != null){
                    List<Kabupaten> new_suggestion = jp.getParseJsonKab(constraint.toString());
                    suggestKab.clear();
                    for (int i=0; i<new_suggestion.size(); i++){
                        suggestKab.add(new_suggestion.get(i).getName());
                    }

                    filterResults.values = suggestKab;
                    filterResults.count = suggestKab.size();
                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results != null && results.count > 0){
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }
        };

        return myFilter;
    }

}
