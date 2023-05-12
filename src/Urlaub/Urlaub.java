package Urlaub;

import java.util.Objects;

public class Urlaub {

    private int id;
    private String mitarbeiter;
    private String von;
    private String bis;

    public Urlaub(int id, String mitarbeiter, String von, String bis) {
        this.id = id;
        this.mitarbeiter = mitarbeiter;
        this.von = von;
        this.bis = bis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMitarbeiter() {
        return mitarbeiter;
    }

    public void setMitarbeiter(String mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }

    public String getVon() {
        return von;
    }

    public void setVon(String von) {
        this.von = von;
    }

    public String getBis() {
        return bis;
    }

    public void setBis(String bis) {
        this.bis = bis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Urlaub)) return false;
        Urlaub urlaub = (Urlaub) o;
        return id == urlaub.id && Objects.equals(mitarbeiter, urlaub.mitarbeiter) && Objects.equals(von, urlaub.von) && Objects.equals(bis, urlaub.bis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mitarbeiter, von, bis);
    }

    @Override
    public String toString() {
        return "Urlaub{" +
                "id=" + id +
                ", mitarbeiter='" + mitarbeiter + '\'' +
                ", von='" + von + '\'' +
                ", bis='" + bis + '\'' +
                '}';
    }
}
