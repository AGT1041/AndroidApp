package com.example.androidapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.androidapplication.entity.Settings;
import com.example.androidapplication.viewmodel.SettingsViewModel;

import java.util.List;


public class SettingFragment extends Fragment implements View.OnClickListener {


    private Spinner reminder;
    private Spinner maxdis;
    private Button save;
    private Spinner minAge;
    private Spinner maxAge;
    private Spinner gender;
    private CheckBox privateAcct;
    private SettingsViewModel settingVModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView (@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);
        save = (Button) view.findViewById(R.id.SaveSettings);
        save.setOnClickListener(this);

        reminder = view.findViewById(R.id.time_seter);
        maxdis = view.findViewById(R.id.editTextMaxDistance);
        gender = view.findViewById(R.id.gender);
        privateAcct = view.findViewById(R.id.acct_checkbox);
        minAge = view.findViewById(R.id.editTextMinAge);
        maxAge = view.findViewById((R.id.editTextMaxAge));

         settingVModel = new ViewModelProvider(this).get(SettingsViewModel.class);

        final Observer<List<Settings>> getSettingsObserver = settings -> { ;
            if (settings == null || settings.size() <= 0) {
                return;
            }

            Settings set = settings.get(settings.size()-1);

            if (set == null) {
                return;
            }

            reminder.setSelection(set.getReminderTime());
            maxdis.setSelection(set.getMaxDist());
            gender.setSelection(getIndex(gender,set.getGender()));
            privateAcct.setChecked(set.isPrivateAcct());
            minAge.setSelection(set.getMinAge());
            maxAge.setSelection(set.getMaxAge());

        };

        settingVModel.loadSettings(this.getContext()).observe(this.getViewLifecycleOwner(), getSettingsObserver);

        return view;
    }
    public void saveSettings(View view) {
        Settings setts = new Settings();
        setts.setReminderTime(reminder.getSelectedItemPosition());
        setts.setMaxDist(maxdis.getSelectedItemPosition());
        setts.setGender(gender.getSelectedItem().toString());
        setts.setPrivateAcct(privateAcct.isChecked());
        setts.setMinAge(minAge.getSelectedItemPosition());
        setts.setMaxAge(maxAge.getSelectedItemPosition());
        //minAge.setText(String.valueOf(sett.setMaxDist()));


        settingVModel.saveSettings (this.getContext(),setts);
        Toast.makeText(getActivity(), "changed saved", Toast.LENGTH_SHORT).show();
    }
    private int getIndex(Spinner spinner, String myString){
        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)){
                return i;
            }
        }

        return 0;
    }




    @Override
    public void onClick(View v) {
        saveSettings(v);
    }
}