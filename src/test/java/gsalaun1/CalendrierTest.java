package gsalaun1;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <p>CalendrierTest</p>
 */
public class CalendrierTest {

    private Calendrier calendrier;

    private Periode periode1;

    private Periode periode2;

    private Periode periode3;

    private Periode periode4;

    @Before
    public void setup() {
        this.periode1 = new Periode.Builder().from(LocalDateTime.now()).to(LocalDateTime.now().plusDays(1)).build();
        this.periode2 = new Periode.Builder().from(LocalDateTime.now()).to(LocalDateTime.now().plusDays(5)).build();
        this.periode3 = new Periode.Builder().from(LocalDateTime.now().plusDays(1))
                .to(LocalDateTime.now().plusDays(1)).build();
        this.periode4 = new Periode.Builder().from(LocalDateTime.now().plusDays(1))
                .to(LocalDateTime.now().plusDays(5)).build();
        this.calendrier = new Calendrier();
        this.calendrier.addPeriode(this.periode1);
        this.calendrier.addPeriode(this.periode2);
        this.calendrier.addPeriode(this.periode3);
        this.calendrier.addPeriode(this.periode4);
    }

    @Test
    public void should_delete_periode() {
        calendrier.removePeriodeAtIndex(0);
        assertThat(calendrier.getPeriodes()).containsExactly(periode2, periode3, periode4);
    }

    @Test
    public void should_copy_calendrier() {
        Calendrier copieCalendrier = new Calendrier();
        copieCalendrier.importPeriodes(this.calendrier);
        assertThat(copieCalendrier.getPeriodes()).containsExactly(periode1, periode2, periode3, periode4);
    }

    @Test
    public void should_return_calendriers_equals() {
        LocalDateTime now = LocalDateTime.now();
        Calendrier calendrier1 = new Calendrier();
        Periode periode1 = new Periode.Builder().from(now).to(now.plusDays(1)).build();
        calendrier1.addPeriode(periode1);
        Calendrier calendrier2 = new Calendrier();
        Periode periode2 = new Periode.Builder().from(now).to(now.plusDays(1)).build();
        calendrier2.addPeriode(periode2);
        assertThat(calendrier1).isEqualTo(calendrier2);
    }

    @Test
    @Ignore
    public void should_sort_calendriers_based_on_periode_beginning() {
        LocalDateTime now = LocalDateTime.now();
        Calendrier calendrier1 = new Calendrier();
        Periode periode1 = new Periode.Builder().from(now).to(now.plusDays(1)).build();
        calendrier1.addPeriode(periode1);
        Calendrier calendrier2 = new Calendrier();
        Periode periode2 = new Periode.Builder().from(now.plusDays(1)).to(now.plusDays(1)).build();
        calendrier2.addPeriode(periode2);
        assertThat(calendrier1.compareTo(calendrier2)).isNegative();
    }

    @Test
    @Ignore
    public void should_sort_calendriers_with_multiple_periodes_based_on_periode_beginning() {
        LocalDateTime now = LocalDateTime.now();
        Calendrier calendrier1 = new Calendrier();
        Periode periode1 = new Periode.Builder().from(now).to(now.plusDays(1)).build();
        Periode periode2 = new Periode.Builder().from(now.plusDays(1)).to(now.plusDays(3)).build();
        Periode periode3 = new Periode.Builder().from(now.plusDays(2)).to(now.plusDays(3)).build();
        calendrier1.addPeriode(periode1);
        calendrier1.addPeriode(periode2);
        calendrier1.addPeriode(periode3);
        Calendrier calendrier2 = new Calendrier();
        Periode periode4 = new Periode.Builder().from(now).to(now.plusDays(1)).build();
        Periode periode5 = new Periode.Builder().from(now.plusDays(1)).to(now.plusDays(2)).build();
        Periode periode6 = new Periode.Builder().from(now.plusDays(5)).to(now.plusDays(8)).build();
        calendrier2.addPeriode(periode4);
        calendrier2.addPeriode(periode5);
        calendrier2.addPeriode(periode6);
        assertThat(calendrier1.compareTo(calendrier2)).isNegative();
    }

