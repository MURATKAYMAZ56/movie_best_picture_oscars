package com.intake.service.csv;

import lombok.Data;

@Data
public class CsvModel extends CsvModelId {
    private String info;
    private String won; // YES, NO
}
