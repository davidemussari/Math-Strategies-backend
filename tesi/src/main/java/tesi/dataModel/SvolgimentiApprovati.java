// Generated with g9.

package tesi.dataModel;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="svolgimenti_approvati")
public class SvolgimentiApprovati implements Serializable {

	private static final long serialVersionUID = 1276155919366105096L;

	/** Primary key. */
    protected static final String PK = "id";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10, columnDefinition = "serial")
    private int id;
    @Column(name="id_esercizio", nullable=false, precision=10)
    private int idEsercizio;
    @Column(nullable=false, length=15000)
    private String passaggi;

    /** Default constructor. */
    public SvolgimentiApprovati() {
        super();
    }

    public SvolgimentiApprovati(StoricoEserciziSvoltiStudenti storicoEsDaSalvare) {
    	idEsercizio = storicoEsDaSalvare.getidEsercizio();
    	passaggi = storicoEsDaSalvare.getPassaggi();
	}

	/**
     * Access method for id.
     *
     * @return the current value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter method for id.
     *
     * @param aId the new value for id
     */
    public void setId(int aId) {
        id = aId;
    }

    /**
     * Access method for idEsercizio.
     *
     * @return the current value of idEsercizio
     */
    public int getIdEsercizio() {
        return idEsercizio;
    }

    /**
     * Setter method for idEsercizio.
     *
     * @param aIdEsercizio the new value for idEsercizio
     */
    public void setIdEsercizio(int aIdEsercizio) {
        idEsercizio = aIdEsercizio;
    }

    /**
     * Access method for passaggi.
     *
     * @return the current value of passaggi
     */
    public String getPassaggi() {
        return passaggi;
    }

    /**
     * Setter method for passaggi.
     *
     * @param aPassaggi the new value for passaggi
     */
    public void setPassaggi(String aPassaggi) {
        passaggi = aPassaggi;
    }

    /**
     * Compares the key for this instance with another SvolgimentiApprovati.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class SvolgimentiApprovati and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof SvolgimentiApprovati)) {
            return false;
        }
        SvolgimentiApprovati that = (SvolgimentiApprovati) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another SvolgimentiApprovati.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof SvolgimentiApprovati)) return false;
        return this.equalKeys(other) && ((SvolgimentiApprovati)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getId();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[SvolgimentiApprovati |");
        sb.append(" id=").append(getId());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("id", Integer.valueOf(getId()));
        return ret;
    }

}
