package com.MeuTeatroPortal.Entidades;

public class Espetaculo {
	private int idEspetaculo;
	private String nomeEspetaculo;
	private String descricao;
	private int idTeatro;
	private int idUsuario;
	private String preco;
	private String dataEvento;
	private String horaEvento;
	private String cia;
	private int classificacaoIndicativa;
	private String link;
	private String imagemId;
	private String status;

	
	public int getIdEspetaculo() {
		return idEspetaculo;
	}
	public void setIdEspetaculo(int idEspetaculo) {
		this.idEspetaculo = idEspetaculo;
	}
	
	public String getNomeEspetaculo() {
		return nomeEspetaculo;
	}
	public void setNomeEspetaculo(String nomeEspetaculo) {
		this.nomeEspetaculo = nomeEspetaculo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getIdTeatro() {
		return idTeatro;
	}
	public void setIdTeatro(int idTeatro) {
		this.idTeatro = idTeatro;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public String getDataEvento() {
		return dataEvento;
	}
	public void setDataEvento(String dataEvento) {
		this.dataEvento = dataEvento;
	}
	public String getHoraEvento() {
		return horaEvento;
	}
	public void setHoraEvento(String horaEvento) {
		this.horaEvento = horaEvento;
	}
	public String getCia() {
		return cia;
	}
	public void setCia(String cia) {
		this.cia = cia;
	}
	public int getClassificacaoIndicativa() {
		return classificacaoIndicativa;
	}
	public void setClassificacaoIndicativa(int classificacaoIndicativa) {
		this.classificacaoIndicativa = classificacaoIndicativa;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getImagemId() {
		return imagemId;
	}
	public void setImagemId(String imgName) {
		this.imagemId = imgName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cia == null) ? 0 : cia.hashCode());
		result = prime * result + classificacaoIndicativa;
		result = prime * result + ((dataEvento == null) ? 0 : dataEvento.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((horaEvento == null) ? 0 : horaEvento.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((nomeEspetaculo == null) ? 0 : nomeEspetaculo.hashCode());
		result = prime * result + ((preco == null) ? 0 : preco.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Espetaculo other = (Espetaculo) obj;
		if (cia == null) {
			if (other.cia != null)
				return false;
		} else if (!cia.equals(other.cia))
			return false;
		if (classificacaoIndicativa != other.classificacaoIndicativa)
			return false;
		if (dataEvento == null) {
			if (other.dataEvento != null)
				return false;
		} else if (!dataEvento.equals(other.dataEvento))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (horaEvento == null) {
			if (other.horaEvento != null)
				return false;
		} else if (!horaEvento.equals(other.horaEvento))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (nomeEspetaculo == null) {
			if (other.nomeEspetaculo != null)
				return false;
		} else if (!nomeEspetaculo.equals(other.nomeEspetaculo))
			return false;
		if (preco == null) {
			if (other.preco != null)
				return false;
		} else if (!preco.equals(other.preco))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Espetaculo [idEspetaculo=" + idEspetaculo + ", nomeEspetaculo=" + nomeEspetaculo + ", descricao="
				+ descricao + ", idTeatro=" + idTeatro + ", idUsuario=" + idUsuario + ", preco=" + preco
				+ ", dataEvento=" + dataEvento + ", horaEvento=" + horaEvento + ", cia=" + cia
				+ ", classificacaoIndicativa=" + classificacaoIndicativa + ", link=" + link + ", imagemId=" + imagemId
				+ ", status=" + status + "]";
	}
	

}
