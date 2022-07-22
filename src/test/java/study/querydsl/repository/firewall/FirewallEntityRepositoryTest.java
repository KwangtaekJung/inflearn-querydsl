package study.querydsl.repository.firewall;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import study.querydsl.entity.firewall.FirewallEntity;
import study.querydsl.entity.firewall.PoolEntity;
import study.querydsl.entity.firewall.ZoneEntity;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.DisplayName.class)
class FirewallEntityRepositoryTest {

    @Autowired ZoneEntityRepository zoneEntityRepository;
    @Autowired PoolEntityRepository poolEntityRepository;
    @Autowired FirewallEntityRepository firewallEntityRepository;
    @Autowired EntityManager em;

    static final String FIREWALL_ID_1 = "FIREWALL-0001";
    static final String FIREWALL_ID_2 = "FIREWALL-0002";

    @AfterAll
    public void afterAll() {
        System.out.println("The End.");
    }

    @Test
    @DisplayName("001. 테스트 데이터 설정")
    public void saveTestData() {
        PoolEntity poolEntity1 = new PoolEntity("POOL-0001", "REGION-EAST", "ACTIVE");
        poolEntityRepository.save(poolEntity1);
        PoolEntity poolEntity2 = new PoolEntity("POOL-0002", "REGION-WEST", "ACTIVE");
        poolEntityRepository.save(poolEntity2);

        ZoneEntity zoneEntity1 = new ZoneEntity("ZONE-0001", poolEntity1, "ACTIVE");
        zoneEntityRepository.save(zoneEntity1);
        ZoneEntity zoneEntity2 = new ZoneEntity("ZONE-0002", poolEntity2, "ACTIVE");
        zoneEntityRepository.save(zoneEntity2);
    }

    @Test
    @DisplayName("100. FirewallEntity1 저장 with save")
    public void saveFirewall_withSave() {
        //given
        ZoneEntity newZoneEntity = new ZoneEntity();
        newZoneEntity.setId("ZONE-0001");
        System.out.println("em.contains(newZoneEntity)=" + em.contains(newZoneEntity));

        //when
        FirewallEntity firewallEntity = new FirewallEntity(FIREWALL_ID_1, newZoneEntity);
        firewallEntityRepository.save(firewallEntity);
    }

    @Test
    @DisplayName("101. findById")
    @Transactional //toString부분에서 lazy loading이 일어나기 때문에 @Transactional을 걸어준다.
    public void findById1() {
        Optional<FirewallEntity> savedFirewallEntity = firewallEntityRepository.findById(FIREWALL_ID_1);
        savedFirewallEntity.ifPresent(System.out::println);
    }

    @Test
    @DisplayName("102. FirewallEntity2 저장 with em.persist")
    @Transactional //em.persist 사용 시 transaction 필요함.
    @Rollback(value = false)
    public void saveFirewall() {
        //given
        ZoneEntity newZoneEntity = new ZoneEntity();
        newZoneEntity.setId("ZONE-0002");
        System.out.println("em.contains(newZoneEntity)=" + em.contains(newZoneEntity));

        //when
        FirewallEntity firewallEntity = new FirewallEntity(FIREWALL_ID_2, newZoneEntity);
        em.persist(firewallEntity);
    }

    @Test
    @DisplayName("103. findById")
    @Transactional //toString부분에서 lazy loading이 일어나기 때문에 @Transactional을 걸어준다.
    public void findById2() {
        Optional<FirewallEntity> savedFirewallEntity = firewallEntityRepository.findById(FIREWALL_ID_2);
        savedFirewallEntity.ifPresent(System.out::println);
    }
}