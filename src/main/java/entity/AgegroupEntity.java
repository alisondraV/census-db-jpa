package entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Represents the AGEGROUP table
 */
@Entity
@Table(name = "AGEGROUP", schema = "CENSUSDB")
public class AgegroupEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ageGroupID", nullable = false)
    private int ageGroupId;
    @Basic
    @Column(name = "description", nullable = false, length = 40)
    private String description;
    @OneToMany(mappedBy = "agegroupByAgeGroup")
    private Collection<AgeEntity> agesByAgeGroupId;

    public int getAgeGroupId() {
        return ageGroupId;
    }

    public void setAgeGroupId(int ageGroupId) {
        this.ageGroupId = ageGroupId;
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

        AgegroupEntity that = (AgegroupEntity) o;

        if (ageGroupId != that.ageGroupId) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ageGroupId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public Collection<AgeEntity> getAgesByAgeGroupId() {
        return agesByAgeGroupId;
    }

    public void setAgesByAgeGroupId(Collection<AgeEntity> agesByAgeGroupId) {
        this.agesByAgeGroupId = agesByAgeGroupId;
    }
}
