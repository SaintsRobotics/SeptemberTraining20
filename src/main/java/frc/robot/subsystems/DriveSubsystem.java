/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  /**
   * Creates a new DriveSubsystem.
   */
  private double m_speed;
  private Talon m_motor;
  public DriveSubsystem(Constants constants) {
      m_motor = new Talon(Constants.MOTOR_PORT);
  }

  public void setSpeed(double speed){
    m_speed = speed;
  }
  public double getSpeed(){
    return m_speed;
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    m_motor.set(m_speed);
  }
}
