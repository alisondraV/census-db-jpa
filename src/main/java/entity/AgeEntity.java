package entity;

import javax.persistence.*;

/**
 * Represents the AGE table
 */
@Entity
@Table(name = "AGE", schema = "CENSUSDB")
public class AgeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ageID", nullable = false)
    private int ageId;
    @Basic
    @Column(name = "ageGroup", nullable = false)
    private int ageGroup;
    @Basic
    @Column(name = "censusYear", nullable = false)
    private int censusYear;
    @Basic
    @Column(name = "geographicArea", nullable = false)
    private int geographicArea;
    @Basic
    @Column(name = "combined", nullable = false)
    private int combined;
    @Basic
    @Column(name = "male", nullable = false)
    private int male;
    @Basic
    @Column(name = "female", nullable = false)
    private int female;
    @ManyToOne
    @JoinColumn(name = "ageGroup", referencedColumnName = "ageGroupID", nullable = false, insertable = false, updatable = false)
    private AgegroupEntity agegroupByAgeGroup;
    @ManyToOne
    @JoinColumn(name = "censusYear", referencedColumnName = "censusYearID", nullable = false, insertable = false, updatable = false)
    private CensusyearEntity censusyearByCensusYear;
    @ManyToOne
    @JoinColumn(name = "geographicArea", referencedColumnName = "geographicAreaID", nullable = false, insertable = false, updatable = false)
    private GeographicareaEntity geographicareaByGeographicArea;

    public int getAgeId() {
        return ageId;
    }

    public void setAgeId(int ageId) {
        this.ageId = ageId;
    }

    public int getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(int ageGroup) {
        this.ageGroup = ageGroup;
    }

    public int getCensusYear() {
        return censusYear;
    }

    public void setCensusYear(int censusYear) {
        this.censusYear = censusYear;
    }

    public int getGeographicArea() {
        return geographicArea;
    }

    public void setGeographicArea(int geographicArea) {
        this.geographicArea = geographicArea;
    }

    public int getCombined() {
        return combined;
    }

    public void setCombined(int combined) {
        this.combined = combined;
    }

    public int getMale() {
        return male;
    }

    public void setMale(int male) {
        this.male = male;
    }

    public int getFemale() {
        return female;
    }

    public void setFemale(int female) {
        this.female = female;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AgeEntity ageEntity = (AgeEntity) o;

        if (ageId != ageEntity.ageId) return false;
        if (ageGroup != ageEntity.ageGroup) return false;
        if (censusYear != ageEntity.censusYear) return false;
        if (geographicArea != ageEntity.geographicArea) return false;
        if (combined != ageEntity.combined) return false;
        if (male != ageEntity.male) return false;
        if (female != ageEntity.female) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ageId;
        result = 31 * result + ageGroup;
        result = 31 * result + censusYear;
        result = 31 * result + geographicArea;
        result = 31 * result + combined;
        result = 31 * result + male;
        result = 31 * result + female;
        return result;
    }

    public AgegroupEntity getAgegroupByAgeGroup() {
        return agegroupByAgeGroup;
    }

    public void setAgegroupByAgeGroup(AgegroupEntity agegroupByAgeGroup) {
        this.agegroupByAgeGroup = agegroupByAgeGroup;
    }

    public CensusyearEntity getCensusyearByCensusYear() {
        return censusyearByCensusYear;
    }

    public void setCensusyearByCensusYear(CensusyearEntity censusyearByCensusYear) {
        this.censusyearByCensusYear = censusyearByCensusYear;
    }

    public GeographicareaEntity getGeographicareaByGeographicArea() {
        return geographicareaByGeographicArea;
    }

    public void setGeographicareaByGeographicArea(GeographicareaEntity geographicareaByGeographicArea) {
        this.geographicareaByGeographicArea = geographicareaByGeographicArea;
    }
}
