package com.urbe.traductor;

import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Scanner;

public class Main {
	
	String[] palabras_notfound = new String[100];

	public static void main(String[] args) throws FileNotFoundException {

		Main ejecucion = new Main();
		Scanner sc=new Scanner(System.in);

		boolean run = true;
		int ask = 0;

		do {
			System.out.println("\n1.- Traduccion Espanol - Ingles\n2.- Traduccion Ingles - Espanol\n3.- Salir");
			
			System.out.println("\nIngrese una opcion: ");
			int opcion_menu = sc.nextInt();
			
			switch(opcion_menu) {
				
				case 1:
					ejecucion.esp_eng();

					System.out.println("\nQuisiera ejecutar otra vez el programa? < 1: Si, 0: No >");
					ask=sc.nextInt();

					if (ask==0) {
						run = false;
					}

					if (ask==1) {
						run = true;
					}
				break;
				
				case 2:
					ejecucion.eng_esp();

					System.out.println("\nQuisiera ejecutar otra vez el programa? < 1: Si, 0: No >");
					ask=sc.nextInt();

					if (ask==0) {
						run = false;
					}

					if (ask==1) {
						run = true;
					}
				break;

				case 3:
					System.out.println("Salir.");
					run = false;
				break;

				default:
					System.out.println("Error, introduzca una opcion correcta.");

					run = true;
				break;
			}
		}
		while(run==true);
	}

	public void eng_esp() {
		
		int word_notfound = 0;
		int count_wordnf = 0;
		int count_wordf = 0;
		int ask = 1;

		FileWriter estadistica_eng = null;
				
		Scanner sc=new Scanner(System.in);
		String ask_word;

		try {
			do {
				// Esto lee el archivo diccionario que se usa para las traducciones
				BufferedReader br=new BufferedReader(new FileReader("src\\com\\urbe\\traductor\\diccio_engesp.txt"));
				
				// Declarando el archivo donde se guardaran las estadisticas
				estadistica_eng = new FileWriter("src\\com\\urbe\\traductor\\stats.txt");
			   
				System.out.println("Ingresa la palabra a traducir: ");

				ask_word = "Palabra - "+sc.nextLine();

				String word = ask_word;

				String espacio="";
				
				boolean word_found = false;
				
				
				// Bucle para buscar la palabra introducida en el diccionario, verifica si esta o no esta.
				while ((espacio= br.readLine())!=null) {
					
					if(espacio.equalsIgnoreCase(ask_word)) {
						System.out.println(espacio);
		
						for(int i=0;i<2;i++) {
							System.out.println(br.readLine());
						}
						
						count_wordf +=1; // Sumatoria de las palabras traducidas
						
						System.out.println("\nQuisiera buscar otra palabra? < 1: Si, 0: No >");
						ask=sc.nextInt();
						
						if(ask==0) {
							System.out.println("\nResultados guardados en el archivo correspondiente a la estadistica (stats.txt)");
						}
						
						sc.nextLine(); // Limpio buffer
						
						word_found = true;
						
						break;
					}
				}
				
				if(!word_found) {
					count_wordnf +=1; // Sumatoria de las veces que no se ha encontrado una palabra
					
					System.out.println("La palabra no existe");
					
					palabras_notfound[word_notfound] = word; // Si la palabra no se encontro que las guarde en un array

					for(int i = 0; i<count_wordnf; i++) { // Imprime las palabras que no se han encontrado
						System.out.println("\nDato no encontrado: "+"["+i+"] "+palabras_notfound[i]);
					}
					
					word_notfound +=1; 
					/*
						Hago una sumatoria para que despues de no encontrar la palabra y guardarla en el array, 
						suma una posicion para que luego ser guarde la proxima palabra no encontrada en la siguiente posicion del array.
		
					*/
					
					System.out.println("\nQuisiera buscar otra palabra? < 1: Si, 0: No >");
					ask=sc.nextInt();
					
					if(ask==0) {
						System.out.println("\nResultados guardados en el archivo correspondiente a la estadistica (stats.txt)");
					}
					
					sc.nextLine(); // Limpio buffer
					
				}
				
				
				// Codigo para eliminar los datos nulos que se encuentran en el array de las palabras no encontradas (palabras_notfound)
				String[] array_deletenull = new String[palabras_notfound.length]; // Declaro un array para almacenar los datos no null
				int conteo = -1;
				
				// For each para eliminar las posiciones null
				for(String var : palabras_notfound) {
					if(var != null) { // Condicion para saltar las posiciones del array que no tienen datos
						array_deletenull[++conteo] = var; // Guardo los datos sin los null, y sigue asi para las sig. posiciones
					}
				}
				
				String[] palabras_noencontradas = new String[array_deletenull.length]; 
				
				// Copio los datos del array que almaceno el datos sin los nulos y lo guardo en otro array para finalmente ser mostrado
				palabras_noencontradas = Arrays.copyOf(array_deletenull, conteo + 1); 
				
				// Guarda la estadistica general de la ejecucion el archivo (stats.txt)
				estadistica_eng.write("# de palabras traducidas: "+count_wordf);
				estadistica_eng.write("\n");
				estadistica_eng.write("# de palabras no traducidas: "+count_wordnf);
				estadistica_eng.write("\n\n");
				estadistica_eng.write("Las no encontradas fueron: ");
				estadistica_eng.write("\n");

				// For each para escribir el arreglo de las palabras no encontradas en el archivo de estadistica (stats.txt)
				for (String words : palabras_noencontradas) {
					estadistica_eng.write(words + "\n");
				}
				
				estadistica_eng.close(); // Deja de escribir en el fichero, lo cierra
			}
			while(ask==1);
		}
		catch (IOException e) {
			System.out.println("Error, verifique los logs correspondientes a la ejecucion.");
		}
	}
	
