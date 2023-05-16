package com.example.gamesuit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements IHost{

    private View ctLawan;
    private View ctPlayer;
    private View ctBattle;
    private FragmentManager fm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.ctLawan = this.findViewById(R.id.frameLawan); // didalam activity_main.XML
        this.ctPlayer = this.findViewById(R.id.framePlayer);
        this.ctBattle = this.findViewById(R.id.frameBattle);

        this.fm =getSupportFragmentManager();//Create Fragment Manager
        this.fm.beginTransaction().
                add(
                R.id.frameLawan,
                new FragmentLawan(),
                "FLAWAN"
                ).add(
                R.id.frameBattle,
                new FragmentBattle(),
                "FBATTLE"
                ).add(
                R.id.framePlayer,
                new FragmentPlayer(),
                "FPLAYER"
        ).commit();


    }

    @Override
    protected void onResume() {
        super.onResume();
        FragmentPlayer fp = (FragmentPlayer) this.fm.findFragmentByTag("FPLAYER");
        fp.setHost(this);
    }

    @Override
    public void suit(int tangan) {
        FragmentLawan frLawan = (FragmentLawan) getSupportFragmentManager().findFragmentByTag("FLAWAN");
        FragmentBattle frBattle = (FragmentBattle) getSupportFragmentManager().findFragmentByTag("FBATTLE");

        int tanganLawan = frLawan.getTangan();
        int tanganPlayer = tangan;
        frBattle.suit(tanganPlayer,tanganLawan);
    }


}