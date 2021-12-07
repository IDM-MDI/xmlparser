package edu.by.ishangulyev.xmlparser.entity;

import edu.by.ishangulyev.xmlparser.entity.enums.CallPrice;
import edu.by.ishangulyev.xmlparser.entity.enums.Parameter;

import java.time.LocalDateTime;

public class FreeCalls extends Tariff
{
    private int minute;

    public FreeCalls(String id, String name, String operatorName,
                           LocalDateTime connectTime, int payroll,
                           CallPrice callPrice, Parameter parameter,
                           int minute)
    {
        super(id, name, operatorName,connectTime,payroll, callPrice, parameter);
        this.minute = minute;
    }
}
