import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaLigada listaPacientes = new ListaLigada();
        int opcion = 0;

        do {
            System.out.println("\n=== SISTEMA DE GESTION - CLINICA VETERINARIA ===");
            System.out.println("1. Registrar nuevo paciente");
            System.out.println("2. Mostrar pacientes registrados");
            System.out.println("3. Eliminar paciente por nombre");
            System.out.println("4. Calcular promedio de edad de los pacientes (Extra)");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el nombre del paciente: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese la especie (Ej. Perro, Gato): ");
                        String especie = scanner.nextLine();
                        System.out.print("Ingrese la edad (anos): ");
                        int edad = scanner.nextInt();
                        scanner.nextLine(); // Limpiar buffer
                        System.out.print("Ingrese el nombre del propietario: ");
                        String propietario = scanner.nextLine();

                        Paciente nuevoPaciente = new Paciente(nombre, especie, edad, propietario);
                        listaPacientes.agregar(nuevoPaciente);
                        break;

                    case 2:
                        listaPacientes.mostrar();
                        break;

                    case 3:
                        if (listaPacientes.estaVacia()) {
                            System.out.println("\nNo hay pacientes para eliminar.");
                            break;
                        }
                        System.out.print("Ingrese el nombreexacto del paciente a eliminar: ");
                        String nombreEliminar = scanner.nextLine();
                        boolean eliminado = listaPacientes.eliminar(nombreEliminar);
                        if (eliminado) {
                            System.out.println("¡Paciente eliminado correctamente!");
                        } else {
                            System.out.println("No se encontro un paciente con ese nombre.");
                        }
                        break;

                    case 4:
                        if (listaPacientes.estaVacia()) {
                            System.out.println("\nNo hay pacientes registrados para calcular el promedio.");
                        } else {
                            double promedio = listaPacientes.calcularPromedioEdad();
                            System.out.println("\nEl promedio de edad de los pacientes es: " + promedio + " anos.");
                        }
                        break;

                    case 5:
                        System.out.println("\nSaliendo del sistema. ¡Hasta luego!");
                        break;

                    default:
                        System.out.println("\nOpcion invalida. Intente de nuevo.");
                }
            } else {
                System.out.println("\nPor favor, ingrese un numero valido.");
                scanner.next();
            }

        } while (opcion != 5);

        scanner.close();
    }
}