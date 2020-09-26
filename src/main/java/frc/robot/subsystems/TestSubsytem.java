/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TestSubsytem extends SubsystemBase {
  /**
   * Creates a new TestSubsytem.
   */
  private double m_speed;
  private Talon leftTalon;
  private Talon rightTalon;
  private SpeedControllerGroup talons;
  public TestSubsytem(Constants constants) {
    leftTalon = new Talon(constants.LEFT_TALON);
    rightTalon = new Talon(constants.RIGHT_TALON);
    rightTalon.setInverted(true);
    talons = new SpeedControllerGroup(leftTalon, rightTalon);
    
  }
public void setSpeed(double speed){
    m_speed = speed;
  }
  public double getSpeed(){
    return m_speed;
  }
  @Override
  public void periodic() {
    talons.set(m_speed);
    // This method will be called once per scheduler run
  }
}
