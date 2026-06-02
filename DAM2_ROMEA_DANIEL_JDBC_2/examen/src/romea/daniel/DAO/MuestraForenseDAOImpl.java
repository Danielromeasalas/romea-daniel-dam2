package src.examen.romea.daniel.DAO;

import src.examen.romea.daniel.BEANS.CentroForense;
import src.examen.romea.daniel.BEANS.InformeForense;
import src.examen.romea.daniel.BEANS.MuestraForense;
import src.examen.romea.daniel.Motores.MotorFactory;
import src.examen.romea.daniel.Motores.MotorSQL;

import java.sql.ResultSet;
import java.util.ArrayList;

public class MuestraForenseDAOImpl extends AbstractDAO<MuestraForense> {

    private static final String SQL_ADD_MUESTRA =
            "INSERT INTO muestras_forenses (codigo_caso, tipo_muestra, fecha_recogida, estado_custodia, fk_centro_id) VALUES (?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE_MUESTRA =
            "UPDATE muestras_forenses SET codigo_caso=?,  tipo_muestra=?, fecha_recogida=?, estado_custodia=?, fk_centro_id=? WHERE id = ?";

    private static final String SQL_FIND_MUESTRA =
            "SELECT * FROM muestras_forenses WHERE id = ?";

    private static final String SQL_FIND_ALL_MUESTRA =
            "SELECT * FROM muestras_forenses ORDER BY id";

    private static final String SQL_FIND_BY_CENTRO =
            "SELECT * FROM muestras_forenses WHERE fk_centro_id = ? ORDER BY id";

    private static final String SQL_FIND_WITH_INFORME =
            "SELECT M.id, M.codigo_caso, M.fecha_recogida, M.estado_custodia, M.fk_centro_id " +
                    " I.id, I.adn_positivo, I.nivel_riesgo, I.conclusion FROM muestras_forenses M " +
                    "INNER JOIN informes_forenses ON M.id = I.fk_muestra_id WHERE M.id = ?, ORDER BY M.ID";


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

    public MuestraForenseDAOImpl(MotorSQL motorSQL) {
        super(motorSQL);
    }

    //Metodos

    private MuestraForense mapMuestra(ResultSet rs) throws Exception {

        MuestraForense newMuestra = new MuestraForense();

        newMuestra.setId(rs.getInt("id"));
        newMuestra.setTipoMuestra(rs.getString("tipo_muestra"));
        newMuestra.setFechaRecogida(rs.getString("fecha_recogida"));
        newMuestra.setEstadoCustodia(rs.getString("estado_custodia"));

        return newMuestra;
    }

    @Override
    public void add(MuestraForense muestra) {

    try{
        motorSQL.connect();
        motorSQL.prepare(SQL_ADD_MUESTRA);
        motorSQL.getPs().setInt(1, muestra.getCodigoCaso());
        motorSQL.getPs().setString(2, muestra.getTipoMuestra());
        motorSQL.getPs().setString(3, muestra.getFechaRecogida());
        motorSQL.getPs().setString(4, muestra.getEstadoCustodia());
        motorSQL.getPs().setInt(5, muestra.getCentro().getId());

        int rows = motorSQL.executeUpdate();
        System.out.println(
                "INSERTADOS: " +
                        rows);

    }catch (Exception e){
        printError(e);
    }finally {
        motorSQL.close();
    }

    }

    @Override
    public void update(MuestraForense muestra) {

        try{
            motorSQL.connect();
            motorSQL.prepare(SQL_UPDATE_MUESTRA);
            motorSQL.getPs().setInt(1, muestra.getCodigoCaso());
            motorSQL.getPs().setString(2, muestra.getTipoMuestra());
            motorSQL.getPs().setString(3, muestra.getFechaRecogida());
            motorSQL.getPs().setString(4, muestra.getEstadoCustodia());
            motorSQL.getPs().setInt(5, muestra.getCentro().getId());
            motorSQL.getPs().setInt(6, muestra.getId());

            int rows = motorSQL.executeUpdate();
            System.out.println("ACTUALIZADOS: " + rows);

        }catch (Exception e){
            printError(e);
        }finally {
            motorSQL.close();
        }

    }

    @Override
    public MuestraForense find(int id) {

        MuestraForense newMuestra = null;

        try{

            motorSQL.connect();
            motorSQL.prepare(SQL_FIND_MUESTRA);
            motorSQL.getPs().setInt(1, id);

            ResultSet rs = motorSQL.executeQuery();
            if(rs.next()){
                newMuestra = mapMuestra(rs);
            }

        }catch (Exception e){
            printError(e);
        }finally {
            motorSQL.close();
        }

        return newMuestra;

    }

    @Override
    public ArrayList<MuestraForense> findAll() {

        ArrayList<MuestraForense> muestras_forenses = new ArrayList<>();

        try{
            motorSQL.connect();
            motorSQL.prepare(SQL_FIND_ALL_MUESTRA);
            ResultSet rs = motorSQL.executeQuery();
            while(rs.next()){
                muestras_forenses.add(mapMuestra(rs));
            }

        }catch (Exception e){
            printError(e);
        }finally {
            motorSQL.close();
        }

        return muestras_forenses;
    }

    public ArrayList<MuestraForense> findByCentro(CentroForense centro) {
        ArrayList<MuestraForense> muestras_forenses = new ArrayList<>();
        int id_centro = centro.getId();

        try{
            motorSQL.connect();
            motorSQL.prepare(SQL_FIND_BY_CENTRO);
            motorSQL.getPs().setInt(1, id_centro);

            ResultSet rs = motorSQL.executeQuery();

            while(rs.next()){
                muestras_forenses.add(mapMuestra(rs));
            }

        }catch (Exception e){
            printError(e);
        }finally {
            motorSQL.close();
        }

        return muestras_forenses;
    }

    public void findWithInforme(MuestraForense muestra) {


    }

    public static void main(String[] args){
        MuestraForenseDAOImpl muestraForenseDAO = new MuestraForenseDAOImpl(MotorFactory.create(MotorFactory.ORACLE));
    }
}
