package com.yoti.springcleaning.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "input_patches")
@Builder
@AllArgsConstructor
public class InputPatches implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_input", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Input idInput;
    @JoinColumn(name = "id_coordinate", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Coordinate idCoordinate;

    public InputPatches() {
    }

    public InputPatches(Integer id) {
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

    public Coordinate getIdCoordinate() {
        return idCoordinate;
    }

    public void setIdCoordinate(Coordinate idCoordinate) {
        this.idCoordinate = idCoordinate;
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
        if (!(object instanceof InputPatches)) {
            return false;
        }
        InputPatches other = (InputPatches) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "InputPatches{" +
                "id=" + id +
                ", idInput=" + idInput +
                ", idCoordinate=" + idCoordinate +
                '}';
    }
}
