/**
 * Class-controller of "/fill"
 * ---Use "/fill" to fill DB from files---
 *
 * @author  Nikita Bondar
 */

package by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries.controllers;

import by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries.services.DBfiller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Maps request to fill DB
 */
@RestController
@RequestMapping("/fill")
public class DbFillController {

    @Autowired
    DBfiller dbFiller;

    @GetMapping("/")
    public ResponseEntity fillDB() {
        try {
            dbFiller.fillDBfromFiles();
            return ResponseEntity.ok("Success filling");

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
