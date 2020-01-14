package com.idianyou.media.core.service.impl;

import com.idianyou.media.spi.dto.MasterTenantDTO;
import com.idianyou.media.spi.service.MasterTenantService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class MasterTenantServiceImpl implements MasterTenantService {


    public MasterTenantDTO findByTenant(String tenant) {
        return null;
    }
}
