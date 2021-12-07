package edu.by.ishangulyev.xmlparser.builder.impl;

import edu.by.ishangulyev.xmlparser.builder.FreeCallsBuilder;
import edu.by.ishangulyev.xmlparser.entity.FreeCalls;
import edu.by.ishangulyev.xmlparser.entity.Tariff;
import edu.by.ishangulyev.xmlparser.entity.enums.CallPrice;
import edu.by.ishangulyev.xmlparser.entity.enums.Parameter;

import java.time.LocalDateTime;

public class FreeCallsBuilderImpl implements FreeCallsBuilder
{
    private String id;
    private String name;
    private String operatorName;
    private LocalDateTime connectTime;
    private int payroll;
    private Parameter parameter;
    private CallPrice callPrice;
    private int minute;

    @Override
    public FreeCallsBuilder setLocalDate(LocalDateTime connectTime)
    {
        this.connectTime = connectTime;
        return this;
    }

    @Override
    public FreeCallsBuilder setID(String id)
    {
        this.id = id;
        return this;
    }

    @Override
    public FreeCallsBuilder setName(String name)
    {
        this.name = name;
        return this;
    }

    @Override
    public FreeCallsBuilder setOperatorName(String operatorName)
    {
        this.operatorName = operatorName;
        return this;
    }

    @Override
    public FreeCallsBuilder setPayRoll(int payroll)
    {
        this.payroll = payroll;
        return this;
    }

    @Override
    public FreeCallsBuilder setCallPrice(CallPrice callPrice)
    {
        this.callPrice = callPrice;
        return this;
    }

    @Override
    public FreeCallsBuilder setParameter(Parameter parameter)
    {
        this.parameter = parameter;
        return this;
    }

    @Override
    public FreeCallsBuilder setMinute(int minute)
    {
        this.minute = minute;
        return this;
    }

    @Override
    public Tariff build()
    {
        return new FreeCalls(id,name,operatorName,connectTime,payroll,callPrice,parameter,minute);
    }
}
