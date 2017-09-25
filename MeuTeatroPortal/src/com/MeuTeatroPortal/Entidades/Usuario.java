package com.MeuTeatroPortal.Entidades;

public class Usuario {
private int id;
private String nome;
private String email;
private String perguntaSecreta;
private String respostaSecreta;
private int teatroPertencente;
private String telefone; 
private int nivelDeAcesso;
private boolean ativo;



public String getTelefone() {
	return telefone;
}
public void setTelefone(String string) {
	this.telefone = string;
}

public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPerguntaSecreta() {
	return perguntaSecreta;
}
public void setPerguntaSecreta(String perguntaSecreta) {
	this.perguntaSecreta = perguntaSecreta;
}
public String getRespostaSecreta() {
	return respostaSecreta;
}
public void setRespostaSecreta(String respostaSecreta) {
	this.respostaSecreta = respostaSecreta;
}
public int getTeatroPertencente() {
	return teatroPertencente;
}
public void setTeatroPertencente(int teatroPertencente) {
	this.teatroPertencente = teatroPertencente;
}
public int getNivelDeAcesso() {
	return nivelDeAcesso;
}
public void setNivelDeAcesso(int i) {
	this.nivelDeAcesso = i;
}
public boolean isAtivo() {
	return ativo;
}
public void setAtivo(boolean ativo) {
	this.ativo = ativo;
}
public int getId() {
	return id;
	
}
public void setId(int id){
	
	this.id = id;
}
@Override
public String toString() {
	return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", perguntaSecreta=" + perguntaSecreta
			+ ", respostaSecreta=" + respostaSecreta + ", teatroPertencente=" + teatroPertencente + ", nivelDeAcesso="
			+ nivelDeAcesso + ", ativo=" + ativo + "]";
}

}
