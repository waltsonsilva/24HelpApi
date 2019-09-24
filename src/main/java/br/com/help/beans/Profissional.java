package br.com.help.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import br.com.help.enums.Servicos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "profissional")
@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize(as = Profissional.class)
public class Profissional implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true, updatable = false)

	private Long id;

	private String cpf;

	private String nome;

	private Servicos servico;
	
}
