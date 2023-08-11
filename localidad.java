//importamos la librerira random
import java.util.Random;
//TicketNo, a y b seran numeros aleatorios de 1 a 15000
//Se agregran los atributos de la clase Localidad
class Localidad{
    private int TicketNo;
    private int a;
    private int b;

//Se crea el constructor de la clase Localidad
    public Localidad(int TicketNo, int a, int b){
        this.TicketNo = TicketNo;
        this.a = a;
        this.b = b;
    }
//Se crean los getters 
    public int getTicketNo(){
        return TicketNo;
    }
    public int geta(){
        return a;
    }
    public int getb(){
        return b;
    }
//Se crea el metodo para generar numeros aleatorios
    public int NumAl(){
        Random r = new Random();
        int NumAl = r.nextInt(15000)+1;
        return NumAl;
    }
}