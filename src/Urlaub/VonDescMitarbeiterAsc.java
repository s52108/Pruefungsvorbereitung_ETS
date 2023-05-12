package Urlaub;

import java.util.Comparator;

public class VonDescMitarbeiterAsc implements Comparator<Urlaub> {
    @Override
    public int compare(Urlaub o1, Urlaub o2) {
        int res = o2.getVon().compareTo(o1.getVon());
        if (res == 0) {
            o1.getMitarbeiter().compareTo(o2.getMitarbeiter());

        }
        return res;
    }
}
