package br.com.help.enums;

public enum Servicos {

	ELETRICO(1, "Eletrico"), MARCENARIA(2, "Macenaria"), JARDINAGEM(3, "Jardinagem");

	private int codigo;
	private String descricao;

	private Servicos(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

}
