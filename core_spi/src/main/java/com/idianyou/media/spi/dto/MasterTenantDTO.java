package com.idianyou.media.spi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Builder
public class MasterTenantDTO implements Serializable {

    private String id;

    private String tenant;

    private String url;

    private String userName;

    private String password;

    private int version;
}
