package edu.by.ishangulyev.xmlparser.entity;

import edu.by.ishangulyev.xmlparser.entity.enums.CallPrice;
import edu.by.ishangulyev.xmlparser.entity.enums.Parameter;

import java.util.Objects;

public abstract class Tariff
{
    private String id;
    private String name;
    private String operatorName;
    private int payroll;
    private CallPrice callPrice;
    private Parameter parameter;

    public Tariff(String id, String name, String operatorName, int payroll, CallPrice callPrice, Parameter parameter)
    {
        this.id = id;
        this.name = name;
        this.operatorName = operatorName;
        this.payroll = payroll;
        this.callPrice = callPrice;
        this.parameter = parameter;
    }

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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tariff tariff = (Tariff) o;
        return payroll == tariff.payroll
                && name.equals(tariff.name)
                && operatorName.equals(tariff.operatorName)
                && callPrice == tariff.callPrice
                && parameter == tariff.parameter;
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Tariff{")
                .append("id = ").append(id)
                .append(", name = ").append(name)
                .append(", operatorName = ").append(operatorName)
                .append(", payroll = ").append(payroll)
                .append(", callPrice = ").append(callPrice)
                .append(", parameter = ").append(parameter)
                .toString();
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, operatorName, payroll, callPrice, parameter);
    }

}
