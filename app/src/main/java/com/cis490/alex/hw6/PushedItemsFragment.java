package com.cis490.alex.hw6;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Alex on 11/23/2014.
 */
public class PushedItemsFragment extends Fragment {

    private ParseQueryAdapter<ParseObject> mainAdapter;
    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart(){
        super.onStart();
        fillList();
    }

    private void fillList()
    {
        mainAdapter = new ParseQueryAdapter<ParseObject>(getActivity(), "PushedText");
        mainAdapter.setTextKey("form1");

        listView = (ListView) getView().findViewById(R.id.listView);
        listView.setAdapter(mainAdapter);
        mainAdapter.loadObjects();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_pushed_list,container,false);
    }
}
