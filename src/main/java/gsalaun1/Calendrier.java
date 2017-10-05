package gsalaun1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * <p>Calendrier</p>
 */
public class Calendrier implements Comparable<Calendrier> {

    private Set<Periode> periodes;

    public Calendrier() {
        this.periodes = new TreeSet<>();
    }

    public void addPeriode(Periode periode) {
        this.periodes.add(periode);
    }

    public Set<Periode> getPeriodes() {
        return periodes;
    }

    public void removePeriodeAtIndex(int idxPeriode) {
        Periode periodeAEnlever = new ArrayList<Periode>(periodes).get(idxPeriode);
        this.periodes.remove(periodeAEnlever);
    }

    public void importPeriodes(Calendrier calendrier) {
        this.periodes.clear();
        this.periodes.addAll(calendrier.getPeriodes());
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Calendrier that = (Calendrier) o;

        return periodes.equals(that.periodes);
    }

    @Override public int hashCode() {
        return periodes.hashCode();
    }

    @Override public int compareTo(Calendrier calendrier) {
        //        Set<Periode> allPeriodes = this.periodes.stream().collect(Collectors.toCollection(TreeSet::new));
        //        allPeriodes.addAll(calendrier.periodes.stream().collect(Collectors.toCollection(TreeSet::new)));
        //
        //        Set<LocalDateTime> datesDebutCalendrierCourant = this.periodes.stream().map(periode -> periode.getDebut()).collect(
        //                Collectors.toCollection(TreeSet::new));
        //        Set<LocalDateTime> datesDebutCalendrier = calendrier.getPeriodes().stream().map(periode -> periode.getDebut()).collect(
        //                Collectors.toCollection(TreeSet::new));
        //
        //        Set<LocalDateTime> datesDebut = new TreeSet<>();
        //        datesDebut.addAll(datesDebutCalendrierCourant);
        //        datesDebut.addAll(datesDebutCalendrier);
        //
        //        Set<LocalDateTime> datesDebutUniques = datesDebut.stream()
        //                .filter(date -> !(datesDebutCalendrierCourant.contains(date) && datesDebutCalendrier.contains(date)))
        //                .collect(Collectors.toCollection(TreeSet::new));
        //
        //        if(datesDebutUniques.isEmpty()){
        //            // TODO Comparaison sur les dates de fin
        //        }
        //
        //
        //        Set<Periode> periodesUniques = allPeriodes.stream()
        //                .filter(periode -> !(this.periodes.contains(periode) && calendrier.getPeriodes().contains(periode)))
        //                .collect(Collectors.toCollection(TreeSet::new));
        //        if (periodesUniques.isEmpty()) {
        //            return 0;
        //        }
        //
        //        Periode premierePeriodeUnique = periodesUniques.stream().findFirst().get();
        //        if (this.periodes.contains(premierePeriodeUnique)) {
        //            return -1 ;
        //        }
        //        if (this.periodes.contains(dernierePeriodeUnique)) {
        //            return 1;
        //        }
        //        return 1;

        //        int comparaisonDatesDebut =this.compareDatesDebut(calendrier) ;
        //        if(comparaisonDatesDebut == 0){
        //            return this.compareDatesFin(calendrier);
        //        }
        //        return comparaisonDatesDebut;

        // TODO Nouvelle version

        //        Set<Periode> periodesUniquesCalendrierCourant = this.periodes.stream()
        //                .filter(periode -> !calendrier.periodes.contains(periode))
        //                .collect(Collectors.toCollection(TreeSet::new));
        //
        //        Set<Periode> periodesUniquesCalendrier = calendrier.getPeriodes().stream()
        //                .filter(periode -> !this.periodes.contains(periode))
        //                .collect(Collectors.toCollection(TreeSet::new));
        //
        //        if (periodesUniquesCalendrierCourant.isEmpty() && !periodesUniquesCalendrier.isEmpty()) {
        //            return -1; // TODO Pas forcément, voir si les périodes en plus sont avant ou après les communes
        //        }
        //        if (!periodesUniquesCalendrierCourant.isEmpty() && periodesUniquesCalendrier.isEmpty()) {
        //            return 1;
        //        }
        //        if (periodesUniquesCalendrierCourant.isEmpty() && periodesUniquesCalendrier.isEmpty()) {
        //            return 0;
        //        }
        //        Periode premierePeriodeUniqueCalendrierCourant = periodesUniquesCalendrierCourant.stream().findFirst().get();
        //        Periode premierePeriodeUniqueCalendrier = periodesUniquesCalendrier.stream().findFirst().get();
        //
        //        if (Objects.equals(premierePeriodeUniqueCalendrierCourant, premierePeriodeUniqueCalendrier)) {
        //            // TODO A faire
        //            Periode dernierePeriodeUniqueCalendrierCourant = periodesUniquesCalendrierCourant.stream()
        //                    .reduce((a, b) -> b).get();
        //            Periode dernierePeriodeUniqueCalendrier = periodesUniquesCalendrier.stream().reduce((a, b) -> b).get();
        //            return dernierePeriodeUniqueCalendrierCourant.compareTo(dernierePeriodeUniqueCalendrier); // TODO Sûr ?
        //            //            return 0 ;
        //        }
        //
        //        //if(premierePeriodeUniqueCalendrierCourant.getDebut().equals(premierePeriodeUniqueCalendrier)){
        //        Set<LocalDateTime> datesDebutUniquesCalendrierCourant = periodesUniquesCalendrierCourant.stream()
        //                .filter(periodeCalendrierCourant -> {
        //                    return periodesUniquesCalendrier.stream()
        //                            .filter(periode -> periode.getDebut().equals(periodeCalendrierCourant.getDebut())).count()
        //                            == 0;
        //                }).map(periode -> periode.getDebut()).collect(Collectors.toCollection(TreeSet::new));
        //
        //        Set<LocalDateTime> datesDebutUniquesCalendrier = periodesUniquesCalendrier.stream().filter(periode -> {
        //            return periodesUniquesCalendrierCourant.stream()
        //                    .filter(periodeCalendrierCourant -> periodeCalendrierCourant.getDebut().equals(periode.getDebut()))
        //                    .count() == 0;
        //        }).map(periode -> periode.getDebut()).collect(Collectors.toCollection(TreeSet::new));
        //
        //        if (datesDebutUniquesCalendrierCourant.isEmpty() && !datesDebutUniquesCalendrier.isEmpty()) {
        //            return -1;
        //        }
        //        if (!datesDebutUniquesCalendrierCourant.isEmpty() && datesDebutUniquesCalendrier.isEmpty()) {
        //            return 1;
        //        }
        //        if (datesDebutUniquesCalendrierCourant.isEmpty() && datesDebutUniquesCalendrier.isEmpty()) {
        //            /*
        //            Set<LocalDateTime> datesFinUniquesCalendrierCourant = periodesUniquesCalendrierCourant.stream()
        //                    .filter(periodeCalendrierCourant -> {
        //                        return periodesUniquesCalendrier.stream()
        //                                .filter(periode -> periode.getFin().equals(periodeCalendrierCourant.getFin())).count()
        //                                == 0;
        //                    }).map(periode -> periode.getFin()).collect(Collectors.toCollection(TreeSet::new));
        //            Set<LocalDateTime> datesFinUniquesCalendrier = periodesUniquesCalendrier.stream().filter(periode -> {
        //                return periodesUniquesCalendrierCourant.stream()
        //                        .filter(periodeCalendrierCourant -> periodeCalendrierCourant.getFin().equals(periode.getFin()))
        //                        .count() == 0;
        //            }).map(periode -> periode.getFin()).collect(Collectors.toCollection(TreeSet::new));
        //            if (datesFinUniquesCalendrierCourant.isEmpty() && !datesFinUniquesCalendrier.isEmpty()) {
        //                return -1;
        //            }
        //            if (!datesFinUniquesCalendrierCourant.isEmpty() && datesFinUniquesCalendrier.isEmpty()) {
        //                return 1;
        //            }
        //            if (datesFinUniquesCalendrierCourant.isEmpty() && datesFinUniquesCalendrier.isEmpty()) {
        //                return 0 ;
        //            }
        //            LocalDateTime derniereDateFinUniqueCalendrierCourant = datesFinUniquesCalendrierCourant.stream().findFirst()
        //                    .get();
        //            LocalDateTime dernierDateFinUniqueCalendrier = datesFinUniquesCalendrier.stream().findFirst().get();
        // TODO Comparer les dernières dates de début ?
        //            */
        //            //LocalDateTime
        //            //return dernierDateFinUniqueCalendrierCourant.compareTo(premiereDateFinUniqueCalendrier);
        //            return 0 ;
        //        }
        //        LocalDateTime premiereDateDebutUniqueCalendrierCourant = datesDebutUniquesCalendrierCourant.stream().findFirst()
        //                .get();
        //        LocalDateTime premiereDateDebutUniqueCalendrier = datesDebutUniquesCalendrier.stream().findFirst().get();
        //
        //        if (Objects.equals(premiereDateDebutUniqueCalendrierCourant, premiereDateDebutUniqueCalendrier)) {
        //            return 0; // TODO Non, comparer les dates de fin
        //        }
        //        System.out.println("DEBUT CAL : " + datesDebutUniquesCalendrier);
        //        System.out.println("DEBUT CAL COURANT : " + datesDebutUniquesCalendrierCourant);
        //        //}
        //
        //        return premiereDateDebutUniqueCalendrierCourant.compareTo(premiereDateDebutUniqueCalendrier);
        //        //        return 0;

        return 1; // TODO A revoir complètement, un jour, quand j'aurai le temps et si quelqu'un se rend compte de quelque chose

    }

