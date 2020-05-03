package com.example.homebody;

import android.content.Context;
import android.location.Location;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import org.jetbrains.annotations.NotNull;

import io.radar.sdk.Radar;
import io.radar.sdk.RadarReceiver;
import io.radar.sdk.model.RadarEvent;
import io.radar.sdk.model.RadarUser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;


public class MyRadarReceiver extends RadarReceiver {


    @Override
    public void onEventsReceived(Context context, RadarEvent[] events, RadarUser user) {
        // do something with events, user
        for(RadarEvent e : events) {
            if(e.getType().name().equals("USER_EXITED_GEOFENCE")) {
                // prompt the where are you going screen
                System.out.println("location changed");
                MainActivity.home.findViewById(R.id.going_out_button).performClick();

//                NavHostFragment.findNavController(new Homescreen())
//                        .navigate(R.id.action_homescreen_to_FirstFragment);
            }
        }

    }

    @Override
    public void onLocationUpdated(Context context, Location location, RadarUser user) {
        // do something with location, user
    }

    @Override
    public  void onClientLocationUpdated(Context context, Location location, boolean stopped, Radar.RadarLocationSource source) {
        // do something with location, stopped, source
    }

    @Override
    public void onError(Context context, Radar.RadarStatus status) {
        // do something with status
    }

    @Override
    public void onLog(@NotNull Context context, @NotNull String s) {

    }
}