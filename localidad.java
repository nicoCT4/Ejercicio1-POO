import java.util.Random;

class Localidad {
    private int ticketNo;
    private int a;
    private int b;
    private int lugarDisponible; // Agregamos lugarDisponible y precio
    private int precio;

    public Localidad(int TicketNo) {
        this.ticketNo = TicketNo;
        this.a = numAl();
        this.b = numAl();
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    } // Método para establecer el precio

    public int getTicketNo() {
        return ticketNo;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getLugarDisponible() { // Método para obtener el lugar disponible
        return lugarDisponible;
    }

    public int getPrecio() { // Método para obtener el precio
        return precio;
    }

    public int numAl() {
        Random r = new Random();
        int numAl = r.nextInt(15000) + 1;
        return numAl;
    }

    public void venderBoletos(int cantidad) { // Método para vender boletos
        if (cantidad > 0 && cantidad <= lugarDisponible) {
            lugarDisponible -= cantidad;
        } else {
            System.out.println("Cantidad inválida de boletos para vender.");
        }
    }
}

