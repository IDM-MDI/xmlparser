package edu.by.ishangulyev.xmlparser.entity;

import edu.by.ishangulyev.xmlparser.entity.enums.CallPrice;
import edu.by.ishangulyev.xmlparser.entity.enums.Parameter;

public abstract class Tariff
{
    private String id;
    private String name;
    private String operatorName;
    private int payroll;
    private CallPrice callPrice;
    private Parameter parameter;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getOperatorName()
    {
        return operatorName;
    }

    public void setOperatorName(String operatorName)
    {
        this.operatorName = operatorName;
    }

    public int getPayroll()
    {
        return payroll;
    }

    public void setPayroll(int payroll)
    {
        this.payroll = payroll;
    }

    public CallPrice getCallPrice()
    {
        return callPrice;
    }

    public void setCallPrice(CallPrice callPrice)
    {
        this.callPrice = callPrice;
    }

    public Parameter getParameter()
    {
        return parameter;
    }

    public void setParameter(Parameter parameter)
    {
        this.parameter = parameter;
    }
}
