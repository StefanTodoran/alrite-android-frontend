package com.ug.air.alrite.Fragments.Patient;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.ug.air.alrite.R;

import java.util.Objects;

public class Fragment1 extends Fragment {

    View view;
    Button back, next;
    RadioGroup radioGroup;
    RadioButton radioButton1, radioButton2;
    String value = "none";
    private static final int YES = 0;
    private static final int NO = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_1, container, false);

        next = view.findViewById(R.id.next);
        radioGroup = view.findViewById(R.id.radioGroup);
        radioButton1 = view.findViewById(R.id.yes);
        radioButton2 = view.findViewById(R.id.no);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = radioGroup.findViewById(checkedId);
                int index = radioGroup.indexOfChild(radioButton);

                switch (index) {
                    case YES:
                        value = "Yes";
                        break;
                    case NO:
                        value = "No";
                        break;

                    default:
                        break;
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (value.equals("Yes")) {
                    FragmentTransaction fr = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
                    fr.replace(R.id.fragment_container, new Fragment2v1());
                    fr.addToBackStack(null);
                    fr.commit();

                } else if (value.equals("No")){
                    FragmentTransaction fr = Objects.requireNonNull(getActivity()).getSupportFragmentManager().beginTransaction();
                    fr.replace(R.id.fragment_container, new Fragment2());
                    fr.addToBackStack(null);
                    fr.commit();

                } else {
                    Toast.makeText(getActivity(), "Please Select one option", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
}