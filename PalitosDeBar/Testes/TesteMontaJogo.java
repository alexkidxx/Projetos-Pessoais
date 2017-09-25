import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TesteMontaJogo {

	
	Player p1;
	Player p2;
	Player p3;
	Player p4;
	Mesa mesa;
	MontaJogo mj;

	@Before
	public void criaUsuarioEMesa(){
	p1=new Player();
	p2=new Player();
	p3=new Player();
	p4=new Player();
	mesa =  new Mesa();
	mj = new MontaJogo();
			
	}
	
	
	@Test
	public void testCriaJogoComDoisPlayers() {	
	mesa.adicionaPlayer(p1);
	mesa.adicionaPlayer(p2);
	assertEquals(mesa.jogadores.size(),mj.quantosPlayers(2));
		
	}
	

}


