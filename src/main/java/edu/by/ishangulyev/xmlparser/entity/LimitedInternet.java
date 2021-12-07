package edu.by.ishangulyev.xmlparser.entity;

import edu.by.ishangulyev.xmlparser.entity.enums.CallPrice;
import edu.by.ishangulyev.xmlparser.entity.enums.Parameter;

import java.time.LocalDateTime;

public class LimitedInternet extends Tariff
{
    private double speed;
    private double payForMb;
    public LimitedInternet(String id, String name, String operatorName,
                           LocalDateTime connectTime, int payroll,
                           CallPrice callPrice, Parameter parameter,
                           double speed, double payForMb)
    {
        super(id, name, operatorName,connectTime,payroll, callPrice, parameter);
        this.payForMb = payForMb;
        this.speed = speed;
    }
}
