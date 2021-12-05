package edu.by.ishangulyev.xmlparser.entity;

import edu.by.ishangulyev.xmlparser.entity.enums.CallPrice;
import edu.by.ishangulyev.xmlparser.entity.enums.Parameter;

public class UnlimitedInternet extends Tariff
{
    private double speed;
    public UnlimitedInternet(String id, String name, String operatorName,
                             int payroll, CallPrice callPrice, Parameter parameter,double speed)
    {
        super(id, name, operatorName, payroll, callPrice, parameter);
        this.speed = speed;
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(super.toString())
                .append(" ,speed = ").append(speed)
                .append("}").toString();
    }
}
