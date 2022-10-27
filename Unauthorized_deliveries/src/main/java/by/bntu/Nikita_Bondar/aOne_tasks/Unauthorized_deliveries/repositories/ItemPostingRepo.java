package by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries.repositories;

import by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries.entities.ItemPosting;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ItemPostingRepo extends CrudRepository<ItemPosting, Long> {
    @Query("select i from ItemPosting i where i.posting.postingDate > ?1")
    List<ItemPosting> findByPosting_PostingDateGreaterThan(Date postingDate);

}
