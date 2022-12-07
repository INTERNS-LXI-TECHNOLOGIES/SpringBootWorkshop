package com.lxisoft.dictionary.batch;

import com.lxisoft.dictionary.entity.Word;
import org.springframework.batch.item.ItemProcessor;

public class WordItemProcessor implements ItemProcessor<Word, Word> {

    @Override
    public Word process(final Word word) throws Exception
    {
        System.out.println("-----------Inside process(final Word word) method--------");
        final String name = word.getName().toUpperCase();
        final Word transformedWord = new Word(name, word.getMeaning(), word.getPartsOfSpeech());

        System.out.println("Converting (" + word + ") into (" + transformedWord + ")");
        return transformedWord;
    }
}
