package com.example.securityclearance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class SecurityClearance extends AppCompatActivity {

    TcpClient mclient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_clearance);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference id_ref = database.getReference("id");
        DatabaseReference name_ref= database.getReference("name");
        DatabaseReference birthday_ref=database.getReference("birthday");
        DatabaseReference area_ref=database.getReference("area");



        id_ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Integer value = dataSnapshot.getValue(Integer.class);
                messageReceived(value.toString());
              //  Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
               // Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        name_ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                messageReceived(value);
                //  Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                // Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        birthday_ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                messageReceived(value);
                //  Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                // Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        area_ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                messageReceived(value);
                //  Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                // Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


       // RelativeLayout rl=(RelativeLayout)findViewById(R.id.RF_ID);

        //ScrollView sv = new ScrollView(this);
        //ScrollView sv= (ScrollView)findViewById(R.id.scroll);

        //sv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
        //LinearLayout ll = new LinearLayout(this);
        //ll.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
        //ll.setOrientation(LinearLayout.VERTICAL);
        //sv.addView(ll);
        //LinearLayout l1=(LinearLayout)findViewById(R.id.lin);
        //AppCompatTextView tex = new AppCompatTextView(this);
        //tex.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT));
        //tex.setText(String.format(getString(R.string.large_text1) +
          //      getString(R.string.large_text)));

        //Button b1 = new Button(this);
        //b1.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT));
        //b1.setText(getString(R.string.connect));
        //b1.setOnClickListener(this);
        //sv.addView(l1);


    }

    public void onClick(View view)
    {
        Toast myToast= Toast.makeText(getApplicationContext(),"CONNECTING TO TCP",Toast.LENGTH_LONG);
        myToast.show();
    }

    public void onButtonTap(View v)
    {
        Toast myToast= Toast.makeText(getApplicationContext(),"CONNECTING TO TCP",Toast.LENGTH_LONG);
        myToast.show();

        LinearLayout l1=(LinearLayout)findViewById(R.id.lin);
/*
        for(int i = 0; i < 20; i++)
        {
            Button b = new Button(this);
            b.setText("Button "+i);
            l1.addView(b);
        }
*/
        messageReceived("OLA");

        //rl.addView(sv);
         //If you want to set entire layout as dynamically, then remove below lines in program :
        //setContentView(R.layout.activity_security_clearance);
         //RelativeLayout rl=(RelativeLayout)findViewById(R.id.RF_ID);
         //rl.addView(sv);

          //And Add below line :
         //this.setContentView(sv);

    }

    public void messageReceived(String D)
    {
        LinearLayout l1=(LinearLayout)findViewById(R.id.lin);
        AppCompatTextView tex= new AppCompatTextView(this);
        tex.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.MATCH_PARENT));
        tex.setText(D);
        l1.addView(tex);
    }
}
