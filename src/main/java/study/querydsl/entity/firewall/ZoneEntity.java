package study.querydsl.entity.firewall;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
//@Table(name = "zone")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ZoneEntity {
    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pool_id")
    private PoolEntity pool;

    private String state;

    @Override
    public String toString() {
        return "ZoneEntity{" +
                "id='" + id + '\'' +
                ", pool=" + pool +
                ", state='" + state + '\'' +
                '}';
    }
}
