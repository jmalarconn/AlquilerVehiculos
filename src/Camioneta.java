public class Camioneta extends Vehiculos{
    private double cCarga;

    public Camioneta(double cCarga) {
        this.cCarga = cCarga;
    }

    public Camioneta(){

    }

    public Camioneta(String marca, String modelo, int anio, double precioDia, boolean disponibilidad, double cCarga) {
        super(marca, modelo, anio, precioDia, disponibilidad);
        this.cCarga = cCarga;
    }

    public double getcCarga() {
        return cCarga;
    }

    public void setcCarga(double cCarga) {
        this.cCarga = cCarga;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Camioneta{" +
                "cCarga=" + cCarga +
                '}';
    }
}
