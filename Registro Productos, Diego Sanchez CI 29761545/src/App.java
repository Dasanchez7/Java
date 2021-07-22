import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int selec;
        int run = 1;

        System.out.println("\nIngrese el # de prductos a ingresar: ");
        
        int num_produ = sc.nextInt();

        //Declaracion de los arrays
        double tasa_dolar = 3200000.0;
        double[] precio_dolar = new double [num_produ];
        double[] precio_vef = new double [num_produ];
        String[] nombre = new String[num_produ];
        String[] id = new String[num_produ];
        double[] price = new double[num_produ];
        int[] cantidad = new int[num_produ];

        // For para pedir los datos
        for (int i = 0; i < num_produ; i++) {

            System.out.print("\nIngrese nombre [" + i + "]:"); 
            nombre[i] = sc.next();

            System.out.print("\nIngrese el ID [" + i + "]:"); 
            id[i] = sc.next();

            System.out.print("\nCantidad (INTERGER) [" + i + "]:"); 
            cantidad[i] = sc.nextInt();

            System.out.print("\nIngrese el Precio (USD DOUBLE) [" + i + "]:"); 
            price[i] = sc.nextDouble();

            precio_dolar[i] = price[i] * cantidad[i];
            precio_vef[i] = price[i] * tasa_dolar * cantidad[i];
        }

        // Do while para que se ejecute x cantidad de veces el menu
        do {
            System.out.println("\n 1.- Lista de Productos \n 2.- Editar productos \n 3.- Total bruto (VEF Y USD) \n 4.- Config (Agregar tasa de cambio) \n 5.- Salir");

            System.out.print("\nSeleccione una opcion: "); 
            selec = sc.nextInt();

            switch(selec) {
                case 1:
                    System.out.print("\n 1.- Lista de productos");

                    //Muestra los productos registrados
                    for (int i = 0; i < num_produ; i++) {
                        System.out.println("\n\nNombre ["+ i +"]: " + nombre[i]);
                        System.out.println("\nID ["+ i +"]: " + id[i]);
                        System.out.println("\nPrecio por Unidad USD ["+ i +"]: " + price[i]);
                        System.out.println("\nCantidad ["+ i +"]: " + cantidad[i]);
                    }
                break;

                case 2:
                    System.out.print("\n 2.- Editar productos \nValores antes de editar");

                    //Muestra los productos registrados
                    for (int i = 0; i < num_produ; i++) {
                        System.out.println("\n\nNombre ["+ i +"]: " + nombre[i]);
                        System.out.println("\nID ["+ i +"]: " + id[i]);
                        System.out.println("\nPrecio por Unidad USD ["+ i +"]: " + price[i]);
                        System.out.println("\nCantidad ["+ i +"]: " + cantidad[i]);
                    }

                    // For para editar cada valor de un array que haya sido seleccionado
                    for(int i = 0; i < num_produ; i++) {

                        System.out.print("\nIntroduzca la propiedad a cambiar ["+ i +"] <1.- Nombre > <2.- ID> <3.- Cantidad> <4.- Precio USD> :");
                        int propiedad = sc.nextInt();

                        if (propiedad == 1) {
                            System.out.println("\nCambiar nombre ["+ i +"]: "); 
                            nombre[i] = sc.next();
                        }
                        else if(propiedad == 2) {
                            System.out.println("\nCambiar ID ["+ i +"]: ");
                            id[i] = sc.next();
                        }
                        else if(propiedad == 3) {
                            System.out.println("\nCambiar cantidad ["+ i +"]: ");
                            cantidad[i] = sc.nextInt();
                        }
                        else if(propiedad == 4) {
                            System.out.print("\nCambiar precio (USD DOUBLE) ["+ i +"]: ");
                            price[i] = sc.nextDouble();
                            precio_dolar[i] = price[i] * cantidad[i];
                            precio_vef[i] = price[i] * tasa_dolar * cantidad[i];
                        }
                        else {
                            System.out.print("Error");
                        }
                        // Formula para sacar el precio en $ y VEF del producto registrado
                        precio_dolar[i] = price[i] * cantidad[i];
                        precio_vef[i] = price[i] * tasa_dolar * cantidad[i];
                    }
                    // Otro for para mostrar los valores despues de la edicion
                    for (int i = 0; i < num_produ; i++) {
                        System.out.println("\n\nNombre ["+ i +"]: " + nombre[i]);
                        System.out.println("\nID ["+ i +"]: " + id[i]);
                        System.out.println("\nPrecio por Unidad USD ["+ i +"]: " + price[i]);
                        System.out.println("\nCantidad ["+ i +"]: " + cantidad[i]);
                    }
                break;
                
                case 3:
                    System.out.print("\n 3.- Total bruto (VEF Y USD)");

                    // Muestra los datos previos y el total bruto
                    for (int i = 0; i < num_produ; i++) {
                    	System.out.println("\n\nLa tasa del dolar tiene un valor de: " + tasa_dolar);
                        System.out.println("\n\nNombre ["+ i +"]: " + nombre[i]);
                        System.out.println("\nID ["+ i +"]: " + id[i]);
                        System.out.println("\nCantidad ["+ i +"]: " + cantidad[i]);
                        System.out.println("\nPrecio por Unidad USD ["+ i +"]: " + price[i]);
                        System.out.println("\nTIene un Precio bruto en USD ["+ i +"]: " + precio_dolar[i]);
                        System.out.println("\nTiene un Precio bruto en VEF ["+ i +"]: " + precio_vef[i]);
                    }
                break;

                case 4:
                    System.out.print("\n 4.- Config (Agregar tasa de cambio)");
                    System.out.print("\nIngrese la nueva tasa de dolar (DOUBLE): ");
                    tasa_dolar = sc.nextDouble();

                    // For para ajustar la tasa de cambio ingresada para cada valor de los productos
                    for (int i = 0; i < num_produ; i++) {
                        precio_dolar[i] = price[i] * cantidad[i];
                        precio_vef[i] = price[i] * tasa_dolar * cantidad[i];
                    }
                break;

                case 5:
                    run = 0;
                break;

                default:
                    System.out.print("Error");
                break; 
            }
            System.out.println("\n¿Desea volver al Menu? < 1.- Si > < 0.- NO> : ");
            int i = sc.nextInt();

            // Condicionales para cerrar la ejecucion del programa y menu
            if(i==1) {
                run = 1;
            }
            else if (i==0){
                run = 0;
            }
        }
        while(run==1);
    }
}
 
