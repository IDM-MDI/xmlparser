package edu.by.ishangulyev.xmlparser.builder;

import edu.by.ishangulyev.xmlparser.entity.Tariff;
import edu.by.ishangulyev.xmlparser.entity.enums.CallPrice;
import edu.by.ishangulyev.xmlparser.entity.enums.Parameter;

public interface TariffBuilder
{
    TariffBuilder setID(String id);
    TariffBuilder setName(String name);
    TariffBuilder setOperatorName(String operatorName);
    TariffBuilder setPayRoll(int payroll);
    TariffBuilder setCallPrice(CallPrice callPrice);
    TariffBuilder setParameter(Parameter parameter);
    Tariff build();
}
