import java.io.*;
import java.util.Random;
public class MAPA{
	public static void main (String args[]){
	Random gerador = new Random();
	BufferedReader entrada;
	entrada = new BufferedReader(new InputStreamReader(System.in));
	String MAPA[][] = new String [17][17];
	String MONSTRO[][] = new String [17][17];
	int i = 0;
	int j = 0;
	int t = 0;
	int u = 0;
	int v = 0;
	int T = 0;
	float Vida = 100f;
	int Fome = 10;
	int FomeF = 0;
	int FomeV = 0;
	int Comida = 0;
	
	
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
	MAPA[u][v] = "Gramado, porem bem iluminado";
	
	
	
	
	
	
	u = 4;
	v = 4;
	
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	
	System.out.println("				EXPLORER v.0");
	System.out.println();
	System.out.println("		Bem vindo ao EXPLORER v.0, ");
	String L_MAPA = ("Seu local e: "+v+" ; "+u+" .");
	String MAO_E = ("Mao esquerda vazia.");
	String MAO_D = ("Mao direita vazia.");
	
	System.out.println(" 	Para te manter vivo      -->		Vida: "+Vida);
	System.out.println(" 	Para te manter atento    -->		Fome: "+Fome);
	System.out.println("	Para nao ficar com fome  -->	 	  "+Comida+" x macas");
	System.out.println();
	System.out.println(" 	Para te localizar     --> 			"+L_MAPA);
	System.out.println("		<--	Quando houver comida, aparecera aqui");
	System.out.println("	Para controlar o que carrega-->			"+MAO_E);
	System.out.println("		<--	Aqui aparecem os mostros. Cuidado...");
	System.out.println("	Para controlar o que carrega-->			"+MAO_D);
	System.out.println();
	System.out.println("E simple, para ir ao sul, escreva: sul ; ");
	System.out.println("Para pegar macas, escreva: pegar maca ; ");
	System.out.println("Para atacar com o que estiver em sua mao direita, escreva: atacar direita ; ");
	System.out.println("Para comer (caso voce tenha comida), escreva: comer ; ");
	System.out.println("Para se livrar de algo (balde, por exemplo) , escreva: jogar balde;");
	System.out.println();
	System.out.println("Esta pronto? Precione enter!");
	String Direcao = entrada.readLine();
	
	
	
	int infinity = 0; 								//Gerador de comida
	int y, w, f, g, tamanho;
	int dupli = 0;
	y=0;
	w=0;
	
	tamanho = 29;
	String GC [][] = new String [16][16];
	int GCA [][] = new int [16][16];
	String COMIDA[][] = new String [17][17];
	int GC2[] = new int [tamanho];
	int cont =0;

	
	while (infinity < tamanho){
		u = gerador.nextInt(15);
		v = gerador.nextInt(15);
		if (GCA[u][v]==1){
			
		} else {
			GCA[u][v] = 1;
			infinity++;
		}
	}
	
	
	String Maca = "	maca no chao!";
	
	for(i = 0 ;i < 17 ;i++){
		for(j = 0 ;j < 17 ;j++){
			COMIDA[i][j]=" ";
		}
	}
	
	for(i = 0 ;i < 15 ;i++){
		for(j = 0 ;j < 15 ;j++){
			if (GCA[i][j]==1){
			COMIDA[i+1][j+1] = Maca;
			cont++;
			}
			
		}
	}
	
	infinity = 0; 								//Gerador de monstros
	float Vida_Monstro= 37f;
	
	tamanho = 23;
	
	int GMA [][] = new int [16][16];
	
	
	while (infinity < tamanho){
		u = gerador.nextInt(15);
		v = gerador.nextInt(15);
		if (GMA[u][v]==1){
			
		} else {
			GMA[u][v] = 1;
			infinity++;
			System.out.println("ADD CACHORRO ; "+u+" ; "+v);
		}
	}
	
	String MonstroCachorroDormindo = "	cachorro grande dormindo ao pe de uma arvore";
	
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
			System.out.println("-----------------ADD CACHORRO ; "+(i+1)+" ; "+(j+1));
			}
		}
	}
	
	u = 4;
	v = 4;
	
	String ERRO =" ";
	
	while (T==0){ 																			//INICIO~~~~~~
	Vida_Monstro = 37f;
	
	L_MAPA = ("Seu local e: "+v+" ; "+u+" .");
	
	if (FomeF == 4){
		Fome--;
		FomeF = 0;
	}
	
	if (Fome <= 4){
		Vida = Vida - (5 - Fome);
	}
	
	if (Fome > 7){
		FomeV++;
		if(FomeV == 2){
		FomeV = 0;
		Vida = Vida + 3;
			if (Vida > 100){
				Vida = 100;
			}
		}
	}
	
	if (Vida <= 0){
		T++;
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("			Obrigado por ter jogado.");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	} else{
	
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println();
	
	System.out.println("			EXPLORER v.0");
	
	if (u==0){
	System.out.println("Aqui1");
	ERRO = "Voce nao pode avancar nesse sentido.";
	u=u+1;
	} else{
		if (v==0){
		System.out.println("Aqui2");
		ERRO = "Voce nao pode avancar nesse sentido.";
		v=v+1;
		} else{
			if (u==16){
				System.out.println("Aqui3");
				ERRO = "Voce nao pode avancar nesse sentido.";
				u=u-1;
			} else{
				if (v==16){
					System.out.println("Aqui4");
					ERRO = "Voce nao pode avancar nesse sentido.";
					v=v-1;
				}
			}
		}
	}
	System.out.println("Aqui5");
	System.out.println(ERRO);
	ERRO = " ";
	L_MAPA = ("Seu local e: "+u+" ; "+v+" .");
	
	System.out.println("								Vida: "+Vida);
	System.out.println("								Fome: "+Fome);
	System.out.println("								   "+Comida+" x macas");
	System.out.println();
	System.out.println("							"+L_MAPA);
	System.out.println(COMIDA[u][v]);
	System.out.println("							"+MAO_E);
	System.out.println(MONSTRO[u][v]);
	System.out.println("							"+MAO_D);
	System.out.println();
	
	
	
	if (Inicio == false){
	System.out.println();
	System.out.println(MAPA[u][v]+", voce acaba de acorda... ");
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println("sul: "+MAPA[u+1][v]);
	System.out.println("leste: "+MAPA[u][v+1]);
	System.out.println("norte: "+MAPA[u-1][v]);
	System.out.println("oeste: "+MAPA[u][v-1]);
	System.out.println();
	} else{
	System.out.println();
	System.out.println("Seu local e: "+MAPA[u][v]);
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println("sul: "+MAPA[u+1][v]);
	System.out.println("leste: "+MAPA[u][v+1]);
	System.out.println("norte: "+MAPA[u-1][v]);
	System.out.println("oeste: "+MAPA[u][v-1]);
	System.out.println();
	}
	
	
	
	
	System.out.println("Escolha uma direcao");
	
	Direcao = entrada.readLine();
	
	if (Direcao.equals("sul")){ 
		u = u + 1;
		FomeF++;
	} else {
		if (Direcao.equals("leste")){
			v = v + 1;
			FomeF++;
		} else{
			if (Direcao.equals("norte")){
				System.out.println("Aqui6");
				u = u - 1;
				System.out.println("Aqui7");
				FomeF++;
				System.out.println(u);
			} else{
				if (Direcao.equals("oeste")){
					v = v - 1;
					FomeF++;
				}
			}
		}
	}
	if (Direcao.equals("pegar maca")){ 
		if(GCA[u-1][v-1]==1){
			Comida++;
			GCA[u-1][v-1]= 0;
			COMIDA[u][v]=" ";
		} else{
			ERRO = "Nao ha macas no chao!";
		}
	}
	if (Direcao.equals("comer")){ 
		if(Comida>0){
			Comida--;
			FomeF = 0;
			Fome = Fome + 3;
			if (Fome >10){
				Fome = 10;
			}
		}
	}
	
	
	if (Direcao.equals("atacar")){
		if(GMA[u-1][v-1]==1){
			Random =  gerador.nextInt(10);
			Vida_Monstro = Vida_Monstro - Random;
			Combate(Direcao, ERRO, Vida, Comida, Fome, Vida_Monstro, L_MAPA, MAO_D, MAO_E, u, v);
			if (Vida_Monstro > 0){
				GMA[u-1][v-1]=0;
				MONSTRO[u][v]=" ";
			}
			System.out.println(Vida_Monstro);
		} else{
			ERRO = "Nao ha nada a ser atacado!";
		}
	}

	if (GMA[u][v]==1){
		Random =  gerador.nextInt(8);
		System.out.println(Random);
		if (Random == 0){
			Combate(Direcao, ERRO, Vida, Comida, Fome, Vida_Monstro, L_MAPA, MAO_D, MAO_E, u, v);
			//if (Cont == 1){
			//	GMA[u-1][v-1]=0;
			//	MONSTRO[u][v]=" ";
			//}
			System.out.println(Vida_Monstro);
		}
	}
	Inicio = true;
	}
	
	
	}
	
	
	
	}catch(Exception e){
		System.out.println("erro");
	}
}
public static void Combate (String Direcao, String ERRO, float Vida, int Comida, int Fome, float Vida_Monstro, String L_MAPA, String MAO_D, String MAO_E, int u, int v){
	Random gerador = new Random();
	BufferedReader entrada;
	entrada = new BufferedReader(new InputStreamReader(System.in));
	int Vantagem_MONS = 0;
	int Vantagem= 0 ;
	int C = 0;
	int Rolagem = 0;
	int Cont = 0;
	String Acao1 = " ";
	String Acao2 = " ";
	try{
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println("				COMBATE COM CACHORRO!!");
	
	while(C == 0){
		Vantagem_MONS = 0;
		if (Vida_Monstro > 0){
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("				COMBATE COM CACHORRO!!");
			System.out.println();
			System.out.println(Acao1);
			System.out.println();
			System.out.println(Acao2);
			Acao1 = " ";
			Acao2 = " ";
			System.out.println();
			System.out.println("Cachorro: "+Vida_Monstro+"							Sua Vida: "+Vida);
			System.out.println("								Fome: "+Fome);
			System.out.println("								   "+Comida+" x macas");
			System.out.println();
			System.out.println("							"+L_MAPA);
			System.out.println();
			System.out.println("							"+MAO_E);
			System.out.println();
			System.out.println("							"+MAO_D);
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			
			
			System.out.println("O que vai fazer?");
			System.out.println();
			System.out.println();
			Direcao = entrada.readLine();
			if (Direcao.equals("atacar")){
				Rolagem =  gerador.nextInt(20);
				if (Rolagem == 0){
					Vantagem_MONS = Vantagem_MONS + 4;
					Acao1 = "Voce escorrega e cai no chao!";
				} else {
					Rolagem = Rolagem + Vantagem;
					if (Rolagem > 15){
						Rolagem =  gerador.nextInt(7);
						Rolagem = Rolagem + Vantagem;
						Vida_Monstro = Vida_Monstro - Rolagem;
						Acao1 = "Voce acerta um chute no cachorro!	--	Dano:"+Rolagem;
					} else{
						if (Rolagem > 7){
							Rolagem =  gerador.nextInt(5);
						Rolagem = Rolagem + Vantagem;
						Vida_Monstro = Vida_Monstro - Rolagem;
						Acao1 = "Voce acerta um soco no cachorro!	--	Dano:"+Rolagem;					
						} else{
						if (Rolagem <= 7){
							Acao1 = "Voce erra!";
						}
						}
					}
				}
			}
			if (Direcao.equals("escapar")){
				Rolagem =  gerador.nextInt(10);
				if (Rolagem > 7){
					C++;
					ERRO = "Voce escapa do combate!";
				} else{
					Acao1 = "Voce nao consegue escapar!";
				}
			}
			if (Direcao.equals("fugir")){
				Rolagem =  gerador.nextInt(10);
				if (Rolagem > 7){
					C++;
					ERRO = "Voce foge do combate!";
				} else{
					Acao1 = "Voce nao consegue fugir!";
				}
			}
		} else{
			Cont = 1;
			C++;
		}
		Vantagem = 0;
		if (Vida > 0 ){
			Rolagem =  gerador.nextInt(20);
			if (Rolagem == 0){
				Vantagem = Vantagem + 4;
				Acao2 = "O cachorro escorrega nas folhas e cai!";
			} else{
				Rolagem = Rolagem + Vantagem_MONS;
				if (Rolagem > 15){
					Rolagem =  gerador.nextInt(7);
					Rolagem = Rolagem + Vantagem_MONS;
					Vida = Vida - Rolagem;
					Acao2 = "O cachorro acerta uma mordida certeira!	--	Dano:"+Rolagem;
				} else{
					if (Rolagem > 7){
						Rolagem =  gerador.nextInt(5);
						Rolagem = Rolagem + Vantagem_MONS;
						Vida = Vida - Rolagem;
						Acao2 = "O cachorro te acerta um patada!	--	Dano:"+Rolagem;
					} else{
						if (Rolagem <= 7){
							Acao2 = "O cachorro tenta te morder, porem voce se esquiva!";
						}
					}
				}
			}
		} else{
		C++;
		Vida = Vida;
		Vantagem_MONS = Vantagem_MONS;
		
		}
		
		
	}
	//return Cont;
	} catch (Exception e){
		System.out.println("Erro!");
	}
}
}