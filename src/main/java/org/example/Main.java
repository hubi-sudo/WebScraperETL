package org.example;

import com.opencsv.CSVWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("http://quotes.toscrape.com/").get();
            Elements quotesHtml = doc.select("div.quote");

            List <Quote> scrapedQuotes = new ArrayList<>();

            for (Element quoteHtml : quotesHtml) {
                String text = quoteHtml.select("span.text").text();
                String author = quoteHtml.select("small.author").text();

                Quote q = new Quote(text, author);
                scrapedQuotes.add(q);
            }

            System.out.println("Zakonczono pobieranie cytatow, liczba to " + scrapedQuotes.size());

            CSVWriter writer = new CSVWriter(new FileWriter("cytaty.csv"));
            writer.writeNext(new String[]{"Cytat","Autor"});

            for (Quote q : scrapedQuotes) {
                writer.writeNext(new String[] {q.text, q.author});
            }

            writer.close();
            System.out.println("Plik wygenerowany");


        }catch (Exception e) {
            System.out.println("wystapil blad");
            e.printStackTrace();
        }
       }
    }
