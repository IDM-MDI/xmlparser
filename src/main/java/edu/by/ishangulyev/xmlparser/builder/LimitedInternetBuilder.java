package edu.by.ishangulyev.xmlparser.builder;

import edu.by.ishangulyev.xmlparser.entity.Tariff;
import edu.by.ishangulyev.xmlparser.entity.enums.CallPrice;
import edu.by.ishangulyev.xmlparser.entity.enums.Parameter;

public interface LimitedInternetBuilder extends TariffBuilder
{
    @Override
    LimitedInternetBuilder setID(String id);

    @Override
    LimitedInternetBuilder setName(String name);

    @Override
    LimitedInternetBuilder setOperatorName(String operatorName);

    @Override
    LimitedInternetBuilder setPayRoll(int payroll);

    @Override
    LimitedInternetBuilder setCallPrice(CallPrice callPrice);

    @Override
    LimitedInternetBuilder setParameter(Parameter parameter);

    LimitedInternetBuilder setPayForMb(double payForMb);
    LimitedInternetBuilder setSpeed(double speed);
    @Override
    Tariff build();
}
