package entity;

import javax.persistence.*;
import java.util.Collection;

@org.hibernate.annotations.NamedQueries(
        @org.hibernate.annotations.NamedQuery(
                name = "findallIncome",
                query = "from TotalincomeEntity"
        )
)

/**
 * Represents the TOTALINCOME table
 */
@Entity
@Table(name = "TOTALINCOME", schema = "CENSUSDB")
public class TotalincomeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private short id;
    @Basic
    @Column(name = "description", nullable = false, length = 40)
    private String description;
    @OneToMany(mappedBy = "totalincomeByTotalIncome")
    private Collection<HouseholdEntity> householdsById;

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

        TotalincomeEntity that = (TotalincomeEntity) o;

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

    @Override
    public String toString() {
        return "{" +
                "description='" + description + '\'' +
                '}';
    }

    public Collection<HouseholdEntity> getHouseholdsById() {
        return householdsById;
    }

    public void setHouseholdsById(Collection<HouseholdEntity> householdsById) {
        this.householdsById = householdsById;
    }
}
