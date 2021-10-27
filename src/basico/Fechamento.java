/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basico;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cbobi
 */
@Entity
@Table(name = "fechamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fechamento.findAll", query = "SELECT f FROM Fechamento f")
    , @NamedQuery(name = "Fechamento.findByCodigo", query = "SELECT f FROM Fechamento f WHERE f.codigo = :codigo")
    , @NamedQuery(name = "Fechamento.findByMat", query = "SELECT f FROM Fechamento f WHERE f.mat = :mat")
    , @NamedQuery(name = "Fechamento.findByNome", query = "SELECT f FROM Fechamento f WHERE f.nome = :nome")
    , @NamedQuery(name = "Fechamento.findByData", query = "SELECT f FROM Fechamento f WHERE f.data = :data")
    , @NamedQuery(name = "Fechamento.findByDesc", query = "SELECT f FROM Fechamento f WHERE f.desc = :desc")})
public class Fechamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Long codigo;
    @Basic(optional = false)
    @Column(name = "mat")
    private int mat;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(name = "desc")
    private String desc;

    public Fechamento() {
    }

    public Fechamento(Long codigo) {
        this.codigo = codigo;
    }

    public Fechamento(Long codigo, int mat, String nome, Date data, String desc) {
        this.codigo = codigo;
        this.mat = mat;
        this.nome = nome;
        this.data = data;
        this.desc = desc;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
        this.mat = mat;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fechamento)) {
            return false;
        }
        Fechamento other = (Fechamento) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "basico.Fechamento[ codigo=" + codigo + " ]";
    }
    
}
