package edu.by.ishangulyev.xmlparser.parser.impl;

import edu.by.ishangulyev.xmlparser.entity.Tariff;
import edu.by.ishangulyev.xmlparser.entity.enums.TariffType;
import edu.by.ishangulyev.xmlparser.exception.TariffException;
import edu.by.ishangulyev.xmlparser.parser.TariffParserBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class TariffDomBuilder implements TariffParserBuilder
{
    private DocumentBuilderFactory factory;
    private Document document;
    private String path;
    private List<Tariff> tariffs;

    public TariffDomBuilder()
    {
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
        String tag = "TAR:";
        String[] compare;
        String compare2;
        for (int i = 0; i < nodes.getLength(); i++)
        {
            if(nodes.item(i) instanceof Element)
            {
                System.out.println(nodes.item(i).getNodeName().toUpperCase(Locale.ROOT));
                compare = nodes.item(i).getNodeName().toUpperCase(Locale.ROOT).split("TAR:");
                System.out.println(compare[1].equals(tariffType.name()));
            }
        }
    }

}
