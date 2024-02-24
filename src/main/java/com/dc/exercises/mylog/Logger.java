package com.dc.exercises.mylog;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {

    private static Logger instance;

    private Logger(){}

    public static Logger getInstance() {
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }

    //Use console as default
    public void log(LogLevel logLevel, String message) throws LoggerException {
        if(logLevel != null && (!message.isEmpty() || !message.isBlank())) {
            writeLogToConsole(formatMessage(logLevel, message));
        }else{
            throw new LoggerException("LogLevel, message and logOutput are mandatory");
        }
    }

    //Select the output
    public void log(LogLevel logLevel, String message, LogOutput logOutput) throws LoggerException {
        if(logLevel != null && (!message.isEmpty() || !message.isBlank()) && logOutput != null) {
            if (logOutput.equals(LogOutput.CONSOLE))
                writeLogToConsole(formatMessage(logLevel, message));
            else if (logOutput.equals(LogOutput.JSON_FILE))
                writeLogToJsonFile(logLevel, message);
            else
                writeLogToXMLFile(logLevel, message);
        }else{
            throw new LoggerException("LogLevel, message and logOutput are mandatory");
        }
    }

    private void writeLogToConsole(String message) {
        System.out.println(message);
    }


    private void writeLogToJsonFile(LogLevel logLevel, String message) {
        JSONArray jsonArray;
        try {
            jsonArray = (JSONArray) new JSONParser().parse(new FileReader("log.json"));
        } catch (Exception exc) {
            //First time
            jsonArray = new JSONArray();
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("date", LocalDateTime.now().toString());
        jsonObject.put("logLevel", logLevel.toString());
        jsonObject.put("message", message);
        jsonArray.add(jsonObject);

        try (FileWriter file = new FileWriter("log.json", false)) {
            file.write(jsonArray.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void writeLogToXMLFile(LogLevel logLevel, String message) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc;

            try {
                doc = docBuilder.parse("log.xml");
            } catch (IOException e) {
                doc = docBuilder.newDocument();
                Element rootElement = doc.createElement("log");
                doc.appendChild(rootElement);
            }

            Element logElement = doc.createElement("entry");
            Element dateElement = doc.createElement("date");
            Element levelElement = doc.createElement("level");
            Element messageElement = doc.createElement("message");

            dateElement.appendChild(doc.createTextNode(LocalDateTime.now().toString()));
            levelElement.appendChild(doc.createTextNode(logLevel.toString()));
            messageElement.appendChild(doc.createTextNode(message));

            logElement.appendChild(dateElement);
            logElement.appendChild(levelElement);
            logElement.appendChild(messageElement);
            doc.getDocumentElement().appendChild(logElement);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new FileWriter("log.xml"));
            transformer.transform(source, result);
        } catch (ParserConfigurationException | IOException | org.xml.sax.SAXException | javax.xml.transform.TransformerException e) {
            e.printStackTrace();
        }
    }

    private String formatMessage(LogLevel logLevel, String message) {
        return "[" + LocalDateTime.now() + "] " + "[" + logLevel + "] " + "[" +  message + "]";
    }

}
