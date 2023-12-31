// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.turnMotor;

public class Speed extends CommandBase {
    /** Creates a new Speed. */
  private DoubleSupplier speed;
  private turnMotor motor;
  /**
   * @param motor motor
   * @param speed speed
   */
  public Speed(turnMotor motor , DoubleSupplier speed) {
    this.speed = speed;
    this.motor = motor;
    addRequirements(motor);
  }
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  /* (non-Javadoc)
   * @see edu.wpi.first.wpilibj2.command.Command#execute()
   */
  @Override
  public void execute() {
    motor.motorspeed(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    motor.motorspeed(()-> 0); 
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