    @Test
    @Ignore
    public void should_sort_calendriers_based_on_periode_ending() {
        LocalDateTime now = LocalDateTime.now();
        Calendrier calendrier1 = new Calendrier();
        Periode periode1 = new Periode.Builder().from(now).to(now.plusDays(1)).build();
        calendrier1.addPeriode(periode1);
        Calendrier calendrier2 = new Calendrier();
        Periode periode2 = new Periode.Builder().from(now).to(now.plusDays(2)).build();
        calendrier2.addPeriode(periode2);
        assertThat(calendrier1.compareTo(calendrier2)).isNegative();
    }

    @Test
    @Ignore
    public void should_sort_calendriers_with_multiple_periodes_based_on_periode_ending() {
        LocalDateTime now = LocalDateTime.now();
        Calendrier calendrier1 = new Calendrier();
        Periode periode1 = new Periode.Builder().from(now).to(now.plusDays(1)).build();
        Periode periode2 = new Periode.Builder().from(now.plusDays(1)).to(now.plusDays(3)).build();
        Periode periode3 = new Periode.Builder().from(now.plusDays(2)).to(now.plusDays(3)).build();
        calendrier1.addPeriode(periode1);
        calendrier1.addPeriode(periode2);
        calendrier1.addPeriode(periode3);
        Calendrier calendrier2 = new Calendrier();
        Periode periode4 = new Periode.Builder().from(now).to(now.plusDays(1)).build();
        Periode periode5 = new Periode.Builder().from(now.plusDays(1)).to(now.plusDays(3)).build();
        Periode periode6 = new Periode.Builder().from(now.plusDays(2)).to(now.plusDays(8)).build();
        calendrier2.addPeriode(periode4);
        calendrier2.addPeriode(periode5);
        calendrier2.addPeriode(periode6);
        assertThat(calendrier1.compareTo(calendrier2)).isNegative();
    }

    @Test
    @Ignore
    public void should_sort_calendriers_with_different_sizes() {
        LocalDateTime now = LocalDateTime.now();
        Calendrier calendrier1 = new Calendrier();
        Periode periode1 = new Periode.Builder().from(now).to(now.plusDays(1)).build();
        Periode periode2 = new Periode.Builder().from(now.plusDays(1)).to(now.plusDays(3)).build();
        calendrier1.addPeriode(periode1);
        calendrier1.addPeriode(periode2);
        calendrier1.addPeriode(periode3);
        Calendrier calendrier2 = new Calendrier();
        Periode periode4 = new Periode.Builder().from(now).to(now.plusDays(1)).build();
        Periode periode5 = new Periode.Builder().from(now.plusDays(1)).to(now.plusDays(3)).build();
        Periode periode6 = new Periode.Builder().from(now.plusDays(2)).to(now.plusDays(8)).build();
        calendrier2.addPeriode(periode4);
        calendrier2.addPeriode(periode5);
        calendrier2.addPeriode(periode6);
        assertThat(calendrier1.compareTo(calendrier2)).isNegative();
    }

    @Test
    public void should_sort_calendriers_with_different_sizes_and_different_beginnings() {
        LocalDateTime now = LocalDateTime.now();
        Calendrier calendrier1 = new Calendrier();
        Periode periode1 = new Periode.Builder().from(now.plusDays(1)).to(now.plusDays(3)).build();
        Periode periode2 = new Periode.Builder().from(now.plusDays(2)).to(now.plusDays(3)).build();
        calendrier1.addPeriode(periode1);
        calendrier1.addPeriode(periode2);
        Calendrier calendrier2 = new Calendrier();
        Periode periode4 = new Periode.Builder().from(now).to(now.plusDays(1)).build();
        Periode periode5 = new Periode.Builder().from(now.plusDays(1)).to(now.plusDays(3)).build();
        Periode periode6 = new Periode.Builder().from(now.plusDays(2)).to(now.plusDays(8)).build();
        calendrier2.addPeriode(periode4);
        calendrier2.addPeriode(periode5);
        calendrier2.addPeriode(periode6);
        assertThat(calendrier1.compareTo(calendrier2)).isPositive();
    }

}