    /**
     * Compare les dates de début des périodes du calendrier courant et de celui passé en paramètres
     * @param calendrier calendrier
     * @return -1 si le calendrier courant a une première date de début inférieure à celle du calendrier passé
     *          0 si les dates de début des périodes sont les mêmes
     *          1 si le calendrier courant a une première date de début supérieure à celle du calendrier passé
     */
    private int compareDatesDebut(Calendrier calendrier) {
        Set<LocalDateTime> datesCalendrierCourant = this.periodes.stream().map(periode -> periode.getDebut()).collect(
                Collectors.toCollection(TreeSet::new));
        Set<LocalDateTime> datesCalendrier = calendrier.getPeriodes().stream().map(periode -> periode.getDebut())
                .collect(
                        Collectors.toCollection(TreeSet::new));
        Set<LocalDateTime> toutesDates = new TreeSet<>();
        toutesDates.addAll(datesCalendrierCourant);
        toutesDates.addAll(datesCalendrier);
        Set<LocalDateTime> datesUniques = toutesDates.stream()
                .filter(date -> !(datesCalendrierCourant.contains(date) && datesCalendrier.contains(date)))
                .collect(Collectors.toCollection(TreeSet::new));
        if (datesUniques.isEmpty()) {
            return 0;
        }
        LocalDateTime dateUnique = datesUniques.stream().findFirst().get();
        if (datesCalendrierCourant.contains(dateUnique)) {
            return -1;
        }
        return 1;
    }

