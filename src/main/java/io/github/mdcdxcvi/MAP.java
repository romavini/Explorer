package io.github.mdcdxcvi;

import java.io.*;
import java.util.Random;

public class MAP {

	private static String ERRO;
	private static int food1 = 0;
	private static int hunger = 10, hungerF = 0;
	public static void main (String[] args){
		Random generator = new Random();

		BufferedReader input;
		input = new BufferedReader(new InputStreamReader(System.in));
		String[][] map = new String [17][17];
		String[][] monster = new String [17][17];
		int i;
		int j;

		int T = 0;
		float life = 100f;

		int hungerV = 0;



		boolean begin = false;

		try{

			generator.nextInt(10);
			int random;

			//=======Monstro_Cachorro_Dormindo=======//

			highWallWalk(map, 0, 17, "Muralha lisa, extremamente alta", 16);


			highWallWalk(map, 1, 16, "Gramado, pouca iluminacao", 15);

			for(i = 2 ;i < 15 ;i++){
				for(j = 2 ;j < 15 ;j++){
					map[i][j] = "Gramado, floresta escura";
				}
			}
			int u = 3;
			int v = 1;
			map[u][v] = "Gramado, porem bem iluminado";

			u = 4;
			v = 4;

			GameScreenCli.printExplorerString("				EXPLORER v.0");
			System.out.println();
			System.out.println("		Bem vindo ao EXPLORER v.0, ");
			String L_MAPA = ("Seu local e: "+ v +" ; "+ u +" .");
			String leftHand = ("Mao esquerda vazia.");
			String rightHand = ("Mao direita vazia.");

			gameStatusNow(life, hunger, food1, L_MAPA, leftHand, rightHand,
					" 	Para te manter vivo      -->		Vida: ",
					" 	Para te manter atento    -->		Fome: ",
					"	Para nao ficar com fome  -->	 	  ", "" +
							" 	Para te localizar     --> 			",
					"		<--	Quando houver comida, aparecera aqui",
					"	Para controlar o que carrega-->			",
					"		<--	Aqui aparecem os mostros. Cuidado...");

			GameScreenCli.printRules();

			input.readLine();

			String direction;
			int infinity = 0; 								//Gerador de comida
			int size;

			size = 29;
			int[][] GCA = new int [16][16];

			String[][] food = new String [17][17];



			while (infinity < size){
				u = generator.nextInt(15);
				v = generator.nextInt(15);
				if (GCA[u][v] != 1){
					GCA[u][v] = 1;
					infinity++;
				}
			}


			String Maca = "	maca no chao!";

			foodGenerator(GCA, food, Maca);

			int[][] GMA = monsterGenerator(generator, monster);

			float monsterHealth;

			u = 4;
			v = 4;

			String error =" ";

			while (T==0){ 																			//INICIO~~~~~~
				monsterHealth = 37f;

				L_MAPA = ("Seu local e: "+ v +" ; "+ u +" .");

				if (hungerF == 4){
					hunger--;
					hungerF = 0;
				}

				if (hunger <= 4){
					life = life - (5 - hunger);
				}

				if (hunger > 7){
					hungerV++;
					if(hungerV == 2){
						hungerV = 0;
						life = life + 3;
						if (life > 100){
							life = 100;
						}
					}
				}

				if (life <= 0){
					T++;
					GameScreenCli.printThanksForPlayingScreen();
				} else{

					GameScreenCli.printExplorerString("			EXPLORER v.0");

					if (u ==0){

						error = "Voce nao pode avancar nesse sentido.";
						u = u +1;
					} else{
						if (v ==0){

							error = "Voce nao pode avancar nesse sentido.";
							v = v +1;
						}else{
							if (v ==16){

								error = "Voce nao pode avancar nesse sentido.";
								v = v -1;
							}
						}
					}

					System.out.println(error);
					error = " ";
					L_MAPA = ("Seu local e: "+ u +" ; "+ v +" .");

					gameStatusNow(life, hunger, food1, L_MAPA, leftHand, rightHand, "								Vida: ", "								Fome: ", "								   ", "							", food[u][v], "							", monster[u][v]);


					if (!begin){
						System.out.println();
						System.out.println(map[u][v]+", voce acaba de acorda... ");
						System.out.println();
						System.out.println();
						System.out.println();
						System.out.println("sul: "+map[u +1][v]);
						System.out.println("leste: "+map[u][v +1]);
						System.out.println("norte: "+map[u -1][v]);
						System.out.println("oeste: "+map[u][v -1]);
						System.out.println();
					} else{
						System.out.println();
						System.out.println("Seu local e: "+map[u][v]);
						System.out.println();
						System.out.println();
						System.out.println();
						System.out.println("sul: "+map[u +1][v]);
						System.out.println("leste: "+map[u][v +1]);
						System.out.println("norte: "+map[u -1][v]);
						System.out.println("oeste: "+map[u][v -1]);
						System.out.println();
					}




					System.out.println("Escolha uma direcao");

					direction = input.readLine();

					if (direction.equals("sul")){
						u = u + 1;
						hungerF++;
					} else {
						if (direction.equals("leste")){
							v = v + 1;
							hungerF++;
						} else{
							if (direction.equals("norte")){

								u = u - 1;

								hungerF++;
								System.out.println(u);
							} else{
								if (direction.equals("oeste")){
									v = v - 1;
									hungerF++;
								}
							}
						}
					}
					if (direction.equals("pegar maca")){
						error = getMaca(u, v, GCA, food, error);
					}
					if (direction.equals("comer")){
						eat();
					}


					if (direction.equals("atacar")){
						if(GMA[u -1][v -1]==1){
							random =  generator.nextInt(10);
							monsterHealth = monsterHealth - random;
							Combate(life, food1, hunger, monsterHealth, L_MAPA, rightHand, leftHand, u, v);
							if (monsterHealth > 0){
								GMA[u -1][v -1]=0;
								monster[u][v]=" ";
							}
							System.out.println(monsterHealth);
						} else{
							error = "Nao ha nada a ser atacado!";
						}
					}

					if (GMA[u][v]==1){
						random =  generator.nextInt(8);
						System.out.println(random);
						if (random == 0){
							Combate(life, food1, hunger, monsterHealth, L_MAPA, rightHand, leftHand, u, v);
							//if (Cont == 1){
							//	GMA[u-1][v-1]=0;
							//	MONSTRO[u][v]=" ";
							//}
							System.out.println(monsterHealth);
						}
					}
					begin = true;
				}

			}

		}catch(Exception e){
			System.out.println("erro");
		}
	}

