package vn.kihon.utility.order;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "`order`")
@Getter
@Setter
@ToString
public class Order {
    @Id
    private String id;
    private String name;
}
