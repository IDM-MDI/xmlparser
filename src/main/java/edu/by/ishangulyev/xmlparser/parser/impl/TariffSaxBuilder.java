package edu.by.ishangulyev.xmlparser.parser.impl;

import edu.by.ishangulyev.xmlparser.entity.Tariff;
import edu.by.ishangulyev.xmlparser.exception.TariffException;
import edu.by.ishangulyev.xmlparser.parser.TariffHandler;
import edu.by.ishangulyev.xmlparser.parser.TariffParserBuilder;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TariffSaxBuilder implements TariffParserBuilder
{
    SAXParserFactory factory;
    SAXParser parser;
    TariffHandler handler;
    String path;
    List<Tariff> result;

    public TariffSaxBuilder()
    {
        handler = new TariffHandler();
        factory = SAXParserFactory.newInstance();
        result = new ArrayList<>();
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
            parser = factory.newSAXParser();
            parser.parse(new File(path),handler);
        } catch (ParserConfigurationException | SAXException | IOException e)
        {
            throw new TariffException("Error while parsing");
        }
        return this;
    }

    @Override
    public TariffParserBuilder collect()
    {
        return this;
    }

    @Override
    public List getResult()
    {
        return handler.getTariffList();
    }
}
