package com.example.coutcounter;

    import androidx.appcompat.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    static int scoreA=0;
    static int scoreB=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called after clicking +3 POINTS button for A. To increase the score by 3.
     */
    public void threePointerA(View view)
    {
        scoreA=scoreA+3;
        displayA(scoreA);
    }

    /**
     * This method is called after clicking +2 POINTS button for A. To increase the score by 2.
     */
    public void twoPointerA(View view)
    {
        scoreA+=2;
        displayA(scoreA);
    }

    /**
     * This method is called after clicking FREE THROW button for A. To increase the score by 3.
     */
    public void freeThrowerA(View view)
    {
        scoreA++;
        displayA(scoreA);
    }

    /**
     * This method displays the score of Team A.
     */
     private void displayA(int val)
     {
        TextView scoreAText= (TextView) findViewById(R.id.team_a_score);
        scoreAText.setText(String.valueOf(val));

     }

    /**
     * This method is called after clicking +3 POINTS button for B. To increase the score by 3.
     */
    public void threePointerB(View view)
    {
        scoreB+=3;
        displayB(scoreB);
    }

    /**
     * This method is called after clicking +2 POINTS button for B. To increase the score by 2.
     */
    public void twoPointerB(View view)
    {
        scoreB+=2;
        displayB(scoreB);
    }

    /**
     * This method is called after clicking FREE THROW button for B. To increase the score by 1.
     */
    public void freeThrowerB(View view)
    {
        scoreB++;
        displayB(scoreB);
    }

    /**
     * Function to reset the score of both the team
     */
    public void resetScore(View view)
    {
        scoreA = 0;
        scoreB = 0;
        displayA(scoreA);
        displayB(scoreB);
    }

    /**
     * This method displays the score of Team b.
     */
    private void displayB(int val)
    {
        TextView scoreAText= (TextView) findViewById(R.id.team_b_score);
        scoreAText.setText(String.valueOf(val));

    }

}