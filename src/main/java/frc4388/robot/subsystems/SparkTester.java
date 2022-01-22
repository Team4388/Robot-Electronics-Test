// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc4388.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SparkTester extends SubsystemBase {
  /** Creates a new SparkTester. */
  public SparkTester(CANSparkMax m_sparkMaxMotor) {}

  public void setMotorSpeed(double speed) {
    speed = Double.max(Double.min(speed, 1.d), -1.d);
    m_sparkTestMotor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
