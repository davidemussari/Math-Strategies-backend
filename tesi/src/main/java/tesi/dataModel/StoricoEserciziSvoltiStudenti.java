// Generated with g9.

package tesi.dataModel;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name="storico_esercizi_svolti_studenti")
public class StoricoEserciziSvoltiStudenti implements Serializable {

	private static final long serialVersionUID = 252429395375884913L;

	/** Primary key. */
    protected static final String PK = "primary";

    @Column(name="id_esercizio", nullable=false, precision=10)
    private int idEsercizio;
    @Column(nullable=false, length=15000)
    private String passaggi;
    @Column(nullable=true, length=200)
    private String commenti;
    @EmbeddedId
    @Column(unique=true, nullable=false)
    private PrimaryStoricoEserciziSvoltiStudenti primary;
    @Column(precision=10)
    private int punteggio;

    /** Default constructor. */
    public StoricoEserciziSvoltiStudenti() {
        super();
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
    public void setidEsercizio(int id) {
    	idEsercizio = id;
    }
    
    /**
     * Access method for passaggi.
     *
     * @return the current value of passaggi
     */
    public String getCommenti() {
        return commenti;
    }

    /**
     * Setter method for passaggi.
     *
     * @param aPassaggi the new value for passaggi
     */
    public void setcommenti(String commento) {
    	commenti = commento;
    }
    
    /**
     * Access method for passaggi.
     *
     * @return the current value of passaggi
     */
    public int getidEsercizio() {
        return idEsercizio;
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
     * Access method for primary.
     *
     * @return the current value of primary
     */
    public PrimaryStoricoEserciziSvoltiStudenti getPrimary() {
        return primary;
    }

    /**
     * Setter method for primary.
     *
     * @param aPrimary the new value for primary
     */
    public void setPrimary(PrimaryStoricoEserciziSvoltiStudenti aPrimary) {
        primary = aPrimary;
    }

    /**
     * Access method for punteggio.
     *
     * @return the current value of punteggio
     */
    public int getPunteggio() {
        return punteggio;
    }

    /**
     * Setter method for punteggio.
     *
     * @param aPunteggio the new value for punteggio
     */
    public void setPunteggio(int aPunteggio) {
        punteggio = aPunteggio;
    }

    /**
     * Compares the key for this instance with another StoricoEserciziSvoltiStudenti.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class StoricoEserciziSvoltiStudenti and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof StoricoEserciziSvoltiStudenti)) {
            return false;
        }
        StoricoEserciziSvoltiStudenti that = (StoricoEserciziSvoltiStudenti) other;
        Object myPrimary = this.getPrimary();
        Object yourPrimary = that.getPrimary();
        if (myPrimary==null ? yourPrimary!=null : !myPrimary.equals(yourPrimary)) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another StoricoEserciziSvoltiStudenti.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof StoricoEserciziSvoltiStudenti)) return false;
        return this.equalKeys(other) && ((StoricoEserciziSvoltiStudenti)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[StoricoEserciziSvoltiStudenti |");
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
