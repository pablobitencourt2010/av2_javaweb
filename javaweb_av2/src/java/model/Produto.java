/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aluno.unilasalle
 */
@Entity
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByQuantidade", query = "SELECT p FROM Produto p WHERE p.quantidade = :quantidade"),
    @NamedQuery(name = "Produto.findByNome", query = "SELECT p FROM Produto p WHERE p.nome = :nome"),
    @NamedQuery(name = "Produto.findByValor", query = "SELECT p FROM Produto p WHERE p.valor = :valor"),
    @NamedQuery(name = "Produto.findByCodigoproduto", query = "SELECT p FROM Produto p WHERE p.codigoproduto = :codigoproduto")})
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "quantidade")
    private Integer quantidade;
    @Size(max = 30)
    @Column(name = "nome")
    private String nome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigoproduto")
    private Integer codigoproduto;

    public Produto() {
    }

    public Produto(Integer codigoproduto) {
        this.codigoproduto = codigoproduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getCodigoproduto() {
        return codigoproduto;
    }

    public void setCodigoproduto(Integer codigoproduto) {
        this.codigoproduto = codigoproduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoproduto != null ? codigoproduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.codigoproduto == null && other.codigoproduto != null) || (this.codigoproduto != null && !this.codigoproduto.equals(other.codigoproduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Produto[ codigoproduto=" + codigoproduto + " ]";
    }
    
}
