package ru.epam.javacore.homework20191230.storage.initor.fileinitor;

import ru.epam.javacore.homework20191230.cargo.domain.Cargo;
import ru.epam.javacore.homework20191230.carrier.domain.Carrier;
import ru.epam.javacore.homework20191230.common.business.exception.checked.InitStorageException;
import ru.epam.javacore.homework20191230.common.solutions.utils.FileUtils;
import ru.epam.javacore.homework20191230.storage.initor.fileinitor.handlers.Handler;
import ru.epam.javacore.homework20191230.transportation.domain.Transportation;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class XmlSaxFileDataInitor extends BaseFileInitor {
    private final String path;

    public XmlSaxFileDataInitor(String path) {
        this.path = path;
    }

    @Override
    public void initStorage() throws InitStorageException {
        File file = null;
        try {
            file = getFileWithInitData();

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            Handler handler = new Handler();
            saxParser.parse(file, handler);
            Map<String, Cargo> cargoMap = handler.getCargoMap();
            Map<String, Carrier> carrierMap = handler.getCarrierMap();
            List<ParsedTransportation> transportations = handler.getTransportations();

            setReferencesBetweenEntities(cargoMap, carrierMap, transportations);

            persistCargos(cargoMap.values());
            persistCarriers(carrierMap.values());
            List<Transportation> transportationList = getTransportationsFromParsedObject(transportations);
            persistTransportations(transportationList);

        } catch (Exception e) {
            e.printStackTrace();
            throw new InitStorageException(e.getMessage());
        } finally {
            if (file != null) {
                file.delete();
            }
        }

    }

    private File getFileWithInitData() throws IOException {
        return FileUtils.createFileFromResource("input", "lesson11", path);
    }
}
