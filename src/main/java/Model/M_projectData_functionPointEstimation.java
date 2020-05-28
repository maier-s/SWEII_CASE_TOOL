/**
 * Main: This file is part of CASE-Tool
 *
 * With the CASE-Tool it is possible to create feasibility studies
 * and save them. The software is based on a student project.
 *
 * Description:  Model for Function Point Estimation
 */

package Model;

public class M_projectData_functionPointEstimation extends M_project_Data_Estimation {
    public M_projectData_functionPointEstimation(double actualValue, double setpoint) {
        super(actualValue, setpoint);
    }

    public int inputEasyNumber = 0;
    public int inputMiddleNumber = 0;
    public int inputComplexNumber = 0;

    public int outputEasyNumber = 0;
    public int outputMiddleNumber = 0;
    public int outputComplexNumber = 0;

    public int queryEasyNumber = 0;
    public int queryMiddleNumber = 0;
    public int queryComplexNumber = 0;

    public int internEasyNumber = 0;
    public int internMiddleNumber = 0;
    public int internComplexNumber = 0;

    public int externEasyNumber = 0;
    public int externMiddleNumber = 0;
    public int externComplexNumber = 0;

    public int factor1 = 0;
    public int factor2 = 0;
    public int factor3 = 0;
    public int factor4a = 0;
    public int factor4b = 0;
    public int factor4c = 0;
    public int factor4d = 0;
    public int factor5 = 0;
    public int factor6 = 0;
    public int factor7 = 0;

    public int e1Sum = 0;
    public int e2Sum = 0;
    public double e3Sum = 0;

    public double jonesDuration = 0;
    public int jonesPersons = 0;
    public double jonesPersonMoths = 0;

    public double correctionFactor = 0;


    @Override
    public void estimate() {

    }

    public void calcE2Sum() {
        //Calculation for E2
        e2Sum = factor1 + factor2 + factor3 + factor4a + factor4b + factor4c + factor4d + factor5 + factor6 + factor7;
    }

    public void calcE3() {
        //Calculation for E3
        e3Sum = (float) e2Sum / 100 + 0.7;
    }

    public void calcFunctionPointResult() {
        //Calculation for Function Point Result
        setpoint = e1Sum * e3Sum;
    }

    public void updateValues() {
        //Update Calculation functions
        calcE2Sum();
        calcE3();
        calcFunctionPointResult();
        calcJonesEstimation();
    }

    private void calcJonesEstimation() {
        //Calculation for Jones Estimation
        jonesDuration = Math.pow(setpoint, 0.4);

        jonesPersons = (int) Math.round(setpoint/150);
        if (jonesPersons < 1 & setpoint != 0) jonesPersons = 1;

        jonesPersonMoths = jonesDuration * jonesPersons;
    }
}