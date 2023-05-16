package com.example.gamesuit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.fragment.app.Fragment;

public class FragmentPlayer extends Fragment implements View.OnClickListener {

    private View ui;
    private View rock;
    private View paper;
    private View scissor;
    private IHost host;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        this.ui = inflater.inflate(R.layout.fr_player,null, false);

        this.rock = this.ui.findViewById(R.id.ivRock);
        this.paper = this.ui.findViewById(R.id.ivPaper);
        this.scissor = this.ui.findViewById(R.id.ivScicor);

        this.rock.setOnClickListener(this);
        this.paper.setOnClickListener(this);
        this.scissor.setOnClickListener(this);

        return this.ui;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ivRock:
                this.host.suit(0);
                break  ;
            case R.id.ivPaper:
                this.host.suit(1);
                break;
            case R.id.ivScicor:
                this.host.suit(2);
                break;
        }
    }
    
    public void setHost(IHost host){
        this.host = host;
    }
}
