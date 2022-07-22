package study.querydsl.repository.firewall;

import org.springframework.data.jpa.repository.JpaRepository;
import study.querydsl.entity.firewall.FirewallEntity;

public interface FirewallEntityRepository extends JpaRepository<FirewallEntity, String> {
}
