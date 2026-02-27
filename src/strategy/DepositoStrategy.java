/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategy;

import model.CajeroModel;
import view.VistaCajero;

public class DepositoStrategy implements TransaccionStrategy {
    @Override
    public void ejecutar(CajeroModel modelo, VistaCajero vista, int usuarioActual) {
        vista.mostrarMensaje("Ingrese cantidad a depositar: ");
        double montoDeposito = vista.pedirCantidad();
        
        if (montoDeposito > 0) {
            modelo.deposito(montoDeposito, usuarioActual);
            vista.mostrarMensaje("Depósito recibido. Nuevo saldo: $" + modelo.getSaldo(usuarioActual));
        } else {
            vista.mostrarMensaje("La cantidad debe ser mayor a cero.");
        }
    }
}
