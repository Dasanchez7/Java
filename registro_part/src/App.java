import java.util.Scanner;

public class App {

    static int cantidad_cli = 1;  // Guarda cantidad cliente
    static String nombre_cli[] = new String [1]; // Guarda el nombre del cliente registrado
    static String ape_cli[] = new String[1]; // Guarda el apellido del cliente

    static String materiales[] = {"Martillo","Cortadora-Cesped","Planta-Electrica", "Aspiradora","Destornillador","Sierra","Lavamanos","Tanque-Agua","Tubo-Cobre","Cemento"}; // Productos
    static String id[] = {"ID #0001","ID #0002","ID #0003","ID #0004","ID #0005","ID #0006","ID #0007","ID #0008","ID #0009","ID #0010"}; // ID de productos 
    static int cantidad[] = {23,90,11,67,51,33,40,72,19,27}; // Cantidad de productos
    static int costo[] = {10,55,500,60,5,90,120,300,25,45}; // Costo de productos en $

    static int cantidad_materiales = 10;
    static int X;

    static int vef_iva = 0;
    static double vef_usd = 0;

    // Funcion para mostrar con 2 for la matriz de los materiales con su ID
    public static void showmateriales() {
        Scanner sc = new Scanner(System.in);

        System.out.print("1.- Mostrar un item en especifico \n2.- Mostrar todo los items \nIngrese la opcion a usar: ");
        int opc = sc.nextInt();
        
        switch(opc) {
            case 1:
                
                System.out.print("Ingrese la posicion a imprimir: ");
                X = sc.nextInt();
                
                for(int i = 0; i < 1; i++) {
                    System.out.println("Dato: " + "["+i+"]");
                    System.out.println(materiales[X]);
                    System.out.println(id[X]);
                    System.out.println("Cantidad: "+cantidad[X]);
                    System.out.println("Costo: "+costo[X]);
                }
            break;

            case 2:
     
                for(int i = 0; i < 10; i++) {
                    System.out.println("Dato: " + "["+i+"]");
                    System.out.println(materiales[i]);
                    System.out.println(id[i]);
                    System.out.println("Cantidad: "+cantidad[i]);
                    System.out.println("Costo: "+costo[i]);
                    System.out.println(" ");
                }
               
            break;

            default:
                System.out.println("Error, ingrese una opcion valida.");
            break;
        } 
    }

