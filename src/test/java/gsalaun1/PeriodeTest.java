package gsalaun1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

/**
 * <p>PeriodeTest</p>
 */
public class PeriodeTest {

    @Test
    public void should_deserialize_date_debut() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            Periode periode = mapper
                    .readValue(new File(getClass().getClassLoader().getResource("periode.json").getFile()),
                            Periode.class);
            assertThat(periode.getDebut().getYear()).isEqualTo(2017);
            assertThat(periode.getDebut().getMonthValue()).isEqualTo(10);
            assertThat(periode.getDebut().getDayOfMonth()).isEqualTo(2);
            assertThat(periode.getDebut().getHour()).isEqualTo(9);
            assertThat(periode.getDebut().getMinute()).isEqualTo(0);
            assertThat(periode.getDebut().getSecond()).isEqualTo(0);
        } catch (IOException ioException) {
            fail();
        }
    }

    @Test
    public void should_deserialize_date_fin() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            Periode periode = mapper
                    .readValue(new File(getClass().getClassLoader().getResource("periode.json").getFile()),
                            Periode.class);
            assertThat(periode.getFin().getYear()).isEqualTo(2017);
            assertThat(periode.getFin().getMonthValue()).isEqualTo(10);
            assertThat(periode.getFin().getDayOfMonth()).isEqualTo(4);
            assertThat(periode.getFin().getHour()).isEqualTo(12);
            assertThat(periode.getFin().getMinute()).isEqualTo(0);
            assertThat(periode.getFin().getSecond()).isEqualTo(0);
        } catch (IOException ioException) {
            fail();
        }
    }

    @Test
    public void should_sort_periodes_based_on_beginning(){
        LocalDateTime now = LocalDateTime.now();
        Periode periode1 = new Periode.Builder().from(now).to(now.plusDays(1)).build();
        Periode periode2 = new Periode.Builder().from(now.plusDays(1)).to(now.plusDays(1)).build();
        assertThat(periode1.compareTo(periode2)).isNegative();
    }

    @Test
    public void should_sort_periodes_based_on_end(){
        LocalDateTime now = LocalDateTime.now();
        Periode periode1 = new Periode.Builder().from(now).to(now.plusDays(1)).build();
        Periode periode2 = new Periode.Builder().from(now).to(now.plusDays(2)).build();
        assertThat(periode1.compareTo(periode2)).isNegative();
    }

    @Test
    public void should_be_equals(){
        LocalDateTime now = LocalDateTime.now();
        Periode periode1 = new Periode.Builder().from(now).to(now.plusDays(1)).build();
        Periode periode2 =new Periode.Builder().from(now).to(now.plusDays(1)).build();
        assertThat(periode1).isEqualTo(periode2);
    }

}