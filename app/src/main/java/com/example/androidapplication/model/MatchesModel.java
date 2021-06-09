package com.example.androidapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

public class MatchesModel implements Parcelable {
    public String imageUrl;
    public boolean liked;
    public String uid;
    public String name;
    public String lat;
    public String longitude;
    public MatchesModel(){

    }

    public MatchesModel(String imageUrl, boolean liked, String name,String lat, String longitude){
        this.name = name;
        this.imageUrl = imageUrl;
        this.liked = liked;
        this.lat = lat;
        this.longitude = longitude;
    }
    public MatchesModel (Parcel in){
        name = in.readString();
        liked = in.readByte() !=0;
        imageUrl = in.readString();
        lat = in.readString();
        longitude = in.readString();
    }
    public String getName() {
        return name;
    }

    public String getUid() {
        return uid;
    }

    public static final Creator<MatchesModel> CREATOR = new Creator<MatchesModel>() {
        @Override
        public MatchesModel createFromParcel(Parcel in) {
            return new MatchesModel(in);
        }

        @Override
        public MatchesModel[] newArray(int size) {
            return new MatchesModel[size];
        }
    };


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeByte((byte) (liked ? 1 : 0));
        dest.writeString(imageUrl);
        dest.writeString(lat);
        dest.writeString(longitude);

    }
}
