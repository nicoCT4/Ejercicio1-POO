//Atributos de la clase comprador
class comprador{
    private String nombre;
    private String email;
    private int lugarDisponible;
    private int precio;

//Constructor de la clase comprador
    public comprador(String nombre, String email, int lugarDisponible, int precio){
        this.nombre = nombre;
        this.email = email;
        this.lugarDisponible = lugarDisponible;
        this.precio = precio;
    }

//Getters de la clase comprador
    public String getNombre(){
        return nombre;
    }
    public String getEmail(){
        return email;
    }
    public int getLugarDisponible(){
        return lugarDisponible;
    }
    public int getPrecio(){
        return precio;
    }
}