	public void esp_eng() {
		
		int count_wordnf = 0;
		int word_notfound = 0;
		int count_wordf = 0;
		int ask = 1;

		FileWriter estadistica_esp = null;
				
		Scanner sc=new Scanner(System.in);
		String ask_word;
		
		try {
			
			do {
				// Esto lee el archivo diccionario que se usa para las traducciones
				BufferedReader br=new BufferedReader(new FileReader("src\\com\\urbe\\traductor\\diccio_espeng.txt"));
				
				// Declarando el archivo donde se guardaran las estadisticas
				estadistica_esp = new FileWriter("src\\com\\urbe\\traductor\\stats.txt");
				
				System.out.println("Ingresa la palabra a traducir: ");

				ask_word = "Palabra - "+sc.nextLine();

				String word = ask_word;

				String espacio="";
				
				boolean word_found = false;
				
				// Bucle para buscar la palabra introducida en el diccionario, verifica si esta o no esta.
				while ((espacio= br.readLine())!=null) {
					
					if(espacio.equalsIgnoreCase(ask_word)) {
						System.out.println(espacio);
		
						for(int i=0;i<2;i++) {
							System.out.println(br.readLine());
						}
						
						count_wordf +=1; // Sumatoria de las palabras traducidas
						
						System.out.println("\nQuisiera buscar otra palabra? < 1: Si, 0: No >");
						ask=sc.nextInt();
						
						if(ask==0) {
							System.out.println("\nResultados guardados en el archivo correspondiente a la estadistica_esp (stats.txt)");
						}
						
						sc.nextLine(); // Limpio buffer
						
						word_found = true;
						
						break;
		
					}
		
				}
				
				if(!word_found) {
					count_wordnf +=1; // Sumatoria de las veces que no se ha encontrado una palabra
					
					System.out.println("La palabra no existe");
					
					palabras_notfound[word_notfound] = word; // Si la palabra no se encontro que las guarde en un array

					for(int i = 0; i<count_wordnf; i++) { // Imprime las palabras que no se han encontrado
						System.out.println("\nDato no encontrado: "+"["+i+"] "+palabras_notfound[i]);
					}
					
					word_notfound +=1; 
					/*
						Hago una sumatoria para que despues de no encontrar la palabra y guardarla en el array, 
						suma una posicion para que luego ser guarde la proxima palabra no encontrada en la siguiente posicion del array.
		
					*/
					
					System.out.println("\nQuisiera buscar otra palabra? < 1: Si, 0: No >");
					ask=sc.nextInt();
					
					if(ask==0) {
						System.out.println("Resultados guardados en el archivo correspondiente a la estadistica_esp (stats.txt)");
					}
					
					sc.nextLine(); // Limpio buffer
					
				}
				
				
				// Codigo para eliminar los datos nulos que se encuentran en el array de las palabras no encontradas (palabras_notfound)
				String[] array_deletenull = new String[palabras_notfound.length]; // Declaro un array para almacenar los datos no null
				int conteo = -1;
				
				// For each para eliminar las posiciones null
				for(String var : palabras_notfound) {
					if(var != null) { // Condicion para saltar las posiciones del array que no tienen datos
						array_deletenull[++conteo] = var; // Guardo los datos sin los null, y sigue asi para las sig. posiciones
					}
				}
				
				String[] palabras_noencontradas = new String[array_deletenull.length]; 
				
				// Copio los datos del array que almaceno el datos sin los nulos y lo guardo en otro array para finalmente ser mostrado
				palabras_noencontradas = Arrays.copyOf(array_deletenull, conteo + 1); 
				
				
				// Guardando la estadistica general de la ejecucion en el archivo (stats.txt)
				estadistica_esp.write("# de palabras traducidas: "+count_wordf);
				estadistica_esp.write("\n");
				estadistica_esp.write("# de palabras no traducidas: "+count_wordnf);
				estadistica_esp.write("\n\n");
				estadistica_esp.write("Las no encontradas fueron: ");
				estadistica_esp.write("\n");

				// For each para escribir el arreglo de las palabras no encontradas en el archivo de estadistica_esp (stats.txt)
				for (String words : palabras_noencontradas) {
					estadistica_esp.write(words + "\n");
				}
				
				estadistica_esp.close(); // Deja de escribir en el fichero, lo cierra
			}
			while(ask==1);
		}
		catch (IOException e) {
			System.out.println("Error, verifique los logs correspondientes a la ejecucion.");
		}
	}	
}

	