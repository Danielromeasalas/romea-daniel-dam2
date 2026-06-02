package src.examen.romea.daniel.DAO;

import src.examen.romea.daniel.BEANS.InformeForense;
import src.examen.romea.daniel.Motores.MotorSQL;

import java.util.ArrayList;

public class InformesForensesDAOImpl extends AbstractDAO<InformeForense> {

    //Comprobacion y constructor
    public void check() {
        try {
            motorSQL.connect();
            if (motorSQL.conn != null &&
                    !motorSQL.conn.isClosed()) {
                System.out.println("CONEXION OK");
            }
        } catch (Exception e) {
            printError(e);
        } finally {
            motorSQL.close();
        }
    }

    public InformesForensesDAOImpl(MotorSQL motorSQL) {
        super(motorSQL);
    }

    //Metodos

    @Override
    public void add(InformeForense informe) {
        System.out.println("Informe anyadido");
    }

    @Override
    public void update(InformeForense informe) {
        System.out.println("Informe actualziado");
    }

    @Override
    public InformeForense find(int id) {
        return null;
    }

    @Override
    public ArrayList<InformeForense> findAll() {
        return null;
    }
}
