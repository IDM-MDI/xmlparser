package edu.by.ishangulyev.xmlparser.main;

import edu.by.ishangulyev.xmlparser.entity.Tariff;
import edu.by.ishangulyev.xmlparser.entity.enums.TariffTag;
import edu.by.ishangulyev.xmlparser.exception.TariffException;
import edu.by.ishangulyev.xmlparser.parser.TariffParserBuilder;
import edu.by.ishangulyev.xmlparser.parser.impl.TariffDomBuilder;
import edu.by.ishangulyev.xmlparser.parser.impl.TariffSaxBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    private static final String path = "src/main/resources/files/tariffs.xml";
    public static void main(String[] args) throws TariffException
    {
//        UnlimitedInternetBuilder builder = new UnlimitedInternetBuilderImpl();
//        Tariff tariff = builder.setID("1")
//                .setName("name")
//                .setOperatorName("operatorName")
//                .setPayRoll(30)
//                .setCallPrice(CallPrice.HOMENETWORK)
//                .setParameter(Parameter.TARIFFICATION)
//                .setSpeed(132)
//                .build();
//        System.out.println(tariff);
//        LimitedInternetBuilder builder1 = new LimitedInternetBuilderImpl();
//        Tariff tariff1 = builder1.setID("1")
//                .setName("name")
//                .setOperatorName("operatorName")
//                .setPayRoll(30)
//                .setCallPrice(CallPrice.HOMENETWORK)
//                .setParameter(Parameter.TARIFFICATION)
//                .setPayForMb(21)
//                .setSpeed(132)
//                .build();
//        System.out.println(tariff1);
//        FreeCallsBuilder builder2 = new FreeCallsBuilderImpl();
//        Tariff tariff2 = builder2.setID("1")
//                .setName("name")
//                .setOperatorName("operatorName")
//                .setPayRoll(30)
//                .setCallPrice(CallPrice.HOMENETWORK)
//                .setParameter(Parameter.TARIFFICATION)
//                .setMinute(21)
//                .build();
//        System.out.println(tariff2);
//        FreeMessengersBuilder builder3 = new FreeMessengersBuilderImpl();
//        Tariff tariff3 = builder3.setID("1")
//                .setName("name")
//                .setOperatorName("operatorName")
//                .setPayRoll(30)
//                .setCallPrice(CallPrice.HOMENETWORK)
//                .setParameter(Parameter.TARIFFICATION)
//                .setSpeed(132)
//                .build();
//        System.out.println(tariff3);
//        List tariffList;
//        TariffParserBuilder builder4 = new TariffDomBuilder();
//        tariffList = builder4.setPath(path).parse().collect().getResult();
//        System.out.println(tariffList);
        List tariffs;
        TariffParserBuilder builder = new TariffSaxBuilder();
        tariffs = builder.setPath(path).parse().getResult();
        System.out.println(tariffs);
    }
}
