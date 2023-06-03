package Lab4.repositotry;

import Lab4.domain.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerRepo extends JpaRepository<Logger, Integer> {

}
