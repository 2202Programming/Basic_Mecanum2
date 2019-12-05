/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Add your docs here.
 */
public class PID {

    private double P = 0.01;
    private double I = 0.01;
    private double Error;
    private double desiredValue;
    private double integral = 0.0;
    private double powerRight;
    private double powerLeft;
    private double power;

    public PID(){
        Error = 0.0;
        desiredValue = 0.0;
    }
    public PID(double d){
        Error = 0.0;
        desiredValue = d;
    }

//double angle can also be a distance I'm just too lazy to change the name

public double leftMotor(double angle){
    
    Error = angle - desiredValue;

    integral += (Error*0.2); //Integral increased by error*time (0.2 seconds is a norm, possibly incorrect)
    
    SmartDashboard.putNumber("Integral", integral);

    //Thing in if statement not for sure, must be tested to determine if it applies for the right or left potor;
    if(angle < desiredValue){
      powerLeft = P*Math.abs(Error) +  I*Math.abs(integral); 
      
    }
    else{
        powerLeft = 0;
    }


    SmartDashboard.putNumber("Power Left", powerLeft);
    SmartDashboard.putNumber("Power Right", powerRight);
   
    return powerLeft;
  }

  //double angle can also be a distance I'm just too lazy to change the name

  public double rightMotor(double angle){
    
    Error = angle - desiredValue;

    integral += (Error*0.2); //Integral increased by error*time (0.2 seconds is a norm, possibly incorrect)
    
    SmartDashboard.putNumber("Integral", integral);

    //Thing in if statement not for sure, must be tested to determine if it applies for the right or left potor;
    if(angle > desiredValue){
      powerRight = P*Math.abs(Error) +  I*Math.abs(integral); 
      
    }
    else{
        powerRight = 0;
    }


    SmartDashboard.putNumber("Power Left", powerLeft);
    SmartDashboard.putNumber("Power Right", powerRight);
   
    return powerRight;
  }

  public double getMotor(double distance){
    
    Error = distance - desiredValue;

    integral += (Error*0.2); //Integral increased by error*time (0.2 seconds is a norm, possibly incorrect)
    
    SmartDashboard.putNumber("Integral", integral);

    //Thing in if statement not for sure, must be tested to determine if it applies for the right or left potor;
      power = P*Error +  I*integral; 


    SmartDashboard.putNumber("Overall power", power);
   
    return power;
  }


  public void setP(double p){
    this.P = p;
  }

  public void setI(double i){
    this.I = i;
  }

  public void setTarget(double t){
      desiredValue = t;
  }

}
