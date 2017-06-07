package chapter2.wordcount;

import java.text.BreakIterator;
import java.util.Iterator;

public class Words implements Iterable<String> {
    private final String text;
    public Words(String text){
        this.text =text;
    }
    private class WordIterator implements Iterator<String>{
        private BreakIterator wordboundary;
        private int start;
        private int end;
        public WordIterator(){
            wordboundary = BreakIterator.getCharacterInstance().getWordInstance();
            start = wordboundary.first();
            end = wordboundary.next();
        }
        public boolean hasNext(){return end != BreakIterator.DONE; }
        public String next(){
            String s = text.substring(start, end);
            start = end;
            end = wordboundary.next();
            return s;
        }
        public void remove(){throw new UnsupportedOperationException(); }
    }

    public Iterator<String> iterator(){
        return new WordIterator();
    }

}
