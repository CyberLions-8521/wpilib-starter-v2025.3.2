package frc.robot.subsystems;

import edu.wpi.first.wpilibj.xrp.XRPMotor;
import edu.wpi.first.wpilibj.Encoder;

public class Drivebase {
    // motor & encoder attributes - can change
    private XRPMotor m_motorL;
    private XRPMotor m_motorR;

    private Encoder m_encoderL;
    private Encoder m_encoderR;

    //constant attributes
    private double wheelDiameter = 2.3622;
    private double wheelCircumference = wheelDiameter * Math.PI;
    private double countsPerWheelRev = 585;
    private double convFactor = wheelCircumference / countsPerWheelRev;

    private double trackWidth = 6.1;
    private double speed = 0.5;

    public Drivebase() {

    }
}
