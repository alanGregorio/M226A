
import com.sun.tools.jconsole.JConsoleContext;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alan.gregorio
 */




public class Matrice {
    
    /*variabili*/
    private boolean loop; 
    private int dimensioni; 
    private String[][] matriceVisibile;
    private int[][] matriceNascosta;
    private String red = "\033[0;31m";     // RED
    private String green = "\033[0;32m";   // GREEN
    private Player player;
    Scanner input = new Scanner(System.in);

   
    /**
     * ritorna loop gioco
     * @return loop del gioco
     */
    public boolean  Getloop() {
        return loop;
    }
    
    /**
     * imposta il loop gioco
     * @param loop loop del gioco
     */
    public void SetLoop(boolean loop){
        this.loop = loop; 
    }
    
    /**
     * ritorna le dimensioni
     * @return dimensioni della matrice
     */
    public int GetDimensioni(){
        return dimensioni; 
    }
    
    
    /**
     * costruttore di default 
     */
    public Matrice(){
        dimensioni = 5; 
        player = new Player("guest"); 
        loop = true; 
        
    }
    
    /**
     * costruttore 
     * @param dimensioni dimensioni della matrice
     * @param nomePlayer nome del player
     */
    public Matrice(int dimensioni, String nomePlayer){
        
        if(dimensioni <= 1){
            System.out.println(red+"dimensioni non valide default -> 5"); 
            this.dimensioni = 5; 
        }else{
            this.dimensioni = dimensioni; 
        }
        loop = true; 
        matriceVisibile = new String[this.dimensioni][this.dimensioni];
        matriceNascosta = new int[this.dimensioni][this.dimensioni]; 
        
        player = new Player(nomePlayer); 
    }
    
    
    /**
     * genera la matrice base e la riempe di fiori 
     * a dipendenza della grandezza
     */
    public void GeneraMatrice(){
        for(int a = 0; a < dimensioni; a++){
            for(int b = 0; b < dimensioni; b++){
                matriceVisibile[a][b] = "#"; 
            }
        } 
        
        for(int a = 0; a < dimensioni; a++){
            for(int b = 0; b < dimensioni; b++){
                matriceNascosta[a][b] = 0; 
            }
        }
        
        for(int a = 0; a <= Math.floor((dimensioni*dimensioni)/4); a++){
             matriceNascosta[1 + (int)(Math.random() * dimensioni-1)][1 + (int)(Math.random() * dimensioni-1)] = 1;
        }
        
        
    }
    
    
    /**
     * stampa la matrice su terminale 
     * e stampa anche il nome del giocatore 
     * e il suo punteggio
     */
    public void StampaMatrice() {
        
        for (int i = 0; i < matriceVisibile.length; i++) {
            for (int j = 0; j < matriceVisibile[i].length; j++) {
                System.out.print(matriceVisibile[i][j]+" "); 
            }
            System.out.println(""); 
        } 
        
        System.out.println(player.GetNomePlayer());
        System.out.println("Punteggio: "+Integer.toString(player.GetPunteggio()));
        
    }
    
    /**
     * stampa la matrice con le posizioni dei fiori
     */
    private void StampaMatriceNacosta() {
        for (int i = 0; i < matriceNascosta.length; i++) {
            for (int j = 0; j < matriceNascosta[i].length; j++) {
                System.out.print(matriceNascosta[i][j]+" "); 
            }
            System.out.println(""); 
        }
    }
    
    /** 
     * controlla se le posizioni inserite dal utente 
     * corrispondono a un fiore 
     * controlla se il giocatore a trovato tutti i fiori 
     * e in caso di vittoria li chiede se vuole giocare ancora 
     * 
     * 
     * @param x posizione x della matrice
     * @param y posizione y della matrice
     */
    public void Controllo(int x, int y){
        boolean temp = false;
        x--; 
        y--; 
        
        
        try{ 
            if(matriceNascosta[y][x] == 1){
                temp = true;
                player.SetPunteggio(player.GetPunteggio()+1);
                matriceNascosta[y][x] = 0; 
                
            }

            if(temp == true){
                matriceVisibile[y][x] = "-"; 

            }else{
                matriceVisibile[y][x] = " "; 
            }
        }
        catch(ArrayIndexOutOfBoundsException ae){
            System.out.println(red + "Valore non valido (valore max: "+dimensioni+" min: 1)");
        }
        catch(NumberFormatException ne) {
            System.out.println(red + "Valore non corretto inserisci un numero (valore max: "+dimensioni+" min: 1)");
        }
        
        if(player.GetPunteggio() == Math.floor((dimensioni*dimensioni)/4)){
            player.aggiungiPartita(player.GetNomePlayer(), player.GetPunteggio());
            System.out.println(green+"HAI VINTO");
            System.out.println("punteggio ottenuto:  "+Integer.toString(player.GetPunteggio()));
            System.out.println("");
            System.out.println("LEADERBOARD");
            player.stampaLeaderBoard();
            System.out.println("");
            System.out.println("");
            System.out.println("Vuoi giocare ancora ? (si/no)");
                    if(input.nextLine().equals("si")){
                        player.SetPunteggio(0);
                        System.out.print("inserisci le dimensioni: ");
                        try{
                            dimensioni = Integer.parseInt(input.nextLine()); 
                        }catch(java.lang.NumberFormatException ne){
                            dimensioni = 5; 
                            System.out.print(red+"dimensioni non valide impostate di default a 5");
                        }
                        matriceVisibile = new String[this.dimensioni][this.dimensioni];
                        matriceNascosta = new int[this.dimensioni][this.dimensioni]; 
                        GeneraMatrice();
                    }else {
                        loop = false; 
                    }
                     
                        
                        
                        
        }
    
  }
   
    
}

