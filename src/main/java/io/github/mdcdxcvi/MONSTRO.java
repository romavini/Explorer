package io.github.mdcdxcvi;

import java.io.*;
import java.util.Random;
public class MONSTRO{
	public static void main (String[] args){
	Random gerador = new Random();
	BufferedReader entrada;
	entrada = new BufferedReader(new InputStreamReader(System.in));
	String[][] MAPA = new String [17][17];
	String[][] MONSTRO = new String [17][17];
	int i = 0;
	int j = 0;
	int t = 0;
	int u = 0;
	int v = 0;
	int T = 0;
	float Vida = 100f;
	int Fome = 10;
	int FomeF = 0;
	
	
	boolean Inicio = false;
	boolean Combate = false;
	boolean Limite = false;
	
	try{
	
	int Random =  gerador.nextInt(10);
	
	
	for(i = 0 ;i < 17 ;i++){ //											//=======MURALHA=======//
		MAPA[i][0] = "Muralha lisa, extremamente alta";
		MAPA[i][16] = "Muralha lisa, extremamente alta";
		MAPA[0][i] = "Muralha lisa, extremamente alta";
		MAPA[16][i] = "Muralha lisa, extremamente alta";
	}
	
	for(i = 1 ;i < 16 ;i++){ //											//=======GRAMADO=======//
		MAPA[i][1] = "Gramado, pouca iluminacao";
		MAPA[i][15] = "Gramado, pouca iluminacao";
		MAPA[1][i] = "Gramado, pouca iluminacao";
		MAPA[15][i] = "Gramado, pouca iluminacao";
	}
	
	for(i = 2 ;i < 15 ;i++){
		for(j = 2 ;j < 15 ;j++){
			MAPA[i][j] = "Gramado, floresta escura";
		}
	}
	
	
	
	
	String Direcao = entrada.readLine();
	
	
	int infinity = 0; 								//Gerador de monstros
	int Vida_Monstro= 37;
	int dupli = 0;
	
	int tamanho;
	tamanho = 5;
	
	int[][] GMA = new int [16][16];
	int cont =0;

		MAP.infinityLessThanSize(gerador, infinity, tamanho, GMA);

		String MonstroCachorroDormindo = "ha um cachorro grande dormindo ao pe de uma arvore";
	
	for(i = 0 ;i < 17 ;i++){
		for(j = 0 ;j < 17 ;j++){
			MONSTRO[i][j]=" ";
		}
	}
	
	for(i = 0 ;i < 15 ;i++){
		for(j = 0 ;j < 15 ;j++){
			if (GMA[i][j]==1){
			MONSTRO[i+1][j+1] = MonstroCachorroDormindo;
			cont++;
			System.out.println("-----------------ADD CACHORRO ; "+i+" ; "+j);
			}
			
		}
	}
	
	while(t==0){
	u = Integer.parseInt(entrada.readLine());
	v = Integer.parseInt(entrada.readLine());
	System.out.println(MONSTRO[u][v]);
	Combate();
	}
	
	} catch (Exception e){
	System.out.println("Erro");
	}
}
public static void Combate (){
	Random gerador = new Random();
	int Random =  gerador.nextInt(2);
	int C = 0;
	if (Random == 0){
	System.out.println("O cachorro acorda!");
	
	while(C == 0){
		
		
		
		
		
		
		
		
		
		
		
		
	}
	} else{
	System.out.println("Nada acontece");
	}
}
}