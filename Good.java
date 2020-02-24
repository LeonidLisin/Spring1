package Lesson3;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "goods_tbl")
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "good_id")
    private int good_id;

    @Column(name = "title_fld")
    private String title_fld;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "buyers_goods_tbl",
            joinColumns = @JoinColumn(name = "good_id"),
            inverseJoinColumns = @JoinColumn(name = "buyer_id")
    )
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private List<Buyer> buyers;


    public int getGood_id() {
        return good_id;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
    }

    public String getTitle_fld() {
        return title_fld;
    }

    public void setTitle_fld(String title_fld) {
        this.title_fld = title_fld;
    }

    @Override
    public String toString() {
        String allBuyers = "";
        for (Buyer o : buyers) {
            allBuyers += o.getName_fld() + " ";
        }
        return "Good " + title_fld + " is sold by: " + allBuyers;
    }
}
