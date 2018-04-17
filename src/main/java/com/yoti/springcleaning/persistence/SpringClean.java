package com.yoti.springcleaning.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "spring_clean")
@Builder
@AllArgsConstructor
public class SpringClean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_input", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Input idInput;
    @JoinColumn(name = "id_output", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Output idOutput;

    public SpringClean() {
    }

    public SpringClean(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Input getIdInput() {
        return idInput;
    }

    public void setIdInput(Input idInput) {
        this.idInput = idInput;
    }

    public Output getIdOutput() {
        return idOutput;
    }

    public void setIdOutput(Output idOutput) {
        this.idOutput = idOutput;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpringClean)) {
            return false;
        }
        SpringClean other = (SpringClean) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SpringClean{" +
                "id=" + id +
                ", idInput=" + idInput +
                ", idOutput=" + idOutput +
                '}';
    }
}
