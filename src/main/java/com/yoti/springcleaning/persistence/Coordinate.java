package com.yoti.springcleaning.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "coordinate")
@Builder
@AllArgsConstructor
public class Coordinate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "x")
    private Integer x;
    @Basic(optional = false)
    @Column(name = "y")
    private Integer y;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coords")
    private Collection<Output> outputCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomSize")
    private Collection<Input> inputCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCoordinate")
    private Collection<InputPatches> inputPatchesCollection;

    public Coordinate() {
    }

    public Coordinate(Integer id) {
        this.id = id;
    }

    public Coordinate(Integer id, Integer x, Integer y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Collection<Output> getOutputCollection() {
        return outputCollection;
    }

    public void setOutputCollection(Collection<Output> outputCollection) {
        this.outputCollection = outputCollection;
    }

    public Collection<Input> getInputCollection() {
        return inputCollection;
    }

    public void setInputCollection(Collection<Input> inputCollection) {
        this.inputCollection = inputCollection;
    }

    public Collection<InputPatches> getInputPatchesCollection() {
        return inputPatchesCollection;
    }

    public void setInputPatchesCollection(Collection<InputPatches> inputPatchesCollection) {
        this.inputPatchesCollection = inputPatchesCollection;
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
        if (!(object instanceof Coordinate)) {
            return false;
        }
        Coordinate other = (Coordinate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                ", outputCollection=" + outputCollection +
                ", inputCollection=" + inputCollection +
                ", inputPatchesCollection=" + inputPatchesCollection +
                '}';
    }
}