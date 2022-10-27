/**
 * Class DBfiller fills DB from ArrayLists
 *
 * @author  Nikita Bondar
 */

package by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries.services;

import by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries.CSVprocessors.csvProcessor;
import by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries.entities.*;
import by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

@Service
public class DBfiller {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    LoginsRepo loginsRepo;
    @Autowired
    PostingRepo postingRepo;
    @Autowired
    ItemRepo itemRepo;
    @Autowired
    ItemPostingRepo itemPostingRepo;

    public void fillDBfromFiles() throws IOException {
        ArrayList<String[]> postingArray = csvProcessor.resdCSV("src/main/resources/CSVs/postings.csv", ';');
        ArrayList<String[]> loginsArray = csvProcessor.resdCSV("src/main/resources/CSVs/logins.csv", ',');

        fillDBfromLogins(loginsArray);
        fillDBfromPostings(postingArray);
    }

    /**
     * Fill Login and User tables
     *
     * @param loginsArray - data from logins.csv
     */
    private void fillDBfromLogins(ArrayList<String[]> loginsArray) {
        for (String[] note : loginsArray) {
            if (note[0].equals("")) continue;

            for (int i = 0; i < note.length; i++) {
                note[i] = note[i].replace("\t", "");
            }

            User user = new User(note[1], note[3], note[4]);
            if (userRepo.findById(user.getAccountName()).isEmpty()) {
                userRepo.save(user);
            }
            Login login = new Login(user, note[2].equals("True"), note[0]);
            loginsRepo.save(login);
        }
    }

    /**
     * Fill Item, Posting and ItemPosting tables
     *
     * @param postingArray - data fro postings.csv
     */
    private void fillDBfromPostings(ArrayList<String[]> postingArray) {
        for (String[] note : postingArray) {
            if (note[0].equals("")) continue;

            for (int i = 0; i < note.length; i++) {
                note[i] = note[i].replace("\t", "");
            }

            Long postingId = Long.parseLong(note[0]);
            Long itenPosition = Long.parseLong(note[1]);
            Date docDate = Date.valueOf(dateConvertToSqlFormat(note[2]));
            Date postDate = Date.valueOf(dateConvertToSqlFormat(note[3]));
            String itemName = note[4];
            Long quantity = Long.parseLong(note[5]);
            String BUn = note[6];
            Double amount = Double.parseDouble(note[7].replace(",", "."));
            String crcy = note[8];
            String username = note[9];
            Boolean isAuthorized = (loginsRepo.findByUser_AccountName(note[9]).isPresent() && (loginsRepo.findByUser_AccountName(note[9])).get().getActive());


            Posting posting = new Posting(postingId, docDate, postDate, username, isAuthorized);
            if (postingRepo.findById(posting.getId()).isEmpty()) {
                postingRepo.save(posting);
            } else {
                posting = postingRepo.findById(posting.getId()).get();
            }

            Item item = new Item(itemName, BUn);
            if (itemRepo.findByItemName(item.getItemName()).isEmpty()) {
                itemRepo.save(item);
            } else {
                item = itemRepo.findByItemName(item.getItemName()).get();
            }

            ItemPosting itemPosting = new ItemPosting(posting, itenPosition, item, quantity, amount, crcy);
            itemPostingRepo.save(itemPosting);
        }
    }


    /**
     * "dd.mm.yyyy" -> "yyyy-mm-dd"
     *
     * @param date - date like "dd.mm.yyyy"
     * @return - date like "yyyy-mm-dd"
     */
    private String dateConvertToSqlFormat(String date) {
        String[] array = date.split("\\.");
        return "" + array[2] + "-" + array[1] + "-" + array[0];
    }

}

