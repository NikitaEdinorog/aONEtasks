/**
 * Entity of Items table consists of:
 *  id
 *  item_name
 *  BUn
 *
 * @authir Nikita Bondar
 */

package by.bntu.Nikita_Bondar.aOne_tasks.Unauthorized_deliveries.entities;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "item_name", nullable = false, unique = true)
    private String itemName;

    @Column(name = "BUn")
    private String BUn;

    public Item() {
    }

    public Item(String itemNmae, String BUn) {
        this.itemName = itemNmae;
        this.BUn = BUn;
    }

    public Long getId() {
        return id;
    }


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemNmae) {
        this.itemName = itemNmae;
    }

    public String getBUn() {
        return BUn;
    }

    public void setBUn(String BUn) {
        this.BUn = BUn;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemNmae='" + itemName + '\'' +
                ", BUn='" + BUn + '\'' +
                '}';
    }
}
