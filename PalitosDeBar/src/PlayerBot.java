
public class PlayerBot extends Player implements jogadaDeBot {
	
	
	@Override
	public void getJogada() {
	//M�todo que gera os palpites aleat�rios do bot
		
		
		
		//gera random dos palpites//////////////////////////////////////////////////////////////////
		escolheMaoFechada(this.resp.nextInt());
	
		setPalpite(this.resp.nextInt());
		this.setJogou();
	}

}
