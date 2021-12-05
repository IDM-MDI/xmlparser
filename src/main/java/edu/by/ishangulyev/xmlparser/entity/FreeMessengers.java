package edu.by.ishangulyev.xmlparser.entity;

import edu.by.ishangulyev.xmlparser.entity.enums.CallPrice;
import edu.by.ishangulyev.xmlparser.entity.enums.Parameter;

public class FreeMessengers extends Tariff
{
    private double speed;
    public FreeMessengers(String id, String name, String operatorName,
                          int payroll, CallPrice callPrice, Parameter parameter,
                          double speed)
    {
        super(id, name, operatorName, payroll, callPrice, parameter);
        this.speed = speed;
    }
}
