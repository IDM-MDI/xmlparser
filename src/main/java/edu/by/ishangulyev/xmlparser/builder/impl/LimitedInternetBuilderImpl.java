package edu.by.ishangulyev.xmlparser.builder.impl;

import edu.by.ishangulyev.xmlparser.builder.LimitedInternetBuilder;
import edu.by.ishangulyev.xmlparser.entity.LimitedInternet;
import edu.by.ishangulyev.xmlparser.entity.Tariff;
import edu.by.ishangulyev.xmlparser.entity.enums.CallPrice;
import edu.by.ishangulyev.xmlparser.entity.enums.Parameter;

public class LimitedInternetBuilderImpl implements LimitedInternetBuilder
{
    private String id;
    private String name;
    private String operatorName;
    private int payroll;
    private Parameter parameter;
    private CallPrice callPrice;
    private double speed;
    private double payForMB;
    @Override
    public LimitedInternetBuilder setID(String id)
    {
        this.id = id;
        return this;
    }

    @Override
    public LimitedInternetBuilder setName(String name)
    {
        this.name = name;
        return this;
    }

    @Override
    public LimitedInternetBuilder setOperatorName(String operatorName)
    {
        this.operatorName = operatorName;
        return this;
    }

    @Override
    public LimitedInternetBuilder setPayRoll(int payroll)
    {
        this.payroll = payroll;
        return this;
    }

    @Override
    public LimitedInternetBuilder setCallPrice(CallPrice callPrice)
    {
        this.callPrice = callPrice;
        return this;
    }

    @Override
    public LimitedInternetBuilder setParameter(Parameter parameter)
    {
        this.parameter = parameter;
        return this;
    }

    @Override
    public LimitedInternetBuilder setPayForMb(double payForMb)
    {
        this.payForMB = payForMb;
        return this;
    }

    @Override
    public LimitedInternetBuilder setSpeed(double speed)
    {
        this.speed = speed;
        return this;
    }

    @Override
    public Tariff build()
    {
        return new LimitedInternet(id,name,operatorName,payroll,callPrice,parameter,speed,payForMB);
    }
}
