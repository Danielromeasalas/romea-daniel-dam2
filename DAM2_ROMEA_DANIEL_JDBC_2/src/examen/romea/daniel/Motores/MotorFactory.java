package romea.daniel.Motores;

import romea.daniel.Motores.PostgreMotorSQL;

public class MotorFactory {

    public static final String POSTGRE = "POSTGRE";
    public static final String ORACLE = "ORACLE";

    public MotorFactory() {
    }

    public static MotorSQL create(String motor) {
        if (motor.equals(POSTGRE)) {
            return new PostgreMotorSQL();
        } else {
            throw new IllegalArgumentException("Motor no soportado");
        }
    }
}