    /**
     * Compare les dates de fin des périodes du calendrier courant et de celui passé en paramètres
     * @param calendrier calendrier
     * @return -1 si le calendrier courant a une première date de fin inférieure à celle du calendrier passé
     *          0 si les dates de fin des périodes sont les mêmes
     *          1 si le calendrier courant a une première date de fin supérieure à celle du calendrier passé
     */
    private int compareDatesFin(Calendrier calendrier) {
        Set<LocalDateTime> datesCalendrierCourant = this.periodes.stream().map(periode -> periode.getFin()).collect(
                Collectors.toCollection(TreeSet::new));
        Set<LocalDateTime> datesCalendrier = calendrier.getPeriodes().stream().map(periode -> periode.getFin()).collect(
                Collectors.toCollection(TreeSet::new));
        Set<LocalDateTime> toutesDates = new TreeSet<>();
        toutesDates.addAll(datesCalendrierCourant);
        toutesDates.addAll(datesCalendrier);
        Set<LocalDateTime> datesUniques = toutesDates.stream()
                .filter(date -> !(datesCalendrierCourant.contains(date) && datesCalendrier.contains(date)))
                .collect(Collectors.toCollection(TreeSet::new));
        if (datesUniques.isEmpty()) {
            return 0;
        }
        LocalDateTime dateUnique = datesUniques.stream().findFirst().get();
        if (datesCalendrierCourant.contains(dateUnique)) {
            return -1;
        }
        return 1;
    }
}