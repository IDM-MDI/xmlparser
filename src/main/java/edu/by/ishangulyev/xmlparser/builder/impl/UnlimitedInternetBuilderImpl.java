package edu.by.ishangulyev.xmlparser.builder.impl;

import edu.by.ishangulyev.xmlparser.builder.UnlimitedInternetBuilder;
import edu.by.ishangulyev.xmlparser.entity.Tariff;
import edu.by.ishangulyev.xmlparser.entity.UnlimitedInternet;
import edu.by.ishangulyev.xmlparser.entity.enums.CallPrice;
import edu.by.ishangulyev.xmlparser.entity.enums.Parameter;

public class UnlimitedInternetBuilderImpl implements UnlimitedInternetBuilder
{
    private String id;
    private String name;
    private String operatorName;
    private int payroll;
    private Parameter parameter;
    private CallPrice callPrice;
    private double speed;

    @Override
    public UnlimitedInternetBuilder setID(String id)
    {
        this.id = id;
        return this;
    }

    @Override
    public UnlimitedInternetBuilder setName(String name)
    {
        this.name = name;
        return this;
    }

    @Override
    public UnlimitedInternetBuilder setOperatorName(String operatorName)
    {
        this.operatorName = operatorName;
        return this;
    }

    @Override
    public UnlimitedInternetBuilder setPayRoll(int payroll)
    {
        this.payroll = payroll;
        return this;
    }

    @Override
    public UnlimitedInternetBuilder setCallPrice(CallPrice callPrice)
    {
        this.callPrice = callPrice;
        return this;
    }

    @Override
    public UnlimitedInternetBuilder setParameter(Parameter parameter)
    {
        this.parameter = parameter;
        return this;
    }

    @Override
    public UnlimitedInternetBuilder setSpeed(double speed)
    {
        this.speed = speed;
        return this;
    }

    @Override
    public Tariff build()
    {
        return new UnlimitedInternet(id,name,operatorName,payroll,callPrice,parameter,speed);
    }
}
