package edu.by.ishangulyev.xmlparser.parser;

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
import edu.by.ishangulyev.xmlparser.entity.enums.TariffTag;
import edu.by.ishangulyev.xmlparser.entity.enums.TariffType;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TariffHandler extends DefaultHandler
{
    List<Tariff> tariffList;
    String currentTagName;
    String plusTag = "tar:";
    String id;
    String name,operatorName;
    Parameter parameter;
    CallPrice callPrice;
    LocalDateTime connectionTime;
    double speed,payForMB;
    int smsPrice,payRoll,minute;
    boolean isTariff;

    public TariffHandler()
    {
        tariffList = new ArrayList<>();
    }

    @Override
    public void startDocument() throws SAXException
    {
        System.out.println("start document");
    }

    @Override
    public void endDocument() throws SAXException
    {
        System.out.println("end document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        currentTagName = qName;
        if(qName.equals(plusTag+(TariffType.UNLIMITEDINTERNET.toString().toLowerCase(Locale.ROOT)))
                || qName.equals(plusTag+(TariffType.LIMITEDINTERNET.toString().toLowerCase(Locale.ROOT)))
                ||qName.equals(plusTag+(TariffType.FREECALLS.toString().toLowerCase(Locale.ROOT)))
                ||qName.equals(plusTag+(TariffType.FREEMESSENGERS.toString().toLowerCase(Locale.ROOT))))
        {
            isTariff = true;
            id = attributes.getValue(0);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        currentTagName = null;
        if(qName.equals(plusTag+(TariffType.UNLIMITEDINTERNET.toString().toLowerCase(Locale.ROOT))))
        {
            UnlimitedInternetBuilder builder = new UnlimitedInternetBuilderImpl();
            tariffList.add(builder.setName(name).setOperatorName(operatorName).setID(id)
                    .setLocalDate(connectionTime).setPayRoll(payRoll).setCallPrice(callPrice)
                    .setParameter(parameter).setSpeed(speed).build());
            isTariff = false;
        }
        else if(qName.equals(plusTag+(TariffType.LIMITEDINTERNET.toString().toLowerCase(Locale.ROOT))))
        {
            LimitedInternetBuilder builder = new LimitedInternetBuilderImpl();
            tariffList.add(builder.setName(name).setOperatorName(operatorName).setID(id)
                    .setLocalDate(connectionTime).setPayRoll(payRoll).setCallPrice(callPrice)
                    .setParameter(parameter).setSpeed(speed).setPayForMb(payForMB).build());
            isTariff = false;
        }
        else if(qName.equals(plusTag+(TariffType.FREECALLS.toString().toLowerCase(Locale.ROOT))))
        {
            FreeCallsBuilder builder = new FreeCallsBuilderImpl();
            tariffList.add(builder.setName(name).setOperatorName(operatorName).setID(id)
                    .setLocalDate(connectionTime).setPayRoll(payRoll).setCallPrice(callPrice)
                    .setParameter(parameter).setMinute(minute).build());
            isTariff = false;
        }
        else if(qName.equals(plusTag+(TariffType.FREEMESSENGERS.toString().toLowerCase(Locale.ROOT))))
        {
            FreeMessengersBuilder builder = new FreeMessengersBuilderImpl();
            tariffList.add(builder.setName(name).setOperatorName(operatorName).setID(id)
                    .setLocalDate(connectionTime).setPayRoll(payRoll).setCallPrice(callPrice)
                    .setParameter(parameter).setSpeed(speed).build());
            isTariff = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {
        if(currentTagName == null)
        {
            return;
        }
        if(isTariff)
        {
            String temp = new String(ch,start,length);
            switch (currentTagName)
            {
                case "tar:name" -> name = temp;
                case "tar:operatorName" -> operatorName = temp;
                case "tar:connectTime" -> connectionTime = LocalDateTime.parse(temp);
                case "tar:payroll" -> payRoll = Integer.parseInt(temp);
                case "tar:callPrice" -> callPrice = CallPrice.valueOf(temp.toUpperCase(Locale.ROOT));
                case "tar:parameters" -> parameter = Parameter.valueOf(temp.toUpperCase(Locale.ROOT));
                case "tar:smsPrice" -> smsPrice = Integer.parseInt(temp);
                case "tar:speed" -> speed = Double.parseDouble(temp);
                case "tar:payForMB" -> payForMB = Double.parseDouble(temp);
                case "tar:minute" -> minute = Integer.parseInt(temp);
            }
        }

    }

    public List<Tariff> getTariffList()
    {
        return List.copyOf(tariffList);
    }
}