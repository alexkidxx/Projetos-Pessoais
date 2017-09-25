import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestePlayer {
	
	Player p1;
	Player p2;
	Player p3;
	
	@Before
	public void criaUsuarios(){
	p1=new Player();
	p2=new Player();
	p3=new Player();
		
	}
	
	@Test
	public void testSetNome(){
	p1=new Player("Alex");
	assertEquals(p1.getNome(),"Alex");
	
	}
	
	@Test
	public void testPalitosNaMaoDoPlayer() {
	assertEquals(3,p1.getMao());
	}
	
	@Test
	public void testEscolherMaoFechada(){
	p1.escolheMaoFechada(1);
	p2.escolheMaoFechada(2);
	p3.escolheMaoFechada(3);
	assertEquals(2,p1.getMao());
	assertEquals(1,p2.getMao());
	assertEquals(0,p3.getMao());
	}
	
	@Test
	public void testMaoArricadora(){
	p1.escolheMaoFechada(1);
	p2.escolheMaoFechada(2);
	p3.escolheMaoFechada(3);
	assertEquals(1,p1.getMaoArriscadora());
	assertEquals(2,p2.getMaoArriscadora());
	assertEquals(3,p3.getMaoArriscadora());
			
	}
	
	@Test
	public void testPerdeUmPalito(){
	p1.perdeUmPalito();
	assertEquals(2,p1.getMao());
	p1.perdeUmPalito();
	assertEquals(1,p1.getMao());	
	p1.perdeUmPalito();
	assertEquals(0,p1.getMao());	
	}
	
	
	
	
}
