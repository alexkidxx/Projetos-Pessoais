
public class PlayerBot extends Player implements jogadaDeBot {
	
	
	@Override
	public void getJogada() {
	//Método que gera os palpites aleatórios do bot
		
		
		
		//gera random dos palpites//////////////////////////////////////////////////////////////////
		escolheMaoFechada(this.resp.nextInt());
	
		setPalpite(this.resp.nextInt());
		this.setJogou();
	}

}
