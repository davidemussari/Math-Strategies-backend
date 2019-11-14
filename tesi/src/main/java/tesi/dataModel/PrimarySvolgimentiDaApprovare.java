// Generated with g9.

package tesi.dataModel;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public final class PrimarySvolgimentiDaApprovare implements Serializable{

	private static final long serialVersionUID = -7331396501113886816L;
	
	@Column(name="id_studente", nullable=false, precision=10)
    private final int idStudente;
    @Column(nullable=false)
    private final Timestamp data;

    /** Initializing constructor. */
    public PrimarySvolgimentiDaApprovare(int idStudente, Timestamp data) {
        this.idStudente = idStudente;
        this.data = data;
    }

    /** Private default constructor (for ORM frameworks). */
    @SuppressWarnings("unused")
    private PrimarySvolgimentiDaApprovare() {
        this(0, null);
    }

    /**
     * Access method for idStudente.
     *
     * @return the current value of idStudente
     */
    public int getIdStudente() {
        return idStudente;
    }

    /**
     * Access method for data.
     *
     * @return the current value of data
     */
    public Timestamp getData() {
        return data;
    }

    /**
     * Compares this instance with another Primary.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (getClass() != other.getClass()) {
            return false;
        }
        PrimarySvolgimentiDaApprovare that = (PrimarySvolgimentiDaApprovare) other;
        if (this.getIdStudente() != that.getIdStudente()) {
            return false;
        }
        Object myData = this.getData();
        Object yourData = that.getData();
        if (myData==null ? yourData!=null : !myData.equals(yourData)) {
            return false;
        }
        return true;
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i = 1;
        int result = 17;
        i = getIdStudente();
        result = 37*result + i;
        if (getData() == null) {
            i = 0;
        } else {
            i = getData().hashCode();
        }
        result = 37*result + i;
        return result;
    }

}
