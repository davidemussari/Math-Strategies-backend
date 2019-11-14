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

@Entity(name="esercizi")
public class Esercizi implements Serializable {

	private static final long serialVersionUID = -7796827943597044480L;

	/** Primary key. */
    protected static final String PK = "id";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int id;
    @Column(nullable=false, precision=10)
    private int tipologia;
    @Column(name="testo_esercizio", length=30)
    private String testoEsercizio;

    /** Default constructor. */
    public Esercizi() {
        super();
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
     * Access method for tipologia.
     *
     * @return the current value of tipologia
     */
    public int getTipologia() {
        return tipologia;
    }

    /**
     * Setter method for tipologia.
     *
     * @param aTipologia the new value for tipologia
     */
    public void setTipologia(int aTipologia) {
        tipologia = aTipologia;
    }

    /**
     * Access method for testoEsercizio.
     *
     * @return the current value of testoEsercizio
     */
    public String getTestoEsercizio() {
        return testoEsercizio;
    }

    /**
     * Setter method for testoEsercizio.
     *
     * @param aTestoEsercizio the new value for testoEsercizio
     */
    public void setTestoEsercizio(String aTestoEsercizio) {
        testoEsercizio = aTestoEsercizio;
    }

    /**
     * Compares the key for this instance with another Esercizi.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Esercizi and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Esercizi)) {
            return false;
        }
        Esercizi that = (Esercizi) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Esercizi.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Esercizi)) return false;
        return this.equalKeys(other) && ((Esercizi)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Esercizi |");
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
