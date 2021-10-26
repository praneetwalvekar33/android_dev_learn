package com.example.clickplaymusic;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //  Variables to increase and the volume by
    int volumeInc =  30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Creating a MediaPlayer object
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.sample_3s);;

        //  calling OncompletionListener to release the resources of the object when the playback
        //  is complete
        //  mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
        //    @Override
        //   public void onCompletion(MediaPlayer mediaPlayer){
        //        mediaPlayer.reset();
        //        mediaPlayer.release();
        //    }

        //});

        //  To find the TextView containing the skip forward text
        TextView skipForward = (TextView) findViewById(R.id.skip_forward);
        //  Setting up onclick listener on the skip forward text
        skipForward.setOnClickListener(new View.OnClickListener() {
            //  To override the method from View Interface so that when the text is clicked it performs the
            //  mentioned action
            @Override
            public void onClick(View v) {
                int currentPosition = mediaPlayer.getCurrentPosition();
               mediaPlayer.seekTo(currentPosition + 60000);
            }
        });

        //  To find the TextView containing the skip back text
        TextView skipBack = (TextView) findViewById(R.id.skip_back);
        //  Setting up onclick listener on the skip forward text
        skipBack.setOnClickListener(new View.OnClickListener() {
            //  To override the method from View Interface so that when the text is clicked it performs the
            //  mentioned action
            @Override
            public void onClick(View v) {
                int currentPosition = mediaPlayer.getCurrentPosition();
                mediaPlayer.seekTo(currentPosition - 60000);
            }
        });

        //  To find the TextView containing the play text
        TextView playButton = (TextView) findViewById(R.id.play_music);
        //  Setting up onclick listener on the skip forward text
        playButton.setOnClickListener(new View.OnClickListener() {
            //  To override the method from View Interface so that when the text is clicked it performs the
            //  mentioned action
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });

        //  To find the TextView containing the pause text
        TextView pauseButton = (TextView) findViewById(R.id.pause_music);
        //  Setting up onclick listener on the skip forward text
        pauseButton.setOnClickListener(new View.OnClickListener() {
            //  To override the method from View Interface so that when the text is clicked it performs the
            //  mentioned action
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });

        //  To find the TextView containing the volume up text
        TextView volumeUp = (TextView) findViewById(R.id.volume_up);
        //  Setting up onclick listener on the skip forward text
        volumeUp.setOnClickListener(new View.OnClickListener() {
            //  To override the method from View Interface so that when the text is clicked it performs the
            //  mentioned action
            @Override
            public void onClick(View v) {
                int maxVolume = 50;
                float log1 = (float) (1-(Math.log(maxVolume - volumeInc) / Math.log(maxVolume)));
                mediaPlayer.setVolume(log1, log1);

                if(volumeInc < 50){
                    volumeInc += 4;
                }
            }
        });

        //  To find the TextView containing the volume down text
        TextView volumeDown = (TextView) findViewById(R.id.volume_down);
        //  Setting up onclick listener on the skip forward text
        volumeDown.setOnClickListener(new View.OnClickListener() {
            //  To override the method from View Interface so that when the text is clicked it performs the
            //  mentioned action
            @Override
            public void onClick(View v) {
                int maxVolume = 50;
                float log1 = (float) (1-(Math.log(maxVolume - volumeInc) / Math.log(maxVolume)));
                mediaPlayer.setVolume(log1, log1);
                if(volumeInc > 0){
                    volumeInc -= 4;
                }
            }
        });



    }
}