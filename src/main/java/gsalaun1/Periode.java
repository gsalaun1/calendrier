package gsalaun1;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * <p>Periode</p>
 */
public class Periode implements Comparable<Periode>, Serializable {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSz")
    private LocalDateTime debut;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSz")
    private LocalDateTime fin;

    /**
     * Constructeur
     */
    public Periode() {

    }

    /**
     * Constructeur
     * @param builder
     */
    private Periode(Builder builder) {
        this.debut = builder.debut;
        this.fin = builder.fin;
    }

    public LocalDateTime getDebut() {
        return debut;
    }

    public void setDebut(LocalDateTime debut) {
        this.debut = debut;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }

    @Override public int compareTo(Periode periode) {
        if (Objects.equals(this.debut, periode.getDebut())) {
            return this.fin.compareTo(periode.getFin());
        }
        return this.debut.compareTo(periode.getDebut());
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Periode periode = (Periode) o;

        if (!debut.equals(periode.debut))
            return false;
        return fin.equals(periode.fin);
    }

    @Override public int hashCode() {
        int result = debut.hashCode();
        result = 31 * result + fin.hashCode();
        return result;
    }

    public static class Builder {

        private LocalDateTime debut;

        private LocalDateTime fin;

        public Builder from(LocalDateTime debutBuilder) {
            this.debut = debutBuilder;
            return this;
        }

        public Builder to(LocalDateTime finBuilder) {
            this.fin = finBuilder;
            return this;
        }

        public Periode build() {
            return new Periode(this);
        }
    }

}