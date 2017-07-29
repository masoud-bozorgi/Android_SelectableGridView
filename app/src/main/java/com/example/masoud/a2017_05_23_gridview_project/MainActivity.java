package com.example.masoud.a2017_05_23_gridview_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.masoud.a2017_05_23_gridview_project.Model.CalculationModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    GridView gridView;
    EditText editText;
    TextView textViewScore;

    ArrayList<CalculationModel> calculationModelArrayList;
    CustomAdapter customAdapter;
    ArrayAdapter<CalculationModel> calculationModelArrayAdapter;

    double totalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
    }

    private void initialize() {


        editText = (EditText)findViewById(R.id.editText);
        textViewScore = (TextView)findViewById(R.id.textViewScore);

        initializeGridView();
    }

    private void initializeGridView() {

        calculationModelArrayList = TextReadr.readFile(this,"tests.txt");
        customAdapter = new CustomAdapter(this, calculationModelArrayList);

        gridView = (GridView)findViewById(R.id.gridView);
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        int row = position /6;

        if(!editText.getText().toString().isEmpty()  && position % 6 == 4){

            double userAnswer = Double.valueOf( editText.getText().toString() );

            CalculationModel currentPositionObject = calculationModelArrayList.get(row);
            currentPositionObject.setUserAnswered(true);
            currentPositionObject.setUserAnswer(userAnswer);
            currentPositionObject.calculateResult();
            currentPositionObject.setFeedback();

            customAdapter.notifyDataSetChanged();


            //TODO: calculate user score and update it

            calculateCurrentScore();
            textViewScore.setText(String.valueOf(totalScore) + "%");

            //TODO: show appropriate message to user
            Toast.makeText(this, currentPositionObject.getFeedback(), Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(this, "Please enter your answer for one of questions.", Toast.LENGTH_SHORT).show();
        }

    }

    private void calculateCurrentScore() {
        double totoalNumberOfAnswers = 0;
        double numberOfRightAnswers = 0;

        for (CalculationModel oneCalculationModel: calculationModelArrayList)
        {
            if(oneCalculationModel.isUserAnswerRight()){
                totoalNumberOfAnswers += 1;
            }

//            if(oneCalculationModel.isUserAnswerRight()){
//                numberOfRightAnswers+=1;
//            }


        }
        totalScore = ( totoalNumberOfAnswers / calculationModelArrayList.size() ) * 100;
    }
}
