package study.querydsl.entity.firewall;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//@Table(name = "pool")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PoolEntity {

    @Id
    private String id;

    private String region;

    private String state;

    @Override
    public String toString() {
        return "PoolEntity{" +
                "id='" + id + '\'' +
                ", region='" + region + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
