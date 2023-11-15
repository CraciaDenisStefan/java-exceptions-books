package org.lessons.java;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
public class Main {

	public static void main(String[] args) {

			File mioFile = new File ("./file.txt");
			FileWriter myWriter = null;
				
			Scanner in = new Scanner(System.in);
			
			System.out.print("Libri da aggiungere: ");
			String numeroLibri = in.nextLine();
			int nLibri = Integer.valueOf(numeroLibri);
			
			int indexLibri = 0;
			Libro[] libro = new Libro[nLibri];
			
			while(indexLibri < nLibri) {
			
				System.out.println("Libro #" + (indexLibri + 1));
					
				System.out.print("Titolo: " );
				String titolo = in.nextLine();
				
				System.out.print("Numero pagine: ");
				String nPagine = in.nextLine();
				int numeroPagine = Integer.valueOf(nPagine);
				
				System.out.print("Autore: ");
				String autore = in.nextLine();
				
				System.out.print("Editore: ");
				String editore = in.nextLine();
					
				
				 try {
		                libro[indexLibri] = new Libro(titolo, numeroPagine, autore, editore);
		                indexLibri++;
		            } catch (Exception e) {
		                System.out.println("Error: " + e.getMessage());
		            }
			 
			}
		
			
			in.close();
			
			try {
				
				myWriter = new FileWriter(mioFile);
				for (int x=0;x<libro.length;x++) {
					
					Libro L = libro[x];
					
					myWriter.write( "----------------------------------------\n"
							+ "Libro" +"\n"
							+ "Titolo: "+ L.getTitolo() + "\n"
							+ "Numero pagine: " + L.getNumeroPagine() + "\n"
							+ "Autore: "+ L.getAutore() + "\n"
							+ "Editore: "+ L.getEditore() + "\n");

				}
			} catch (IOException e) {
				
				System.out.println("Error writing file: " + e.getMessage());
			} finally {
				
				if (myWriter != null)
					try {
						myWriter.close();
					} catch (IOException e) { }
			}		
			 
			Scanner reader = null;
			try {
				
				reader = new Scanner(mioFile);
				
				while (reader.hasNextLine()) {
				   String data = reader.nextLine();
				   System.out.println(data);
				}
			} catch (FileNotFoundException e) {
				
				System.out.println("Error reading file: " + e.getMessage());
			} finally {
				
				if (reader != null)
					reader.close();
			}
	}
	
}
