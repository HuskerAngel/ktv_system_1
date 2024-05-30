package com.example.ktv_system.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.ktv_system.dao.GequfenleiProduct;
import com.example.ktv_system.dao.GexingProduct;
import com.example.ktv_system.R;
import com.example.ktv_system.adapter.GequfenleiAdapter;
import com.example.ktv_system.adapter.GexingAdapter;
import com.example.ktv_system.sqlite.MyDatabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {
    private Button mbtfadanmu;
    private Button mbtfazhufu;
    private GridView mgvgequ_mingdan;
    private ListView mlvgexing_mingdan;
    private List<GequfenleiProduct> gequfenleilist;
    private List<GexingProduct> gexinglist;
    private Button mbtsousuo;
    private EditText met;
    private GequfenleiAdapter gequfenleiAdapter;
    private RadioGroup mrg;
    private RadioButton mrb1,mrb2;

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
        mbtsousuo = view.findViewById(R.id.sousuo_btn);
        met = view.findViewById(R.id.sousuo);
        mgvgequ_mingdan = view.findViewById(R.id.gequ_mingdan);
        mlvgexing_mingdan = view.findViewById(R.id.gexing_mingdan);
        mrg = view.findViewById(R.id.radiogroup);
        mrb1 = view.findViewById(R.id.radiobutton1);
        mrb2 = view.findViewById(R.id.radiobutton2);
        mrb1.setChecked(true);
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

        initGequfenleiProduct();
//        initGexingProduct();
        MyDatabaseHelper myDatabaseHelper = new MyDatabaseHelper(getContext());
        gequfenleiAdapter = new GequfenleiAdapter(this.gequfenleilist,getContext());
        gexinglist = new ArrayList<>();
        gexinglist = myDatabaseHelper.getAllGexingProduct();
        GexingAdapter gexingAdapter = new GexingAdapter(myDatabaseHelper.getAllGexingProduct(),getContext());
//        GexingAdapter gexingAdapter = new GexingAdapter(this.gexinglist,getContext());
        mgvgequ_mingdan.setAdapter(gequfenleiAdapter);
        mlvgexing_mingdan.setAdapter(gexingAdapter);

        mrb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mgvgequ_mingdan.setVisibility(View.VISIBLE);
                    mlvgexing_mingdan.setVisibility(View.GONE);
                }
            }
        });
        mrb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mgvgequ_mingdan.setVisibility(View.GONE);
                    mlvgexing_mingdan.setVisibility(View.VISIBLE);
                }
            }
        });
        mrg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = mrg.findViewById(checkedId);
                String string = radioButton.getText().toString();
                switch (string){
                    case "歌星列表":
                        mgvgequ_mingdan.setVisibility(View.GONE);
                        mlvgexing_mingdan.setVisibility(View.VISIBLE);
                        break;
                    case "歌曲分类":
                        mgvgequ_mingdan.setVisibility(View.VISIBLE);
                        mlvgexing_mingdan.setVisibility(View.GONE);
                }
            }
        });
        mgvgequ_mingdan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intenttomusiclist = new Intent();
                Bundle musiclistbundle = new Bundle();
                musiclistbundle.putString("分类",gequfenleilist.get(position).getTitle());
                intenttomusiclist.putExtra("extra",musiclistbundle);
                intenttomusiclist.setAction("歌曲列表");
                intenttomusiclist.addCategory(Intent.CATEGORY_DEFAULT);
                startActivity(intenttomusiclist);
            }
        });

        mlvgexing_mingdan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intenttogexingxinxi = new Intent();
                Bundle gexingxinxibundle = new Bundle();
                gexingxinxibundle.putString("歌手名",gexinglist.get(position).getTitle());
                gexingxinxibundle.putString("歌手图片",gexinglist.get(position).getImg());
                intenttogexingxinxi.putExtra("extra",gexingxinxibundle);
                intenttogexingxinxi.setAction("歌星曲目列表");
                intenttogexingxinxi.addCategory(Intent.CATEGORY_DEFAULT);
                startActivity(intenttogexingxinxi);
            }
        });


        met.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_SEARCH){
                    Intent intenttosousuo = new Intent();
                    Bundle sousuobundle = new Bundle();
                    sousuobundle.putString("搜索内容",met.getText().toString());
                    intenttosousuo.putExtra("extra",sousuobundle);
                    intenttosousuo.setAction("搜索");
                    intenttosousuo.addCategory(Intent.CATEGORY_DEFAULT);
                    startActivity(intenttosousuo);
                }
                return false;
            }
        });
        mbtsousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenttosousuo = new Intent();
                Bundle sousuobundle = new Bundle();
                sousuobundle.putString("搜索内容",met.getText().toString());
                intenttosousuo.putExtra("extra",sousuobundle);
                intenttosousuo.setAction("搜索");
                intenttosousuo.addCategory(Intent.CATEGORY_DEFAULT);
                startActivity(intenttosousuo);
            }
        });
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

    }
    private void initGequfenleiProduct(){
        gequfenleilist = new ArrayList<>();
        gequfenleilist.add(new GequfenleiProduct(R.drawable.folk,"民谣"));
        gequfenleilist.add(new GequfenleiProduct(R.drawable.rock,"摇滚"));
        gequfenleilist.add(new GequfenleiProduct(R.drawable.west,"欧美"));
        gequfenleilist.add(new GequfenleiProduct(R.drawable.pop,"流行"));

    }
    private void initGexingProduct(){
        gexinglist = new ArrayList<>();
        gexinglist.add(new GexingProduct("sample6.png","民谣"));
        gexinglist.add(new GexingProduct("sample5.png","摇滚"));
        gexinglist.add(new GexingProduct("sample7.png","欧美"));
        gexinglist.add(new GexingProduct("sample8.png","流行"));

    }

    @Override
    public void onResume() {
        super.onResume();

        gequfenleiAdapter.notifyDataSetChanged();


    }
}