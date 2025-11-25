import java.util.Scanner;

public class InventarioSupermercado {
    // Maximo de productos
    public static final int MAX_PRODUCTOS = 5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nombres y cantidades
        String[] nombres = new String[MAX_PRODUCTOS];
        int[] cantidades = new int[MAX_PRODUCTOS];

        // Registro de productos
        System.out.println("Registro de Productos");
        for (int i = 0; i < MAX_PRODUCTOS; i++) {
            System.out.print("Nombre del producto " + (i + 1) + ": ");
            nombres[i] = sc.nextLine();

            int cantidad;
            do {
                System.out.print("Cantidad de " + nombres[i] + ": ");
                cantidad = sc.nextInt();
                sc.nextLine(); 
                if (cantidad < 0) {
                    System.out.println("La cantidad no puede ser negativa, intente de nuevo.");
                }
            } while (cantidad < 0);
            cantidades[i] = cantidad;
        }


        int opcion;
        do {
            // Menu
            System.out.println("1. Mostrar todos los productos y existencias");
            System.out.println("2. Buscar un producto por nombre");
            System.out.println("3. Actualizar el inventario");
            System.out.println("4. Generar alerta de productos con cantidad menor a 10");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); // 

            switch (opcion) {
                case 1:
                    mostrarInventario(nombres, cantidades);
                    break;
                case 2:
                    System.out.print("Ingrese nombre del producto a buscar: ");
                    String buscar = sc.nextLine();
                    buscarProducto(nombres, cantidades, buscar);
                    break;
                case 3:
                    System.out.print("Ingrese nombre del producto a actualizar: ");
                    String actualizar = sc.nextLine();
                    actualizarInventario(nombres, cantidades, actualizar, sc);
                    break;
                case 4:
                    generarAlertas(nombres, cantidades);
                    break;
                case 5:
                    System.out.println("Saliendo del sistema, gracias por utilizarnos :) ");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opcion != 5);

        sc.close();
    }

    public static void mostrarInventario(String[] nombres, int[] cantidades) {
        int total = 0;
        System.out.println("\nProductos en inventario:");
        for (int i = 0; i < MAX_PRODUCTOS; i++) {
            System.out.println(nombres[i] + " -> " + cantidades[i] + " unidades");
            total += cantidades[i];
        }
        System.out.println("Total acumulado en inventario: " + total);
    }

    // Buscar producto
    public static void buscarProducto(String[] nombres, int[] cantidades, String buscar) {
        boolean encontrado = false;
        for (int i = 0; i < MAX_PRODUCTOS; i++) {
            if (nombres[i].equalsIgnoreCase(buscar)) {
                System.out.println("El producto " + nombres[i] + " tiene " + cantidades[i] + " unidades.");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }
    }

    // Actualizar inventario
    public static void actualizarInventario(String[] nombres, int[] cantidades, String producto, Scanner sc) {
        boolean encontrado = false;
        for (int i = 0; i < MAX_PRODUCTOS; i++) {
            if (nombres[i].equalsIgnoreCase(producto)) {
                System.out.print("Ingrese cantidad a modificar (ejemplo: +5 o -3): ");
                int cambio = sc.nextInt();
                sc.nextLine();

                if (cantidades[i] + cambio < 0) {
                    System.out.println("No se puede tener cantidad negativa.");
                } else {
                    cantidades[i] += cambio;
                    System.out.println("Nuevo stock de " + nombres[i] + ": " + cantidades[i]);
                }
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }
    }

    public static void generarAlertas(String[] nombres, int[] cantidades) {
        System.out.println("\nProductos con stock menor a 10:");
        boolean hayAlerta = false;
        for (int i = 0; i < MAX_PRODUCTOS; i++) {
            if (cantidades[i] < 10) {
                System.out.println(nombres[i] + " -> " + cantidades[i] + " unidades.");
                hayAlerta = true;
            }
        }
        if (!hayAlerta) {
            System.out.println("No hay alertas.");
        }
    }
}
