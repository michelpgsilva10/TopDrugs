/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Roberto
 */
@Entity
@Table(name="venda")
public class VendaVO {
    
    public VendaVO(){
        super();
    }
    @Id 
    @SequenceGenerator(name = "cod_venda", sequenceName = "spk_venda", allocationSize = 1)
    @GeneratedValue(generator = "cod_venda", strategy = GenerationType.SEQUENCE)
    @Column(name = "cod_venda", nullable = false)
    private int codVenda;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "funcionario_fk", nullable = false)
    private FuncionarioVO funcionario;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_fk", nullable = false)
    private PessoaVO pessoa;    
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "produto_fk", nullable = false)
    private ProdutoVO produto;
    
    @Column(name="numero_nota",nullable = false)
    private int numeroNota;
    
    @Column(name="desconto")
    private float desconto;
    
    @Column(name="data")
    @Temporal(TemporalType.DATE)
    private Date data;

    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    public FuncionarioVO getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioVO funcionario) {
        this.funcionario = funcionario;
    }

    public PessoaVO getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaVO pessoa) {
        this.pessoa = pessoa;
    }

    public ProdutoVO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoVO produto) {
        this.produto = produto;
    }

    public int getNumeroNota() {
        return numeroNota;
    }

    public void setNumeroNota(int numeroNota) {
        this.numeroNota = numeroNota;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
    
}
