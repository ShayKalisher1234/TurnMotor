// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Speed;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.turnMotor;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  private turnMotor motor;
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  //new xboxcontroller , joysticks 
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer(turnMotor motor) {
    this.motor = motor;
    configureBindings();
  }

  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));
   //  without defult, only works in one way : m_driverController.axisGreaterThan(XboxController.Axis.kLeftY.value, 0).whileTrue(new Speed(motor ,()-> m_driverController.getLeftY()));
   Default(XboxController.Axis.kLeftY.value, 0).whileTrue(new Speed(motor ,()-> m_driverController.getLeftY()));
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }


  private Trigger Default(int value, int i) {
    return null;
  }

  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
