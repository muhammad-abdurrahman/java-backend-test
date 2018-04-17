package com.yoti.springcleaning.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "input")
@Builder
@AllArgsConstructor
public class Input implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "instructions")
    private String instructions;
    @JoinColumn(name = "room_size", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Coordinate roomSize;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInput")
    private Collection<SpringClean> springCleanCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInput")
    private Collection<InputPatches> inputPatchesCollection;

    public Input() {
    }

    public Input(Integer id) {
        this.id = id;
    }

    public Input(Integer id, String instructions) {
        this.id = id;
        this.instructions = instructions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Coordinate getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(Coordinate roomSize) {
        this.roomSize = roomSize;
    }

    public Collection<SpringClean> getSpringCleanCollection() {
        return springCleanCollection;
    }

    public void setSpringCleanCollection(Collection<SpringClean> springCleanCollection) {
        this.springCleanCollection = springCleanCollection;
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
        if (!(object instanceof Input)) {
            return false;
        }
        Input other = (Input) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Input{" +
                "id=" + id +
                ", instructions='" + instructions + '\'' +
                ", roomSize=" + roomSize +
                ", springCleanCollection=" + springCleanCollection +
                ", inputPatchesCollection=" + inputPatchesCollection +
                '}';
    }
}
