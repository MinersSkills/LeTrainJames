package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.XboxController;

public class Drive {
    private VictorSPX frontleft = new VictorSPX(1);
    private VictorSPX backleft = new VictorSPX(4);
    private VictorSPX frontright = new VictorSPX(3);
    private VictorSPX backright = new VictorSPX(2);
    
     XboxController controller = new XboxController(0);


    public void drive() {
        double speed = controller.getRightX() / 3;
        double rotation = controller.getLeftY() / 3;

        double left = speed + rotation;
        double right = speed - rotation;

        frontleft.set(ControlMode.PercentOutput, left);
        backleft.set(ControlMode.PercentOutput, left);
        frontright.set(ControlMode.PercentOutput, right);
        backright.set(ControlMode.PercentOutput, right);
    }
}
