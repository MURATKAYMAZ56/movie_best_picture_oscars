package com.intake.service.csv;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(of = {"year", "category", "nominee"})
public class CsvModelId {

    private String year; // 2002 (82st)
    private String category;
    private String nominee;
}
