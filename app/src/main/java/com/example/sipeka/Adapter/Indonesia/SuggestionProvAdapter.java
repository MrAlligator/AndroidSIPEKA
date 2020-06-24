package com.example.sipeka.Adapter.Indonesia;

import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sipeka.Model.Indonesia.Provinsi;
import com.example.sipeka.Util.JsonParse;

import java.util.ArrayList;
import java.util.List;

public class SuggestionProvAdapter extends ArrayAdapter<String> {

    private static final String TAG = SuggestionProvAdapter.class.getSimpleName();
    private List<String> suggestionProv;
    Context mContext;

    public SuggestionProvAdapter(Activity context, String nameFilter){
        super(context, android.R.layout.simple_dropdown_item_1line);
        this.mContext = context;
        suggestionProv = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return suggestionProv.size();
    }

    @Nullable
    @Override
    public String getItem(int index) {
        return suggestionProv.get(index);
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
                    List<Provinsi> new_suggestion = jp.getParseJsonProv(constraint.toString());
                    suggestionProv.clear();
                    for (int i=0; i < new_suggestion.size(); i++){
                        suggestionProv.add(new_suggestion.get(i).getName());
                    }
                    filterResults.values = suggestionProv;
                    filterResults.count = suggestionProv.size();
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
