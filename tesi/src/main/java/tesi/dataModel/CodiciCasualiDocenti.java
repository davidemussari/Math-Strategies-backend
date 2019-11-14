package tesi.dataModel;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="codici_casuali_docenti")
public class CodiciCasualiDocenti implements Serializable {

	private static final long serialVersionUID = 7816719136117346461L;

	/** Primary key. */
    protected static final String PK = "idDocente";

    @Id
    @Column(name="id_docente", unique=true, nullable=false, precision=10)
    private int idDocente;
    @Column(name="codice_casuale", nullable=false, length=5)
    private String codiceCasuale;

    /** Default constructor. */
    public CodiciCasualiDocenti() {
        super();
    }

    /**
     * Access method for idDocente.
     *
     * @return the current value of idDocente
     */
    public int getIdDocente() {
        return idDocente;
    }

    /**
     * Setter method for idDocente.
     *
     * @param aIdDocente the new value for idDocente
     */
    public void setIdDocente(int aIdDocente) {
        idDocente = aIdDocente;
    }

    /**
     * Access method for codiceCasuale.
     *
     * @return the current value of codiceCasuale
     */
    public String getCodiceCasuale() {
        return codiceCasuale;
    }

    /**
     * Setter method for codiceCasuale.
     *
     * @param aCodiceCasuale the new value for codiceCasuale
     */
    public void setCodiceCasuale(String aCodiceCasuale) {
        codiceCasuale = aCodiceCasuale;
    }

    /**
     * Compares the key for this instance with another CodiciCasualiDocenti.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class CodiciCasualiDocenti and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof CodiciCasualiDocenti)) {
            return false;
        }
        CodiciCasualiDocenti that = (CodiciCasualiDocenti) other;
        if (this.getIdDocente() != that.getIdDocente()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another CodiciCasualiDocenti.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof CodiciCasualiDocenti)) return false;
        return this.equalKeys(other) && ((CodiciCasualiDocenti)other).equalKeys(this);
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
        i = getIdDocente();
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
        StringBuffer sb = new StringBuffer("[CodiciCasualiDocenti |");
        sb.append(" idDocente=").append(getIdDocente());
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
        ret.put("idDocente", Integer.valueOf(getIdDocente()));
        return ret;
    }

}
