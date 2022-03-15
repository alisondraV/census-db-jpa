package entity;

import javax.persistence.*;

@Entity
@Table(name = "HOUSEHOLD", schema = "CENSUSDB")
public class HouseholdEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "geographicArea", nullable = false)
    private int geographicArea;
    @Basic
    @Column(name = "householdType", nullable = false)
    private short householdType;
    @Basic
    @Column(name = "householdSize", nullable = false)
    private short householdSize;
    @Basic
    @Column(name = "householdsByAgeRange", nullable = false)
    private short householdsByAgeRange;
    @Basic
    @Column(name = "householdEarners", nullable = false)
    private short householdEarners;
    @Basic
    @Column(name = "totalIncome", nullable = false)
    private short totalIncome;
    @Basic
    @Column(name = "censusYear", nullable = false)
    private int censusYear;
    @Basic
    @Column(name = "numberReported", nullable = false)
    private int numberReported;
    @ManyToOne
    @JoinColumn(name = "geographicArea", referencedColumnName = "geographicAreaID", nullable = false, insertable = false, updatable = false)
    private GeographicareaEntity geographicareaByGeographicArea;
    @ManyToOne
    @JoinColumn(name = "householdType", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private HouseholdtypeEntity householdtypeByHouseholdType;
    @ManyToOne
    @JoinColumn(name = "householdType", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private HouseholdtypeEntity householdtypeByHouseholdType_0;
    @ManyToOne
    @JoinColumn(name = "householdSize", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private HouseholdsizeEntity householdsizeByHouseholdSize;
    @ManyToOne
    @JoinColumn(name = "householdsByAgeRange", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private HouseholdsbyagerangeEntity householdsbyagerangeByHouseholdsByAgeRange;
    @ManyToOne
    @JoinColumn(name = "householdEarners", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private HouseholdearnersEntity householdearnersByHouseholdEarners;
    @ManyToOne
    @JoinColumn(name = "totalIncome", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private TotalincomeEntity totalincomeByTotalIncome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGeographicArea() {
        return geographicArea;
    }

    public void setGeographicArea(int geographicArea) {
        this.geographicArea = geographicArea;
    }

    public short getHouseholdType() {
        return householdType;
    }

    public void setHouseholdType(short householdType) {
        this.householdType = householdType;
    }

    public short getHouseholdSize() {
        return householdSize;
    }

    public void setHouseholdSize(short householdSize) {
        this.householdSize = householdSize;
    }

    public short getHouseholdsByAgeRange() {
        return householdsByAgeRange;
    }

    public void setHouseholdsByAgeRange(short householdsByAgeRange) {
        this.householdsByAgeRange = householdsByAgeRange;
    }

    public short getHouseholdEarners() {
        return householdEarners;
    }

    public void setHouseholdEarners(short householdEarners) {
        this.householdEarners = householdEarners;
    }

    public short getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(short totalIncome) {
        this.totalIncome = totalIncome;
    }

    public int getCensusYear() {
        return censusYear;
    }

    public void setCensusYear(int censusYear) {
        this.censusYear = censusYear;
    }

    public int getNumberReported() {
        return numberReported;
    }

    public void setNumberReported(int numberReported) {
        this.numberReported = numberReported;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HouseholdEntity that = (HouseholdEntity) o;

        if (id != that.id) return false;
        if (geographicArea != that.geographicArea) return false;
        if (householdType != that.householdType) return false;
        if (householdSize != that.householdSize) return false;
        if (householdsByAgeRange != that.householdsByAgeRange) return false;
        if (householdEarners != that.householdEarners) return false;
        if (totalIncome != that.totalIncome) return false;
        if (censusYear != that.censusYear) return false;
        if (numberReported != that.numberReported) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + geographicArea;
        result = 31 * result + (int) householdType;
        result = 31 * result + (int) householdSize;
        result = 31 * result + (int) householdsByAgeRange;
        result = 31 * result + (int) householdEarners;
        result = 31 * result + (int) totalIncome;
        result = 31 * result + censusYear;
        result = 31 * result + numberReported;
        return result;
    }

    public GeographicareaEntity getGeographicareaByGeographicArea() {
        return geographicareaByGeographicArea;
    }

    public void setGeographicareaByGeographicArea(GeographicareaEntity geographicareaByGeographicArea) {
        this.geographicareaByGeographicArea = geographicareaByGeographicArea;
    }

    public HouseholdtypeEntity getHouseholdtypeByHouseholdType() {
        return householdtypeByHouseholdType;
    }

    public void setHouseholdtypeByHouseholdType(HouseholdtypeEntity householdtypeByHouseholdType) {
        this.householdtypeByHouseholdType = householdtypeByHouseholdType;
    }

    public HouseholdtypeEntity getHouseholdtypeByHouseholdType_0() {
        return householdtypeByHouseholdType_0;
    }

    public void setHouseholdtypeByHouseholdType_0(HouseholdtypeEntity householdtypeByHouseholdType_0) {
        this.householdtypeByHouseholdType_0 = householdtypeByHouseholdType_0;
    }

    public HouseholdsizeEntity getHouseholdsizeByHouseholdSize() {
        return householdsizeByHouseholdSize;
    }

    public void setHouseholdsizeByHouseholdSize(HouseholdsizeEntity householdsizeByHouseholdSize) {
        this.householdsizeByHouseholdSize = householdsizeByHouseholdSize;
    }

    public HouseholdsbyagerangeEntity getHouseholdsbyagerangeByHouseholdsByAgeRange() {
        return householdsbyagerangeByHouseholdsByAgeRange;
    }

    public void setHouseholdsbyagerangeByHouseholdsByAgeRange(HouseholdsbyagerangeEntity householdsbyagerangeByHouseholdsByAgeRange) {
        this.householdsbyagerangeByHouseholdsByAgeRange = householdsbyagerangeByHouseholdsByAgeRange;
    }

    public HouseholdearnersEntity getHouseholdearnersByHouseholdEarners() {
        return householdearnersByHouseholdEarners;
    }

    public void setHouseholdearnersByHouseholdEarners(HouseholdearnersEntity householdearnersByHouseholdEarners) {
        this.householdearnersByHouseholdEarners = householdearnersByHouseholdEarners;
    }

    public TotalincomeEntity getTotalincomeByTotalIncome() {
        return totalincomeByTotalIncome;
    }

    public void setTotalincomeByTotalIncome(TotalincomeEntity totalincomeByTotalIncome) {
        this.totalincomeByTotalIncome = totalincomeByTotalIncome;
    }
}
