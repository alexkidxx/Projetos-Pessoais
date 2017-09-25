import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteMesa {

	Player p1;
	Player p2;
	Player p3;
	Player p4;
	Mesa m1;	
	
	@Before
	public void criaUsuarios(){
	p1 = new Player("Alex");
	p2 = new Player();
	p3 = new Player();
	p4 = new Player();
	m1 = new Mesa();
	}
	
	@Test
	public void testAdicionaUsuariosNaMesa() {
	m1.adicionaPlayer(p1);
	m1.adicionaPlayer(p2);
	m1.adicionaPlayer(p3);
	assertEquals(3,m1.jogadores.size());
	}
	
	@Test
	public void testEscolheIniciativa(){
	m1.adicionaPlayer(p1);
	m1.adicionaPlayer(p2);
	m1.adicionaPlayer(p3);
	assertEquals(p1,m1.getIniciativa());
	assertEquals(p2,m1.getIniciativa());
	assertEquals(p3,m1.getIniciativa());
	assertEquals(p1,m1.getIniciativa());
	assertEquals(p2,m1.getIniciativa());
	assertEquals(p3,m1.getIniciativa());
	}

	
	@Test
	public void testMaoVencedora(){
	p1.escolheMaoFechada(2);
	p2.escolheMaoFechada(1);
	p1.setPalpite(3);
	p2.setPalpite(2);	
	m1.adicionaPlayer(p1);
	m1.adicionaPlayer(p2);
	assertEquals(3,m1.getPalpiteVencedor());
			
	}
		
	
	@Test
	public void testVerificaVencedor(){
	p1.escolheMaoFechada(2);
	p2.escolheMaoFechada(1);
	p1.setPalpite(3);
	p2.setPalpite(2);	
	m1.adicionaPlayer(p1);
	m1.adicionaPlayer(p2);
	assertEquals(p1,m1.verificaVencedorDaRodada());
	}
	
	@Test
	public void testMesaRecebePalpite(){
	m1.adicionaPlayer(p1);
	m1.adicionaPlayer(p2);	
	p1.escolheMaoFechada(2);
	p2.escolheMaoFechada(1);
	m1.recebePalpite(p1,3);
	assertEquals(3,p1.getPalpite());
		
	}
	
	@Test
	public void testMesaRecebePalpiteUnico(){
	m1.adicionaPlayer(p1);
	m1.adicionaPlayer(p2);	
	p1.escolheMaoFechada(2);
	p2.escolheMaoFechada(1);
	m1.recebePalpite(p1,3);
	m1.recebePalpite(p2,3);
	assertEquals(3,p1.getPalpite());
	assertEquals(-1,p2.getPalpite());
	}
	
	@Test
	public void testTodosJogam(){
	m1.adicionaPlayer(p1);
	m1.adicionaPlayer(p2);	
	assertEquals(m1.jaJogou(p1),false);
	assertEquals(m1.jaJogou(p2),false);
	m1.jogou(p2);
	assertEquals(m1.jaJogou(p2),true);
	assertEquals(m1.jaJogou(p1),false);
	}
	
	@Test
	public void habilitaJogadoresParaNovaRodada(){
	m1.adicionaPlayer(p1);
	m1.adicionaPlayer(p2);	
	m1.jogou(p2);		
	m1.jogou(p2);
	m1.novaRodada();
	assertEquals(m1.jaJogou(p1),false);
	assertEquals(m1.jaJogou(p2),false);
	
	}
	
/*	@Test
	public void getJogada(){
	m1.adicionaPlayer(p1);
	m1.adicionaPlayer(p2);		
	p1.escolheMaoFechada(2);
	p1.setPalpite(3);
	m1.getJogada(p1);	
		
	assertEquals(p1.getMaoArriscadora(),2);
	assertEquals(p1.getPalpite(),3);
	assertEquals(m1.jaJogou(p1),true);	
		
	}*/
	
	/*@Test 
	public void getRodada(){
	m1.adicionaPlayer(p1);
	m1.adicionaPlayer(p2);	
	m1.adicionaPlayer(p3);
	m1.adicionaPlayer(p4);	
	m1.getRodada();
	assertEquals(p1.jogou,true);
	assertEquals(p2.jogou,true);
	assertEquals(p3.jogou,true);
	assertEquals(p4.jogou,true);
	}*/
	
	@Test
	public void atribuiVencedor(){
	m1.adicionaPlayer(p1);
	m1.adicionaPlayer(p2);	
	m1.adicionaPlayer(p3);
	m1.getRodada();
	assertEquals(p1,m1.atribuiVencedor());	
	m1.novaRodada();
	assertEquals(p1.getMao(),2);
	}
	
	
	
}
