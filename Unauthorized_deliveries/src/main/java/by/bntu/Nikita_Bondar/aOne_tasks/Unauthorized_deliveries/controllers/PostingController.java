/**
 * Class-Controller of "/posting"
 *
 * @author  Nikita Bondar
 */

package by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries.controllers;

import by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries.entities.ItemPosting;
import by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries.services.ItemPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posting")
public class PostingController {

    @Autowired
    ItemPostsService itemPostsService;

    /**
     * Maps requests with period and filter(isAuthorized) params
     *
     * @param period - period of time
     * @param isAuthorized - boolean(string) filter
     * @return
     */
    @GetMapping(params = {"period","isAuthorized"})
    public ResponseEntity withAuthFilterGet(@RequestParam String period,
                                            @RequestParam String isAuthorized) {
        try {
            ItemPosting[] itemPosting = itemPostsService.isAuthorizedFilter(period, isAuthorized);
            return ResponseEntity.ok(itemPosting);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("ne poluchilos");
        }
    }

    /**
     * Maps requests with only period param
     *
     * @param period - period of time
     * @return
     */
    @GetMapping(params = {"period"})
    public ResponseEntity mainGet(@RequestParam String period) {
        try {
            ItemPosting[] itemPosting = itemPostsService.selectByPeriod(period);
            return ResponseEntity.ok(itemPosting);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("ne poluchilos");
        }
    }


}
