//Atributos de la clase comprador
class Comprador {
    private String nombre;
    private String email;
    private int lugarDisponible;
    private int presupuesto;

    public Comprador(String nombre, String email, int lugarDisponible, int presupuesto) {
        this.nombre = nombre;
        this.email = email;
        this.lugarDisponible = lugarDisponible;
        this.presupuesto = presupuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public int getLugarDisponible() {
        return lugarDisponible;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void comprarBoletos(int cantidad, int costoTotal) {
        lugarDisponible -= cantidad;
        presupuesto -= costoTotal;
    }
}
