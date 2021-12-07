package edu.by.ishangulyev.xmlparser.parser.impl;

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
import edu.by.ishangulyev.xmlparser.entity.enums.TariffType;
import edu.by.ishangulyev.xmlparser.exception.TariffException;
import edu.by.ishangulyev.xmlparser.parser.TariffParserBuilder;
import edu.by.ishangulyev.xmlparser.validator.TariffDomValidator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TariffDomBuilder implements TariffParserBuilder
{
    private DocumentBuilderFactory factory;
    private Document document;
    private String path;
    private String tagRemover = "TAR:";
    private List<Tariff> tariffs;
    private TariffDomValidator validator;
    public TariffDomBuilder()
    {
        validator = new TariffDomValidator();
        tariffs = new ArrayList<>();
        factory = DocumentBuilderFactory.newInstance();
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
            DocumentBuilder builder = factory.newDocumentBuilder();
            this.document = builder.parse(new File(path));
        } catch (ParserConfigurationException | IOException | SAXException e)
        {
            throw new TariffException();
        }
        return this;
    }
    @Override
    public TariffParserBuilder collect()
    {
        collectAllInfo();
        return this;
    }

    @Override
    public List getResult()
    {
        return List.of(tariffs);
    }

    private void collectAllInfo()
    {
        collectInfo(TariffType.UNLIMITEDINTERNET);
        collectInfo(TariffType.LIMITEDINTERNET);
        collectInfo(TariffType.FREECALLS);
        collectInfo(TariffType.FREEMESSENGERS);
    }

    private void collectInfo(TariffType tariffType)
    {
        Element element = document.getDocumentElement();
        NodeList nodes = element.getChildNodes();
        String[] compare;
        for (int i = 0; i < nodes.getLength(); i++)
        {
            if(nodes.item(i) instanceof Element)
            {
                compare = nodes.item(i).getNodeName().toUpperCase(Locale.ROOT).split(tagRemover);
                if(compare[1].equals(tariffType.name()))
                {
                    addInfo(((Element) nodes.item(i)).getAttribute("id"),
                            tariffType,nodes.item(i).getChildNodes());
                }
            }
        }
    }
    private void addInfo(String id, TariffType tariffType, NodeList childNodes)
    {
        List<String> allinfo = new ArrayList<>();
        int j = 1;
        Text text;
        for (int i = 0; i < childNodes.getLength(); i++)
        {
            if(validator.isNodeValid(i,childNodes))
            {
                text = (Text)childNodes.item(i).getFirstChild();
                allinfo.add(text.getData());
            }
        }
      tariffs.add(createInfoHelper(allinfo,tariffType,id));
    }

    private Tariff createInfoHelper(List<String> list, TariffType tariffType, String id)
    {
        String name = "",operatorName = "";
        int payroll = 0,smsPrice;
        Parameter parameter = null;
        CallPrice callPrice = null;
        double speed = 0;
        double payForMb = 0;
        LocalDateTime connectTime = null;
        for (int i = 0; i < list.size(); i++)
        {
            switch (i)
            {
                case 0: name = list.get(i); break;
                case 1: operatorName = list.get(i); break;
                case 2: connectTime = LocalDateTime.parse(list.get(i)); break;
                case 3: payroll = Integer.parseInt(list.get(i)); break;
                case 4:
                    switch (list.get(i))
                    {
                        case "homeNetwork" -> callPrice = CallPrice.HOMENETWORK;
                        case "fixedNetwork" -> callPrice = CallPrice.FIXEDNETWORK;
                        case "otherNetwork" -> callPrice = CallPrice.OTHERNETWORK;
                    }
                    break;
                case 5: smsPrice = Integer.parseInt(list.get(i)); break;
                case 6:
                    switch (list.get(i))
                    {
                        case "tariffication" -> parameter = Parameter.TARIFFICATION;
                        case "favoriteNumber" -> parameter = Parameter.FAVORITENUMBER;
                        case "connectionPay" -> parameter = Parameter.CONNECTIONPAY;
                    }
                    break;
                case 7: speed = Double.parseDouble(list.get(i)); break;
                case 8: payForMb = Double.parseDouble(list.get(i)); break;
            }
        }

        switch(tariffType)
        {
            case FREECALLS -> {
                FreeCallsBuilder builder = new FreeCallsBuilderImpl();
                return builder.setID(id).setName(name).setOperatorName(operatorName)
                        .setPayRoll(payroll).setCallPrice(callPrice).setParameter(parameter)
                        .setMinute((int)speed).setLocalDate(connectTime).build();
            }
            case FREEMESSENGERS -> {
                FreeMessengersBuilder builder = new FreeMessengersBuilderImpl();
                return builder.setID(id).setName(name).setOperatorName(operatorName)
                        .setPayRoll(payroll).setCallPrice(callPrice).setParameter(parameter)
                        .setSpeed(speed).setLocalDate(connectTime).build();
            }
            case UNLIMITEDINTERNET -> {
                UnlimitedInternetBuilder builder = new UnlimitedInternetBuilderImpl();
                return builder.setID(id).setName(name).setOperatorName(operatorName)
                        .setPayRoll(payroll).setCallPrice(callPrice).setParameter(parameter)
                        .setSpeed(speed).setLocalDate(connectTime).build();
            }
            case LIMITEDINTERNET -> {
                LimitedInternetBuilder builder = new LimitedInternetBuilderImpl();
                return builder.setID(id).setName(name).setOperatorName(operatorName)
                        .setPayRoll(payroll).setCallPrice(callPrice).setParameter(parameter)
                        .setSpeed(speed).setPayForMb(payForMb).setLocalDate(connectTime).build();
            }
            default -> {
                return null;
            }
        }
    }
}
