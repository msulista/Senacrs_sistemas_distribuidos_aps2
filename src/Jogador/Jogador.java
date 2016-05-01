package Jogador;

import java.util.List;

import util.Console;
import Carta.Baralho;
import Carta.CartaST;

public class Jogador {

	Baralho baralho = new Baralho();
	List<CartaST> maoPlayer = baralho.geraBaralhoPlayer();

	public void listarCartas(List<CartaST> maoPlayer) {

		System.out.println("LISTA DE CARTAS DISPONIVEIS");
		System.out
				.println("-----------------------------------------------------");
		for (int i = 0; i < maoPlayer.size(); i++) {
			System.out.println("Carta " + i);
			System.out.println(maoPlayer.get(i).getNome());
			System.out.println(maoPlayer.get(i).getForça());
			System.out.println(maoPlayer.get(i).getEnergia());
			System.out.println(maoPlayer.get(i).getPoder());
			System.out.println(maoPlayer.get(i).getAgilizade());
			System.out
					.println("-----------------------------------------------------");
		}
	}
	
	public CartaST realizaJogada(){
		
		CartaST carta = maoPlayer.get(Console.lerInt("Informe a carta desejada: "));
		maoPlayer.remove(carta);
		return carta;
	}
	
	

}
