package com.example.masoud.a2017_05_23_gridview_project;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.masoud.a2017_05_23_gridview_project.Model.CalculationModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by masoud on 2017-05-23.
 */

public class TextReadr {


    public static ArrayList<CalculationModel> readFile(Context context, String fileName)
    {  //, int [] arrayOfPictures

        ArrayList<CalculationModel> calculationArrayList =  new ArrayList<>();

        AssetManager assetManager = context.getAssets();

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(assetManager.open(fileName));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String oneLine;


            while ((oneLine = bufferedReader.readLine()) != null){

                StringTokenizer stringTokenizer = new StringTokenizer(oneLine, ",");

                //Extract calculation model attributes from text file

                int firstOperand = Integer.valueOf(stringTokenizer.nextToken());
                String operator = stringTokenizer.nextToken();
                int secondOperand = Integer.valueOf(stringTokenizer.nextToken());

                //Build calculation object: int operand1, String operator, int operand2
                CalculationModel calculationModel = new CalculationModel(firstOperand, operator, secondOperand);

                calculationArrayList.add(calculationModel);
            }
            bufferedReader.close();
            inputStreamReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return  calculationArrayList;
    }
}
