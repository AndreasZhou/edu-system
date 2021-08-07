package com.andreas.bo;

import com.andreas.domain.Resource;
import lombok.Data;

/**
 * 描述：ResourceBO
 */
@Data
public class ResourceBO extends Resource {
    private Integer pageNum;
    private Integer pageSize;
}
