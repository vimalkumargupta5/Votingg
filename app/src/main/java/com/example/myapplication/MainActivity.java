package com.example.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;
import com.squareup.picasso.Picasso;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        SpaceNavigationView bottomNavigation;
        private Button buttonCandidate, buttonNews, buttonBooth, buttonResult;
        private ImageView newupcoming, newregister, newparties, newsearch, analysis, following, notice, newvoterrequest;
        ViewPager viewPager;
        TextView textView;
        FirebaseAuth mAuth;
        FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.editTextName);
        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        viewPager = (ViewPager) findViewById(R.id.myViewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
        buttonCandidate = (Button) findViewById(R.id.buttonCandidate);
        buttonNews = (Button) findViewById(R.id.buttonNews);
        buttonBooth = (Button) findViewById(R.id.buttonBooth);
        buttonResult = (Button) findViewById(R.id.buttonResult);
        newupcoming = findViewById(R.id.newupcoming);
        newparties = findViewById(R.id.newparties);
        newregister = findViewById(R.id.newregister);
        newsearch = findViewById(R.id.newsearch);
        analysis = findViewById(R.id.analytics);
        following = findViewById(R.id.following);
        notice = findViewById(R.id.notice);
        newvoterrequest = findViewById(R.id.newvoterrequest);
        newvoterrequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewVoterRequest();
            }
        });
        analysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAnalytics();
            }
        });
        following.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBoothInfo();
            }
        });
        notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAnnouncementBoard();
            }
        });
        newupcoming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNext();
            }
        });
        newparties.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openParties();

            }
        });
        newregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRequest();

            }
        });
        newsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSearch();

            }
        });
        //loadUserInformation();
        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openResultstatus();
            }
        });
        buttonBooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBooth();
            }
        });
        buttonNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewspaper();
            }
        });
        buttonCandidate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCandidate();
            }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
       // updateHeader();
    }

    private void openNewVoterRequest() {
        Intent intent = new Intent(this, NewRegistrationVerification.class);
        startActivity(intent);

    }

    private void openBoothInfo() {
        Intent intent = new Intent(this, Center_info.class);
        startActivity(intent);
    }

    private void openContact() {
        Intent intent = new Intent(this, Contact.class);
        startActivity(intent);
    }

    private void openSearch() {
        Intent intent = new Intent(this, VotersList.class);
        startActivity(intent);
    }

    private void openRequest() {
        Intent intent = new Intent(this, Voter_verification.class);
        startActivity(intent);
    }

    private void openParties() {
        Intent intent = new Intent(this, Political_parties.class);
        startActivity(intent);
    }

    private void openNext() {
        Intent intent = new Intent(this, UpcomingElection.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this,Sign_in.class));
        }
    }


    private void openResultstatus() {
        Intent intent = new Intent(this,Result.class);
        startActivity(intent);

    }

    private void openBooth() {
        Intent intent = new Intent(this, GoogleMapsActivity.class);
        startActivity(intent);

    }

    private void openNewspaper() {
        Intent intent = new Intent(this, News.class);
        startActivity(intent);

    }

    private void openCandidate() {
        Intent intent = new Intent(this, CandidateProfile.class);
        startActivity(intent);

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){

        //noinspection SimplifiableIfStatement
            case R.id.action_logout:
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(this,Sign_in.class));
                break;
            case R.id.action_settings:
                openSetting();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void openSetting() {
        Intent intent = new Intent(this,Setting.class);
        startActivity(intent);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_profile) {
            openSignPage();
        }
        else if (id == R.id.nav_feedback) {
            openFeedback();


        }
        else if (id == R.id.nav_complaint) {
            openComplaint();


        }
        else if (id == R.id.nav_faq) {
            openFaq();

        }
        else if (id == R.id.nav_tc) {
            openTerms();

        }
        else if (id == R.id.nav_assistance) {
            openContact();

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void openAnnouncementBoard() {
        Intent intent = new Intent(this, AnnouncementBoard.class);
        startActivity(intent);
    }

    private void openFaq() {
        Intent intent = new Intent(this, Faq.class);
        startActivity(intent);
    }

    private void openTerms() {
        Intent intent = new Intent(this, Terms.class);
        startActivity(intent);
    }

    private void openAnalytics() {
        Intent intent = new Intent(this,Analytics.class);
        startActivity(intent);
    }
    private void openComplaint() {
        Intent intent = new Intent(this,Complaint.class);
        startActivity(intent);
    }

    private void openFeedback() {
        Intent intent = new Intent(this,Feedback.class);
        startActivity(intent);
    }
    private void openSignPage() {
        Intent intent = new Intent(this,Sign_in.class);
        startActivity(intent);
    }
}
