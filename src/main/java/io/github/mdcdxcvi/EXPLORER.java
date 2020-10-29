package io.github.mdcdxcvi;

import java.io.*;
public class EXPLORER{
	public static void main (String[] args){
	BufferedReader entrada;
	entrada = new BufferedReader(new InputStreamReader(System.in));
	String[][] MAPA = new String [17][17];
	int u = 3;
	int v = 3;
	int T = 0;
	try{
		
		
	while (T==0){
	
	String Sul = "sul";
	String Leste = "leste";
	String Norte = "norte";
	String Oeste = "oeste";
	
	
	System.out.println();
	System.out.println(MAPA[u][v]+", você acaba de acorda... Ao sul: "+MAPA[u-1][v]+" ; Ao leste: "+MAPA[u][v+1]+" ; Ao norte: "+MAPA[u+1][v]+" ; Ao oeste: "+MAPA[u][v-1]);
	System.out.println();
	System.out.println("Escolha uma direção");
	
	String Direcao = entrada.readLine();
	
	if ("Sul"==Direcao){
		u = u - 1;
	} else {
		if ( Direcao == Leste ){
			v = v + 1;
		} else{
			if ( Direcao == Norte ){
				u = u + 1;
			} else{
				if ( Direcao == Oeste ){
					v = v - 1;
				}
			}
		}
	}
	System.out.println(Direcao);
	System.out.println(u + " ; " + v);
	}
	
	
	
	} catch(Exception e){
		System.out.println("Erro");
	}
	}
}	