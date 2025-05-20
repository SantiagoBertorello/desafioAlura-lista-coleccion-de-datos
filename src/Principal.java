import modelos.Producto;

import java.util.*;

public class Principal {
    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);
        List<Producto> compraRealizada = new ArrayList<>();

        System.out.println("Ingrese Cuanto de Crédito disponible tiene en la tarjeta: ");
        double limiteTarjetaDeCredito = teclado.nextInt();
        int opcion;

        do {
            System.out.println("\n1. Agregar compra");
            System.out.println("0. Salir y ver compras");
            System.out.print("Elija una opción: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Escriba la descripción de la compra: ");
                    teclado.nextLine(); // Limpiar el buffer
                    String descripcion = teclado.nextLine();

                    System.out.print("Escriba el valor de la compra: ");
                    double valor = teclado.nextDouble();

                    if (valor <= limiteTarjetaDeCredito && limiteTarjetaDeCredito != 0) {
                        compraRealizada.add(new Producto(descripcion, valor));
                        limiteTarjetaDeCredito -= valor;
                        System.out.println("Compra agregada. Crédito restante: $" + limiteTarjetaDeCredito);
                    } else {
                        System.out.println("No tiene suficiente crédito para esta compra.");
                    }
                    break;

                case 0:
                    // Ordenamos por precio
                    compraRealizada.sort(Comparator.comparingDouble(Producto::getValorProducto));
                    System.out.println("\n##############################");
                    System.out.println("\nCOMPRAS REALIZADAS:");
                    compraRealizada.forEach(System.out::println);
                    System.out.println("\nCrédito restante: $" + limiteTarjetaDeCredito);
                    System.out.println("\n##############################");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        teclado.close();
    }
}

