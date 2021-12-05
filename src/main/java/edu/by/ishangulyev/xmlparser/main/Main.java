package edu.by.ishangulyev.xmlparser.main;

import edu.by.ishangulyev.xmlparser.builder.FreeCallsBuilder;
import edu.by.ishangulyev.xmlparser.builder.FreeMessengersBuilder;
import edu.by.ishangulyev.xmlparser.builder.LimitedInternetBuilder;
import edu.by.ishangulyev.xmlparser.builder.UnlimitedInternetBuilder;
import edu.by.ishangulyev.xmlparser.builder.impl.FreeCallsBuilderImpl;
import edu.by.ishangulyev.xmlparser.builder.impl.FreeMessengersBuilderImpl;
import edu.by.ishangulyev.xmlparser.builder.impl.LimitedInternetBuilderImpl;
import edu.by.ishangulyev.xmlparser.builder.impl.UnlimitedInternetBuilderImpl;
import edu.by.ishangulyev.xmlparser.entity.Tariff;
import edu.by.ishangulyev.xmlparser.entity.enums.CallPrice;
import edu.by.ishangulyev.xmlparser.entity.enums.Parameter;

public class Main
{
    public static void main(String[] args)
    {
        UnlimitedInternetBuilder builder = new UnlimitedInternetBuilderImpl();
        Tariff tariff = builder.setID("1")
                .setName("name")
                .setOperatorName("operatorName")
                .setPayRoll(30)
                .setCallPrice(CallPrice.HOMENETWORK)
                .setParameter(Parameter.TARIFFICATION)
                .setSpeed(132)
                .build();
        System.out.println(tariff);
        LimitedInternetBuilder builder1 = new LimitedInternetBuilderImpl();
        Tariff tariff1 = builder1.setID("1")
                .setName("name")
                .setOperatorName("operatorName")
                .setPayRoll(30)
                .setCallPrice(CallPrice.HOMENETWORK)
                .setParameter(Parameter.TARIFFICATION)
                .setPayForMb(21)
                .setSpeed(132)
                .build();
        System.out.println(tariff1);
        FreeCallsBuilder builder2 = new FreeCallsBuilderImpl();
        Tariff tariff2 = builder2.setID("1")
                .setName("name")
                .setOperatorName("operatorName")
                .setPayRoll(30)
                .setCallPrice(CallPrice.HOMENETWORK)
                .setParameter(Parameter.TARIFFICATION)
                .setMinute(21)
                .build();
        System.out.println(tariff2);
        FreeMessengersBuilder builder3 = new FreeMessengersBuilderImpl();
        Tariff tariff3 = builder3.setID("1")
                .setName("name")
                .setOperatorName("operatorName")
                .setPayRoll(30)
                .setCallPrice(CallPrice.HOMENETWORK)
                .setParameter(Parameter.TARIFFICATION)
                .setSpeed(132)
                .build();
        System.out.println(tariff3);
    }
}