    public static void register_client() {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 1; i++) {
            System.out.print("\nIngrese nombre [" + i + "]:"); 
            nombre_cli[i] = sc.next();

            System.out.print("\nIngrese el apellido [" + i + "]:"); 
            ape_cli[i] = sc.next();
        }
    }

    public static void menu_opciones() {
        Scanner sc = new Scanner(System.in);
        int run = 1;
        int run2 = 1;
        int run3 = 1;
        int run4 = 1;
        int run5 = 1;

        do {
            System.out.println("\nIngrese la opcion que desea ejecutar? \n1.- Seccion Productos \n2.- Seccion Clientes \n3.- Carrito de Compra \n4.- Parametros \n5.- Exit ");
            System.out.println("\nIngrese el IVA y la tasa del dolar antes de comprar.");
            int opc = sc.nextInt();
            switch(opc) {

                case 1: 
                    System.out.println("\nHaz seleccionado la opcion 1. Seccion Producto");

                    do {
                        System.out.println("\nSeleccione una opcion: 1.- Lista de productos con su ID, 2.- Exit");
                        int menu_opc = sc.nextInt();

                        switch(menu_opc) {
                            case 1:
                                showmateriales();
                            break;

                            case 2:
                                System.out.println("Exit");
                                run2 = 0;
                            break;
                        }
                    }
                    while(run2==1);
                    
                break;

                case 2:
                    System.out.println("\nHaz seleccionado la opcion 2. Seccion Cliente");

                    do {
                        System.out.println("\nSeleccione una opcion: 1.- Registrar cliente, 2.- Ver clientes, 3.- Exit");
                        int menu_opc = sc.nextInt();

                        switch(menu_opc) {
                            case 1:
                                register_client();
                            break;

                            case 2:
                                System.out.println("Ver clientes: ");
                                
                                for (int i = 0; i < 1; i++) {
                                    System.out.println("\n\nNombre ["+ i +"]: " + nombre_cli[i]);
                                    System.out.println("\nApellido ["+ i +"]: " + ape_cli[i]);
                                }
                
                            break;

                            case 3:
                                run3 = 0;
                            break;

                            default:
                                System.out.println("Error, ingrese una opcion correcta.");
                            break;
                        }
                    }
                    while(run3==1);

                break;

                case 3:
                    System.out.println("\nHaz seleccionado la opcion 3. Carrito de Compra");
                    do{
                        System.out.println("1.- Comprar \n2.- Salir");
                        int menu_opc = sc.nextInt();

                        switch(menu_opc) {
                            case 1:
                                showmateriales();

                                System.out.println("Cuantos productos desea comprar: ");
                                int num_comprar = sc.nextInt();

                                
                                for(int i = 0; i < num_comprar; i++) {
                                    System.out.println("¿Que producto desea comprar?: ");
                                    int X = sc.nextInt();

                                    cantidad[X] = cantidad[X]-1;

                                    if(cantidad[X] == 0) {
                                        elimina1ElementoArray2(cantidad, X);
                                        mostrararraycantidad(X);

                                        for(int z = 0; z < 10; z++) {
                                            System.out.println(" ");
                                            System.out.println(materiales[z+1]);
                                            System.out.println(id[z+1]);
                                        }
                                        
                                    }
                                }
                    
                            break;

                            case 2:
                                run5 = 0;
                            break; 

                            default:
                                System.out.print("Error, ingrese una opcion correcta.");
                                run5 = 0;
                            break;
                        }                        
                    }
                    while(run5==1);

                break;
                
                case 4:
                    System.out.println("\nHaz seleccionado la opcion 4. Parametros");

                    do {
                        System.out.print("\nSeleccione una opcion: 1.- Colocar IVA, 2.- Valor del Dolar ($), 3.- Exit : ");
                        int menu_opc = sc.nextInt();

                        switch(menu_opc) {

                            case 1:

                            System.out.println("Valor actual: " + vef_iva);
                                
                            System.out.println("Coloque el IVA: ");
                            vef_iva = sc.nextInt();

                            System.out.println("Nuevos valor IVA: "+"\n"+vef_iva +"%");
                            
                            break;

                            case 2:

                                System.out.println("Valor actual: " + vef_usd);

                                System.out.print("Introduzca la tasa de cambio (USD ---> VEF) : ");
                                vef_usd = sc.nextDouble();

                                System.out.println("Nuevo valor de la Tasa de cambio: " + vef_usd + " VEF");

                            break;

                            case 3:
                                run4 = 0;
                            break;

                            default:
                                System.out.println("Error, ingrese una opcion correcta.");
                            break;
                        }
                    }
                    while(run4==1);

                break;

                case 5:
                    System.out.print("Haz seleccionado la opcion 5.- Salir");
                    run = 0;
                break;


                default:
                    System.out.println("Error, ingrese una opcion correcta.");
                break;
            }

        }
        while(run==1);
    }

    public static int[] elimina1ElementoArray2(int[] array, int valor) {
        int omitir = -1;//Inicializamos con un valor IMPOSIBLE en un array

        for (int i = 0; i < array.length; i++) {

            if (array[i] == valor) {

                omitir = i;//La variable "omitir" solo varia si encontramos el valor a eliminar

                break;//"Rompemos" el bucle for, no es necesario que siga buscando.

            }
        }

        if (omitir == -1) {//Conserva el valor IMPOSIBLE, por lo tanto, el valor a eliminar no existe en el array

            return array;//Devolvemos el array original sin ningún cambio.
        }
        else {

            int[] arrayModif = new int[array.length - 1];

            int indiceModif = 0;

            for (int i = 0; i < array.length; i++) {

                //La i del bucle for sera el indice para el array original

                if (i != omitir)//Si el indice es distinto de "omitir", entonces si copiamos el numero al nuevo array

                {

                    arrayModif[indiceModif] = array[i];

                    indiceModif++;//Incrementamos el indice del array modificado para apuntar a la siguiente posicion

                }

            }

            return arrayModif;

        }

    }

    public static void mostrararraycantidad(int k) {
        int valorEliminar = 0;

        k = valorEliminar;
        //Mostramos array sin modificar

        System.out.print("Valores del array: ");

        for (int valor: cantidad) {

            System.out.print(valor + " ");

        }

        System.out.println("\nVamos a eliminar: " + valorEliminar);

 
        cantidad = elimina1ElementoArray2(cantidad, valorEliminar);


        //Comprobamos si se ha eliminado

        System.out.print("Valores del array: ");

        for (int valor: cantidad) {

            System.out.print(valor + " ");

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bienvenido a FerreTodo, por favor ingrese una opcion en el menu");
        menu_opciones();

    }
}