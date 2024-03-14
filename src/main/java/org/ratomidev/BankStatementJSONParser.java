package org.ratomidev;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sun.tools.jconsole.JConsoleContext;
import org.ratomidev.model.BankTransaction;

import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BankStatementJSONParser implements BankStatementParser{
    private static final DateTimeFormatter DATE_PATTERN
            = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private ObjectMapper objectMapper;

    private static final String RESOURCES = "src/main/resources/";
    public BankStatementJSONParser() {
        objectMapper = new ObjectMapper();


    }
    @Override
    public BankTransaction parseObject(Object object) {
        if(object != null && (object instanceof JsonNode)) {
            final JsonNode jsonNode = (JsonNode) object;
            final LocalDate date = LocalDate.parse(jsonNode.get("date").asText(), DATE_PATTERN);
            final Double amount = jsonNode.get("amount").asDouble();
            final String description = jsonNode.get("description").toString();
            return new BankTransaction(date, amount, description);

        }else {
            return null;
        }
    }

    @Override
    public List<BankTransaction> parseFile(String fileName) throws IOException {
        List<BankTransaction> result = new ArrayList<>();
        Path path = Paths.get(RESOURCES + fileName);
        String fileContent = Files.readString(path);

        JsonNode jsonNode = objectMapper.readTree(fileContent);

        for(JsonNode object: jsonNode) {
            result.add(parseObject(object));
        }
        return result;
    }
}
