/* Desarrollar un algoritmo en Java utilizando métodos, para calcular y mostrar el valor del subsidio que le corresponde a cada empleado de acuerdo a su perfil y número de hijos. Solo aplica para estratos socioeconómicos 1, 2 y 3.
Perfil A: >= 3 hijos; Perfil B: 2 hijos; Perfil C: 1 hijo.  
*/
import java.util.Scanner;
public class ejercicio4 {
    static int id;
    static String nomEmpleado;
    static byte nroHijos;
    static char salir;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        validarEstrato(sc);
        sc.close();
    }

    public static void validarEstrato(Scanner sc){
        byte estrato;
        System.out.println("\n== E N T R E G A  D E  S U B S I D I O S ==\n\nVALIDAR ESTRATO");
        System.out.print("Nro. estrato: ");
        estrato = sc.nextByte();
        if(estrato < 1 || estrato > 3){
            System.out.println("El subsidio solo aplica para estratos 1, 2 y 3.");
        } else {
            menu(sc);
        }
    }

    public static void menu(Scanner sc){  
        byte opcion; 
        boolean flag = true;
        
        System.out.print("Documento identidad: ");
        id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nombre: ");
        nomEmpleado = sc.nextLine();
        
        do {
            System.out.print("\n**** M E N U ****\n1. Perfil A.\n2. Perfil B.\n3. Perfil C.\n4. Salir.\nDigite una opción: ");
            opcion = sc.nextByte();
            
            switch (opcion) {
                case 1: 
                    subsidioA(sc);
                    break;
                case 2:
                    subsidioB(sc);
                    break;
                case 3:
                    subsidioC(sc);
                    break;
                case 4:
                    System.out.print("¿Está seguro de salir del sistema (S/N)?: ");
                    salir = sc.next().toUpperCase().charAt(0);
                    if(salir == 'S'){
                        flag = false;
                        System.out.println("Ha salido del sistema.");
                    }
                    else {
                        System.out.println("opcion incorrecta regresando al menu");
                    }
                    break;
                default:
                    System.out.println("Opción incorrecta. Intente de nuevo.");
            }
        } while(flag);
    } 

    public static void subsidioA(Scanner sc){ 
        int perfil_A = 900;
        System.out.println("\n== PERFIL A ==");
        System.out.print("Número de hijos: "); 
        nroHijos = sc.nextByte();
        if(nroHijos >= 3) {
            System.out.println("Usuario/a: " + nomEmpleado + " con ID " + id + ", ha sido beneficiado/a con un subsidio de $" + nroHijos * perfil_A);
        } else {
            System.out.println("Este perfil solo aplica para hijos igual o superior a tres.");
        }
    }

    public static void subsidioB(Scanner sc){ 
        int perfil_B = 700;
        System.out.println("\n== PERFIL B ==");
        System.out.print("Número de hijos: "); 
        nroHijos = sc.nextByte();
        if(nroHijos == 2) {
            System.out.println("Usuario/a: " + nomEmpleado + " con ID " + id + ", ha sido beneficiado/a con un subsidio de $" + nroHijos * perfil_B);
        } else {
            System.out.println("Este perfil solo aplica para empleados con dos hijos.");
        }
    }

    public static void subsidioC(Scanner sc){ 
        int perfil_C = 550;
        System.out.println("\n== PERFIL C ==");
        System.out.print("Número de hijos: "); 
        nroHijos = sc.nextByte();
        if(nroHijos == 1) {
            System.out.println("Usuario/a: " + nomEmpleado + " con ID " + id + ", ha sido beneficiado/a con un subsidio de $" + nroHijos * perfil_C);
        } else {
            System.out.println("Este perfil solo aplica para empleados con un (1) hijo.");
        }
    }
}