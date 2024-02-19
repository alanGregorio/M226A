/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Classe player prato fiorito 
 * 
 * @author alan.gregorio
 * @version 19.02.2024
 */
import java.util.ArrayList;

public class Player {
    
    private String nome; 
    private int punteggio; 
    private String red = "\033[0;31m";     // RED
    private String green = "\033[0;32m";   // GREEN
    private ArrayList<String> leaderBoard; 

    
    

    
  
    /**
     * Imposta il nome del giocatore
     * 
     * @param nome nome giocatore 
     */
    public void SetNomePlayer(String nome) {
        
        if(nome.equals(" ") || nome.equals("")){
            System.out.println("nome non valido immesso di default -> Guest"); 
            nome = "Guest"; 
        }else{
            nome = nome; 
        } 
    } 
    
    /**
     * ritorna il nome del player
     * 
     * @return nome player 
     */
    public String GetNomePlayer(){
        return nome; 
    }
    
    /**
     * ritorna il punteggio
     * 
     * @return punteggio 
     */
    public int GetPunteggio(){
        return punteggio; 
    }
    
    
    /**
     * Imposta il punteggio
     * 
     * @param punteggio punteggio player 
     */
    public void SetPunteggio(int punteggio){
        if(punteggio < 0){
            System.out.println(red+"Punteggio non valido (default 0)");
            punteggio = 0; 
        }else{
            this.punteggio = punteggio; 
        }
    }
    
    
    
    /**
     * cotruttore classe player
     * 
     * @param nome nome player
     */
    public Player(String nome) {
        
        this.nome = nome; 
        punteggio = 0;
 
        leaderBoard = new ArrayList<>();
        
    }
    
    /**
     * Aggiunge al leaderboard la partita
     * @param nomePlayer nome giocatore
     * @param punteggio punteggio ottenuto
     */
    public void aggiungiPartita(String nomePlayer, int punteggio) {
        String partita = nomePlayer + "     " + punteggio;
        leaderBoard.add(partita);
    }

    
    /**
     * Stampa la leaderboard a terminale
     * in ordine 
     */
        public void stampaLeaderBoard() {
        leaderBoard.sort((partita1, partita2) -> {
            String[] split1 = partita1.split(" ");
            String[] split2 = partita2.split(" ");
            int score1 = Integer.parseInt(split1[split1.length - 1]);
            int score2 = Integer.parseInt(split2[split2.length - 1]);
            return score2 - score1; // for descending order
        });

        for (String partita : leaderBoard) {
            System.out.println(partita);
        }
    }

    
    
    
}
