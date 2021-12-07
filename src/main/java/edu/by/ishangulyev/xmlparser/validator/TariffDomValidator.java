package edu.by.ishangulyev.xmlparser.validator;

import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class TariffDomValidator
{
    public boolean isNodeValid(int i, NodeList childNodes)
    {
        return !childNodes.item(i).getTextContent().trim().isEmpty()
                && !((Text)childNodes.item(i).getFirstChild()).getData().isEmpty()
                && !((Text)childNodes.item(i).getFirstChild()).getData().trim().equals("\n");
    }
}
