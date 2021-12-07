package edu.by.ishangulyev.xmlparser.builder;

import edu.by.ishangulyev.xmlparser.entity.Tariff;
import edu.by.ishangulyev.xmlparser.entity.enums.CallPrice;
import edu.by.ishangulyev.xmlparser.entity.enums.Parameter;

import java.time.LocalDateTime;

public interface TariffBuilder
{
    TariffBuilder setID(String id);
    TariffBuilder setName(String name);
    TariffBuilder setOperatorName(String operatorName);
    TariffBuilder setLocalDate(LocalDateTime connectTime);
    TariffBuilder setPayRoll(int payroll);
    TariffBuilder setCallPrice(CallPrice callPrice);
    TariffBuilder setParameter(Parameter parameter);
    Tariff build();
}
