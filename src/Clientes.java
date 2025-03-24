public class Clientes {
    private String nombre;
    private int cedula;
    private int Licencia;

    private static Clientes instancia;

    public static Clientes obtenerInstancia() {
        if (instancia == null) {
            instancia = new Clientes();
        }
        return instancia;
    }
    public Clientes(){

    }
    public Clientes(String nombre, int cedula, int licencia) {
        this.nombre = nombre;
        this.cedula = cedula;
        Licencia = licencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getLicencia() {
        return Licencia;
    }

    public void setLicencia(int licencia) {
        Licencia = licencia;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "nombre='" + nombre + '\'' +
                ", cedula=" + cedula +
                ", Licencia=" + Licencia +
                '}';
    }
}
