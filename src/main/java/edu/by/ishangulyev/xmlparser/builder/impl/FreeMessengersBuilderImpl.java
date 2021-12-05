package edu.by.ishangulyev.xmlparser.builder.impl;

import edu.by.ishangulyev.xmlparser.builder.FreeMessengersBuilder;
import edu.by.ishangulyev.xmlparser.entity.FreeMessengers;
import edu.by.ishangulyev.xmlparser.entity.Tariff;
import edu.by.ishangulyev.xmlparser.entity.enums.CallPrice;
import edu.by.ishangulyev.xmlparser.entity.enums.Parameter;

public class FreeMessengersBuilderImpl implements FreeMessengersBuilder
{
    private String id;
    private String name;
    private String operatorName;
    private int payroll;
    private Parameter parameter;
    private CallPrice callPrice;
    private double speed;

    @Override
    public FreeMessengersBuilder setID(String id)
    {
        this.id = id;
        return this;
    }

    @Override
    public FreeMessengersBuilder setName(String name)
    {
        this.name = name;
        return this;
    }

    @Override
    public FreeMessengersBuilder setOperatorName(String operatorName)
    {
        this.operatorName = operatorName;
        return this;
    }

    @Override
    public FreeMessengersBuilder setPayRoll(int payroll)
    {
        this.payroll = payroll;
        return this;
    }

    @Override
    public FreeMessengersBuilder setCallPrice(CallPrice callPrice)
    {
        this.callPrice = callPrice;
        return this;
    }

    @Override
    public FreeMessengersBuilder setParameter(Parameter parameter)
    {
        this.parameter = parameter;
        return this;
    }

    @Override
    public FreeMessengersBuilder setSpeed(double speed)
    {
        this.speed = speed;
        return this;
    }

    @Override
    public Tariff build()
    {
        return new FreeMessengers(id,name,operatorName,payroll,callPrice,parameter,speed);
    }
}
