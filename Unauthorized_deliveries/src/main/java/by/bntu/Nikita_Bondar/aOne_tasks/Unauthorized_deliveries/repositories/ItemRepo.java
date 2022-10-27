package by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries.repositories;

import by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries.entities.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface ItemRepo extends CrudRepository<Item, Long> {
    Optional<Item> findByItemName(String itemName);
}
