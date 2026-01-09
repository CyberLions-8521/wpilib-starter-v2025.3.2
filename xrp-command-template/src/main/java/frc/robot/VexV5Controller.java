
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;

/** Add your docs here. */
public class VexV5Controller extends GenericHID {

    public VexV5Controller(int port) {
        super(port);
    }

    public double getLeftX() {
        return super.getRawAxis(0);
    }
    
    public double getLeftY() {
        return super.getRawAxis(1);
    }
      
    public double getRightX() {
        return super.getRawAxis(2);
    }
    
    public double getRightY() {
        return super.getRawAxis(3);
    }
    
    public boolean getButtonA() {
        return super.getRawButton(2);
    }
    
    public boolean getButtonB() {
        return super.getRawButton(1);
    }
    
    public boolean getButtonX() {
        return super.getRawButton(4);
    }
    
    public boolean getButtonY() {
        return super.getRawButton(3);
    }

    public boolean getUp() {
        return super.getRawButton(13);
    }

    public boolean getDown() {
        return super.getRawButton(14);
    }

    public boolean getLeft() {
        return super.getRawButton(15);
    }

    public boolean getRight() {
        return super.getRawButton(16);
    }

    public boolean getL1() {
        return super.getRawButton(5);
    }

    public boolean getL2() {
        return super.getRawButton(7);
    }

    public boolean getR1() {
        return super.getRawButton(6);
    }

    public boolean getR2() {
        return super.getRawButton(8);
    }


}
