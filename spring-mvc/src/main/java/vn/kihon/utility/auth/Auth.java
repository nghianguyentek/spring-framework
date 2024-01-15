package vn.kihon.utility.auth;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Auth {
    @Id
    private String id;
    private String name;
}
