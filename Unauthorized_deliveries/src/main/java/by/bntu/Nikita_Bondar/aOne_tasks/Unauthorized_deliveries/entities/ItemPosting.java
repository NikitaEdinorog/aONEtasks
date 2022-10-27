/**
 * Entity of item_posting table consists of:
 *  id
 *  Posting
 *  item_position
 *  Item
 *  quantity
 *  amount
 *  currency
 *
 * @author  Nikita Bondar
 */

package by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "item_posting")

public class ItemPosting implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    private Posting posting;

    @Column(name = "item_position")
    private Long itemPosition;

    @ManyToOne
    private Item item;

    @Column(name = "quantity", nullable = false)
    private Long quantity;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "crcy")
    String crcy;

    public ItemPosting() {
    }

    public ItemPosting(Posting posting, Long itemPosition, Item item, Long quantity, Double amount, String crcy) {
        this.posting = posting;
        this.itemPosition = itemPosition;
        this.item = item;
        this.quantity = quantity;
        this.amount = amount;
        this.crcy = crcy;
    }

    public Posting getPosting() {
        return posting;
    }

    public void setPosting(Posting posting) {
        this.posting = posting;
    }

    public Long getItemPosition() {
        return itemPosition;
    }

    public void setItemPosition(Long itemPosition) {
        this.itemPosition = itemPosition;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCrcy() {
        return crcy;
    }

    public void setCrcy(String crcy) {
        this.crcy = crcy;
    }

    @Override
    public String toString() {
        return "ItemPosting{" +
                "id=" + id +
                ", posting=" + posting +
                ", itemPosition=" + itemPosition +
                ", item=" + item +
                ", quantity=" + quantity +
                ", amount=" + amount +
                ", crcy='" + crcy + '\'' +
                '}';
    }
}
