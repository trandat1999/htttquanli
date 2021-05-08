package com.tranhuudat.htttquanli.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SearchDto implements Serializable {
    private Date startDate;
    private Date endDate;
    private String nameCode;
}
