//@author: Nicolás Concuá
//Universidad del Valle de Guatemala
//Eras Tour - Ejercicio 1 POO
//Fecha 11/08/2023
//3 localidades: localidad 1= $100, localidad 2= $500, localidad 10 = $1000
//para cada localidad un maximo de 20 boletos

import java.util.Random;
import java.util.Scanner;

public class ErasTour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Comprador compradorActual = null;

        Localidad localidadAlejada = new Localidad(1);
        Localidad localidadMejorVista = new Localidad(5);
        Localidad localidadMejorLocalidad = new Localidad(10);

        localidadAlejada.setPrecio(100);
        localidadMejorVista.setPrecio(500);
        localidadMejorLocalidad.setPrecio(1000);

        while (true) {
            System.out.println("--------------------------------------------------");
            System.out.println("Bienvenido a Eras Tour");
            System.out.println("1. Registrarse");
            System.out.println("2. Comprar boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Salir");
            System.out.println("--------------------------------------------------");
            System.out.print("Ingrese la opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese su nombre:");
                    String nombre = sc.next();
                    System.out.println("Ingrese su correo electrónico:");
                    String email = sc.next();
                    System.out.println("Ingrese la cantidad de boletos que desea comprar:");
                    int cantidadBoletos = sc.nextInt();
                    System.out.println("Ingrese su presupuesto máximo:");
                    int presupuesto = sc.nextInt();
                    compradorActual = new Comprador(nombre, email, cantidadBoletos, presupuesto);
                    break;

                case 2:
                    if (compradorActual == null) {
                        System.out.println("Debe crear un nuevo comprador antes de solicitar boletos.");
                    } 
                    else {
                        int boletosVendidos = 0;
                        int totalBoletos= 60;
                        boolean boletosAptos = true; 
                        int a = new Random().nextInt(14999) + 1; // Generamos a
                        int b = new Random().nextInt(14999) + 1; // Generamos b

                        while (boletosVendidos < totalBoletos && boletosAptos) {
                            int ticket = new Random().nextInt(14999) + 1;

                            System.out.println("valor de a " + a);
                            System.out.println("valor de b " + b);
                            System.out.println("valor de ticket " + ticket);

                            if (ticket >= a && ticket <= b || ticket >= b && ticket <= a) {
                                System.out.println("El ticket es apto para comprar boletos.");
                                Localidad localidadSeleccionada = null;
                                int numeroLocalidad = new Random().nextInt(3);
                                if (numeroLocalidad == 0) {
                                    localidadSeleccionada = localidadAlejada;
                                } else if (numeroLocalidad == 1) {
                                    localidadSeleccionada = localidadMejorVista;
                                } else if (numeroLocalidad == 2) {
                                    localidadSeleccionada = localidadMejorLocalidad;
                                }

                                if (localidadSeleccionada.getLugarDisponible() > 0) {
                                    int cantidadBoletosDeseados = 1;

                                    if (cantidadBoletosDeseados <= localidadSeleccionada.getLugarDisponible()) {
                                        int costoTotal = cantidadBoletosDeseados * localidadSeleccionada.getPrecio();
                                        compradorActual.comprarBoletos(cantidadBoletosDeseados, costoTotal);
                                        localidadSeleccionada.venderBoletos(cantidadBoletosDeseados);

                                        System.out.println("Boletos vendidos con éxito.");
                                        System.out.println("Cantidad de boletos vendidos: " + cantidadBoletosDeseados);
                                        System.out.println("Total a pagar: $" + costoTotal);

                                        boletosVendidos++;
                                    } else {
                                        System.out.println("No hay suficientes boletos disponibles en la localidad seleccionada.");
                                    }
                                } else {
                                    System.out.println("La localidad seleccionada no tiene espacios disponibles.");
                                }
                            } else {
                                System.out.println("El ticket no es apto para comprar boletos.");
                                boletosAptos = false; // Establecemos la bandera en falso
                            }
                        }

                        if (boletosAptos) {
                            System.out.println("Se han vendido " + boletosVendidos + " boletos en total.");
                        } else {
                            System.out.println("No se pudieron vender boletos.");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Disponibilidad total de boletos:");
                    System.out.println("Localidad 1: " + localidadAlejada.getLugarDisponible());
                    System.out.println("Localidad 5: " + localidadMejorVista.getLugarDisponible());
                    System.out.println("Localidad 10: " + localidadMejorLocalidad.getLugarDisponible());
                    break;
                case 4:
                    System.out.println("Ingrese el número de localidad que desea consultar:");
                    int numeroLocalidad = sc.nextInt();
                    Localidad localidadSeleccionada = null;
                    if (numeroLocalidad == 1) {
                        localidadSeleccionada = localidadAlejada;
                    } else if (numeroLocalidad == 5) {
                        localidadSeleccionada = localidadMejorVista;
                    } else if (numeroLocalidad == 10) {
                        localidadSeleccionada = localidadMejorLocalidad;
                    }

                    if (localidadSeleccionada != null) {
                        System.out.println("Disponibilidad de boletos en la localidad " + numeroLocalidad + ": " + localidadSeleccionada.getLugarDisponible());
                    } else {
                        System.out.println("La localidad ingresada no existe.");
                    }
                    break;
                case 5:
                    int totalVentas = 0;
                    totalVentas += localidadAlejada.getPrecio() * (60 - localidadAlejada.getLugarDisponible());
                    totalVentas += localidadMejorVista.getPrecio() * (60 - localidadMejorVista.getLugarDisponible());
                    totalVentas += localidadMejorLocalidad.getPrecio() * (60 - localidadMejorLocalidad.getLugarDisponible());
                    System.out.println("Reporte de caja:");
                    System.out.println("Total de ventas: $" + totalVentas);
                    break;

                case 6:
                    System.out.println("Gracias por usar Eras Tour. ¡Hasta pronto!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        }
    }
}

