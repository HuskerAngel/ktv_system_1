package com.example.ktv_system.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import com.example.ktv_system.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {
    private Button mbtfadanmu;
    private Button mbtfazhufu;
    private Button mbtgequfenlei;
    private Button mbtgexing;
    private Button mbtyaokong;
    private Button mbtdiange;

    private GridView mlvgequ_mingdan;
    private ListView mgvgexing_mingdan;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment mainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mbtfadanmu = view.findViewById(R.id.fadanmu);
        mbtfazhufu = view.findViewById(R.id.fazhufu);
        mbtgequfenlei = view.findViewById(R.id.gequfenlei);
        mbtgexing = view.findViewById(R.id.gexing);
        mbtyaokong = view.findViewById(R.id.yaokong);
        mbtdiange = view.findViewById(R.id.diange);
        mlvgequ_mingdan = view.findViewById(R.id.gequ_mingdan);
        mgvgexing_mingdan = view.findViewById(R.id.gexing_mingdan);
        Intent intentfadanmu = new Intent();
        Intent intentfazhufu = new Intent();
        Intent intentyaokong = new Intent();
        Intent intentdiange = new Intent();
        intentfadanmu.setAction("redirecttofadanmu");
        intentfadanmu.addCategory(Intent.CATEGORY_DEFAULT);
        intentfazhufu.setAction("redirecttofazhufu");
        intentfazhufu.addCategory(Intent.CATEGORY_DEFAULT);
        intentyaokong.setAction("redirecttoyaokong");
        intentyaokong.addCategory(Intent.CATEGORY_DEFAULT);
        intentdiange.setAction("redirecttodiange");
        intentdiange.addCategory(Intent.CATEGORY_DEFAULT);
        mbtfadanmu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentfadanmu);
            }
        });
        mbtfazhufu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentfazhufu);
            }
        });
        mbtyaokong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentyaokong);
            }
        });
        mbtdiange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentdiange);
            }
        });
        mbtgequfenlei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mbtgexing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}