import java.io.*;
import java.util.Random;

public class MAP {

	private static String ERRO;
	private static int food1 = 0;
	private static int hunger = 10, hungerF = 0;
	private static Language langObj;
	public static void main (String[] args){
		Random generator = new Random();

		// user input
		try{	
			String language = new String(args[0]);
			String country = new String(args[1]);
			langObj = new Language(language,country);
		}
		catch(Exception e){
			langObj = new Language();
		}

		// // use specified message bundle
		// if (language != null && country != null){
		// 	langObj = new Language(language,country);
		// }
		// else{
		// //System.out.println(e);
		// // use default message bundle
		// langObj = new Language();
		// }


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

			// highWallWalk(map, 0, 17, "Muralha lisa, extremamente alta", 16);
			highWallWalk(map, 0, 17, langObj.getMessage("Extremamente_Alta"), 16);


			// highWallWalk(map, 1, 16, "Gramado, pouca iluminacao", 15);
			highWallWalk(map, 1, 16, langObj.getMessage("Gramado_Pouca_Iluminacao"), 15);

			for(i = 2 ;i < 15 ;i++){
				for(j = 2 ;j < 15 ;j++){
					// map[i][j] = "Gramado, floresta escura";
					map[i][j] = langObj.getMessage("Gramado_Floresta_Escura");
				}
			}
			int u = 3;
			int v = 1;
			// map[u][v] = "Gramado, porem bem iluminado";
			map[u][v] = langObj.getMessage("Gramado_Bem_Iluminado");

			u = 4;
			v = 4;

			GameScreenCli.printExplorerString("				EXPLORER v.0");
			System.out.println();
			// System.out.println("		Bem vindo ao EXPLORER v.0, ");
			System.out.println("		"+langObj.getMessage("Bem_Vindo")+" ");
			// String L_MAPA = ("Seu local e: "+ v +" ; "+ u +" .");
			String L_MAPA = (langObj.getMessage("Seu_Local")+" "+ v +" ; "+ u +" .");
			// String leftHand = ("Mao esquerda vazia.");
			String leftHand = langObj.getMessage("Mao_Esquerda_Vazia");
			// String rightHand = ("Mao direita vazia.");
			String rightHand = langObj.getMessage("Mao_Direita_Vazia");

			// gameStatusNow(life, hunger, food1, L_MAPA, leftHand, rightHand,
			// 		" 	Para te manter vivo      -->		Vida: ",
			// 		" 	Para te manter atento    -->		Fome: ",
			// 		"	Para nao ficar com fome  -->	 	  ", "" +
			// 				" 	Para te localizar     --> 			",
			// 		"		<--	Quando houver comida, aparecera aqui",
			// 		"	Para controlar o que carrega-->			",
			// 		"		<--	Aqui aparecem os mostros. Cuidado...");

					gameStatusNow(life, hunger, food1, L_MAPA, leftHand, rightHand,
					" 	"+langObj.getMessage("Para_Manter_Vivo")+" ",
					" 	"+langObj.getMessage("Para_Manter_Atento")+" ",
					"	"+langObj.getMessage("Para_Nao_Fome")+"	 	  ", "" +
							" 	"+langObj.getMessage("Para_Te_Localizar")+" 			",
					"		"+langObj.getMessage("Comida_Aparecera_Aqui"),
					"	"+langObj.getMessage("Para_Controlar_Carrega")+"			",
					"		"+langObj.getMessage("Aqui_Aparecem_Mostros"));

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


			// String Maca = "	maca no chao!";
			String Maca = "	"+langObj.getMessage("Maca_No_Chao");

			foodGenerator(GCA, food, Maca);

			int[][] GMA = monsterGenerator(generator, monster);

			float monsterHealth;

			u = 4;
			v = 4;

			String error =" ";

			while (T==0){ 																			//INICIO~~~~~~
				monsterHealth = 37f;

				// L_MAPA = ("Seu local e: "+ v +" ; "+ u +" .");
				L_MAPA = (langObj.getMessage("Seu_Local")+" "+ v +" ; "+ u +" .");

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

						// error = "Voce nao pode avancar nesse sentido.";
						error = langObj.getMessage("Direcao_Errada");
						u = u +1;
					} else{
						if (v ==0){

							// error = "Voce nao pode avancar nesse sentido.";
							error = langObj.getMessage("Direcao_Errada");
							v = v +1;
						}else{
							if (v ==16){

								// error = "Voce nao pode avancar nesse sentido.";
								error = langObj.getMessage("Direcao_Errada");
								v = v -1;
							}
						}
					}

					System.out.println(error);
					error = " ";
					L_MAPA = (langObj.getMessage("Seu_Local")+" "+ u +" ; "+ v +" .");

					// gameStatusNow(life, hunger, food1, L_MAPA, leftHand, rightHand, "								Vida: ", "								Fome: ", "								   ", "							", food[u][v], "							", monster[u][v]);
					gameStatusNow(life, hunger, food1, L_MAPA, leftHand, rightHand, "								"+langObj.getMessage("Vida")+" ", "								"+langObj.getMessage("Fome")+" ", "								   ", "							", food[u][v], "							", monster[u][v]);


					if (!begin){
						System.out.println();
						// System.out.println(map[u][v]+", voce acaba de acorda... ");
						System.out.println(map[u][v]+", "+langObj.getMessage("Voce_De_Acorda")+" ");
						System.out.println();
						System.out.println();
						System.out.println();
						System.out.println(langObj.getMessage("Sul")+": "+map[u +1][v]);
						System.out.println(langObj.getMessage("Leste")+": "+map[u][v +1]);
						System.out.println(langObj.getMessage("Norte")+": "+map[u -1][v]);
						System.out.println(langObj.getMessage("Oeste")+": "+map[u][v -1]);
						System.out.println();
					} else{
						System.out.println();
						System.out.println(langObj.getMessage("Seu_Local")+" "+map[u][v]);
						System.out.println();
						System.out.println();
						System.out.println();
						System.out.println(langObj.getMessage("Sul")+": "+map[u +1][v]);
						System.out.println(langObj.getMessage("Leste")+": "+map[u][v +1]);
						System.out.println(langObj.getMessage("Norte")+": "+map[u -1][v]);
						System.out.println(langObj.getMessage("Oeste")+": "+map[u][v -1]);
						System.out.println();
					}




					System.out.println(langObj.getMessage("Escolha_Direcao"));

					direction = input.readLine();

					if (direction.equals(langObj.getMessage("Sul"))){
						u = u + 1;
						hungerF++;
					} else {
						if (direction.equals(langObj.getMessage("Leste"))){
							v = v + 1;
							hungerF++;
						} else{
							if (direction.equals(langObj.getMessage("Norte"))){

								u = u - 1;

								hungerF++;
								System.out.println(u);
							} else{
								if (direction.equals(langObj.getMessage("Oeste"))){
									v = v - 1;
									hungerF++;
								}
							}
						}
					}
					if (direction.equals(langObj.getMessage("Pegar_Maca"))){
						// error = getMaca(u, v, GCA, food, error);
						error = getMaca(u, v, GCA, food, error, langObj.getMessage("Nao_Macas_Chao"));
					}
					if (direction.equals(langObj.getMessage("Comer"))){
						eat();
					}


					if (direction.equals(langObj.getMessage("Atacar"))){
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
							error = langObj.getMessage("Nada_Atacado");
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
			System.out.println(langObj.getMessage("Erro"));
		}
	}

