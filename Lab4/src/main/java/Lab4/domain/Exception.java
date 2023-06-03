package Lab4.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Exception {

    @Id
    @GeneratedValue
    int id;

    @Temporal(TemporalType.DATE)
    LocalDate date;
    @Temporal(TemporalType.TIME)
    LocalTime time;

    String principle;
    String operation;
    String exceptionType;

    public Exception(LocalDate date, LocalTime time, String operation, String principle, String exceptionType) {
        this.date = date;
        this.time = time;
        this.operation = operation;
        this.principle = principle;
        this.exceptionType = exceptionType;
    }
}
