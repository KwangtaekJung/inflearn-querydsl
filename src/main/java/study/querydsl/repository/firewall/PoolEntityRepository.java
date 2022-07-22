package study.querydsl.repository.firewall;

import org.springframework.data.jpa.repository.JpaRepository;
import study.querydsl.entity.firewall.PoolEntity;

public interface PoolEntityRepository extends JpaRepository<PoolEntity, String> {
}
