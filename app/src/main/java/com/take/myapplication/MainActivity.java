package com.take.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.take.myapplication.https.HttpsRequest;
import com.take.myapplication.interfacess.Consts;
import com.take.myapplication.interfacess.Helper;
import com.take.myapplication.model.DataDTO;
import com.take.myapplication.model.NameDTO;
import com.take.myapplication.model.RequestDTO;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    static List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;
    RecyclerView rvNames;
    private LayoutInflater myInflater;
    TextView fast, retrofit;
    JSONObject paramObject;
    HashMap<String ,String>parms= new HashMap<>();
    public static ArrayList<NameDTO> nameDTOS;
    LinearLayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myInflater = LayoutInflater.from(MainActivity.this);

        try {
            paramObject = new JSONObject();
            paramObject.put("serial_number", "");
            paramObject.put("imei_number", "");
            paramObject.put("type_name", "");
            paramObject.put("android_id", "3befcdff44932047");
            paramObject.put("type", "smartphone");

            parms.put("serial_number", "");
            parms.put("imei_number", "");
            parms.put("type_name", "");
            parms.put("android_id", "3befcdff44932047");
            parms.put("type", "smartphone");
        }
        catch (Exception e)
        {
            e.printStackTrace();


        }


        fast = (TextView) findViewById(R.id.tvFast);
        rvNames = (RecyclerView) findViewById(R.id.rvNames);
        retrofit = (TextView) findViewById(R.id.tvRetrofit);


        mLayoutManager = new LinearLayoutManager(MainActivity.this);
        rvNames.setLayoutManager(mLayoutManager);


        fast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });

        retrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getHeroes();
            }
        });

//



    }

    private void getData() {
        new HttpsRequest(Consts.API,parms,MainActivity.this).stringPost("TAG", new Helper() {
            @Override
            public void backResponse(boolean flag, String msg, JSONObject response) {
                try {
                    nameDTOS = new ArrayList<>();
                    Type getpetDTO = new TypeToken<List<NameDTO>>() {
                    }.getType();

                    nameDTOS = (ArrayList<NameDTO>) new Gson().fromJson(response.getJSONArray("data").toString(), getpetDTO);
                    Log.e("getDataTry", "backResponse: "+nameDTOS.get(0).getAction_name() );
                    Log.e("getDataTry", "backResponse: "+response );


                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("getDataCatch", "backResponse: "+e );
                }

                setSection();

            }
        });

    }

    private void setSection() {




        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
            expandableListView.setVisibility(View.VISIBLE);
            fast.setVisibility(View.GONE);
            retrofit.setVisibility(View.GONE);
        expandableListDetail = ExpandableListDataPump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());

        expandableListAdapter = new CustomExpandableListview(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);

        HashMap<String, List<String>> finalExpandableListDetail = expandableListDetail;
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        nameDTOS.get(groupPosition)
                                + " -> "
                                + nameDTOS.get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });
    }

    private void getHeroes() {

        RequestDTO requestDTO=new RequestDTO();
        requestDTO.setAndroid_id("3befcdff44932047");
        requestDTO.setImei_number("");
        requestDTO.setSerial_number("");
        requestDTO.setType("smartphone");
        requestDTO.setType_name("");





        Api api = APIClient.getClient().create(Api.class);



        Log.e("TAG", "getHeroes: "+paramObject.toString() );
        Call<ResponseBody> call = api.savePost(requestDTO);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("TAG", "onResponse: "+response );


                JSONObject object;
                try {
                    object = new JSONObject(response.body().string());
                    nameDTOS = new ArrayList<>();
                    Type getpetDTO = new TypeToken<List<NameDTO>>() {
                    }.getType();

                    nameDTOS = (ArrayList<NameDTO>) new Gson().fromJson(object.getJSONArray("data").toString(), getpetDTO);
                    setSection();
                } catch (Exception e) {
                    e.printStackTrace();
                }


                Toast.makeText(MainActivity.this, ""+response, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                Log.e("TAG", "onFailure: "+t.toString() );

            }


        });
    }


    public static class ExpandableListDataPump {
        public static HashMap<String, List<String>> getData() {
            HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();


            for(int i=0;i<nameDTOS.size();i++){
                expandableListTitle = new ArrayList<String>();

                for(int j=0;j<nameDTOS.get(i).getSection().size();j++){
                    expandableListTitle.add(nameDTOS.get(i).getSection().get(j).getTitle());

                }
                expandableListDetail.put(nameDTOS.get(i).getAction_name(), expandableListTitle);


            }



            return expandableListDetail;
        }
    }



}