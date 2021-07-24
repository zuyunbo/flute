package com.cloud.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author 2u c1111
 * @since 1.0 2021-07-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class HotData {
    private static final long serialVersionUID = 1L;

    private Long id;


    /**
     *
     */
    @ApiModelProperty("")
    private String title;


    /**
     *
     */
    @ApiModelProperty("")
    private String url;


    /**
     *
     */
    @ApiModelProperty("")
    private String content;


    /**
     *
     */
    @ApiModelProperty("")
    private Long cnt;


    /**
     *
     */
    @ApiModelProperty("")
    private String siteName;


    /**
     *
     */
    @ApiModelProperty("")
    private String hotTag;
}
