package src.examen.romea.daniel.DAO;

import src.examen.romea.daniel.Motores.MotorSQL;

import java.util.ArrayList;

public abstract class AbstractDAO<T> implements DAO<T>{

    protected MotorSQL motorSQL;
    public AbstractDAO(MotorSQL motorSQL) {
        this.motorSQL = motorSQL;
    }
    protected void printError(Exception e){
        System.out.println("[ERROR] " + e.getMessage());
    }

}
