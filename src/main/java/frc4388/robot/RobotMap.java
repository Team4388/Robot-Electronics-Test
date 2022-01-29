/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc4388.robot;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.sensors.PigeonIMU;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc4388.robot.Constants.DriveConstants;
import frc4388.robot.Constants.FalconTesterConstants;
import frc4388.robot.Constants.LEDConstants;
import frc4388.robot.Constants.SparkTesterConstants;
import frc4388.robot.subsystems.FalconTester;

/**
 * Defines and holds all I/O objects on the Roborio. This is useful for unit
 * testing and modularization.
 */
public class RobotMap {

    public RobotMap() {
        configureLEDMotorControllers();
        configureFalconTestMotorControllers();
        configureSparkTestMotor();
    }

    /* LED Subsystem */
    public final Spark LEDController = new Spark(LEDConstants.LED_SPARK_ID);

    void configureLEDMotorControllers() {
        
    }

    /* Falcon Tester */
    public final WPI_TalonFX falconTestMotor = new WPI_TalonFX(FalconTesterConstants.CAN_ID);
    void configureFalconTestMotorControllers() {
        falconTestMotor.configFactoryDefault();
        falconTestMotor.setNeutralMode(NeutralMode.Brake);
    }

    /* SparkMax Tester*/
    public final CANSparkMax sparkTestMotor = new CANSparkMax(SparkTesterConstants.CAN_ID, MotorType.kBrushless);
    void configureSparkTestMotor() {
        sparkTestMotor.restoreFactoryDefaults();
    }
}
