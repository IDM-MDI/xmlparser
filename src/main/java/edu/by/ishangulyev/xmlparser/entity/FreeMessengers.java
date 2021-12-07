package edu.by.ishangulyev.xmlparser.entity;

import edu.by.ishangulyev.xmlparser.entity.enums.CallPrice;
import edu.by.ishangulyev.xmlparser.entity.enums.Parameter;

import java.time.LocalDateTime;

public class FreeMessengers extends Tariff
{
    private double speed;
    public FreeMessengers(String id, String name, String operatorName,
                           LocalDateTime connectTime, int payroll,
                           CallPrice callPrice, Parameter parameter,
                           double speed)
    {
        super(id, name, operatorName,connectTime,payroll, callPrice, parameter);
        this.speed = speed;
    }
}
