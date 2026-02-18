package model;

import java.util.Scanner;

public class CajeroModel {
    public Scanner sc = new Scanner(System.in);
    public String[] usuarios = {"1234", "5678"};
    public String[] nombres = {"Juan", "Maria"};
    public double[] saldos = {1000.0, 2500.0};

    public double deposito(double deposito, int usuarioActual) {
               return saldos[usuarioActual] += deposito;
    }
    public int IniciarSesion(String pin){
        for (int i = 0; i < usuarios.length; i++) {
                if (usuarios[i].equals(pin)) {
                    return i;
                }
            }
        return -1;
    }
    public boolean retiro(double cantidad, int usuarioActual) {
        if (cantidad > 0 && saldos[usuarioActual] >= cantidad) {
            saldos[usuarioActual] -= cantidad;
            return true; 
        }
        return false;
    }

    public String getNombre(int usuarioActual) {
        return nombres[usuarioActual];
    }

    public double getSaldo(int usuarioActual) {
        return saldos[usuarioActual];
    }
}
