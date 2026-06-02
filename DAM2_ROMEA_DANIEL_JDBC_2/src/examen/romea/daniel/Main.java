package src.examen.romea.daniel;

import src.examen.romea.daniel.BEANS.CentroForense;
import src.examen.romea.daniel.BEANS.InformeForense;
import src.examen.romea.daniel.BEANS.MuestraForense;
import src.examen.romea.daniel.DAO.MuestraForenseDAOImpl;
import src.examen.romea.daniel.Motores.MotorFactory;
import src.examen.romea.daniel.Motores.MotorSQL;

public class Main {
    public static void main(String[] args) {


        MuestraForenseDAOImpl muestraDao = new MuestraForenseDAOImpl(MotorFactory.create(MotorFactory.POSTGRE));

        CentroForense centro = new CentroForense(1, "NOMBRE", "PAIS", 10);
        InformeForense informe = new InformeForense();
        MuestraForense newMuestra = new MuestraForense(1213, "TipoMuestra", "01/02/2026", "EstadoCustodia", centro, informe);

        muestraDao.add(newMuestra);
        muestraDao.update(newMuestra);
        System.out.println( muestraDao.find(2) );
        System.out.println( muestraDao.findAll() );
        System.out.println( muestraDao.findByCentro(centro) );

    }
}