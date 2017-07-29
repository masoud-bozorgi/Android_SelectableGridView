package com.example.masoud.a2017_05_23_gridview_project.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by masoud on 2017-05-23.
 */

public class DataCollection implements Serializable {


    List<CalculationModel> calculationArray;

    double correctAnswersPercentage = 0;

    int numberOfRightAnswers = 0;


    public DataCollection() {
        this.calculationArray = new ArrayList<>();
    }

    public List<CalculationModel> getCalculationArray() {
        return calculationArray;
    }

    public double getCorrectAnswersPercentage() {
        score();
        return correctAnswersPercentage;
    }

    public void add(CalculationModel myCalculation){

        calculationArray.add(myCalculation);
    }

    //--------------------------------------- Calculate correctAnswersPercentage
    public void score(){
        try {
            correctAnswersPercentage = (double) numberOfRightAnswers / (double) calculationArray.size();
        }catch (Exception e){

        }
    }

    @Override
    public String toString() {
        String calculationArrayContents = "No data";

        for(CalculationModel oneCalculation : calculationArray){
            oneCalculation.toString();
        }

        return calculationArrayContents;
    }
}
