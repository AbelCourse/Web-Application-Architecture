package Lab4.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Logger {

    @Id
    @GeneratedValue
    int id;

    @Temporal(TemporalType.DATE)
    LocalDate date;
    @Temporal(TemporalType.TIME)
    LocalTime time;


    String operation;
    String principle;

    public Logger(LocalDate date, LocalTime time, String operation, String principle) {
        this.date = date;
        this.time = time;
        this.operation = operation;
        this.principle = principle;
    }
}
