package br.com.help.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize(as = Profissional.class)
public class Usuario implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String cpf;
	private String senha;
	private String email;
	private String sexo;
	private int ativo;
	private String login;
	
}
