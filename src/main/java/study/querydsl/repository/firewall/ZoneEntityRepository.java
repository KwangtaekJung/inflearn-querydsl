package study.querydsl.repository.firewall;

import org.springframework.data.jpa.repository.JpaRepository;
import study.querydsl.entity.firewall.ZoneEntity;

public interface ZoneEntityRepository extends JpaRepository<ZoneEntity, String> {
}
