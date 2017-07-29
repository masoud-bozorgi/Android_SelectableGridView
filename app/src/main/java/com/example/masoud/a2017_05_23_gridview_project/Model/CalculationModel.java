package com.example.masoud.a2017_05_23_gridview_project.Model;

import java.io.Serializable;

/**
 * Created by masoud on 2017-05-23.
 */

public class CalculationModel implements Serializable
{

    private int operand1 = 0;
    private int operand2 = 0;


    private double result = 0.0;
    private double userAnswer = 0.0;

    private boolean userAnswered = false;
    private boolean userAnswerIsRight = false;

    private String operator;

    private String feedback = "";

    public CalculationModel() {

        do{
            calculateResult();
        }while (operand2 == 0 && operator.equals("/"));

    }

    public CalculationModel(int operand1, String operator, int operand2) {
        this.operand1 = operand1;
        this.operator = operator;
        this.operand2 = operand2;
    }

    public CalculationModel(double result, double userAnswer) {
        this.result = result;
        this.userAnswer = userAnswer;
    }

    //------------------------------------------------- 2 Operands
    public int getOperand1() {
        return operand1;
    }

    public void setOperand1(int operand1) {
        this.operand1 = operand1;
    }

    public int getOperand2() {
        return operand2;
    }

    public void setOperand2(int operand2) {
        this.operand2 = operand2;
    }
    //-------------------------------------------------




    //------------------------------------------------- OPERATOR

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    //-------------------------------------------------




    //------------------------------------------------- User Answer
    public double getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(double userAnswer) {
        this.userAnswer = userAnswer;
    }
    //-------------------------------------------------




    //------------------------------------------------- Calculated right answer
    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
    //-------------------------------------------------




    //------------------------------------------------- Feedback
    public String getFeedback() {
        return feedback;
    }
    //-------------------------------------------------



    //------------------------------------------------- is user Answered the question
    public boolean isUserAnswered() {
        return userAnswered;
    }

    public void setUserAnswered(boolean userAnswered) {
        this.userAnswered = userAnswered;
    }
    //-------------------------------------------------



    //------------------------------------------------- is userAnswer Right
    public boolean isUserAnswerRight() {
        return userAnswerIsRight;
    }

    public void setUserAnswerIsRight(boolean userAnswerIsRight) {
        this.userAnswerIsRight = userAnswerIsRight;
    }
    //-------------------------------------------------




    public void setFeedback()
    {
        double evaluatedAnswer ;
        evaluatedAnswer = Math.abs(this.result - this.userAnswer);

        if (operator.equals("/") )
        {
            userAnswerIsRight = evaluatedAnswer <= 0.1;
        }else{
            userAnswerIsRight = evaluatedAnswer == 0.0;
        }

        if (userAnswerIsRight){
            this.feedback = "Your answer is right." + "\n";
        }else{
            this.feedback = "Your answer is wrong!" + "\n" + "Write answer is: " + Math.round(result) + "\n" ;
        }
    }





    public void calculateResult()
    {
        switch (operator)
        {
            case "+":
                result = operand1 + operand2;
                break;

            case "-":
                result = operand1 - operand2;
                break;

            case "*":
                result = operand1 * operand2;
                break;

            case "/":

                try{
                    result =  (double)operand1 / (double)operand2;
                }catch (Exception e){

                }
                break;
        }
    }

}

