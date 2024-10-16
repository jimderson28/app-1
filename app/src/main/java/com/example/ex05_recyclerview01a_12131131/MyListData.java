package com.example.ex05_recyclerview01a_12131131;

import java.util.ArrayList;

public class MyListData {
    private String description;
    private int imgId;
    public MyListData(String description, int imgId){
        this.description=description;
        this.imgId=imgId;
    }
    public String getDescription(){return description;}
    public void setDescription(String description) {this.description = description;}
    public int getImgId(){return imgId; }
    public void setImgId(int imgId) {this.imgId = imgId; }

    public static ArrayList<MyListData> getMyListDataArrayList(){
        ArrayList<MyListData> mList = new ArrayList<>();
                mList.add ( new MyListData("Email", android.R.drawable.ic_dialog_email));
                mList.add ( new MyListData("Info", android.R.drawable.ic_dialog_info));
                mList.add(   new MyListData("Delete", android.R.drawable.ic_delete));
                mList.add(new MyListData("Dialer", android.R.drawable.ic_dialog_dialer));
                mList.add(new MyListData("Alert", android.R.drawable.ic_dialog_alert));
                mList.add(new MyListData("Map", android.R.drawable.ic_dialog_map));
                mList.add(new MyListData("Email", android.R.drawable.ic_dialog_email));
                mList.add(new MyListData("Info", android.R.drawable.ic_dialog_info));
                mList.add(new MyListData("Delete", android.R.drawable.ic_delete));
                mList.add(new MyListData("Dialer", android.R.drawable.ic_dialog_dialer));
                mList.add(new MyListData("Alert", android.R.drawable.ic_dialog_alert));
                mList.add (new MyListData("Map", android.R.drawable.ic_dialog_map));
        return mList;
    }
    public static MyListData[] getMyListDataArray(){
        MyListData[] myListData = new MyListData[]{
                new MyListData("Email", android.R.drawable.ic_dialog_email),
                new MyListData("Info", android.R.drawable.ic_dialog_info),
                new MyListData("Delete", android.R.drawable.ic_delete),
                new MyListData("Dialer", android.R.drawable.ic_dialog_dialer),
                new MyListData("Alert", android.R.drawable.ic_dialog_alert),
                new MyListData("Map", android.R.drawable.ic_dialog_map),
                new MyListData("Email", android.R.drawable.ic_dialog_email),
                new MyListData("Info", android.R.drawable.ic_dialog_info),
                new MyListData("Delete", android.R.drawable.ic_delete),
                new MyListData("Dialer", android.R.drawable.ic_dialog_dialer),
                new MyListData("Alert", android.R.drawable.ic_dialog_alert),
                new MyListData("Map", android.R.drawable.ic_dialog_map),
        };
        return myListData;
    }
}
