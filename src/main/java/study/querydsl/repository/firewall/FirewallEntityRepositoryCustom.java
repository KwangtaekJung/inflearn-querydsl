package study.querydsl.repository.firewall;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import study.querydsl.dto.FirewallSearchCondition;
import study.querydsl.entity.firewall.FirewallEntity;

public interface FirewallEntityRepositoryCustom {

    Page<FirewallEntity> searchPageWithRegion(FirewallSearchCondition condition, Pageable pageable);
}
