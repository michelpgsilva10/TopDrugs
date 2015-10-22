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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="cod_venda",nullable=false)
    private int codVenda;
    
    @Column(name="cod_vendedor",nullable=false)
    @ManyToOne(fetch=FetchType.LAZY)
    private FuncionarioVO funcionario;
    
    @Column(name="cod_cliente",nullable=false)
    @ManyToOne(fetch=FetchType.LAZY)
    private PessoaVO pessoa;
    
    @Column(name="cod_produto",nullable=false)
    @ManyToOne(fetch=FetchType.LAZY)
    private ProdutoVO produto;
    
    @Column(name="numero_nota",nullable = false)
    private int numeroNota;
    
    @Column(name="desconto")
    private float desconto;
    
    @Column(name="data")
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
