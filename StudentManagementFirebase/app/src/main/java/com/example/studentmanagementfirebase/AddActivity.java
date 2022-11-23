package com.example.studentmanagementfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {

    EditText edtAddId, edtAddName, edtAddDescription, edtAddImage;
    Button btnAdd;
    ImageView  imvBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        initAddListener();
    }

    private void initAddListener() {
        btnAdd = findViewById(R.id.btnAdd);
        imvBack = findViewById(R.id.imvBack);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
                clearAll();
            }
        });

        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
//                onBackPressed();
            }
        });


    }

    private void insertData(){
        edtAddId = findViewById(R.id.edtAddId);
        edtAddName = findViewById(R.id.edtAddName);
        edtAddDescription = findViewById(R.id.edtAddDescription);
        edtAddImage = findViewById(R.id.edtAddImage);

        Map<String, Object> map = new HashMap<>();
        map.put("tenKhoaHoc", edtAddId.getText().toString());
        map.put("tenThuongGoi", edtAddName.getText().toString());
        map.put("dacTinh", edtAddDescription.getText().toString());
        map.put("hinhAnh", edtAddImage.getText().toString());


        FirebaseDatabase.getInstance().getReference().child("students").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                    Toast.makeText(AddActivity.this,     "Add student successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddActivity.this, "Error while insert data.", Toast.LENGTH_SHORT).show();
                    }
                });

    }

    private void clearAll(){

        edtAddId.setText("");
        edtAddName.setText("");
        edtAddDescription.setText("");
        edtAddImage.setText("");
    }





}