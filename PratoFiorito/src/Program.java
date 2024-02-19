/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author alan.gregorio
 */

import java.awt.image.ColorConvertOp;
import java.util.Scanner;


public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /*COLORI*/
        String red = "\033[0;31m";     // RED
        String green = "\033[0;32m";   // GREEN
        
        int dimensioni; 
          
        
        /*musica*/
        Sound.play("src/prova.wav");
        
        Scanner input = new Scanner(System.in);
        
        
        /*Input utente*/
        System.out.println("Enter username");
        String nome = input.nextLine(); 
        System.out.println("Inserire dimensioni");
        
        try{
            dimensioni = Integer.parseInt(input.nextLine()); 
        }catch(java.lang.NumberFormatException ne){
            dimensioni = 5; 
            System.out.print(red+"dimensioni non valide impostate di default a 5");
        }
        
        /*crea la matrice*/
        Matrice prova = new Matrice(dimensioni,nome);
        prova.GeneraMatrice();
        
        
        /*loop gioco*/
        while(prova.Getloop()){
            
            
            System.out.println("");
            prova.StampaMatrice();
            System.out.println("Inserisci le cordinate x e y (separato dalla virgola) es 5,3");
        try{
            String temp = input.nextLine();
            String[] cordinate = temp.split(",");
            
            /* trim serve a togliere gli spazzi */ 
            prova.Controllo(Integer.parseInt(cordinate[0].trim()), Integer.parseInt(cordinate[1].trim()));
        }catch(java.lang.NumberFormatException ae){
            System.out.print(red+"formato cordinate non valido x,y");
        
        }catch(java.lang.ArrayIndexOutOfBoundsException ae){
            System.out.print(red+"formato cordinate non valido x,y");
        }

            
        }
        }
        
    
}
