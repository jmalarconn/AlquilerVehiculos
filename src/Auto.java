public class Auto extends Vehiculos {
    private int Npuertas;

    public Auto(){

    }
    public Auto(int npuertas) {
        Npuertas = npuertas;
    }

    public Auto(String marca, String modelo, int anio, double precioDia, boolean disponibilidad, int npuertas) {
        super(marca, modelo, anio, precioDia, disponibilidad);
        Npuertas = npuertas;
    }

    public int getNpuertas() {
        return Npuertas;
    }

    public void setNpuertas(int npuertas) {
        Npuertas = npuertas;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Auto{" +
                "Npuertas=" + Npuertas +
                '}';
    }
}

