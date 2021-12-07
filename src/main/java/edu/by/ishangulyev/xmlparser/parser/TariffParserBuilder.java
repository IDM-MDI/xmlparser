package edu.by.ishangulyev.xmlparser.parser;

import edu.by.ishangulyev.xmlparser.exception.TariffException;

import java.util.List;

public interface TariffParserBuilder
{
    TariffParserBuilder setPath(String path);
    TariffParserBuilder parse() throws TariffException;
    TariffParserBuilder collect() throws TariffException;
    List getResult();
}
