package br.edu.fcv.exemplo02;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class State implements Serializable {

	private static final long serialVersionUID = 23L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STATE_ID")
	private Long stateId;
	@Column
	private String name;
}
