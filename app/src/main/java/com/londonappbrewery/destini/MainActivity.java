package com.londonappbrewery.destini;

import android.os.Trace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:

    Button topButton, bottomButton, resetButton;
    TextView storyTextView;

    int stories[] = {R.string.T1_Story, R.string.T2_Story, R.string.T3_Story};
    int answersTop[] = {R.string.T1_Ans1, R.string.T2_Ans1, R.string.T3_Ans1};
    int answerBottom[] = {R.string.T1_Ans2, R.string.T2_Ans2, R.string.T3_Ans2};
    int ends[] = {R.string.T4_End, R.string.T5_End, R.string.T6_End};

    int actualStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        topButton = (Button) findViewById(R.id.buttonTop);
        bottomButton = (Button) findViewById(R.id.buttonBottom);
        resetButton = (Button) findViewById(R.id.reset_button);
        storyTextView = (TextView) findViewById(R.id.storyTextView);

        resetButton.setVisibility(View.INVISIBLE);
        resetButton.setActivated(false);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (actualStory == 0 || actualStory == 1){
                    actualStory = 2;
                } else if (actualStory == 2){
                    actualStory = 5;
                }
                setStoryStrings();
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (actualStory == 0){
                    actualStory = 1;
                } else if (actualStory == 1){
                    actualStory = 3;
                } else if (actualStory == 2){
                    actualStory = 4;
                }
                setStoryStrings();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualStory = 0;
                setStoryStrings();
            }
        });

    }

    public void setStoryStrings(){
        topButton.setVisibility(View.VISIBLE);
        bottomButton.setVisibility(View.VISIBLE);
        topButton.setActivated(true);
        bottomButton.setActivated(true);
        resetButton.setVisibility(View.INVISIBLE);
        resetButton.setActivated(false);
        if (actualStory == 0){
            storyTextView.setText(stories[0]);
            topButton.setText(answersTop[0]);
            bottomButton.setText(answerBottom[0]);
        } else if (actualStory == 1){
            storyTextView.setText(stories[1]);
            topButton.setText(answersTop[1]);
            bottomButton.setText(answerBottom[1]);
        } else if (actualStory == 2){
            storyTextView.setText(stories[2]);
            topButton.setText(answersTop[2]);
            bottomButton.setText(answerBottom[2]);
        } else if (actualStory == 3){
            storyTextView.setText(ends[0]);
            topButton.setVisibility(View.INVISIBLE);
            bottomButton.setVisibility(View.INVISIBLE);
            topButton.setActivated(false);
            bottomButton.setActivated(false);
            resetButton.setVisibility(View.VISIBLE);
            resetButton.setActivated(true);
        } else if (actualStory == 4){
            storyTextView.setText(ends[1]);
            topButton.setVisibility(View.INVISIBLE);
            bottomButton.setVisibility(View.INVISIBLE);
            topButton.setActivated(false);
            bottomButton.setActivated(false);
            resetButton.setVisibility(View.VISIBLE);
            resetButton.setActivated(true);
        } else if (actualStory == 5){
            storyTextView.setText(ends[2]);
            topButton.setVisibility(View.INVISIBLE);
            bottomButton.setVisibility(View.INVISIBLE);
            topButton.setActivated(false);
            bottomButton.setActivated(false);
            resetButton.setVisibility(View.VISIBLE);
            resetButton.setActivated(true);
        }
    }
}
