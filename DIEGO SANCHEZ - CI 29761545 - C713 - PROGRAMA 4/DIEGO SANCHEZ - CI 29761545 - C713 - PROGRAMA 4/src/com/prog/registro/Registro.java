package com.prog.registro;
import java.util.Scanner;

public class Registro {

    public int materias2[][] = new int[100][100];
	public int array_promedio2[] = new int[100];

    public int calculo_edad(int dia_actual, int mes_actual, int año_actual, int dia_cumple, int mes_cumple, int año_nacimiento){

        int edad = 0;
        // Condicionales que hacen el calculo de la edad
        if(mes_actual>mes_cumple||mes_actual==mes_cumple&&dia_actual==dia_cumple){
            edad=año_actual-año_nacimiento;
            
        }
        else if(mes_actual<mes_cumple||mes_actual==mes_cumple&&dia_actual!=dia_cumple){
            edad=(año_actual-año_nacimiento)-1;
        }
    
        return edad;
    }

    public static int[][] promedio_est(int num_materias,int numero_estudiantes, int matriz_notas[][], int array_promedioest[]) {
		Scanner sc = new Scanner(System.in);
        boolean run = false;

		// De parametro a las variables a utilizar en esa funcion
		int num_est = numero_estudiantes;
		int notas_materias[][] = matriz_notas;
		int array_promedio[] = array_promedioest;

		int suma_promedio = 0;  
		int promedio_general = 0;

        // Arrays para notas alta y bajas de los estudiantes
        int est_high[] = new int[100];
        int est_low[] = new int[100];

        int nota_high = 0; 
        int nota_low = 0;
 
		// System.out.println("Ingresa la cantidad de materias a evaluar: ");
		int cantidad_mate = num_materias;

		// For que se ejecuta segun el X cantidad de estudiantes, y las X cantidad de materias

        for (int z = 0; z < num_est; z++) {
            int suma = 0; // Resetea la sumatoria de las notas

            nota_high = 0; 
            nota_low = 100;

            System.out.println("\nEstudiante: " + z);
            do {
                for (int j = 0; j < cantidad_mate; j++) {

                    System.out.println("Ingrese las notas de sus materias: ");
                    notas_materias[z][j] = sc.nextInt();
                    
                    if(notas_materias[z][j]>0&&notas_materias[z][j]<=20) {

                        if(notas_materias[z][j]>nota_high) { // Condicionales para saber si la nota de la materia es la mas alta o la mas baja
                            nota_high = notas_materias[z][j];
                        }
                        if(notas_materias[z][j]<nota_low){
                            nota_low = notas_materias[z][j];
                        }
                        suma = suma + notas_materias[z][j]; // Hace la sumatoria de las notas para sacar el promedio
                        run = true;
                    }
                    else {
                        System.out.println("Valor introducido incorrecto, intente el proceso otra vez.");
                        run = false;
                    }
                }
            }
            while(run==false);

            int promedio = suma / cantidad_mate; // Aca se saca el promedio para luego guardarlo en un array
            array_promedio[z] = promedio;

            suma_promedio = suma_promedio + array_promedio[z]; // Hace la sumatoria de los promedios de los estudiantes

            est_high[z]=nota_high; // Guarda en un array las notas altas y bajas de los estudiantes
        	est_low[z]=nota_low;

        }
		promedio_general = suma_promedio / num_est; // Esta operacion saca el promedio general de los estudiantes

        for(int g = 0; g < num_est; g++) {
            System.out.println("\nEstudiante: "+"["+g+"] ");
            System.out.println("Nota mas alta del estudiante: "+est_high[g]);
            System.out.println("Nota mas baja del estudiante: "+est_low[g]);
        }
        return matriz_notas;
	}

    // Esta funcion me retorna el array de los promedios de los estudiantes
    public static int[] mostrar_promedio(int num_materias,int numero_estudiantes, int matriz_notas[][], int array_promedioest[]) {
        int run = 1;

		// Convierto el argumento en la< variable a utlizar(num_est)
		int num_est = numero_estudiantes;
        
		int notas_materias[][] = matriz_notas;
		int array_promedio[] = array_promedioest;   

		// Guarda la sumatorias de los promedios para luegar sacar el promedio general
		int suma_promedio = 0;
		int promedio_general = 0;

		//System.out.println("Ingresa la cantidad de materias a evaluar: ");
		int cantidad_mate = num_materias;

        for (int z = 0; z < num_est; z++) {
            int suma = 0; // Resetea la sumatoria de las notas

            for (int j = 0; j < cantidad_mate; j++) {
                suma = suma + notas_materias[z][j];
            }
            int promedio = suma / cantidad_mate; // Aca se saca el promedio para luego guardarlo en un array
            array_promedio[z] = promedio;

            suma_promedio = suma_promedio + array_promedio[z]; // Hace la sumatoria de los promedios de los estudiantes
        }
		promedio_general = suma_promedio / num_est; // Esta operacion saca el promedio general de los estudiantes
        
        return array_promedio;
    }

}
