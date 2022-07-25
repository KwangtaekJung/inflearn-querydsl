package study.querydsl.repository.firewall;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;
import study.querydsl.dto.FirewallSearchCondition;
import study.querydsl.entity.firewall.FirewallEntity;
import study.querydsl.repository.support.Querydsl4RepositorySupport;

import static study.querydsl.entity.firewall.QFirewallEntity.firewallEntity;

public class FirewallEntityRepositoryCustomImpl extends Querydsl4RepositorySupport implements FirewallEntityRepositoryCustom {

    public FirewallEntityRepositoryCustomImpl() {
        super(FirewallEntity.class);
    }

    @Override
    public Page<FirewallEntity> searchPageWithRegion(FirewallSearchCondition condition, Pageable pageable) {
        return applyPagination(pageable, query -> query
                .select(firewallEntity)
                .from(firewallEntity)
                .where(regionContains(condition.getRegion()))
        );
    }

    private BooleanExpression regionContains(String region) {
        return ObjectUtils.isEmpty(region) ? null : firewallEntity.zone.pool.region.contains(region);
    }
}
