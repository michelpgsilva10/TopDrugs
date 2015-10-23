/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author michel
 */

@Entity
@Table(name = "item_venda")
public class ItemVendaVO {
    
    @Id
    @SequenceGenerator(name = "cod_item_venda", sequenceName = "spk_item_venda", allocationSize = 1)
    @GeneratedValue(generator = "cod_item_venda", strategy = GenerationType.SEQUENCE)
    @Column(name = "cod_item_venda")
    private int codItemVenda;
    
    @Column(name = "valor_unidade")
    private float valorUnidade;
    
    @Column(name = "quantidade")
    private float quantidade;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_fk")
    private ProdutoVO produto;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venda_fk")
    private VendaVO venda;
    
    public ItemVendaVO() {
        
    }

    public int getCodItemVenda() {
        return codItemVenda;
    }

    public void setCodItemVenda(int codItemVenda) {
        this.codItemVenda = codItemVenda;
    }

    public float getValorUnidade() {
        return valorUnidade;
    }

    public void setValorUnidade(float valorUnidade) {
        this.valorUnidade = valorUnidade;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public ProdutoVO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoVO produto) {
        this.produto = produto;
    }

    public VendaVO getVenda() {
        return venda;
    }

    public void setVenda(VendaVO venda) {
        this.venda = venda;
    }  
    
}
