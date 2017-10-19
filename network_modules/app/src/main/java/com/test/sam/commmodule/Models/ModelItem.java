package com.test.sam.commmodule.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sam on 7/3/17.
 */

public class ModelItem implements Parcelable{

    public ModelItem () {}

    protected ModelItem (Parcel in){

        id = in.readString();
        name = in.readString();
        descrpition = in.readString();
    }

    public static final Creator<ModelItem> CREATOR = new Creator<ModelItem>() {

        @Override
        public ModelItem createFromParcel(Parcel source) {
            return new ModelItem(source);
        }

        @Override
        public ModelItem[] newArray(int size) {
            return new ModelItem[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescrpition() {
        return descrpition;
    }

    public void setDescrpition(String descrpition) {
        this.descrpition = descrpition;
    }

    private String id;
    private String name;
    private String descrpition;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(descrpition);
    }
}
