package tallerpilas.colas;

import java.util.Scanner;

public class TallerPilasColas {

    public static void main(String[] args) {
        Metodos metodos = new Metodos();
        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("\n-------------- Menú --------------");
            System.out.println("------PILAS-------");
            System.out.println("1. Apilar");
            System.out.println("2. Apilar por posición");
            System.out.println("3. Apilar por dato");
            System.out.println("4. Desapilar");
            System.out.println("5. Eliminar por posición de la pila");
            System.out.println("6. Eliminar por dato de la pila");
            System.out.println("7. Invertir pila");
            System.out.println("8. Mostrar pila");
            System.out.println("------COLAS-------");
            System.out.println("9. Encolar");
            System.out.println("10. Encolar por posición");
            System.out.println("11. Encolar por dato");
            System.out.println("12. Desencolar");
            System.out.println("13. Eliminar por posición de la cola");
            System.out.println("14. Eliminar por dato de la cola");      
            System.out.println("15. Invertir cola");       
            System.out.println("16. Mostrar cola");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = scanner.next();

            switch (opcion) {
                case "1":
                    System.out.print("Ingrese el dato a apilar (int o String): ");
                    metodos.apilar(scanner.next());
                    break;

                case "2":
                    System.out.print("Ingrese el dato a apilar (int o String): ");
                    String datoApilarPos = scanner.next();
                    System.out.print("Ingrese la posición: ");
                    metodos.apilarPorPosicion(datoApilarPos, scanner.nextInt());
                    break;

                case "3":
                    System.out.print("Ingrese el dato a apilar (int o String): ");
                    String datoApilarDato = scanner.next();
                    System.out.print("Ingrese el dato de referencia (int o String): ");
                    metodos.apilarPorDato(datoApilarDato, scanner.next());
                    break;

                case "4":
                    metodos.desapilar();
                    break;

                case "5":
                    System.out.print("Ingrese la posición a eliminar de la pila: ");
                    metodos.eliminarPorPosicionPila(scanner.nextInt());
                    break;

                case "6":
                    System.out.print("Ingrese el dato a eliminar de la pila (int o String): ");
                    metodos.eliminarPorDatoPila(scanner.next());
                    break;

                case "7":
                    metodos.invertirPila();
                    break;

                case "8":
                    metodos.mostrarPila();
                    break;

                case "9":
                    System.out.print("Ingrese el dato a encolar (int o String): ");
                    metodos.encolar(scanner.next());
                    break;

                case "10":
                    System.out.print("Ingrese el dato a encolar (int o String): ");
                    String datoEncolarPos = scanner.next();
                    System.out.print("Ingrese la posición: ");
                    metodos.encolarPorPosicion(datoEncolarPos, scanner.nextInt());
                    break;

                case "11":
                    System.out.print("Ingrese el dato a encolar (int o String): ");
                    String datoEncolarDato = scanner.next();
                    System.out.print("Ingrese el dato de referencia (int o String): ");
                    metodos.encolarPorDato(datoEncolarDato, scanner.next());
                    break;

                case "12":
                    metodos.desencolar();
                    break;

                case "13":
                    System.out.print("Ingrese la posición a eliminar de la cola: ");
                    metodos.eliminarPorPosicionCola(scanner.nextInt());
                    break;

                case "14":
                    System.out.print("Ingrese el dato a eliminar de la cola (int o String): ");
                    metodos.eliminarPorDatoCola(scanner.next());
                    break;

                case "15":
                    metodos.invertirCola();
                    break;

                case "16":
                    metodos.mostrarCola();
                    break;

                case "0":
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (!opcion.equals("0"));

        scanner.close();
    }
}
