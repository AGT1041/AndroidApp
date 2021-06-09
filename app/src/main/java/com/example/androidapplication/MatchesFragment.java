package com.example.androidapplication;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidapplication.model.MatchesModel;
import com.example.androidapplication.viewmodel.MatchesViewModel;

import java.util.ArrayList;
public class MatchesFragment extends Fragment {
    private static final String ARG_COLUMN_COUNT = "column-count";
    static final String ARG_DATA_SET = "data-set";
    MatcheDatas matchesData;
    View v;
    RecyclerView recycler;
    Float maxRange = 14423.64f;
    public ArrayList matches=new ArrayList();
    public MatchesViewModel mviewModel=new MatchesViewModel();
    private FragmentManager manager;
    private ArrayList<String>  names;
    LocationManager locationManager;
    Location userlocation;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            matches = getArguments().getParcelableArrayList(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_matches, container, false);

        locationManager = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);
        userlocation = new Location(LocationManager.GPS_PROVIDER);

        recycler = v.findViewById(R.id.recycler_view);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
        MatchesCardRecyclerViewAdapter adapter = new MatchesCardRecyclerViewAdapter(matches);
       // List<MatcheDatas> matchesDataList = new ArrayList<>();



        //getMatches();
       // updateGps(v);





        recycler.setAdapter(adapter);
        //recyclerView.addItemDecoration
        mviewModel.getMatche(
                (ArrayList<MatchesModel> m)-> {

                    adapter.setMatches(m);
                    adapter.notifyDataSetChanged();
                   // for (int i = 0; i < matches.size(); i++) {
                  //  names.add(m.get(i).name);

                }//}
        );

        return v;
    }
    @Override
    public void onPause() {
        mviewModel.clear();
        super.onPause();
    }
    private boolean isLocationEnabled() {
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }
    private boolean checkLocation() {
        if(!isLocationEnabled()) {
            showAlert();
        }
        return isLocationEnabled();
    }

    private void showAlert() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(this.getContext());
        dialog.setTitle(R.string.allow_location)
                .setMessage(getString(R.string.location_message))
                .setPositiveButton(R.string.location_settings, (paramDialogInterface, paramInt) -> {
                    Intent myIntent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivity(myIntent);
                })
                .setNegativeButton(R.string.location_cancel, (paramDialogInterface, paramInt) -> {
                });
        dialog.show();
    }

    public void updateGps(View view) {
        if(!checkLocation()) {
            return;
        }
        if (ActivityCompat.checkSelfPermission(this.getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60 * 1000, 10, locationListener);
        }
    }
    private final LocationListener locationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            userlocation.setLatitude(location.getLatitude());
            userlocation.setLongitude(location.getLongitude());
            getMatches();
        }

    };
    public void getMatches() {
        mviewModel.getMatche(
                (ArrayList<MatchesModel> matches) -> {
                    ArrayList<MatchesModel> pastMax = new ArrayList<>();
                    float[] distance = new float[1];
                    for(MatchesModel match : matches){
                        Location.distanceBetween(Double.parseDouble(match.lat), Double.parseDouble(match.longitude), userlocation.getLatitude(), userlocation.getLongitude(), distance);
                        if(distance[0] > maxRange){
                            pastMax.add(match);
                        }
                    }
                    matches.removeAll(pastMax);

                });
    }
}