
package strategy;

import model.CajeroModel;
import view.VistaCajero;

public class RetiroStrategy implements TransaccionStrategy {
    @Override
    public void ejecutar(CajeroModel modelo, VistaCajero vista, int usuarioActual) {
        vista.mostrarMensaje("Ingrese cantidad a retirar: ");
        double retiro = vista.pedirCantidad();
        
        if (modelo.retiro(retiro, usuarioActual)) {
            vista.mostrarMensaje("Retiro exitoso. Nuevo saldo: $" + modelo.getSaldo(usuarioActual));
        } else {
            vista.mostrarMensaje("Saldo insuficiente o cantidad inválida.");
        }
    }
}
