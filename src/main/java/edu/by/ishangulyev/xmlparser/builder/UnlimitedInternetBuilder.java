package edu.by.ishangulyev.xmlparser.builder;

import edu.by.ishangulyev.xmlparser.entity.Tariff;
import edu.by.ishangulyev.xmlparser.entity.enums.CallPrice;
import edu.by.ishangulyev.xmlparser.entity.enums.Parameter;

import java.time.LocalDateTime;

public interface UnlimitedInternetBuilder extends TariffBuilder
{
    @Override
    UnlimitedInternetBuilder setID(String id);

    @Override
    UnlimitedInternetBuilder setName(String name);

    @Override
    UnlimitedInternetBuilder setOperatorName(String operatorName);

    @Override
    UnlimitedInternetBuilder setPayRoll(int payroll);

    @Override
    UnlimitedInternetBuilder setCallPrice(CallPrice callPrice);

    @Override
    UnlimitedInternetBuilder setParameter(Parameter parameter);

    UnlimitedInternetBuilder setSpeed(double speed);

    @Override
    UnlimitedInternetBuilder setLocalDate(LocalDateTime connectTime);

    @Override
    Tariff build();
}
