/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj.kinematics.MecanumDriveKinematics;
import edu.wpi.first.wpilibj.kinematics.MecanumDriveOdometry;
import edu.wpi.first.wpilibj.kinematics.MecanumDriveWheelSpeeds;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArcadeSubsystem extends SubsystemBase {
  private CANSparkMax leftFrontCanSparkMax;
  private CANSparkMax RightFrontCanSparkMax;
  private CANSparkMax leftBackCanSparkMax;
  private CANSparkMax RightBackCanSparkMax;
  private MecanumDrive drive;
  private double m_yspeed;
  private double m_xspeed;
  private double m_rotation;
  private MecanumDriveKinematics mecanumDriveKinematics;
  private MecanumDriveWheelSpeeds mecanumDriveWheelSpeeds;
  private MecanumDriveOdometry mecanumDriveOdometry;

  /**
   * Creates a new ArcadeSubsystem.
   */
  public ArcadeSubsystem() {
        leftFrontCanSparkMax = new CANSparkMax(1, MotorType.kBrushless);
        RightFrontCanSparkMax = new CANSparkMax(2, MotorType.kBrushless);
        leftBackCanSparkMax = new CANSparkMax(3, MotorType.kBrushless);
        RightBackCanSparkMax = new CANSparkMax(4, MotorType.kBrushless);
        
        mecanumDriveKinematics = new MecanumDriveKinematics(new Translation2d(-1, 1), new Translation2d(1, 1), 
        new Translation2d(-1, -1), new Translation2d(1, -1));
        mecanumDriveOdometry = new MecanumDriveOdometry(mecanumDriveKinematics, new Rotation2d(), new Pose2d());
      
      }

  public void setYSpeed(double speed){
    m_yspeed = speed;
  }
  public void setXSpeed(double speed){
    m_xspeed = speed;
  }
  public void setRotation(double rotation){
    m_rotation = rotation;
  }
  public void drive(double xSpeed, double yspeed, double roxation){
    mecanumDriveWheelSpeeds = mecanumDriveKinematics.toWheelSpeeds(new ChassisSpeeds(xSpeed, yspeed, roxation));
    m_xspeed = xSpeed;
    m_yspeed = yspeed;
    m_rotation = roxation;
    mecanumDriveOdometry.update(new Rotation2d(), mecanumDriveWheelSpeeds);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    int maxSpeed = 1;
    leftFrontCanSparkMax.set(mecanumDriveWheelSpeeds.frontLeftMetersPerSecond / maxSpeed);
      
  }
}
