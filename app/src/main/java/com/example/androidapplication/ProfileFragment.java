package com.example.androidapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class ProfileFragment extends Fragment {

    private SecondActivity.Data datas;
    private FragmentManager manger;
    private TextView users, userage, userjob, userdesc,age;





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        users=view.findViewById(R.id.loginText);
        userage=view.findViewById(R.id.age);
        userdesc=view.findViewById(R.id.description);
        userjob=view.findViewById(R.id.setoccupation);

        users.setText(this.datas.user);
        userjob.setText(this.datas.work);
        userdesc.setText(this.datas.descrption);
        userage.setInputType(this.datas.ages);
        return view;
    }
    public void setData(SecondActivity.Data data){
        this.datas =data;
    }

}