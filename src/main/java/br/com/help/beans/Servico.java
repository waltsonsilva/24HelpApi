package br.com.help.beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "servico")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize(as = Profissional.class)
public class Servico implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;

}
