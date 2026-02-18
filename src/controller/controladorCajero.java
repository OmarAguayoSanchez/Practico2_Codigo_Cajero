package controller; 
import model.CajeroModel;
import view.VistaCajero;

public class controladorCajero {
    private CajeroModel modelo;
    private VistaCajero vista;
    private int usuarioActual;

    
    public controladorCajero(CajeroModel modelo, VistaCajero vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.usuarioActual = -1;
    }

    public void iniciar() {
        int intentos = 0;
        int usuarioActual = -1;
        while (intentos < 3 && usuarioActual == -1) {
            System.out.println("Ingrese su PIN: ");
            String pin = vista.pedirDato();

            usuarioActual = modelo.IniciarSesion(pin);

            if (usuarioActual == -1) {
                vista.mostrarMensaje("PIN incorrecto.");
                intentos++;
            }
        }
        if (usuarioActual == -1) {
            vista.mostrarMensaje("Demasiados intentos fallidos. Adiós.");
            return; // Detenemos el programa aquí
        }

        vista.mostrarMensaje("Bienvenido, " + modelo.getNombre(usuarioActual));
        boolean salir = true;
        while (salir) {
            int opcion = vista.menu();

            switch (opcion) {
                case 1: 
                    double saldo = modelo.getSaldo(usuarioActual);
                    vista.mostrarMensaje("Su saldo actual es: " + saldo);
                    break;

                case 2:
                    System.out.println("Ingrese cantidad a retirar: ");
                    double retiro = vista.pedirCantidad();
                    boolean exito = modelo.retiro(retiro, usuarioActual);
                    
                    if (exito) {
                        vista.mostrarMensaje("Retiro exitoso. Nuevo saldo: " + modelo.getSaldo(usuarioActual));
                    } else {
                        vista.mostrarMensaje("Saldo insuficiente o cantidad invalida.");
                    }
                    break;

                case 3:
                    System.out.println("Ingrese cantidad a depositar: ");
                    double montoDeposito = vista.pedirCantidad();
                    if (montoDeposito > 0) {
                        modelo.deposito(montoDeposito, usuarioActual);
                        vista.mostrarMensaje("Deposito recibido. Nuevo saldo: " + modelo.getSaldo(usuarioActual));
                    } else {
                        vista.mostrarMensaje("La cantidad debe ser mayor a cero.");
                    }
                    break;

                case 4:
                    vista.mostrarMensaje("Cerrando sesion... Gracias por usar nuestro cajero");
                    salir = false;
                    break;

                default:
                    vista.mostrarMensaje("Opcion Incorecta");
            }
        }
    }
}
