package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import de.hdodenhof.circleimageview.CircleImageView;

public class NewVoterRequest extends AppCompatActivity {
    private EditText fullname_txt, fathername_txt, uid_txt, mno_txt, dob_txt, email_txt, addressone_txt, addresstwo_txt, state_txt, district_txt, pin_txt, gender;
    private Button register;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_voter_request);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        fullname_txt = (EditText) findViewById(R.id.fullname_txt);
        fathername_txt = (EditText) findViewById(R.id.fathername_txt);
        uid_txt = (EditText) findViewById(R.id.uid_txt);
        mno_txt = (EditText) findViewById(R.id.mno_txt);
        dob_txt = (EditText) findViewById(R.id.dob_txt);
        email_txt = (EditText) findViewById(R.id.email_txt);
        addressone_txt = (EditText) findViewById(R.id.addressone_txt);
        addresstwo_txt = (EditText) findViewById(R.id.addresstwo_txt);
        state_txt = (EditText) findViewById(R.id.state_txt);
        district_txt = (EditText) findViewById(R.id.district_txt);
        pin_txt = (EditText) findViewById(R.id.pin_txt);
        register = (Button) findViewById(R.id.register_btn);
        gender = (EditText) findViewById(R.id.gender_txt);
        databaseReference = FirebaseDatabase.getInstance().getReference("NewVotersRegistrationRequest");
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addVoters();

            }
        });
    }
    public void addVoters(){
        String fullName = fullname_txt.getText().toString();
        String fatherName = fathername_txt.getText().toString();
        String uniqueId = uid_txt.getText().toString();
        String mobileNo = mno_txt.getText().toString();
        String dateBirth = dob_txt.getText().toString();
        String emailVoter = email_txt.getText().toString();
        String addressLineOne = addressone_txt.getText().toString();
        String addressLineTwo = addresstwo_txt.getText().toString();
        String stateVoter = state_txt.getText().toString();
        String districtVoter= district_txt.getText().toString();
        String postalCode = pin_txt.getText().toString();
        String Gender = gender.getText().toString();


        if(!TextUtils.isEmpty(fullName) && !TextUtils.isEmpty(fatherName) && !TextUtils.isEmpty(uniqueId) && !TextUtils.isEmpty(mobileNo) && !TextUtils.isEmpty(dateBirth) && !TextUtils.isEmpty(emailVoter) && !TextUtils.isEmpty(addressLineOne) && !TextUtils.isEmpty(addressLineTwo) && !TextUtils.isEmpty(stateVoter) && !TextUtils.isEmpty(districtVoter) && !TextUtils.isEmpty(postalCode)){
            String id = databaseReference.push().getKey();
            NewVoterRegistrationClass newVoterRegistrationClass = new NewVoterRegistrationClass(id, fullName, fatherName,uniqueId,mobileNo,dateBirth, emailVoter, addressLineOne, addressLineTwo, stateVoter, districtVoter, postalCode, Gender);
            databaseReference.child(id).setValue(newVoterRegistrationClass);
            fullname_txt.setText("");
            fathername_txt.setText("");
            uid_txt.setText("");
            mno_txt.setText("");
            dob_txt.setText("");
            email_txt.setText("");
            addressone_txt.setText("");
            addresstwo_txt.setText("");
            state_txt.setText("");
            district_txt.setText("");
            pin_txt.setText("");
            gender.setText("");
            Toast.makeText(getApplicationContext(), "Request has been submitted!", Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(NewVoterRequest.this, "Please Fill Every Fields!", Toast.LENGTH_LONG).show();
        }


    }
}
