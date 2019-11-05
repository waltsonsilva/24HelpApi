package br.com.help.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.help.enums.Servicos;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "profissional")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Profissional extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private double ranking;

	private Servicos servico;
}
