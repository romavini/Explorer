import java.io.*;
import java.util.Random;

public class MAP {

	private static String Direcao;
	private static String ERRO;

	public static void main (String[] args){
		Random generator = new Random();

		BufferedReader input;
		input = new BufferedReader(new InputStreamReader(System.in));
		String[][] map = new String [17][17];
		String[][] monster = new String [17][17];
		int i;
		int j;
		int u;
		int v;
		int T = 0;
		float life = 100f;
		int hunger = 10;
		int FomeF = 0;
		int FomeV = 0;
		int Comida = 0;


		boolean Inicio = false;

		try{

			generator.nextInt(10);
			int Random;

			//=======Monstro_Cachorro_Dormindo=======//

			highWallWalk(map, 0, 17, "Muralha lisa, extremamente alta", 16);


			highWallWalk(map, 1, 16, "Gramado, pouca iluminacao", 15);

			for(i = 2 ;i < 15 ;i++){
				for(j = 2 ;j < 15 ;j++){
					map[i][j] = "Gramado, floresta escura";
				}
			}
			u=3;
			v=1;
			map[u][v] = "Gramado, porem bem iluminado";

			u = 4;
			v = 4;

			GameScreenCli.printExplorerString("				EXPLORER v.0");
			System.out.println();
			System.out.println("		Bem vindo ao EXPLORER v.0, ");
			String L_MAPA = ("Seu local e: "+v+" ; "+u+" .");
			String MAO_E = ("Mao esquerda vazia.");
			String MAO_D = ("Mao direita vazia.");

			System.out.println(" 	Para te manter vivo      -->		Vida: "+life);
			System.out.println(" 	Para te manter atento    -->		Fome: "+hunger);
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


			String Direcao;
			int infinity = 0; 								//Gerador de comida
			int tamanho;

			tamanho = 29;
			int[][] GCA = new int [16][16];
			String[][] food = new String [17][17];



			while (infinity < tamanho){
				u = generator.nextInt(15);
				v = generator.nextInt(15);
				if (GCA[u][v] != 1){
					GCA[u][v] = 1;
					infinity++;
				}
			}


			String Maca = "	maca no chao!";

			for(i = 0 ;i < 17 ;i++){
				for(j = 0 ;j < 17 ;j++){
					food[i][j]=" ";
				}
			}

			for(i = 0 ;i < 15 ;i++){
				for(j = 0 ;j < 15 ;j++){
					if (GCA[i][j]==1){
						food[i+1][j+1] = Maca;
					}

				}
			}

			infinity = 0; 								//Gerador de monstros
			float Vida_Monstro= 37f;

			tamanho = 23;

			int[][] GMA = new int [16][16];


			infinityLessThanSize(generator, infinity, tamanho, GMA);

			String MonstroCachorroDormindo = "	cachorro grande dormindo ao pe de uma arvore";

			for(i = 0 ;i < 17 ;i++){
				for(j = 0 ;j < 17 ;j++){
					monster[i][j]=" ";
				}
			}

			for(i = 0 ;i < 15 ;i++){
				for(j = 0 ;j < 15 ;j++){
					if (GMA[i][j]==1){
						monster[i+1][j+1] = MonstroCachorroDormindo;
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
					hunger--;
					FomeF = 0;
				}

				if (hunger <= 4){
					life = life - (5 - hunger);
				}

				if (hunger > 7){
					FomeV++;
					if(FomeV == 2){
						FomeV = 0;
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
							if (v==16){
								System.out.println("Aqui4");
								ERRO = "Voce nao pode avancar nesse sentido.";
								v=v-1;
							}
						}
					}
					System.out.println("Aqui5");
					System.out.println(ERRO);
					ERRO = " ";
					L_MAPA = ("Seu local e: "+u+" ; "+v+" .");

					System.out.println("								Vida: "+life);
					System.out.println("								Fome: "+hunger);
					System.out.println("								   "+Comida+" x macas");
					System.out.println();
					System.out.println("							"+L_MAPA);
					System.out.println(food[u][v]);
					System.out.println("							"+MAO_E);
					System.out.println(monster[u][v]);
					System.out.println("							"+MAO_D);
					System.out.println();



					if (!Inicio){
						System.out.println();
						System.out.println(map[u][v]+", voce acaba de acorda... ");
						System.out.println();
						System.out.println();
						System.out.println();
						System.out.println("sul: "+map[u+1][v]);
						System.out.println("leste: "+map[u][v+1]);
						System.out.println("norte: "+map[u-1][v]);
						System.out.println("oeste: "+map[u][v-1]);
						System.out.println();
					} else{
						System.out.println();
						System.out.println("Seu local e: "+map[u][v]);
						System.out.println();
						System.out.println();
						System.out.println();
						System.out.println("sul: "+map[u+1][v]);
						System.out.println("leste: "+map[u][v+1]);
						System.out.println("norte: "+map[u-1][v]);
						System.out.println("oeste: "+map[u][v-1]);
						System.out.println();
					}




					System.out.println("Escolha uma direcao");

					Direcao = input.readLine();

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
							food[u][v]=" ";
						} else{
							ERRO = "Nao ha macas no chao!";
						}
					}
					if (Direcao.equals("comer")){
						if(Comida>0){
							Comida--;
							FomeF = 0;
							hunger = hunger + 3;
							if (hunger >10){
								hunger = 10;
							}
						}
					}


					if (Direcao.equals("atacar")){
						if(GMA[u-1][v-1]==1){
							Random =  generator.nextInt(10);
							Vida_Monstro = Vida_Monstro - Random;
							Combate(life, Comida, hunger, Vida_Monstro, L_MAPA, MAO_D, MAO_E, u, v);
							if (Vida_Monstro > 0){
								GMA[u-1][v-1]=0;
								monster[u][v]=" ";
							}
							System.out.println(Vida_Monstro);
						} else{
							ERRO = "Nao ha nada a ser atacado!";
						}
					}

					if (GMA[u][v]==1){
						Random =  generator.nextInt(8);
						System.out.println(Random);
						if (Random == 0){
							Combate(life, Comida, hunger, Vida_Monstro, L_MAPA, MAO_D, MAO_E, u, v);
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
				System.out.println("ADD CACHORRO ; "+u+" ; "+v);
			}
		}
	}

	public static void Combate (float Vida, int Comida, int Fome, float Vida_Monstro, String L_MAPA, String MAO_D, String MAO_E, int u, int v){
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
					GameScreenCli.printExplorerString("O que vai fazer?");
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
									Acao1 = "Voce erra!";
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
								Acao2 = "O cachorro tenta te morder, porem voce se esquiva!";
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