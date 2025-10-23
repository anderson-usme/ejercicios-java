import java.util.Scanner;
public class ejercicio5 {
    static Scanner sc = new Scanner(System.in);
    static float base, altura;
    public static void main(String[] args) {
        System.out.println("el area del cuadrado es: "+calcularCuadrado(base, altura));

        sc.close();
    }
    /* float pq es el tipo de datos que necesitamos */
    static float calcularCuadrado(float base, float altura){

        System.out.println("digita la base");
        base = sc.nextFloat();
        System.out.println("digita la altura");
        altura = sc.nextFloat();
        if (base<1 || altura<1) {
            System.out.println("los valores deben ser mayores a 0,intenta de nuevo: "); 
            System.exit(0);
        }
        return base*altura; //asi retornamos el resultado de esta multiplicacion y se guarda en el metodo calcularCuadrado

    }

    
}