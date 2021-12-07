package edu.by.ishangulyev.xmlparser.builder;

import edu.by.ishangulyev.xmlparser.entity.Tariff;
import edu.by.ishangulyev.xmlparser.entity.enums.CallPrice;
import edu.by.ishangulyev.xmlparser.entity.enums.Parameter;

import java.time.LocalDateTime;

public interface FreeMessengersBuilder extends TariffBuilder
{
    @Override
    FreeMessengersBuilder setID(String id);

    @Override
    FreeMessengersBuilder setName(String name);

    @Override
    FreeMessengersBuilder setOperatorName(String operatorName);

    @Override
    FreeMessengersBuilder setPayRoll(int payroll);

    @Override
    FreeMessengersBuilder setCallPrice(CallPrice callPrice);

    @Override
    FreeMessengersBuilder setParameter(Parameter parameter);

    FreeMessengersBuilder setSpeed(double speed);

    @Override
    FreeMessengersBuilder setLocalDate(LocalDateTime connectTime);

    @Override
    Tariff build();
}
