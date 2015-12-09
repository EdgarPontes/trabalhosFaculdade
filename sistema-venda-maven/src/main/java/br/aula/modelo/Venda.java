package br.aula.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Fernando
 */
@Entity
public class Venda implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    private Date dataVenda;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venda", targetEntity = ItensVenda.class)
    private List<ItensVenda> produtos = new ArrayList<>();

}
