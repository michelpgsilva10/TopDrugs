/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author miche
 */
@Entity
@Table(name = "produto")
public class ProdutoVO {
    
    @Id
    @Column(name = "cod_produto")
    private int codProduto;
    
    @Column(name = "cod_barra", length = 15)
    private String codBarra;
    
    @Column(name = "nome", length = 100)
    private String nome;
    
    @Column(name = "tipo", length = 50)
    private String tipo;
    
    @Column(name = "fabricante", length = 100)
    private String fabricante;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "data_validade")
    private Date dataValidade;
    
    @Column(name = "lote", length = 10)
    private String lote;
    
    @Column(name = "preco")
    private float preco;
    
    @Column(name = "qtde_min")
    private float qtdeMin;
    
    @Column(name = "qtde_max")
    private float qtdeMax;   
 
    public ProdutoVO() {
        
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public String getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getQtdeMin() {
        return qtdeMin;
    }

    public void setQtdeMin(float qtdeMin) {
        this.qtdeMin = qtdeMin;
    }

    public float getQtdeMax() {
        return qtdeMax;
    }

    public void setQtdeMax(float qtdeMax) {
        this.qtdeMax = qtdeMax;
    }   
    
}