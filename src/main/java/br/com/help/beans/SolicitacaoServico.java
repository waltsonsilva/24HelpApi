package br.com.help.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "solicitacao_servico")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize(as = Profissional.class)
public class SolicitacaoServico implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Solicitante solicitante;
	private Date dataSolicitação;

}
