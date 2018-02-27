package com.example.android.tennisscorecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    short scorePlayerA = 0;
    short scorePlayerB = 0;
    int gamesPlayerA = 0;
    int gamesPlayerB = 0;
    int setsPlayerA = 0;
    int setsPlayerB = 0;
    private String scoreTeamA = "love";
    private String scoreTeamB = "love";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void addScorePlayerA(View view) {
        scorePlayerA = (short) (scorePlayerA + 1);
        if (scorePlayerA == 1) {
            scoreTeamA = "15";
            displayMessageA(scoreTeamA);
        }
        if (scorePlayerA == 2) {
            scoreTeamA = "30";
            displayMessageA(scoreTeamA);
        }
        if (scorePlayerA == 3) {
            scoreTeamA = "40";
            displayMessageA(scoreTeamA);
        }
        if (scorePlayerA == 4) {
            scoreTeamA = "YAY";
            displayMessageA(scoreTeamA);
            scoreTeamB = "0";
            displayMessageB(scoreTeamB);
            gamesPlayerA = gamesPlayerA + 1;
            displayGameScoreA(gamesPlayerA);
            scorePlayerA = 0;
            scorePlayerB = 0;
        }

        if (gamesPlayerA > 5 && (gamesPlayerA - gamesPlayerB) > 2 ||
                gamesPlayerA > 5 && (gamesPlayerA - gamesPlayerB) == 2) {
            setsPlayerA = setsPlayerA + 1;
            scorePlayerA = 0;
            scorePlayerB = 0;
            gamesPlayerA = 0;
            gamesPlayerB = 0;
            displayGameScoreA(gamesPlayerA);
            displayGameScoreB(gamesPlayerB);
            displaySetsScoreA(setsPlayerA);
        }

        if (setsPlayerA > 1 && (setsPlayerA - setsPlayerB) > 1 ||
                (setsPlayerA > 1 && (setsPlayerA - setsPlayerB) == 1)) {
            scoreTeamA = "WINNER";
            displayMessageA(scoreTeamA);
            scoreTeamB = "LOSER";
            displayMessageB(scoreTeamB);
        }

    }

    public void addScorePlayerB(View view) {
        scorePlayerB = (short) (scorePlayerB + 1);
        if (scorePlayerB == 1) {
            scoreTeamB = "15";
            displayMessageB(scoreTeamB);
        }
        if (scorePlayerB == 2) {
            scoreTeamB = "30";
            displayMessageB(scoreTeamB);
        }
        if (scorePlayerB == 3) {
            scoreTeamB = "40";
            displayMessageB(scoreTeamB);
        }
        if (scorePlayerB == 4) {
            scoreTeamB = "YAY";
            displayMessageB(scoreTeamB);
            scoreTeamA = "0";
            displayMessageA(scoreTeamA);
            gamesPlayerB = gamesPlayerB + 1;
            displayGameScoreB(gamesPlayerB);
            scorePlayerA = 0;
            scorePlayerB = 0;
        }

        if (gamesPlayerB > 5 && (gamesPlayerB - gamesPlayerA) > 2 ||
                gamesPlayerB > 5 && (gamesPlayerB - gamesPlayerA) == 2) {
            setsPlayerB = setsPlayerB + 1;
            scorePlayerA = 0;
            scorePlayerB = 0;
            gamesPlayerA = 0;
            gamesPlayerB = 0;
            displayGameScoreA(gamesPlayerA);
            displayGameScoreB(gamesPlayerB);
            displaySetsScoreB(setsPlayerB);

        }

        if (setsPlayerB > 1 && (setsPlayerB - setsPlayerA) > 1 ||
                setsPlayerB > 1 && (setsPlayerB - setsPlayerA) == 1) {
            scoreTeamB = "WINNER";
            displayMessageB(scoreTeamB);
            scoreTeamA = "LOSER";
            displayMessageA(scoreTeamA);
        }

    }

    public void Reset(View view) {
        scorePlayerA = 0;
        scorePlayerB = 0;
        gamesPlayerA = 0;
        gamesPlayerB = 0;
        setsPlayerA = 0;
        setsPlayerB = 0;
        displayGameScoreA(gamesPlayerA);
        displayGameScoreB(gamesPlayerB);
        displaySetsScoreB(setsPlayerB);
        displaySetsScoreA(setsPlayerA);
        scoreTeamB = "0";
        displayMessageB(scoreTeamB);
        scoreTeamA = "0";
        displayMessageA(scoreTeamA);
    }

    private void displayMessageA(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.player_a_points);
        priceTextView.setText(message);
    }

    private void displayGameScoreA(int gamesPlayerA) {
        TextView scoreView = (TextView) findViewById(R.id.player_a_games);
        scoreView.setText(String.valueOf(gamesPlayerA));
    }

    private void displaySetsScoreA(int setsPlayerA) {
        TextView scoreView = (TextView) findViewById(R.id.player_a_sets);
        scoreView.setText(String.valueOf(setsPlayerA));
    }

    private void displayMessageB(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.player_b_points);
        priceTextView.setText(message);
    }

    private void displayGameScoreB(int gamesPlayerB) {
        TextView scoreView = (TextView) findViewById(R.id.player_b_games);
        scoreView.setText(String.valueOf(gamesPlayerB));
    }

    private void displaySetsScoreB(int setsPlayerB) {
        TextView scoreView = (TextView) findViewById(R.id.player_b_sets);
        scoreView.setText(String.valueOf(setsPlayerB));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //somehow save values of the variables and strings
        outState.putShort("scorePlayerA2", scorePlayerA);
        outState.putShort("scorePlayerB2", scorePlayerB);
        outState.putString("scoreTeamA2", scoreTeamA);
        outState.putString("scoreTeamB2", scoreTeamB);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //repopulate values
        scorePlayerA = savedInstanceState.getShort("scorePlayerA2");
        scorePlayerB = savedInstanceState.getShort("scorePlayerB2");
        scoreTeamA = savedInstanceState.getString("scoreTeamA2");
        scoreTeamB = savedInstanceState.getString("scoreTeamB2");

    }

}