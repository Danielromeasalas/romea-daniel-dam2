package src.examen.romea.daniel.DAO;

import src.examen.romea.daniel.BEANS.CentroForense;
import src.examen.romea.daniel.Motores.MotorSQL;

import java.util.ArrayList;

public class CentroForenseDAOImpl extends AbstractDAO<CentroForense> {


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

    public CentroForenseDAOImpl(MotorSQL motorSQL) {
        super(motorSQL);
    }


    //Metodos
    @Override
    public void add(CentroForense centro) {
        System.out.println(centro.getNombre() + " anyadido");
    }

    @Override
    public void update(CentroForense centro) {
        System.out.println(centro.getNombre() + " actualziado");
    }

    @Override
    public CentroForense find(int id) {
        return null;
    }

    @Override
    public ArrayList<CentroForense> findAll() {
        return null;
    }


}
