package com.example.android.tennisscorecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scorePlayerA = 0;
    int scorePlayerB = 0;
    int gamesPlayerA = 0;
    int gamesPlayerB = 0;
    int setsPlayerA = 0;
    int setsPlayerB = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addScorePlayerA(View view) {
        scorePlayerA = scorePlayerA + 1;
        if (scorePlayerA == 1) {
            String scoreTeamA = "15";
            displayMessageA(scoreTeamA);
        }
        if (scorePlayerA == 2) {
            String scoreTeamA = "30";
            displayMessageA(scoreTeamA);
        }
        if (scorePlayerA == 3) {
            String scoreTeamA = "40";
            displayMessageA(scoreTeamA);
        }
        if (scorePlayerA == 4) {
            String scoreTeamA = "YAY";
            displayMessageA(scoreTeamA);
            String scoreTeamB = "0";
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
            String scoreTeamA = "WINNER";
            displayMessageA(scoreTeamA);
            String scoreTeamB = "LOSER";
            displayMessageB(scoreTeamB);
        }

    }

    public void addScorePlayerB(View view) {
        scorePlayerB = scorePlayerB + 1;
        if (scorePlayerB == 1) {
            String scoreTeamB = "15";
            displayMessageB(scoreTeamB);
        }
        if (scorePlayerB == 2) {
            String scoreTeamB = "30";
            displayMessageB(scoreTeamB);
        }
        if (scorePlayerB == 3) {
            String scoreTeamB = "40";
            displayMessageB(scoreTeamB);
        }
        if (scorePlayerB == 4) {
            String scoreTeamB = "YAY";
            displayMessageB(scoreTeamB);
            String scoreTeamA = "0";
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
            String scoreTeamB = "WINNER";
            displayMessageB(scoreTeamB);
            String scoreTeamA = "LOSER";
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
        String scoreTeamB = "0";
        displayMessageB(scoreTeamB);
        String scoreTeamA = "0";
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
}