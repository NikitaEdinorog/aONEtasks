/**
 * Class ItemPostsService selects data by period and filters by isAuthorized
 *
 * @author  Nikita Bondar
 */

package by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries.services;

import by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries.entities.ItemPosting;
import by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries.repositories.ItemPostingRepo;
import by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries.repositories.PostingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class ItemPostsService {

    @Autowired
    ItemPostingRepo itemPostingRepo;

    @Autowired
    PostingRepo postingRepo;

    /**
     * Selects data by filter from array
     *
     * @param period - period of time
     * @param isAuth - boolean(string) filter
     * @return - array of results from ItemPosting table
     */
    public ItemPosting[] isAuthorizedFilter(String period, String isAuth){

        ItemPosting[] itemPostings = selectByPeriod(period);
        int newSize = 0;
        for (int i =0; i< itemPostings.length; i++){
            if (itemPostings[i].getPosting().isAuthorized().equals(Boolean.valueOf(isAuth))) newSize++;
        }
        ItemPosting[] authPostings =new ItemPosting[newSize];
        for (int i =0, index=0; i< itemPostings.length; i++){
            if (itemPostings[i].getPosting().isAuthorized().equals(Boolean.valueOf(isAuth))) authPostings[index++] = itemPostings[i];
        }
        return authPostings;
    }

    /**
     *Chooses right period
     *
     * @param period - period of time
     * @return -  array of results from ItemPosting table
     */
    public ItemPosting[] selectByPeriod(String period) {

        ItemPosting[] itemPostingSelected = null;
        if (period.equals("day")) {
            itemPostingSelected = selectResults(0, 0, 1);
        } else if (period.equals("month")) {
            itemPostingSelected = selectResults(0, 1, 0);
        } else if (period.equals("quatro")) {
            itemPostingSelected = selectResults(0, 4, 0);
        } else if (period.equals("year")) {
            itemPostingSelected = selectResults(1, 0, 0);
        }

        return itemPostingSelected;

    }

    /**
     * Selects data by period
     *
     * @param yearDiff - number of years in period
     * @param monthDiff - number of months in period
     * @param dayDiff - number of days in period
     * @return - array of results from ItemPosting table
     */
    private ItemPosting[] selectResults(int yearDiff, int monthDiff, int dayDiff) {
        int year = LocalDate.now().minusYears(yearDiff).minusMonths(monthDiff).minusDays(dayDiff).getYear();
        int month = LocalDate.now().minusYears(yearDiff).minusMonths(monthDiff).minusDays(dayDiff).getMonthValue();
        int day = LocalDate.now().minusYears(yearDiff).minusMonths(monthDiff).minusDays(dayDiff).getDayOfMonth();
        Date dateLimit = Date.valueOf("" + year + "-" + month + "-" + day);

        List<ItemPosting> itemPostingList = itemPostingRepo.findByPosting_PostingDateGreaterThan(dateLimit);
        ItemPosting[] itemPostings = new ItemPosting[itemPostingList.size()];
        for (int i = 0; i < itemPostingList.size(); i++) {
            itemPostings[i] = itemPostingList.get(i);
        }
        return itemPostings;
    }

}


