package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "CENSUSYEAR", schema = "CENSUSDB")
public class CensusyearEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "censusYearID", nullable = false)
    private int censusYearId;
    @Basic
    @Column(name = "censusYear", nullable = false)
    private int censusYear;
    @OneToMany(mappedBy = "censusyearByCensusYear")
    private Collection<AgeEntity> agesByCensusYearId;

    public int getCensusYearId() {
        return censusYearId;
    }

    public void setCensusYearId(int censusYearId) {
        this.censusYearId = censusYearId;
    }

    public int getCensusYear() {
        return censusYear;
    }

    public void setCensusYear(int censusYear) {
        this.censusYear = censusYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CensusyearEntity that = (CensusyearEntity) o;

        if (censusYearId != that.censusYearId) return false;
        if (censusYear != that.censusYear) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = censusYearId;
        result = 31 * result + censusYear;
        return result;
    }

    public Collection<AgeEntity> getAgesByCensusYearId() {
        return agesByCensusYearId;
    }

    public void setAgesByCensusYearId(Collection<AgeEntity> agesByCensusYearId) {
        this.agesByCensusYearId = agesByCensusYearId;
    }
}
