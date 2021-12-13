package org.example.logic;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import org.example.domain.Sentence;
import org.example.domain.Text;
import org.example.domain.Word;

import java.io.StringWriter;
import java.util.ArrayList;

public class Converter {

    public String convertToXml(Text text) {
        try {
            StringWriter writer = new StringWriter();

            //Class converting objects into XML format
            JAXBContext jaxbContext = JAXBContext.newInstance(Text.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
            marshaller.marshal(text, writer);

            String result = writer.toString();

            return result;


        } catch (Exception e) {
            return e.toString();
        }
    }

    public String convertToCsv(Text text) {

        int longestSentenceLength = 0;
        int numberOfSentences = text.getSentence().size();

        StringBuilder sentencesAsCsv = new StringBuilder();

        //iterating sentence by sentence
        for(int i = 0; i < numberOfSentences; i++) {

            ArrayList<Word> processedSentence = text.getSentence().get(i).getWord();

            longestSentenceLength = Math.max(longestSentenceLength, processedSentence.size());

            StringBuilder sentenceString = new StringBuilder("\n" + Sentence.class.getSimpleName() + " " + (i + 1));

            //iterating over words inside sentence
            StringBuilder wordString = new StringBuilder();
            for (int j = 0; j < processedSentence.size(); j++) {

                wordString.append(", " + processedSentence.get(j).getWord());
            }

            sentenceString.append(wordString.toString());
            sentencesAsCsv.append(sentenceString.toString());
        }

        //creating csv header
        StringBuilder csvHeader = new StringBuilder();
        for (int i = 0; i < longestSentenceLength; i++) {

            String wordCounter = ", " + Word.class.getSimpleName() + " " + (i + 1);
            csvHeader.append(wordCounter);
        }

        String fullTextAsCsv = csvHeader.toString() + sentencesAsCsv.toString();

        return fullTextAsCsv;
    }
}
