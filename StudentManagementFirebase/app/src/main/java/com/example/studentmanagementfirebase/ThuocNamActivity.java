package com.example.studentmanagementfirebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class ThuocNamActivity extends AppCompatActivity {
    RecyclerView rcv;
    ThuocAdaper thuocNamAdapter;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thuocnam);

        initView();
        initListener();
    }


    private void initView(){
        rcv  = findViewById(R.id.rcv);

        rcv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));

        FirebaseRecyclerOptions<ThuocNam> options =
                new FirebaseRecyclerOptions.Builder<ThuocNam>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("thuocNam"), ThuocNam.class)
                        .build();

        thuocNamAdapter = new ThuocAdaper(options);
        rcv.setAdapter(thuocNamAdapter);
    }



    private void initListener() {
        floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AddActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        thuocNamAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        thuocNamAdapter.stopListening();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search, menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                txtSearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                txtSearch(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private  void txtSearch(String str){
        FirebaseRecyclerOptions<ThuocNam> options =
                new FirebaseRecyclerOptions.Builder<ThuocNam>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("thuocNam").orderByChild("tenThuongGoi").startAt(str).endAt(str + "~"), ThuocNam.class)
                        .build();


        thuocNamAdapter = new ThuocAdaper(options);
        thuocNamAdapter.startListening();
        rcv.setAdapter(thuocNamAdapter);

    }
}