
import controller.controladorCajero;
import model.CajeroModel;
import view.VistaCajero;

public class Practica1Cajero {
    public static void main(String[] args) {
        VistaCajero vista= new VistaCajero();
        CajeroModel modelo= new CajeroModel();
        controladorCajero controlador = new controladorCajero(modelo,vista);
        controlador.iniciar();
    }
}
