package by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries.repositories;

import by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries.entities.Login;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LoginsRepo extends CrudRepository<Login, Long> {
    Optional<Login> findByUser_AccountName(String accountName);
}
