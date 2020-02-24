package Lesson3;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "buyers_tbl")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "buyer_id")
    private int buyer_id;

    @Column(name = "name_fld")
    private String name_fld;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "buyers_goods_tbl",
            joinColumns = @JoinColumn(name = "buyer_id"),
            inverseJoinColumns = @JoinColumn(name = "good_id")
    )
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private List<Good> goods;

    public int getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(int buyer_id) {
        this.buyer_id = buyer_id;
    }

    public String getName_fld() {
        return name_fld;
    }

    public void setName_fld(String name_fld) {
        this.name_fld = name_fld;
    }

    @Override
    public String toString() {
        String allGoods = "";
        for (Good o : goods) {
            allGoods += o.getTitle_fld() + " ";
        }
        return "Buyer " + name_fld + " sold: " + allGoods;
    }
}
