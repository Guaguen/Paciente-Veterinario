class Nodo {
    Paciente dato;
    Nodo siguiente;

    public Nodo(Paciente dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

public class ListaLigada {
    private Nodo cabeza;

    public ListaLigada() {
        this.cabeza = null;
    }

    public void agregar(Paciente paciente) {
        Nodo nuevoNodo = new Nodo(paciente);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        System.out.println("¡Paciente registrado exitosamente!");
    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("\nNo hay pacientes registrados en la lista.");
            return;
        }
        System.out.println("\n--- LISTA DE PACIENTES VETERINARIOS ---");
        Nodo actual = cabeza;
        int contador = 1;
        while (actual != null) {
            System.out.println(contador + ". " + actual.dato);
            actual = actual.siguiente;
            contador++;
        }
    }

    public boolean eliminar(String nombrePaciente) {
        if (cabeza == null) {
            return false;
        }

        if (cabeza.dato.getNombre().equalsIgnoreCase(nombrePaciente)) {
            cabeza = cabeza.siguiente;
            return true;
        }

        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.dato.getNombre().equalsIgnoreCase(nombrePaciente)) {
                actual.siguiente = actual.siguiente.siguiente;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    public double calcularPromedioEdad() {
        if (cabeza == null) {
            return 0.0;
        }
        int sumaEdades = 0;
        int totalPacientes = 0;
        Nodo actual = cabeza;
        while (actual != null) {
            sumaEdades += actual.dato.getEdad();
            totalPacientes++;
            actual = actual.siguiente;
        }
        return (double) sumaEdades / totalPacientes;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }
}