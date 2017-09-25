import java.util.Scanner;

public class Player {

	private int mao;
	private int maoArriscadora;
	private int palpite;
	public boolean jogou;
	private String nome;
	Scanner resp = new Scanner(System.in);
	
	public Player(){
	mao=3;	
	palpite = -1;
	jogou = false;
	}	
	
	public Player(String nome) {
	this.nome = nome;
	mao=3;	
	palpite = -1;
	jogou = false;
	}

	public Object getMao() {
	return mao;
	}

	public void escolheMaoFechada(int palitoArriscador) {
	if(palitoArriscador >= 0 && palitoArriscador <= mao)
		mao-=palitoArriscador;
		maoArriscadora =palitoArriscador;
	}

	public int getMaoArriscadora() {
		
		return maoArriscadora;
	}

	public int getPalpite() {
		return palpite;
	}

	public void perdeUmPalito() {
	mao-=1;		
	}

	public void setPalpite(int i) {
		palpite = i;
		
	}

	public void devolvePraMao() {
		this.mao = mao + maoArriscadora; 
		maoArriscadora = 0;
	}

	public String getNome() {
	
		return nome;
	}
	public void setJogou(){
	this.jogou=true;	
		
	}
	public boolean getJogou(){
		return jogou;
	}

	@Override
	public String toString() {
		return  getNome() ;
	}

	public void getJogada() {
	//Método que pergunta via console apenas para jogadores humanos
		System.out.println("Quantos palitos você esconde na sua mão "+getNome()+"?");
		escolheMaoFechada(this.resp.nextInt());
		System.out.println("Quantos palitos você acha que tem no total da soma de todas as mãos?");
		setPalpite(this.resp.nextInt());
		this.setJogou();
	}
	
	

}
