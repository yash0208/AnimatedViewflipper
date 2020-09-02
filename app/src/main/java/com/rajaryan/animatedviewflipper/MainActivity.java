package com.rajaryan.animatedviewflipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    ViewFlipper mViewFlipper;
    ImageView Image1,Image2,Image3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewFlipper=findViewById(R.id.ViewFlipper);
        Image1=findViewById(R.id.image1);
        Image2=findViewById(R.id.image2);
        Image3=findViewById(R.id.image3);

            DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("Main Page Header");
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String im1=dataSnapshot.child("1").getValue().toString();
                    String im2=dataSnapshot.child("2").getValue().toString();
                    String im3=dataSnapshot.child("3").getValue().toString();
                    Glide.with(getApplicationContext()).load(im1).fitCenter().into(Image1);
                    Glide.with(getApplicationContext()).load(im2).fitCenter().into(Image2);
                    Glide.with(getApplicationContext()).load(im3).fitCenter().into(Image3);
                    mViewFlipper.setAutoStart(true);
                    mViewFlipper.setFlipInterval(4000);
                    mViewFlipper.startFlipping();
                    mViewFlipper.setInAnimation(MainActivity.this,R.anim.left_in);
                    mViewFlipper.setOutAnimation(MainActivity.this,R.anim.left_out);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


    }
}
