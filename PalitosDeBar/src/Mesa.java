import java.util.ArrayList;
import java.util.Scanner;

public class Mesa {

	public ArrayList<Player> jogadores = new ArrayList<Player>();
	private int indiceDaIniciativa;
	
	public void adicionaPlayer(Player jogador) {
		jogadores.add(jogador);
			
		
	}

	 public Player getIniciativa() {
	 if(indiceDaIniciativa >= jogadores.size())
	 indiceDaIniciativa = 0;
	 Player playerASerRetornado = jogadores.get(indiceDaIniciativa);	  
	 indiceDaIniciativa++;
	 return playerASerRetornado ;
	}

	public int getPalpiteVencedor() {
		int palpiteVencedor = 0;
		for(Player p: jogadores)
			palpiteVencedor += p.getMaoArriscadora();
		return palpiteVencedor;
	}

	
	
	public Player verificaVencedorDaRodada() {
	for(Player p: jogadores)
	if(p.getPalpite() == getPalpiteVencedor())
	return p;
		return null;
	}
	
	

	public void recebePalpite(Player playerPalpite, int palpite) {
	if(isUnico(palpite))
		playerPalpite.setPalpite(palpite);
		
	}

	private boolean isUnico(int palpite) {
		for(Player p: jogadores){
			if(p.getPalpite()==palpite)
				return false;
		}
		return true;
	}

	
	
	public int getPalpite(Player p1) {
		
		return p1.getPalpite();
	}

	public boolean jaJogou(Player jogador) {
		
		return jogador.getJogou();
	}

	public void jogou(Player jogador) {
		jogador.setJogou();
		
	}

	public void novaRodada() {
	for(Player p: jogadores){
		p.jogou = false;
		p.devolvePraMao();
	}
	}

	public void getJogada(Player jogador) {
		jogador.getJogada();
	}

	public void getRodada() {
	for(Player p: jogadores)
	this.getJogada(p);
	}

	public Player atribuiVencedor() {
		//se não tiver vencedor como é que faz já que tem que retornar um player????
		this.verificaVencedorDaRodada().perdeUmPalito();
		System.out.println("O vencedor é: "+this.verificaVencedorDaRodada().toString());
		return this.verificaVencedorDaRodada();
	}
	

}
