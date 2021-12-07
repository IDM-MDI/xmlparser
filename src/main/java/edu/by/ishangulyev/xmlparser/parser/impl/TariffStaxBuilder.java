package edu.by.ishangulyev.xmlparser.parser.impl;

import edu.by.ishangulyev.xmlparser.entity.Tariff;
import edu.by.ishangulyev.xmlparser.entity.enums.CallPrice;
import edu.by.ishangulyev.xmlparser.entity.enums.Parameter;
import edu.by.ishangulyev.xmlparser.entity.enums.TariffType;
import edu.by.ishangulyev.xmlparser.exception.TariffException;
import edu.by.ishangulyev.xmlparser.parser.TariffParserBuilder;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class TariffStaxBuilder implements TariffParserBuilder
{
    XMLStreamReader reader;
    List<Tariff> tariffs;
    String path;

    String id;
    String name,operatorName;
    Parameter parameter;
    CallPrice callPrice;
    LocalDateTime connectionTime;
    double speed,payForMB;
    int smsPrice,payRoll,minute;
    boolean isTariff;

    public TariffStaxBuilder()
    {
        tariffs = new ArrayList<>();
    }
    @Override
    public TariffParserBuilder setPath(String path)
    {
        this.path = path;
        return this;
    }

    @Override
    public TariffParserBuilder parse() throws TariffException
    {
        try
        {
            reader = XMLInputFactory.newInstance().createXMLStreamReader(path,new FileInputStream(path));
        } catch (XMLStreamException | FileNotFoundException e)
        {
            throw new TariffException("Error while parsing");
        }
        return this;
    }

    @Override
    public TariffParserBuilder collect() throws TariffException
    {
        collectInfo();
        return this;
    }

    @Override
    public List getResult()
    {
        return null;
    }
    private void collectInfo() throws TariffException
    {
        try
        {
        while (reader.hasNext())
        {
            int event = reader.next();
            if (event == XMLStreamConstants.START_ELEMENT)
            {
                String element = reader.getLocalName();

                if (element.equals(TariffType.FREECALLS.name().toLowerCase(Locale.ROOT)))
                {
                    name = reader.getElementText();
                    continue;
                }
                if (element.equals(TariffType.LIMITEDINTERNET.name().toLowerCase(Locale.ROOT)))
                {
                    name = reader.getElementText();
                    continue;
                }

                if (element.equals(TariffType.UNLIMITEDINTERNET.name().toLowerCase(Locale.ROOT)))
                {
                    name = reader.getText();
                    continue;
                }

                if (element.equals(TariffType.FREEMESSENGERS.name().toLowerCase(Locale.ROOT)))
                {
                    name = reader.getText();
                    continue;
                }
            }
        }
            System.out.println(name);
        }
        catch (Exception e)
        {
        //    log.error("Couldn't parse AddressResponse", e);
        }
    }
//  {
//        while(true)
//        {
//            try
//            {
//                if (!reader.hasNext()) break;
//            }
//            catch (XMLStreamException e)
//            {
//                throw new TariffException("Error while reading file");
//            }
//            if(reader.isStartElement()
//                    && (reader.getLocalName().equals(TariffType.FREECALLS.name().toLowerCase(Locale.ROOT))
//                    || reader.getLocalName().equals(TariffType.FREEMESSENGERS.name().toLowerCase(Locale.ROOT))
//                    || reader.getLocalName().equals(TariffType.UNLIMITEDINTERNET.name().toLowerCase(Locale.ROOT))
//                    || reader.getLocalName().equals(TariffType.LIMITEDINTERNET.name().toLowerCase(Locale.ROOT))))
//            {
//                isTariff = true;
//                id = reader.getAttributeValue(0);
//            }
//            if(reader.isEndElement()
//                    && (reader.getLocalName().equals(TariffType.FREECALLS.name().toLowerCase(Locale.ROOT))
//                    || reader.getLocalName().equals(TariffType.FREEMESSENGERS.name().toLowerCase(Locale.ROOT))
//                    || reader.getLocalName().equals(TariffType.UNLIMITEDINTERNET.name().toLowerCase(Locale.ROOT))
//                    || reader.getLocalName().equals(TariffType.LIMITEDINTERNET.name().toLowerCase(Locale.ROOT))))
//            {
//                isTariff = false;
//            }
//            try
//            {
//                if(reader.getElementText() != null)
//                {
//                    System.out.println(reader.getElementText());
//                    String temp = reader.getText();
//                    switch (temp)
//                    {
//                        case "tar:name" -> name = temp;
//                        case "tar:operatorName" -> operatorName = temp;
//                        case "tar:connectTime" -> connectionTime = LocalDateTime.parse(temp);
//                        case "tar:payroll" -> payRoll = Integer.parseInt(temp);
//                        case "tar:callPrice" -> callPrice = CallPrice.valueOf(temp.toUpperCase(Locale.ROOT));
//                        case "tar:parameters" -> parameter = Parameter.valueOf(temp.toUpperCase(Locale.ROOT));
//                        case "tar:smsPrice" -> smsPrice = Integer.parseInt(temp);
//                        case "tar:speed" -> speed = Double.parseDouble(temp);
//                        case "tar:payForMB" -> payForMB = Double.parseDouble(temp);
//                        case "tar:minute" -> minute = Integer.parseInt(temp);
//                    }
//
//                }
//            } catch (XMLStreamException e)
//            {
//                throw new TariffException();
//            }
//            try
//            {
//                reader.next();
//            }
//            catch (XMLStreamException e)
//            {
//                throw new TariffException("Error while changing position");
//            }
//        }
//    }
}
