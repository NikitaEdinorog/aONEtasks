package by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries.repositories;

import by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries.entities.User;
import org.springframework.data.repository.CrudRepository;


public interface UserRepo extends CrudRepository<User,String> {
}
