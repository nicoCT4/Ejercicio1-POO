//@author: Nicolás Concuá
//Universidad del Valle de Guatemala
//Eras Tour - Ejercicio 1 POO
//Fecha 11/08/2023

import java.util.Random;
import java.util.Scanner;
/**
 * Clase principal que simula la venta de boletos para el tour.
 */
public class ErasTour {
    /**
     * Método principal que ejecuta el programa.
        * @param args
        */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Comprador compradorActual = null;
        Random random = new Random();

        //crear instancias de localidades
        Localidad localidad1 = new Localidad(1,20);
        Localidad localidad5 = new Localidad(5,20);
        Localidad localidad10 = new Localidad(10,20);

        //establecer precios
        localidad1.setPrecio(100);
        localidad5.setPrecio(500);
        localidad10.setPrecio(1000);

        while (true) {
            //Mostrar menú
            System.out.println("--------------------------------------------------");
            System.out.println("Bienvenido a Eras Tour, estas son las opciones:");
            System.out.println("1. Registrarse");
            System.out.println("2. Comprar boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Salir");
            System.out.println("--------------------------------------------------");
            System.out.print("Ingrese la opción que desea: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    //Opción para crear un nuevo comprador
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
                    //Opción para comprar boletos
                    if (compradorActual == null) {
                        System.out.println("Debe crear un nuevo comprador antes de solicitar boletos.");
                    } else {
                        int boletosVendidos = 0;
                        int totalBoletos = 60;
                        boolean boletosAptos = true;
                        // prueba int a = 5;
                        //prueba int b = 10;
                        int a= random.nextInt(14999)+1;
                        int b= random.nextInt(14999)+1;
            
                        while (boletosVendidos < totalBoletos && boletosAptos) {
                            //numeor de prueba int ticket = 7;
                            int ticket = random.nextInt(14999)+1;
            
                            System.out.println("valor de a " + a);
                            System.out.println("valor de b " + b);
                            System.out.println("valor de ticket " + ticket);
            
                            if (ticket >= a && ticket <= b || ticket >= b && ticket <= a) {
                                System.out.println("El ticket es apto para comprar boletos.");
                                Localidad localidadSeleccionada = null;
                                int numeroLocalidad = random.nextInt(3);
                                if (numeroLocalidad == 0) {
                                    localidadSeleccionada = localidad1;
                                    System.out.println("Le a tocado la localidad: 1");
                                } else if (numeroLocalidad == 1) {
                                    localidadSeleccionada = localidad5;
                                    System.out.println("Le a tocado la localidad: 5");
                                } else if (numeroLocalidad == 2) {
                                    localidadSeleccionada = localidad10;
                                    System.out.println("Le a tocado la localidad: 10");
                                }
            
                                if (localidadSeleccionada.getLugarDisponible() > 0) {
                                    int cantidadBoletosDeseados = compradorActual.getLugarDisponible();
            
                                    if (cantidadBoletosDeseados <= localidadSeleccionada.getLugarDisponible()) {
                                        int costoTotal = cantidadBoletosDeseados * localidadSeleccionada.getPrecio();
            
                                        if (costoTotal > compradorActual.getPresupuesto()) {
                                            System.out.println("El precio de la sección es mayor al presupuesto. No se puede comprar.");
                                            boletosAptos = false;
                                            break;
                                        }
            
                                        compradorActual.comprarBoletos(cantidadBoletosDeseados, costoTotal);
                                        localidadSeleccionada.venderBoletos(cantidadBoletosDeseados);
            
                                        System.out.println("Boletos vendidos con éxito.");
                                        System.out.println("Cantidad de boletos vendidos: " + cantidadBoletosDeseados);
                                        System.out.println("Total a pagar: $" + costoTotal);
            
                                        boletosVendidos += cantidadBoletosDeseados;
                                        break;
                                    } else {
                                        System.out.println("No hay suficientes boletos disponibles en la localidad seleccionada.");
                                        break;
                                    }
                                } else {
                                    System.out.println("La localidad seleccionada no tiene espacios disponibles.");
                                }
                            } else {
                                System.out.println("El ticket no es apto para comprar boletos.");
                                boletosAptos = false;
                            }
                        }
            
                        if (boletosAptos) {
                            System.out.println("Se han vendido " + boletosVendidos + " boletos en total.");
                            System.out.println("Si desea comprar más boletos, debe registrar un nuevo comprador.");
                        } else {
                            System.out.println("No se pudieron vender boletos.");
                        }
                    }
                    break;
                
                case 3:
                    //Opción para consultar disponibilidad total
                    System.out.println("Disponibilidad total de boletos:");
                    System.out.println("Localidad 1: " + localidad1.getLugarDisponible());
                    System.out.println("Localidad 5: " + localidad5.getLugarDisponible());
                    System.out.println("Localidad 10: " + localidad10.getLugarDisponible());
                    break;
                case 4:
                    //Opción para consultar disponibilidad individual
                    System.out.println("Ingrese el número de localidad que desea consultar:");
                    System.out.println("Localidad  1");
                    System.out.println("Localidad  5");
                    System.out.println("Localidad 10");
                    int numeroLocalidad = sc.nextInt();
                    Localidad localidadSeleccionada = null;
                    if (numeroLocalidad == 1) {
                        localidadSeleccionada = localidad1;
                    } else if (numeroLocalidad == 5) {
                        localidadSeleccionada = localidad5;
                    } else if (numeroLocalidad == 10) {
                        localidadSeleccionada = localidad10;
                    }

                    if (localidadSeleccionada != null) {
                        System.out.println("Disponibilidad de boletos en la localidad " + numeroLocalidad + ": " + localidadSeleccionada.getLugarDisponible());
                    } else {
                        System.out.println("La localidad ingresada no existe.");
                    }
                    break;
                case 5:
                    //Opción para consultar reporte de caja
                    int totalVentas = 0;
                    totalVentas += localidad1.getPrecio() * (20 - localidad1.getLugarDisponible());
                    totalVentas += localidad5.getPrecio() * (20 - localidad5.getLugarDisponible());
                    totalVentas += localidad10.getPrecio() * (20 - localidad10.getLugarDisponible());
                    System.out.println("Reporte de caja:");
                    System.out.println("Total de ventas: $" + totalVentas);
                    break;

                case 6:
                    //Opción para salir del programa
                    System.out.println("Gracias por usar Eras Tour. ¡Hasta pronto!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
            }
        }
    }
}

