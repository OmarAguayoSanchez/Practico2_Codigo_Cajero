
package strategy;

import model.CajeroModel;
import view.VistaCajero;

public interface TransaccionStrategy {
    void ejecutar(CajeroModel modelo, VistaCajero vista, int usuarioActual);
}
