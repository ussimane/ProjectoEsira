/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esira.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ussimane
 */
@Embeddable
public class PlanoavaliacaoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "iddisc", nullable = false)
    private long iddisc;
    @Basic(optional = false)
    @Column(name = "turno", nullable = false)
    private int turno;
    @Basic(optional = false)
    @Column(name = "turma", nullable = false)
    private int turma;
    @Basic(optional = false)
    @Column(name = "dataavaliacao", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataavaliacao;

    public PlanoavaliacaoPK() {
    }

    public PlanoavaliacaoPK(long iddisc, int turno, int turma, Date dataavaliacao) {
        this.iddisc = iddisc;
        this.turno = turno;
        this.turma = turma;
        this.dataavaliacao = dataavaliacao;
    }

    public long getIddisc() {
        return iddisc;
    }

    public void setIddisc(long iddisc) {
        this.iddisc = iddisc;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getTurma() {
        return turma;
    }

    public void setTurma(int turma) {
        this.turma = turma;
    }

    public Date getDataavaliacao() {
        return dataavaliacao;
    }

    public void setDataavaliacao(Date dataavaliacao) {
        this.dataavaliacao = dataavaliacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) iddisc;
        hash += (int) turno;
        hash += (int) turma;
        hash += (dataavaliacao != null ? dataavaliacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanoavaliacaoPK)) {
            return false;
        }
        PlanoavaliacaoPK other = (PlanoavaliacaoPK) object;
        if (this.iddisc != other.iddisc) {
            return false;
        }
        if (this.turno != other.turno) {
            return false;
        }
        if (this.turma != other.turma) {
            return false;
        }
        if ((this.dataavaliacao == null && other.dataavaliacao != null) || (this.dataavaliacao != null && !this.dataavaliacao.equals(other.dataavaliacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "esira.domain.PlanoavaliacaoPK[ iddisc=" + iddisc + ", turno=" + turno + ", turma=" + turma + ", dataavaliacao=" + dataavaliacao + " ]";
    }
    
}
