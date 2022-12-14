// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends CommandBase {
  /** Creates a new ACCELERATION_CONSTANT. */
    private DriveSubsystem m_drivetrain;
    private Joystick joystick;
    private double acceleration_constant;

  public DriveCommand(DriveSubsystem drivetrain, Joystick joystick){
    m_drivetrain = drivetrain;
    this.joystick = joystick;
    this.acceleration_constant = DriveConstants.ACCELERATION_CONSTANT;
    addRequirements(m_drivetrain);
  }
    // Use addRequirements() here to declare subsystem dependencies.

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = this. joystick.getY();
    double rotation = this.joystick.getX();
    double normalizedSpeed = Math.signum(speed) * Math.pow(speed, this.acceleration_constant);
    double normalizedRotation = Math.signum(rotation) * Math.pow(rotation, this.acceleration_constant);
    this.m_drivetrain.diffDrive(normalizedSpeed, -normalizedRotation);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
