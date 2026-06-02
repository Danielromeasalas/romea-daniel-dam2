package src.examen.romea.daniel.BEANS;

public class MuestraForense {

    private int id;
    private int codigoCaso;
    private String tipoMuestra;
    private String fechaRecogida;
    private String estadoCustodia;
    private CentroForense centro;


    public MuestraForense(int codigoCaso, String tipoMuestra, String fechaRecogida, String estadoCustodia, CentroForense centro) {
        this.codigoCaso = codigoCaso;
        this.tipoMuestra = tipoMuestra;
        this.fechaRecogida = fechaRecogida;
        this.estadoCustodia = estadoCustodia;
        this.centro = centro;
    }

    public MuestraForense(int id, int codigoCaso, String tipoMuestra, String fechaRecogida, String estadoCustodia, CentroForense centro) {
        this.id = id;
        this.codigoCaso = codigoCaso;
        this.tipoMuestra = tipoMuestra;
        this.fechaRecogida = fechaRecogida;
        this.estadoCustodia = estadoCustodia;
        this.centro = centro;
    }
}
