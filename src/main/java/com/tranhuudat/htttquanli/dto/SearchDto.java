package com.tranhuudat.htttquanli.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SearchDto implements Serializable {

    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date startDate;
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date endDate;
    private String nameCode;
    private String phoneNumber;
}
