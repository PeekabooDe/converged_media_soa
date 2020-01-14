package com.idianyou.media.core.repository;


import com.idianyou.media.core.entity.MasterTenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MasteTenantRepository extends JpaRepository<MasterTenant, String> {

    @Query("select p from MasterTenant p where p.tenant = :tenant")
    MasterTenant findByTenant(@Param("tenant") String tenant);

}
