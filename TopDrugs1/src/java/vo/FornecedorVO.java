/*

CREATE TABLE FORNECEDOR
(
cod_fornecedor NUMBER,
cnpj VARCHAR(15),
razao_social VARCHAR(100),
nome_fantasia VARCHAR(100),
email VARCHAR(100),
cidade VARCHAR(100),
uf CHAR(2),
CONSTRAINT pk_fornecedor_005 PRIMARY KEY (cod_fornecedor)
)

 */
package vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="fornecedor")
public class FornecedorVO {
    
    @Id
    @SequenceGenerator(name = "cod_fornecedor", sequenceName = "spk_fornecedor", allocationSize = 1)
    @GeneratedValue(generator = "cod_fornecedor", strategy = GenerationType.SEQUENCE)
    @Column(name="cod_fornecedor")
    private int codigoGerente;
    
    @Column(name="cnpj")
    private String cnpj;
    
    @Column(name="razao_social")
    private String razaoSocial;
     
    @Column(name="nome_fantasia")
    private String nomeFantasia;
     
    @Column(name="email")
    private String email;
     
    @Column(name="cidade")
    private String cidade;
      
    @Column(name="uf")
    private String uf;
     
    
}

