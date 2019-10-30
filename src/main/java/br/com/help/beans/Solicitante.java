package br.com.help.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "solicitante")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize(as = Profissional.class)
@EqualsAndHashCode(callSuper=false)
public class Solicitante extends Usuario {

	private static final long serialVersionUID = 1L;
	private double ranking;

}
