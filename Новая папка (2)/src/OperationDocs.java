import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.metadata.IIOMetadataNode;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sun.security.krb5.internal.AuthorizationData;

import java.time.LocalDate;

public class OperationDocs extends EntityDocument {

    private IIOMetadataNode doc;
    private AuthorizationData nodeList;

    public OperationDocs(int id, String title, String author, LocalDate creationDate, LocalDate registrationDate, String status) {
        super(id, title, author, creationDate, registrationDate, status);
    }

    private OperationDocs(int id, String title) {
        super(id, title);
    }



    private EntityDocument getDocument(Node node) {
        int i = 0;
        EntityDocument lang = new EntityDocument(super.getId(), super.getStatus());
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            lang.setId(Integer.parseInt(getTagValue("id", element)));
            lang.setStatus(getTagValue("status", element));
        }

        return lang;
    }


    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

    public int CountDocsbySA(int id, String status) {
        String filepath = "listdocs.xml";
        OperationDocs operationDocs = new OperationDocs(id, status);
        EntityDocument lang = new EntityDocument(id, status);
        List<List<String>> length = new ArrayList<>();
        length.add(List.of("id_doc", "Status_doc"));
        File xmlFile = new File(filepath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("ListDocs");


            List<String> langList = new ArrayList<String>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                langList.add(getId(), getStatus());
            }


            for (String lang1 : langList) {
                if (langList.toArray() == new String[]{"Approve"}) {

                }

                System.out.println(lang1.toString());
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return CountDocsbySA(id, status);
    }

    public static void OperationDocs(int id, String title, String author, LocalDate creationDate, LocalDate registrationDate, String status) {
        OperationDocs statusApprove = new OperationDocs(id, title, author, creationDate, registrationDate, status);

        //Операция по отбору докментов по дате
        statusApprove.CountDocsbySA(id, status);

    }


}
