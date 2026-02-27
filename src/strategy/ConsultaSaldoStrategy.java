package strategy;

import model.CajeroModel;
import view.VistaCajero;

public class ConsultaSaldoStrategy implements TransaccionStrategy {

    @Override
    public void ejecutar(CajeroModel modelo, VistaCajero vista, int usuarioActual) {
        double saldo = modelo.getSaldo(usuarioActual);
        vista.mostrarMensaje("Su saldo actual es: $" + saldo);
    }
}
