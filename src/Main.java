import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int op;
        Boolean continuar = true;

        List<Vehiculos> lstVehiculos = new ArrayList<>();
        List<Clientes> lstClientes = new ArrayList<>();
        List<Vehiculos> lstAlquilados = new ArrayList<>();

        Clientes cl1 = Clientes.obtenerInstancia();

        do {
            System.out.println("""
                    -------------------------------------------------
                    1. REGISTRAR AUTO
                    2. REGISTRAR CAMIONETA
                    3. REGISTRAR CLIENTE
                    4. REALIZAR ALQUILER
                    5. COSTO TOTAL DEL ALQUILER
                    6. LISTA DE VEHICULOS DISPONIBLES
                    7. LISTA DE CLIENTES
                    8. DEVOLUCION DE UN VEHICULO
                    9. SALIR
                    -------------------------------------------------
                    """);
            op = teclado.nextInt();
            switch(op){
                case 1 -> {

                    Auto automovil = new Auto();

                    System.out.println("SE VA A REGISTRAR UN AUTO");
                    System.out.println(" ");
                    teclado.nextLine();
                    System.out.println("INGRESA LA MARCA DEL AUTO");
                    automovil.setMarca(teclado.next());
                    System.out.println("INGRESA EL MODELO DEL AUTO");
                    automovil.setModelo(teclado.next());
                    System.out.println("INGRESA EL AÑO DEL AUTO");
                    automovil.setAnio(teclado.nextInt());
                    System.out.println("INGRESA EL PRECIO POR DIA DEL AUTO");
                    automovil.setPrecioDia(teclado.nextDouble());
                    System.out.println("INGRESA EL NUMERO DE PUERTAS");
                    automovil.setNpuertas(teclado.nextInt());
                    automovil.setDisponibilidad(true);

                    Auto AutoMovil = new Auto(automovil.getMarca(), automovil.getModelo(), automovil.getAnio(), automovil.getPrecioDia(), automovil.getDisponibilidad(), automovil.getNpuertas());
                    lstVehiculos.add(AutoMovil);

                    System.out.println("AUTOMOVIL REGISTRADO CON EXITO");
                }
                case 2 ->{
                    Camioneta camioneta = new Camioneta();

                    System.out.println("SE VA A REGISTRAR UNA CAMIONETA");
                    System.out.println(" ");
                    teclado.nextLine();
                    System.out.println("INGRESA LA MARCA DE LA CAMIONETA");
                    camioneta.setMarca(teclado.next());
                    System.out.println("INGRESA EL MODELO DE LA CAMIONETA");
                    camioneta.setModelo(teclado.next());
                    System.out.println("INGRESA EL AÑO DE LA CAMIONETA");
                    camioneta.setAnio(teclado.nextInt());
                    System.out.println("INGRESA EL PRECIO POR DIA DE LA CAMIONETA");
                    camioneta.setPrecioDia(teclado.nextDouble());
                    System.out.println("INGRESA LA CAPACIDAD DE CARGA DE LA CAMIONETA");
                    camioneta.setcCarga(teclado.nextDouble());
                    camioneta.setDisponibilidad(true);

                    Camioneta Camion = new Camioneta(camioneta.getMarca(), camioneta.getModelo(), camioneta.getAnio(), camioneta.getPrecioDia(), camioneta.getDisponibilidad(), camioneta.getcCarga());
                    lstVehiculos.add(Camion);

                    System.out.println("CAMIONETA REGISTRADA CON EXITO");
                }
                case 3 -> {

                    teclado.nextLine();
                    System.out.println("SE VA A REGISTRAR UN CLIENTE");
                    System.out.println(" ");
                    System.out.println("INGRESE EL NOMBRE DEL CLIENTE");
                    cl1.setNombre(teclado.next());
                    System.out.println("INGRESE LA CEDULA DEL CLIENTE");
                    System.out.println("LA CEDULA DEBE CONTAR CON 10 DIGITOS");
                    String cedula = teclado.next();
                    if (cedula.matches("\\d{10,}")) {
                        cl1.setCedula(Integer.parseInt(cedula));
                    } else {
                        System.out.println("CEDULA INVALIDA, DEBE CONTENER 10 DATOS NUMERICOS");
                        return;
                    }
                    System.out.println("INGRESE LA LICENCIA DEL CLIENTE");
                    System.out.println("LA LICENCIA DEBE CONTAR CON 10 DIGITOS");
                    String licencia = teclado.next();
                    if (licencia.matches("\\d{10,}")) {
                        cl1.setLicencia(Integer.parseInt(licencia));
                    } else {
                        System.out.println("LICENCIA INVALIDA, DEBE CONTENER 10 DATOS NUMERICOS");
                        return;
                    }
                    lstClientes.add(new Clientes(cl1.getNombre(), cl1.getCedula(), cl1.getLicencia()));
                    System.out.println("CLIENTE CREADO");
                }
                case 4 ->{
                    String Nvehiculo;
                    System.out.println("INGRESE MODELO DEL VEHICULO QUE QUIERE ALQUILAR");
                    Vehiculos vehiculoAlquilado = null;
                    Nvehiculo = teclado.next();
                    for(int i = 0; i < lstVehiculos.size(); i++) {
                        if (lstVehiculos.get(i).getModelo().equalsIgnoreCase(Nvehiculo)) {
                            System.out.println(lstVehiculos.get(i));
                            vehiculoAlquilado = lstVehiculos.remove(i);
                            lstAlquilados.add(vehiculoAlquilado);
                        }
                    }
                    String Cliente;
                    System.out.println("INGRESE EL CLIENTE QUE DESEA ALQUILAR EL VEHICULO");
                    Cliente = teclado.next();
                    for(int j = 0; j < lstClientes.size(); j++) {
                        if (lstClientes.get(j).getNombre().equalsIgnoreCase(Cliente)){
                            System.out.println(lstClientes.get(j));
                        }
                    }
                    System.out.println("EL VEHICULO DE MODELO " +  vehiculoAlquilado.getModelo() + " HA SIDO ALQUILADO");
                    System.out.println("INGRESE EL NUMERO DE DIAS QUE VA A DURAR EL ALQUILER");
                    int Ndias;
                    Ndias = teclado.nextInt();
                    vehiculoAlquilado.setDiasAlquiler(Ndias);
                    System.out.println("EL VEHICULO SERA ALQUILADO POR " + Ndias + " DIAS");
                }
                case 5 -> {
                    System.out.println("INGRESE EL MODELO DEL VEHÍCULO ALQUILADO PARA CALCULAR EL COSTO TOTAL:");
                    String modeloAlquilado = teclado.next();
                    boolean encontrado = false;

                    for (Vehiculos vehiculo : lstAlquilados) {
                        if (vehiculo.getModelo().equalsIgnoreCase(modeloAlquilado)) {
                            if(vehiculo.getDiasAlquiler()<7) {
                                double costoTotal = vehiculo.getPrecioDia() * vehiculo.getDiasAlquiler();
                                System.out.println("EL COSTO TOTAL DEL ALQUILER ES DE " + costoTotal + " PESOS");
                                encontrado = true;
                                break;
                            } else {
                                double costoTotal = ((vehiculo.getPrecioDia() * vehiculo.getDiasAlquiler())*10)/100;
                                double costoTotalD = (vehiculo.getPrecioDia()* vehiculo.getDiasAlquiler())-costoTotal;
                                System.out.println("EL COSTO TOTAL DEL ALQUILER ES DE " + costoTotalD + " PESOS");
                                encontrado = true;
                                break;
                            }

                        }
                    }

                    if (!encontrado) {
                        System.out.println("VEHÍCULO NO ENCONTRADO O NO ESTÁ ALQUILADO.");
                    }
                }
                case 6 ->{
                    System.out.println(lstVehiculos);
                }
                case 7 ->{
                    System.out.println(lstClientes);
                }
                case 8 -> {
                    String Nvehiculo;
                    System.out.println("INGRESE MODELO DEL VEHICULO QUE QUIERE DEVOLVER");
                    Vehiculos vehiculoAlquilado = new Vehiculos();
                    Nvehiculo = teclado.next();
                    for (int i = 0; i < lstAlquilados.size(); i++) {
                        if (lstAlquilados.get(i).getModelo().equalsIgnoreCase(Nvehiculo)) {
                            System.out.println(lstAlquilados.get(i));
                            lstVehiculos.add(vehiculoAlquilado);
                            vehiculoAlquilado.setDiasAlquiler(0);
                            lstAlquilados.remove(vehiculoAlquilado);
                            System.out.println("EL VEHICULO HA SIDO DEVUELTO");
                        }
                    }
                }
                case 9 ->{
                    System.out.println("SALIENDO ...");
                    continuar = false;
                }
                default ->{
                    System.out.println("LA OPCCION NO EXISTE");
                }
            }
        }while(continuar);
    }
}