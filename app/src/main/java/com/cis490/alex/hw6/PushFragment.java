package com.cis490.alex.hw6;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseObject;

/**
 * Created by Alex on 11/23/2014.
 */
public class PushFragment extends Fragment {

    @Override
    public void onStart(){
        super.onStart();
        initControls();
    }

    private void initControls()
    {
        final Button button = (Button) getView().findViewById(R.id.btnPushSubmit);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                EditText editText = (EditText) getView().findViewById(R.id.pushText);
                String pushText = editText.getText().toString();

                ParseObject pushedText = new ParseObject("PushedText");
                pushedText.put("form1", pushText);
                pushedText.saveInBackground();
                Toast toast = Toast.makeText(getActivity(), "Text pushed to Parse.com", Toast.LENGTH_LONG);
                toast.show();
                ((EditText) getView().findViewById(R.id.pushText)).setText("");
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_push,container,false);

    }
}