	private static String getMaca(int u, int v, int[][] GCA, String[][] food, String error) {
		if(GCA[u -1][v -1]==1){
			food1++;
			GCA[u -1][v -1]= 0;
			food[u][v]=" ";
		} else{
			error = "Nao ha macas no chao!";
		}
		return error;
	}

	private static void eat() {
		if(food1>0){
			food1--;
			hungerF = 0;
			hunger = hunger + 3;
			if (hunger >10){
				hunger = 10;
			}
		}
	}

	private static void foodGenerator(int[][] GCA, String[][] food, String maca) {
		int i;
		int j;
		for(i = 0 ; i < 17 ; i++){
			for(j = 0 ;j < 17 ;j++){
				food[i][j]=" ";
			}
		}

		for(i = 0 ;i < 15 ;i++){
			for(j = 0 ;j < 15 ;j++){
				if (GCA[i][j]==1){
					food[i+1][j+1] = maca;
				}

			}
		}
	}


	private static int[][] monsterGenerator(Random generator, String[][] monster) {
		int size;
		int infinity;
		infinity = 0; 							//Gerador de monstros

		size = 23;

		int[][] GMA = new int [16][16];


		infinityLessThanSize(generator, infinity, size, GMA);

		String SleepingMonsterDog = "	cachorro grande dormindo ao pe de uma arvore";

		foodGenerator(GMA, monster, SleepingMonsterDog);
		return GMA;
	}

	private static void gameStatusNow(float life, int hunger, int food1, String l_MAPA, String leftHand, String rightHand, String s, String s2, String s3, String s4, String s5, String s6, String s7) {
		System.out.println(s + life);
		System.out.println(s2 + hunger);
		System.out.println(s3 + food1 + " x macas");
		System.out.println();
		System.out.println(s4 + l_MAPA);
		System.out.println(s5);
		System.out.println(s6 + leftHand);
		System.out.println(s7);
		System.out.println(s6 + rightHand);
		System.out.println();
	}

