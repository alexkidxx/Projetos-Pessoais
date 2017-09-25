
public class MontaJogo {

Mesa mj = new Mesa();	
	
	
	public int quantosPlayers(int qtdPlayersNaPartida) {
		
		for(int i=0;i>=qtdPlayersNaPartida;i++)
			mj.adicionaPlayer(new Player());
			
		return qtdPlayersNaPartida;
	}

}
