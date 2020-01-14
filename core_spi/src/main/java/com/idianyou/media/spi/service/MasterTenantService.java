package com.idianyou.media.spi.service;

import com.idianyou.media.spi.dto.MasterTenantDTO;

public interface MasterTenantService {

    /**
     * 租户条件查询
     * @param tenant 租户标识 （二级域名..等）
     * @return MasterTenantDTO
     */
    MasterTenantDTO findByTenant(String tenant);
}
