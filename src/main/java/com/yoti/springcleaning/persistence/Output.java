package com.yoti.springcleaning.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "output")
@Builder
@AllArgsConstructor
public class Output implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "patches")
    private int patches;
    @JoinColumn(name = "coords", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Coordinate coords;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOutput")
    private Collection<SpringClean> springCleanCollection;

    public Output() {
    }

    public Output(Integer id) {
        this.id = id;
    }

    public Output(Integer id, int patches) {
        this.id = id;
        this.patches = patches;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPatches() {
        return patches;
    }

    public void setPatches(int patches) {
        this.patches = patches;
    }

    public Coordinate getCoords() {
        return coords;
    }

    public void setCoords(Coordinate coords) {
        this.coords = coords;
    }

    public Collection<SpringClean> getSpringCleanCollection() {
        return springCleanCollection;
    }

    public void setSpringCleanCollection(Collection<SpringClean> springCleanCollection) {
        this.springCleanCollection = springCleanCollection;
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
        if (!(object instanceof Output)) {
            return false;
        }
        Output other = (Output) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Output{" +
                "id=" + id +
                ", patches=" + patches +
                ", coords=" + coords +
                ", springCleanCollection=" + springCleanCollection +
                '}';
    }
}
