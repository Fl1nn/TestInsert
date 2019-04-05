package com.example.testrealtimedatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    EditText txtname,txtheight,txtphone,txtage;
    Button btnsave;
    Member member;
    DatabaseReference myRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // FirebaseApp.initializeApp(this);
        setContentView(R.layout.activity_main);
        txtage = (EditText) findViewById(R.id.txtage);
        txtname = (EditText) findViewById(R.id.txtname);
        txtphone = (EditText) findViewById(R.id.txtphone);
        txtheight = (EditText) findViewById(R.id.txtheight);
        btnsave = (Button) findViewById(R.id.btnsave);
        member = new Member("linh",10,"01323236",10);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");

        myRef.setValue("Hello3, World!");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                myRef = database.getReference("message");
                MainActivity.this.myRef.setValue("Hello4, World!");
                String value = dataSnapshot.getValue(String.class);
                Log.e("check", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.e("check", "Failed to read value.", error.toException());
            }
        });
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference("Member");

       // DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users");
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users");

// Creating new user node, which returns the unique key value
// new user node would be /users/$userid/
        String userId = mDatabase.push().getKey();

// creating user object

// pushing user to 'users' node using the userId

        mDatabase.child(userId).setValue(member);
        Log.e("check","ok");
//        myRef.setValue("Hello, World!");
//        dtb = FirebaseDatabase.getInstance().getReference().child("Member");
//        btnsave.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                int age= Integer.parseInt(txtage.getText().toString().trim());
////                float hei = Float.parseFloat(txtheight.getText().toString().trim());
////                Long phone = Long.parseLong(txtphone.getText().toString().trim());
////                String name = txtname.getText().toString().trim();
////                member.setAge(age);
////                member.setHeight(hei);
////                member.setName(name);
////                member.setPhone(phone);
////                MainActivity.this.myRef.push().setValue(member);
////                Log.e("check","ok");
////            }
////        });

    }
}
