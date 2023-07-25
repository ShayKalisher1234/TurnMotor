// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class turnMotor extends SubsystemBase {
  /** Creates a new turnMotor. */
  private CANSparkMax motor; 
  public turnMotor() {
    motor = new CANSparkMax(18, MotorType.kBrushless);
  }  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

public void motorspeed(DoubleSupplier speed ) {
  motor.set(speed.getAsDouble());
}
}

