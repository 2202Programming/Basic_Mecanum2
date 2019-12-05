/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.CanbusDistanceSensor;
import frc.robot.LIDAR;


/**
 * Add your docs here.
 */
public class LIDAR_Subsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public static final double LIDAR_DIST = 57.15;

  public static LIDAR lidar1 = new LIDAR(20);
  public static LIDAR lidar2 = new LIDAR(21);


  public LIDAR_Subsystem(){
    
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  //find first lidar

//find angle of object lidar is hitting
public double findAngle(){
  double dist2 = lidar2.getLidar();
  double dist1 = lidar1.getLidar();

  double difference = dist1 - dist2;

  double angle = Math.toDegrees(Math.atan(difference/LIDAR_DIST));

  return angle;

}

public double getDistance(){
  double dist1 = lidar1.getLidar();
  double dist2 = lidar2.getLidar();

  double avg = (dist1 + dist2)/2;
  return avg; 
}




}
