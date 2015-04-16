package com.example.leodavinci360.recorder;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import java.io.File;


public class RecordActivity extends ActionBarActivity {

    private Button button1, button2, button3, button4, button5, button6, button7;
    private MediaPlayer play;
    private MediaRecorder record;
    private String FILE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);


        FILE =Environment.getExternalStorageDirectory() + "/tempRecord.3gpp";


        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                play = MediaPlayer.create(RecordActivity.this, R.raw.clap);
                play.start();
                play.setOnCompletionListener(new OnCompletionListener() {

                    @Override
                    public void onCompletion(MediaPlayer play) {
                        play.release();

                    }
                });

            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                play = MediaPlayer.create(RecordActivity.this, R.raw.conga);
                play.start();
                play.setOnCompletionListener(new OnCompletionListener() {

                    @Override
                    public void onCompletion(MediaPlayer play) {
                        play.release();

                    }
                });

            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                play = MediaPlayer.create(RecordActivity.this, R.raw.drumroll);
                play.start();
                play.setOnCompletionListener(new OnCompletionListener() {

                    @Override
                    public void onCompletion(MediaPlayer play) {
                        play.release();

                    }
                });

            }
        });

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                play = MediaPlayer.create(RecordActivity.this, R.raw.glass);
                play.start();
                play.setOnCompletionListener(new OnCompletionListener() {

                    @Override
                    public void onCompletion(MediaPlayer play) {
                        play.release();

                    }
                });

            }
        });

        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                play = MediaPlayer.create(RecordActivity.this, R.raw.tap);
                play.start();
                play.setOnCompletionListener(new OnCompletionListener() {

                    @Override
                    public void onCompletion(MediaPlayer play) {
                        play.release();

                    }
                });

            }
        });

        button6 = (Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                play = MediaPlayer.create(RecordActivity.this, R.raw.bell);
                play.start();
                play.setOnCompletionListener(new OnCompletionListener() {

                    @Override
                    public void onCompletion(MediaPlayer play) {
                        play.release();

                    }
                });

            }

        });


        button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (button7.getText().toString().equals("Record")) {
                    startRecord();

                } else if (button7.getText().toString().equals("End")) {
                    stopRecord();

                } else if (button7.getText().toString().equals("Play")) {
                    startPlayback();

                } else {
                    stopPlayback();
                }


            }

    });

}
        public void startRecord() throws Exception {
            if (record != null) {
                record.release();
            }


            File fileOut = new File(FILE);
            if (fileOut != null) {
                fileOut.delete();
            }

            record = new MediaRecorder();
            record.setAudioSource(MediaRecorder.AudioSource.MIC);
            record.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
            record.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB); //Runs on versions before 2.3
            record.setOutputFile(FILE); //path

            record.prepare();
            record.start();
        }

        public void stopRecord()
        {   record.stop();
            record.release();
        }

        public void startPlayback() throws Exception {
            if (play != null) {
                play.stop();
                play.release();
            }
            play = new MediaPlayer();
            play.setDataSource(FILE);
            play.prepare();
            play.start();
        }

        public void stopPlayback()
        {

        }


        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_record, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }
    }

