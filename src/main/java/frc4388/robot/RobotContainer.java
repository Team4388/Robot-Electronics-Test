/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc4388.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc4388.robot.Constants.*;
import frc4388.robot.subsystems.FalconTester;
import frc4388.robot.subsystems.LED;
import frc4388.robot.subsystems.SparkTester;
import frc4388.utility.LEDPatterns;
import frc4388.utility.controller.IHandController;
import frc4388.utility.controller.XboxController;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    /* RobotMap */
    private final RobotMap m_robotMap = new RobotMap();

    /* Subsystems */

    private final LED m_robotLED = new LED(m_robotMap.LEDController);

    // private final FalconTester m_falconTester = new FalconTester(m_robotMap.falconTestMotor);
    private final SparkTester m_SparkTester = new SparkTester(m_robotMap.sparkTestMotor);

    /* Controllers */
    private final XboxController m_driverXbox = new XboxController(OIConstants.XBOX_DRIVER_ID);
    private final XboxController m_operatorXbox = new XboxController(OIConstants.XBOX_OPERATOR_ID);

    /**
     * The container for the robot. Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        configureButtonBindings();

        /* Default Commands */
        // drives the robot with a two-axis input from the driver controller

        // m_falconTester.setDefaultCommand(
        //         new RunCommand(() -> m_falconTester.setMotorSpeed(0.1d * getDriverController().getLeftYAxis()),
        //          m_falconTester));
        
        m_SparkTester.setDefaultCommand(
                         new RunCommand(() -> m_SparkTester.setMotorSpeed(0.25d * getDriverController().getLeftYAxis()),
                          m_SparkTester));
        // continually sends updates to the Blinkin LED controller to keep the lights on
        m_robotLED.setDefaultCommand(new RunCommand(() -> m_robotLED.updateLED(), m_robotLED));
    }


    /**
     * Use this method to define your button->command mappings. Buttons can be
     * created by instantiating a {@link GenericHID} or one of its subclasses
     * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
     * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        /* Driver Buttons */
        // test command to spin the robot while pressing A on the driver controller
        // new JoystickButton(getDriverJoystick(), XboxController.A_BUTTON)
        //         .whileHeld(() -> m_robotDrive.driveWithInput(0, 1));

        /* Operator Buttons */
        // activates "Lit Mode"
        new JoystickButton(getOperatorJoystick(), XboxController.A_BUTTON)
                .whenPressed(() -> m_robotLED.setPattern(LEDPatterns.LAVA_RAINBOW))
                .whenReleased(() -> m_robotLED.setPattern(LEDConstants.DEFAULT_PATTERN));
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        // no auto
        return new InstantCommand();
    }

    /**
     * Add your docs here.
     */
    public IHandController getDriverController() {
        return m_driverXbox;
    }

    /**
     * Add your docs here.
     */
    public IHandController getOperatorController() {
        return m_operatorXbox;
    }

    /**
     * Add your docs here.
     */
    public Joystick getOperatorJoystick() {
        return m_operatorXbox.getJoyStick();
    }

    /**
     * Add your docs here.
     */
    public Joystick getDriverJoystick() {
        return m_driverXbox.getJoyStick();
    }
}
