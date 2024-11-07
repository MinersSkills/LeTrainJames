package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.XboxController;

public class Intake {
    private CANSparkMax motor_robo;
    private XboxController controller;
    private boolean buttonAux = false;
    private boolean buttonState = false;
    private DigitalInput fimdeCU;

    public Intake() {
        motor_robo = new CANSparkMax(11, MotorType.kBrushless);
        controller = new XboxController(0);
        fimdeCU = new DigitalInput(2);
    }

    public void intake_motor() {
        boolean buttonB = controller.getBButton();

        if (buttonB && !buttonState) {
            buttonAux = !buttonAux;
        }
        buttonState = buttonB;

        if (buttonAux) {
            motor_robo.set(-1.0);
        } else {
            motor_robo.disable();
        }
    }

    public void setFimdeCurso(){
        if (fimdeCU.get() == false) {
            motor_robo.set(0);
            buttonAux = false;
        }
        else {
            return;
        }
    }
}