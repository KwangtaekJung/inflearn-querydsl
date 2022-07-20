package study.querydsl.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Pool {

    @Id
    private String id;

    private String region;

    public Pool(String id, String region) {
        this.id = id;
        this.region = region;
    }

}
