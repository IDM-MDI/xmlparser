package edu.by.ishangulyev.xmlparser.builder;

import edu.by.ishangulyev.xmlparser.entity.Tariff;
import edu.by.ishangulyev.xmlparser.entity.enums.CallPrice;
import edu.by.ishangulyev.xmlparser.entity.enums.Parameter;

public interface FreeCallsBuilder extends TariffBuilder
{
    @Override
    FreeCallsBuilder setID(String id);

    @Override
    FreeCallsBuilder setName(String name);

    @Override
    FreeCallsBuilder setOperatorName(String operatorName);

    @Override
    FreeCallsBuilder setPayRoll(int payroll);

    @Override
    FreeCallsBuilder setCallPrice(CallPrice callPrice);

    @Override
    FreeCallsBuilder setParameter(Parameter parameter);

    FreeCallsBuilder setMinute(int minute);

    @Override
    Tariff build();
}
