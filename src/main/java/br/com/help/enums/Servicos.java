package br.com.help.enums;

public enum Servicos {

	ELETRICO(0, "Eletrico"), MARCENARIA(1, "Macenaria"), JARDINAGEM(2, "Jardinagem");

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
