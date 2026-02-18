
package view;

import java.util.Scanner;

public class VistaCajero {
    private Scanner sc =new Scanner(System.in);
    boolean salir = false;
     public int menu(){
         System.out.println("\n1. Ver saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            return sc.nextInt();
     }
     public String pedirDato(){
         return sc.nextLine();
     }
     public double pedirCantidad(){
         return sc.nextDouble();
     }
     public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
