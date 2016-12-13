package com.ali.android.fragementapp;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendFragment extends Fragment {


    public FriendFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        MyLog.myPrint("FriendFragment->onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyLog.myPrint("FriendFragment->onCreate");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MyLog.myPrint("FriendFragment->onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        MyLog.myPrint("FriendFragment->onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        MyLog.myPrint("FriendFragment->onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        MyLog.myPrint("FriendFragment->onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        MyLog.myPrint("FriendFragment->onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MyLog.myPrint("FriendFragment->onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        MyLog.myPrint("FriendFragment->onDestroyView");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        MyLog.myPrint("FriendFragment->onDetach");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        MyLog.myPrint("FriendFragment->onSaveInstanceState");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View view = inflater.inflate(R.layout.activity_tab_friend, container, false);
        MyLog.myPrint("FriendFragment->onCreateView");
        return view;

    }

}
