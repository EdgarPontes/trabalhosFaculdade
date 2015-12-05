package br.aula.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Fernando
 */
@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dataCompra;

    @ManyToOne
    private Fornecedor fornecedor;

    @OneToMany(cascade = CascadeType.ALL
    , mappedBy = "compra", targetEntity = ItensCompra.class)
    private List<ItensCompra> produtos = new ArrayList<>();
}
