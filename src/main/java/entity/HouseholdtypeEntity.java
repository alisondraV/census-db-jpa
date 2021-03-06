package entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Represents the HOUSEHOLDTYPE table
 */
@Entity
@Table(name = "HOUSEHOLDTYPE", schema = "CENSUSDB")
public class HouseholdtypeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private short id;
    @Basic
    @Column(name = "description", nullable = false, length = 70)
    private String description;
    @OneToMany(mappedBy = "householdtypeByHouseholdType")
    private Collection<HouseholdEntity> householdsById;
    @OneToMany(mappedBy = "householdtypeByHouseholdType_0")
    private Collection<HouseholdEntity> householdsById_0;

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HouseholdtypeEntity that = (HouseholdtypeEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) id;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public Collection<HouseholdEntity> getHouseholdsById() {
        return householdsById;
    }

    public void setHouseholdsById(Collection<HouseholdEntity> householdsById) {
        this.householdsById = householdsById;
    }

    public Collection<HouseholdEntity> getHouseholdsById_0() {
        return householdsById_0;
    }

    public void setHouseholdsById_0(Collection<HouseholdEntity> householdsById_0) {
        this.householdsById_0 = householdsById_0;
    }
}
