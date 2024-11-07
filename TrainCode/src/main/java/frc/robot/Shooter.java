package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.XboxController;

public class Shooter {
    private CANSparkMax shooter_1;
    private CANSparkMax shooter_2;
    private XboxController controller;
    private boolean Aux = false;
    private boolean State = false;
    private CANSparkMax articulate;
    // private boolean inicio = false;
    // private boolean fim = false;

    public Shooter() {
        shooter_1 = new CANSparkMax(3, MotorType.kBrushless);
        shooter_2 = new CANSparkMax(4, MotorType.kBrushless);
        controller = new XboxController(0);
        articulate = new CANSparkMax(40, MotorType.kBrushed);
    }

    public void shooter() {
        boolean buttonY = controller.getYButton();

        if (buttonY && !State) {
            Aux = !Aux;
        }
        State = buttonY;

        if (Aux) {
            shooter_1.set(-1);
            shooter_2.set(-1);
        }

        else {
            shooter_1.disable();
            shooter_2.disable();
        }
    }

    public void articulacao() {
        if(controller.getAButton()) {
            articulate.set(-0.2);
        }
        else {
            articulate.disable();
        }
    }
}
