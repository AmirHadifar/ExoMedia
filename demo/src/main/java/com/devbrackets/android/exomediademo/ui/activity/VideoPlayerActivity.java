package com.devbrackets.android.exomediademo.ui.activity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import com.devbrackets.android.exomedia.listener.OnPreparedListener;
import com.devbrackets.android.exomedia.ui.widget.EMVideoView;
import com.devbrackets.android.exomedia.ui.widget.VideoControllersSetupBox;
import com.devbrackets.android.exomedia.ui.widget.VideoControls;
import com.devbrackets.android.exomediademo.R;


public class VideoPlayerActivity extends Activity {
    public static final String EXTRA_INDEX = "EXTRA_INDEX";

    protected EMVideoView emVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_player_activity);

        init();
    }



    protected void init() {

        emVideoView = (EMVideoView) findViewById(R.id.video_play_activity_video_view);
        VideoControls videoControls = new VideoControllersSetupBox(this);
        videoControls.setFastForwardButtonEnabled(true);
        videoControls.setRewindButtonEnabled(true);
        emVideoView.setControls(videoControls);
        emVideoView.setOnPreparedListener(new OnPreparedListener() {
            @Override
            public void onPrepared() {
                emVideoView.start();
            }
        });
        emVideoView.setVideoURI(Uri.parse("http://www.sample-videos.com/video/mp4/720/big_buck_bunny_720p_5mb.mp4"));

    }

}
