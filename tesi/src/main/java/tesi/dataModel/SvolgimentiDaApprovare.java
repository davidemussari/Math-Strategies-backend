// Generated with g9.

package tesi.dataModel;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name="svolgimenti_da_approvare")
public class SvolgimentiDaApprovare implements Serializable {

	private static final long serialVersionUID = -2765491728702047140L;

	/** Primary key. */
    protected static final String PK = "primary";

    @Column(name="id_esercizio", nullable=false, precision=10)
    private Integer idEsercizio;
    @EmbeddedId
    @Column(unique=true, nullable=false)
    private PrimarySvolgimentiDaApprovare primary;
    @Column(nullable=false, length=15000)
    private String passaggi;

    /** Default constructor. */
    public SvolgimentiDaApprovare() {
        idEsercizio = null;
        primary = new PrimarySvolgimentiDaApprovare();
        passaggi = null;
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
     * Access method for primary.
     *
     * @return the current value of primary
     */
    public PrimarySvolgimentiDaApprovare getPrimary() {
        return primary;
    }

    /**
     * Setter method for primary.
     *
     * @param aPrimary the new value for primary
     */
    public void setPrimary(PrimarySvolgimentiDaApprovare aPrimary) {
        primary = aPrimary;
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
     * Compares the key for this instance with another SvolgimentiDaApprovare.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class SvolgimentiDaApprovare and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof SvolgimentiDaApprovare)) {
            return false;
        }
        SvolgimentiDaApprovare that = (SvolgimentiDaApprovare) other;
        Object myPrimary = this.getPrimary();
        Object yourPrimary = that.getPrimary();
        if (myPrimary==null ? yourPrimary!=null : !myPrimary.equals(yourPrimary)) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another SvolgimentiDaApprovare.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof SvolgimentiDaApprovare)) return false;
        return this.equalKeys(other) && ((SvolgimentiDaApprovare)other).equalKeys(this);
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
        if (getPrimary() == null) {
            i = 0;
        } else {
            i = getPrimary().hashCode();
        }
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
        StringBuffer sb = new StringBuffer("[SvolgimentiDaApprovare |");
        sb.append(" primary=").append(getPrimary());
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
        ret.put("primary", getPrimary());
        return ret;
    }

}
