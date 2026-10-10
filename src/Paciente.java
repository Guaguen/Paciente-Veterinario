public class Paciente {
    private String nombre;
    private String especie;
    private int edad;
    private String propietario;

    public Paciente(String nombre, String especie, int edad, String propietario) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.propietario = propietario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return "Paciente [Nombre: " + nombre +
                ", Especie: " + especie +
                ", Edad: " + edad + " años" +
                ", Propietario: " + propietario + "]";
    }
}