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

@Entity(name="utenti")
public class Utenti implements Serializable {

	private static final long serialVersionUID = 1L;

	/** Primary key. */
    protected static final String PK = "id";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int id;
    @Column(name="NOME", nullable=false, length=30)
    private String nome;
    @Column(name="COGNOME", nullable=false, length=30)
    private String cognome;
    @Column(name="PASSWD", nullable=false, length=32)
    private String passwd;
    @Column(name="USERNAME", nullable=false, length=10)
    private String username;
    @Column(name="DOCENTE_ASSEGNATO", precision=10)
    private int docenteAssegnato;

    /** Default constructor. */
    public Utenti() {
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
     * Access method for nome.
     *
     * @return the current value of nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Setter method for nome.
     *
     * @param aNome the new value for nome
     */
    public void setNome(String aNome) {
        nome = aNome;
    }

    /**
     * Access method for cognome.
     *
     * @return the current value of cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Setter method for cognome.
     *
     * @param aCognome the new value for cognome
     */
    public void setCognome(String aCognome) {
        cognome = aCognome;
    }

    /**
     * Access method for passwd.
     *
     * @return the current value of passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * Setter method for passwd.
     *
     * @param aPasswd the new value for passwd
     */
    public void setPasswd(String aPasswd) {
        passwd = aPasswd;
    }

    /**
     * Access method for username.
     *
     * @return the current value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter method for username.
     *
     * @param aUsername the new value for username
     */
    public void setUsername(String aUsername) {
        username = aUsername;
    }

    /**
     * Access method for docenteAssegnato.
     *
     * @return the current value of docenteAssegnato
     */
    public int getDocenteAssegnato() {
        return docenteAssegnato;
    }

    /**
     * Setter method for docenteAssegnato.
     *
     * @param aDocenteAssegnato the new value for docenteAssegnato
     */
    public void setDocenteAssegnato(int aDocenteAssegnato) {
        docenteAssegnato = aDocenteAssegnato;
    }

    /**
     * Compares the key for this instance with another Utenti.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Utenti and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Utenti)) {
            return false;
        }
        Utenti that = (Utenti) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Utenti.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Utenti)) return false;
        return this.equalKeys(other) && ((Utenti)other).equalKeys(this);
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
        StringBuffer sb = new StringBuffer("[Utenti |");
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
