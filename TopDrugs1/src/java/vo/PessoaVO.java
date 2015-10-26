/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vo;

import dao.SampleEntity;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_pessoa")
@DiscriminatorValue(value = "Cliente")
public class PessoaVO {

    @Id
    @SequenceGenerator(name = "cod_pessoa", sequenceName = "spk_pessoa", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cod_pessoa")
    @Column(name="cod_pessoa")
    private int codigoPessoa;
    
    @Column(name="nome")
    private String nome;
    
    @Column(name="cpf")
    private String cpf;
    
    @Column(name="email")
    private String email;
    
    @Temporal(TemporalType.DATE)
    @Column(name="data_nascimento")
    private Date dataNascimento;
    
    @Column(name="bairro")
    private String bairro;
    
    @Column(name="rua")
    private String rua;
    
    @Column(name="numero")
    private int numero;
    
    @Column(name="complemento")
    private String complemento;
    
    @Column(name="cidade")
    private String cidade;
    
    @Column(name="uf")
    private String uf;
    
    @Column(name="local_de_trabalho")
    private String localDeTrabalho;
    
    @Temporal(TemporalType.DATE)
    @Column(name="data_cadastro")
    private Date dataCadastro;
    
    public PessoaVO() {
        
    }
    
    public int getCodigoPessoa() {
        return codigoPessoa;
    }

    public void setCodigoPessoa(int codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLocalDeTrabalho() {
        return localDeTrabalho;
    }

    public void setLocalDeTrabalho(String localDeTrabalho) {
        this.localDeTrabalho = localDeTrabalho;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.codigoPessoa;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PessoaVO other = (PessoaVO) obj;
        if (this.codigoPessoa != other.codigoPessoa) {
            return false;
        }
        return true;
    }   
    
}
