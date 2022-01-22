// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc4388.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FalconTester extends SubsystemBase {
  WPI_TalonFX m_FalconTestMotor;

  /** Creates a new FalconTester. */
  public FalconTester(WPI_TalonFX falconTestMotor) {
    m_FalconTestMotor = falconTestMotor;
  }

  public void setMotorSpeed(double speed) {
    speed = Double.max(Double.min(speed, 1.d), -1.d);
    m_FalconTestMotor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