	private static String getMaca(int u, int v, int[][] GCA, String[][] food, String error, String strDisplay) {
		if(GCA[u -1][v -1]==1){
			food1++;
			GCA[u -1][v -1]= 0;
			food[u][v]=" ";
		} else{
			// error = "Nao ha macas no chao!";
			error = strDisplay;
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

		// String SleepingMonsterDog = "	cachorro grande dormindo ao pe de uma arvore";
		String SleepingMonsterDog = "	"+langObj.getMessage("Cachorro_Grande_Dormindo");

		foodGenerator(GMA, monster, SleepingMonsterDog);
		return GMA;
	}

	private static void gameStatusNow(float life, int hunger, int food1, String l_MAPA, String leftHand, String rightHand, String s, String s2, String s3, String s4, String s5, String s6, String s7) {
		System.out.println(s + life);
		System.out.println(s2 + hunger);
		System.out.println(s3 + food1 + " "+langObj.getMessage("X_Macas"));
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
			System.out.println("				"+langObj.getMessage("Combate_Com_Cachorro")+"!!");

			while(C == 0){
				Vantagem_MONS = 0;
				if (Vida_Monstro > 0){

					System.out.println();
					System.out.println();
					System.out.println();
					System.out.println("				"+langObj.getMessage("Combate_Com_Cachorro")+"!!");
					System.out.println();
					System.out.println(action1);
					System.out.println();
					System.out.println(action2);
					action1 = " ";
					action2 = " ";
					System.out.println();
					System.out.println(langObj.getMessage("Cachorro")+" "+Vida_Monstro+"							"+langObj.getMessage("Sua_Vida")+" "+Vida);
					System.out.println("								"+langObj.getMessage("Fome")+" "+Fome);
					System.out.println("								   "+Comida+" "+langObj.getMessage("X_Macas"));
					System.out.println();
					System.out.println("							"+L_MAPA);
					System.out.println();
					System.out.println("							"+MAO_E);
					System.out.println();
					System.out.println("							"+MAO_D);
					GameScreenCli.printExplorerString(langObj.getMessage("Que_Vai_Fazer"));
					System.out.println();
					System.out.println();

					String direcao = input.readLine();
					if (direcao.equals(langObj.getMessage("Atacar"))){
						roll =  generator.nextInt(20);
						if (roll == 0){
							Vantagem_MONS = Vantagem_MONS + 4;
							action1 = langObj.getMessage("Escorrega_E_Cai");
						} else {
							roll = roll + Vantagem;
							if (roll > 15){
								roll =  generator.nextInt(7);
								roll = roll + Vantagem;
								Vida_Monstro = Vida_Monstro - roll;
								action1 = langObj.getMessage("Chute_No_Cachorro")+roll;
							} else{
								if (roll > 7){
									roll =  generator.nextInt(5);
									roll = roll + Vantagem;
									Vida_Monstro = Vida_Monstro - roll;
									action1 = langObj.getMessage("Soco_No_Cachorro")+roll;
								} else{
									action1 = langObj.getMessage("Voce_Erra");
								}
							}
						}
					}
					if (direcao.equals(langObj.getMessage("Escapar"))){
						roll =  generator.nextInt(10);
						if (roll > 7){
							C++;
							ERRO = langObj.getMessage("Escapa_Do_Combate");
						} else{
							action1 = langObj.getMessage("Nao_Consegue_Escapar");
						}
					}
					if (direcao.equals(langObj.getMessage("Fugir"))){
						roll =  generator.nextInt(10);
						if (roll > 7){
							C++;
							ERRO = langObj.getMessage("Foge_Do_Combate");
						} else{
							action1 = langObj.getMessage("Nao_Consegue_Fugir");
						}
					}
				} else{
					// Cont defined but never used ?
					int Cont = 1;
					C++;
				}
				Vantagem = 0;
				if (Vida > 0 ){
					roll =  generator.nextInt(20);
					if (roll == 0){
						Vantagem = Vantagem + 4;
						action2 = langObj.getMessage("Cachorro_Escorrega_E_Cai");
					} else{
						roll = roll + Vantagem_MONS;
						if (roll > 15){
							roll =  generator.nextInt(7);
							roll = roll + Vantagem_MONS;
							Vida = Vida - roll;
							action2 = langObj.getMessage("Cachorro_Mordida")+roll;
						} else{
							if (roll > 7){
								roll =  generator.nextInt(5);
								roll = roll + Vantagem_MONS;
								Vida = Vida - roll;
								action2 = langObj.getMessage("Cachorro_Acerta_Patada")+roll;
							} else{
								action2 = langObj.getMessage("Cachorro_Morder_Voce_Esquiva");
							}
						}
					}
				} else{
					C++;

				}

			}
			//return Cont;
		} catch (Exception e){
			System.out.println(langObj.getMessage("Erro"));
		}
	}
}