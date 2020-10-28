package io.github.mdcdxcvi;

import java.io.*;
import java.util.Random;
public class COMIDA{
	public static void main (String[] args){
	Random gerador = new Random();
	BufferedReader entrada;
	entrada = new BufferedReader(new InputStreamReader(System.in));
	String[][] MAPA = new String [17][17];
	int[][] G = new int [17][17];
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
	
	String Monstro_Cachorro_Dormindo = "há um cachorro grande dormindo ao pe de uma arvore"; //=======Monstro_Cachorro_Dormindo=======//
	
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
	
	u=3;
	v=1;
	MAPA[u][v] = MAPA[u][v]+", "+Monstro_Cachorro_Dormindo; //=======MONSTRO=======//
	u++;
	MAPA[u][v] = "Gramado, porem bem iluminado";
	
	
	String Direcao = entrada.readLine();
	
	
	int infinity = 0; 								//Gerador de comida
	int y, w, f, g, tamanho;
	int dupli = 0;
	y=0;
	w=0;
	
	tamanho = 29;
	String[][] GC = new String [16][16];
	int[][] GCA = new int [16][16];
	int[] GC1 = new int [tamanho];
	int[] GC2 = new int [tamanho];
	int cont =0;

	
	while (infinity < tamanho){
		u = gerador.nextInt(15);
		v = gerador.nextInt(15);
		System.out.println(u+" ; "+y+" ; "+v+" ; "+w+" ; "+tamanho+" ; "+infinity+"-----------------");
		if (GCA[u][v]==1){
			
		} else {
			GCA[u][v] = 1;
			infinity++;
			System.out.println("---------------------------teste 1 : "+infinity);
		}
	}
	
	Direcao = entrada.readLine();
	
	for(i = 0 ;i < 15 ;i++){
		for(j = 0 ;j < 15 ;j++){
			if (GCA[i][j]==1){
			MAPA[i+1][j+1] = MAPA[i+1][j+1]+", maca no chao";
			System.out.println(i+" ; "+y+" ; "+j+" ; "+w+" ; "+GCA[i][j]+" ; "+cont+"-----------------");
			cont++;
			}
			
		}
	}
	
	while(t==0){
	u = Integer.parseInt(entrada.readLine());
	v = Integer.parseInt(entrada.readLine());
	System.out.println(MAPA[u][v]);
	}
	
	} catch (Exception e){
	System.out.println("Erro");
	}
}
}