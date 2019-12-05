/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.CanbusDistanceSensor;

/**
 * Add your docs here.
 */
public class LIDAR {

    private int CANAdress;
    public LIDAR(int CAN){
        CANAdress = CAN; 
    }

    public double getLidar(){
        int[] temp = { 0, 0 };
         temp = CanbusDistanceSensor.getDistanceMM(CANAdress);
    
         double lidarValue = (double)temp[0];
        
        SmartDashboard.putNumber("Lidar" + CANAdress, Math.round(lidarValue));
    
        return lidarValue;
      }

}
