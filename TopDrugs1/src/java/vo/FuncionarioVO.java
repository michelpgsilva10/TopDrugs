/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Roberto
 */
@Entity
@Table(name = "funcionario")
@DiscriminatorValue(value = "Funcionário")
public class FuncionarioVO extends PessoaVO {
    
    @Temporal(TemporalType.DATE)
    @Column(name = "data_admissao")
    private Date dataAdmissao;
    
    @Column(name = "matricula", length = 20)
    private String matricula;
    
    @Column(name = "funcao", length = 100)
    private String funcao;
    
    @Column(name = "salario")
    private float salario;    
    
    public FuncionarioVO() {
        
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    } 
    
}
