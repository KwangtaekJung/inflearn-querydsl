package study.querydsl.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Zone {

    @Id
    private String id;

    private String poolId;

    public Zone(String id, String poolId) {
        this.id = id;
        this.poolId = poolId;
    }
}
