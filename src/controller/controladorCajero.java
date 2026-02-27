package controller; 

import model.CajeroModel;
import view.VistaCajero;
import strategy.*;
import java.util.HashMap;
import java.util.Map;

public class controladorCajero {
    private CajeroModel modelo;
    private VistaCajero vista;
    // Mapa para guardar nuestras estrategias
    private Map<Integer, TransaccionStrategy> estrategias; 

    public controladorCajero(CajeroModel modelo, VistaCajero vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        // Inicializamos y registramos las estrategias
        this.estrategias = new HashMap<>();
        this.estrategias.put(1, new ConsultaSaldoStrategy());
        this.estrategias.put(2, new RetiroStrategy());
        this.estrategias.put(3, new DepositoStrategy());
    }

    public void iniciar() {
        int intentos = 0;
        int usuarioActual = -1;
        
        while (intentos < 3 && usuarioActual == -1) {
            vista.mostrarMensaje("Ingrese su PIN: ");
            String pin = vista.pedirDato();

            usuarioActual = modelo.IniciarSesion(pin);

            if (usuarioActual == -1) {
                vista.mostrarMensaje("PIN incorrecto.");
                intentos++;
            }
        }
        
        if (usuarioActual == -1) {
            vista.mostrarMensaje("Demasiados intentos fallidos. Adiós.");
            return;
        }

        vista.mostrarMensaje("Bienvenido, " + modelo.getNombre(usuarioActual));
        boolean salir = false;
        
        while (!salir) {
            int opcion = vista.menu();

            if (opcion == 4) {
                vista.mostrarMensaje("Cerrando sesión... Gracias por usar nuestro cajero");
                salir = true;
                continue;
            }

            // Ejecutamos la estrategia basada en la opción del menú
            TransaccionStrategy estrategia = estrategias.get(opcion);
            
            if (estrategia != null) {
                estrategia.ejecutar(modelo, vista, usuarioActual);
            } else {
                vista.mostrarMensaje("Opción Incorrecta");
            }
        }
    }
}