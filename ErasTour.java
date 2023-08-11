//@author: Nicolás Concuá
//Universidad del Valle de Guatemala
//Eras Tour - Ejercicio 1 POO
//Fecha 11/08/2023

import java.util.Scanner;

public class ErasTour{
    public static void main (String[] args){
        System.out.println("----------------------------------------------------");
        System.out.println("Bienvenido a Eras Tour");
        System.out.println("Estas son las opciones que tenemos para ti");
        System.out.println("1. Comprar boletos");
        System.out.println("2. Nueva solicitud de boletos");
        System.out.println("3. Consultar disponibilidad total");
        System.out.println("4. Consultar disponibilidad por localidad");
        System.out.println("5 reporte de ventas");
        System.out.println("6. Salir");
        System.out.println("----------------------------------------------------");
        Scanner sc = new Scanner(System.in);
        int opcion =1;

        while (opcion != 6){
            System.out.println("Ingrese la opcion que desea realizar");
            opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Ingrese su nombre");
                    String nombre = sc.next();
                    System.out.println("Ingrese su correo electronico");
                    String email = sc.next();
                    System.out.println("Ingrese la cantidad de boletos que desea comprar");
                    int lugarDisponible = sc.nextInt();
                    System.out.println("Ingrese el precio que desea pagar por cada boleto");
                    int precio = sc.nextInt();
                    comprador c = new comprador(nombre, email, lugarDisponible, precio);
                    System.out.println("Su compra ha sido realizada con exito");
                    System.out.println("----------------------------------------------------");
                    break;
                case 2:
                    System.out.println("Ingrese el numero de boletos que desea solicitar");
                    int TicketNo = sc.nextInt();
                    System.out.println("Ingrese el numero de boletos que desea solicitar");
                    int a = sc.nextInt();
                    System.out.println("Ingrese el numero de boletos que desea solicitar");
                    int b = sc.nextInt();
                    Localidad l = new Localidad(TicketNo, a, b);
                    System.out.println("Su solicitud ha sido realizada con exito");
                    System.out.println("----------------------------------------------------");
                    break;
                case 3:
                    System.out.println("La disponibilidad total es de: ");
                    System.out.println("----------------------------------------------------");
                    break;
                case 4:
                    System.out.println("Ingrese la localidad que desea consultar");
                    String localidad = sc.next();
                    System.out.println("La disponibilidad de la localidad " + localidad + " es de: ");
                    System.out.println("----------------------------------------------------");
                    break;
                case 5:
                    System.out.println("El reporte de ventas es el siguiente: ");
                    System.out.println("----------------------------------------------------");
                    break;
                case 6:
                    System.out.println("Gracias por visitar Eras Tour");
                    System.out.println("----------------------------------------------------");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    System.out.println("----------------------------------------------------");
                    break;
            }
        }

    }
}