	private static void highWallWalk(String[][] MAPA, int i2, int i3, String s, int i4) {
		int i;
		for (i = i2; i < i3; i++) { //											//=======MURALHA=======//
			MAPA[i][i2] = s;
			MAPA[i][i4] = s;
			MAPA[i2][i] = s;
			MAPA[i4][i] = s;
		}
	}

	static void infinityLessThanSize(Random gerador, int infinity, int tamanho, int[][] GMA) {
		int u;
		int v;
		while (infinity < tamanho){
			u = gerador.nextInt(15);
			v = gerador.nextInt(15);
			if (GMA[u][v]==1){

			} else {
				GMA[u][v] = 1;
				infinity++;
				//System.out.println("ADD CACHORRO ; "+u+" ; "+v);
			}
		}
	}

	public static void Combate (float Vida, int Comida, int Fome, float Vida_Monstro, String L_MAPA, String MAO_D, String MAO_E, int u, int v){
		Random generator = new Random();
		BufferedReader input;
		input = new BufferedReader(new InputStreamReader(System.in));
		int Vantagem_MONS;
		int Vantagem= 0 ;
		int C = 0;
		int roll;
		String action1 = " ";
		String action2 = " ";
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
					System.out.println(action1);
					System.out.println();
					System.out.println(action2);
					action1 = " ";
					action2 = " ";
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
					GameScreenCli.printExplorerString("O que vai fazer?");
					System.out.println();
					System.out.println();

					String direcao = input.readLine();
					if (direcao.equals("atacar")){
						roll =  generator.nextInt(20);
						if (roll == 0){
							Vantagem_MONS = Vantagem_MONS + 4;
							action1 = "Voce escorrega e cai no chao!";
						} else {
							roll = roll + Vantagem;
							if (roll > 15){
								roll =  generator.nextInt(7);
								roll = roll + Vantagem;
								Vida_Monstro = Vida_Monstro - roll;
								action1 = "Voce acerta um chute no cachorro!	--	Dano:"+roll;
							} else{
								if (roll > 7){
									roll =  generator.nextInt(5);
									roll = roll + Vantagem;
									Vida_Monstro = Vida_Monstro - roll;
									action1 = "Voce acerta um soco no cachorro!	--	Dano:"+roll;
								} else{
									action1 = "Voce erra!";
								}
							}
						}
					}
					if (direcao.equals("escapar")){
						roll =  generator.nextInt(10);
						if (roll > 7){
							C++;
							ERRO = "Voce escapa do combate!";
						} else{
							action1 = "Voce nao consegue escapar!";
						}
					}
					if (direcao.equals("fugir")){
						roll =  generator.nextInt(10);
						if (roll > 7){
							C++;
							ERRO = "Voce foge do combate!";
						} else{
							action1 = "Voce nao consegue fugir!";
						}
					}
				} else{
					int Cont = 1;
					C++;
				}
				Vantagem = 0;
				if (Vida > 0 ){
					roll =  generator.nextInt(20);
					if (roll == 0){
						Vantagem = Vantagem + 4;
						action2 = "O cachorro escorrega nas folhas e cai!";
					} else{
						roll = roll + Vantagem_MONS;
						if (roll > 15){
							roll =  generator.nextInt(7);
							roll = roll + Vantagem_MONS;
							Vida = Vida - roll;
							action2 = "O cachorro acerta uma mordida certeira!	--	Dano:"+roll;
						} else{
							if (roll > 7){
								roll =  generator.nextInt(5);
								roll = roll + Vantagem_MONS;
								Vida = Vida - roll;
								action2 = "O cachorro te acerta um patada!	--	Dano:"+roll;
							} else{
								action2 = "O cachorro tenta te morder, porem voce se esquiva!";
							}
						}
					}
				} else{
					C++;

				}

			}
			//return Cont;
		} catch (Exception e){
			System.out.println("Erro!");
		}
	}
}
