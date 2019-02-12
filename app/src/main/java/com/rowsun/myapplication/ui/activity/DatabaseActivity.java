package com.rowsun.myapplication.ui.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.rowsun.myapplication.R;
import com.rowsun.myapplication.database.DatabaseHandler;
import com.rowsun.myapplication.model.User;
import com.rowsun.myapplication.ui.adapter.AdapterUser;

import java.util.ArrayList;
import java.util.List;

public class DatabaseActivity extends AppCompatActivity {
    DatabaseHandler databaseHandler;
    RecyclerView rvData;
    List<User> userList;
    AdapterUser adapterUser;
    TextInputLayout tlText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        databaseHandler = new DatabaseHandler(this);
        tlText = findViewById(R.id.tl_text);
        rvData = findViewById(R.id.rv_data);
        // LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
        //  StaggeredGridLayoutManager layoutManager= new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int i) {
                return 2;
            }
        });
//        Realm.init(this);
//        RealmConfiguration config = new RealmConfiguration.Builder()
//                .name(Realm.DEFAULT_REALM_NAME)
//                .deleteRealmIfMigrationNeeded()
//                .schemaVersion(4)
//                .build();
       // Realm.setDefaultConfiguration(config);
      //  Realm m =  Realm.getInstance(config);

//        m.executeTransactionAsync(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                RealmMyTable t = realm.createObject(RealmMyTable.class, "1");
//                t.setName("nsdnsds");
//                t.setAdd("nsdnsds");
//            }
//        }, new Realm.Transaction.OnSuccess() {
//            @Override
//            public void onSuccess() {
//
//            }
//        });





        rvData.setLayoutManager(layoutManager);
        userList = new ArrayList<>();
        adapterUser = new AdapterUser(this, userList);
        rvData.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rvData.setAdapter(adapterUser);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User("Roshan", "rrijal", "abc");
                long i = databaseHandler.insertUser(user);
                userList.add(user);
                adapterUser.notifyDataSetChanged();
                tlText.setError("invalid input");
              //  new ExampleDialogFragment().show(getSupportFragmentManager(), "tag");
                Toast t = Toast.makeText(DatabaseActivity.this, "Tetet", Toast.LENGTH_LONG);
                t.getView().setBackgroundColor(getResources().getColor(R.color.colorAccent));

                t.show();

                startActivity(new Intent(DatabaseActivity.this, ContentProvidersActivity.class));
               // new GreenToast(DatabaseActivity.this, "HELOOOO").show();
             //   GreenToast.makeText(DatabaseActivity.this, "heeelee", Toast.LENGTH_LONG).show();
            }
        });
        findViewById(R.id.btn_update)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        User user = new User("Roshan Rijal", "rrijal", "abc");
                        user.setId(1);

                        databaseHandler.updateUser(user);
                        Toast toast = new Toast(getApplicationContext());
                        toast.setView(LayoutInflater.from(getApplicationContext()).inflate(R.layout.row_news, null));
                        toast.setDuration(Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0,0);
                        toast.show();
                    }
                });


        findViewById(R.id.btn_delete)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //  User  user = new User("Roshan Rijal", "rrijal", "abc");
                        //user.setId(1);
                        databaseHandler.deleteUser("2");
                    }
                });

        findViewById(R.id.btn_get).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<User> list = databaseHandler.getUserList();
//                for (User s : list) {
                Log.d("TAG", "LIST  " + list.size());
//                }
                userList = list;
                adapterUser = new AdapterUser(DatabaseActivity.this, userList);
                rvData.setAdapter(adapterUser);
                // adapterUser.notifyDataSetChanged();
            }
        });
        new CountDownTimer(654564544, 60 * 1000) {

            @Override
            public void onTick(long l) {
                Log.d("tag", "onTick: " + l);
            }

            @Override
            public void onFinish() {

            }
        }.start();

    }


}
