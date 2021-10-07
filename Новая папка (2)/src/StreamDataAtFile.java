import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.time.LocalDate;
import java.io.*;

public class StreamDataAtFile extends EntityDocument {

    private String configFile;

    public StreamDataAtFile(int id, String title, String author, LocalDate creationDate, LocalDate registrationDate, String status) {
        super(id, title, author, creationDate, registrationDate, status);
    }

    public StreamDataAtFile(int id, String s, String author, String registrationDate1, String creationDate1, String title) {
        super(id, title);
    }



    public void saveConfig() throws Exception {

        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();

        XMLEventWriter eventWriter = outputFactory
                .createXMLEventWriter(new FileOutputStream("C:\\Users\\sdsoe\\Desktop\\Новая папка (2)\\src\\listdocs.xml"));

        XMLEventFactory eventFactory = XMLEventFactory.newInstance();
        XMLEvent end = eventFactory.createDTD("\n");

        StartDocument startDocument = eventFactory.createStartDocument();
        eventWriter.add(startDocument);

        StartElement configStartElement = eventFactory.createStartElement("",
                "", "doc");
        eventWriter.add(configStartElement);
        eventWriter.add(end);
        createNode(eventWriter, "id", "0");
        createNode(eventWriter, "titleDocument", "0");
        createNode(eventWriter, "authorDocument", "0");
        createNode(eventWriter, "datecreate", "0");
        createNode(eventWriter, "dateregistration", "0");
        createNode(eventWriter, "statusDocument", "0");
        eventWriter.add(eventFactory.createEndElement("", "", "doc"));
        eventWriter.add(end);
        eventWriter.add(eventFactory.createEndDocument());
        eventWriter.close();
    }

    public void createNode(XMLEventWriter eventWriter, String name,String value) throws XMLStreamException {
        XMLEventFactory eventFactory = XMLEventFactory.newInstance();
        XMLEvent end = eventFactory.createDTD("\n");
        XMLEvent tab = eventFactory.createDTD("\t");

        StartElement sElement = eventFactory.createStartElement("", "", name);
        eventWriter.add(tab);
        eventWriter.add(sElement);

        Characters characters = eventFactory.createCharacters(value);
        eventWriter.add(characters);

        EndElement eElement = eventFactory.createEndElement("", "ListDocs", name);
        eventWriter.add(eElement);
        eventWriter.add(end);
    }
}