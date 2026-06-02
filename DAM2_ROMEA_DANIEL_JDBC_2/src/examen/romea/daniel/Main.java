package romea.daniel;

import romea.daniel.BEANS.Agencia;
import romea.daniel.BEANS.Detalle;
import romea.daniel.BEANS.Satelite;
import romea.daniel.DAO.AgenciaDAOImpl;
import romea.daniel.DAO.SateliteDAOImpl;
import romea.daniel.Motores.MotorFactory;
import romea.daniel.Motores.MotorSQL;

public class Main {
    public static void main(String[] args) {

        MotorSQL motorSQL = MotorFactory.create(MotorFactory.POSTGRE);
        AgenciaDAOImpl aDao = new AgenciaDAOImpl(motorSQL);
        SateliteDAOImpl sDao = new SateliteDAOImpl(motorSQL);

        Agencia agencia4 = new Agencia("Agencia 4", "Francia");
        aDao.add(agencia4);
        Detalle detalleSat4 = new Detalle(1, 100, 100, 100);

        Satelite satelite4 = new Satelite("Satelite4", 100, 100, 100, true, aDao.find(3), detalleSat4);
        sDao.add(satelite4);


    }
}