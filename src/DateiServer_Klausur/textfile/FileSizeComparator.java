package DateiServer_Klausur.textfile;

import java.util.Comparator;

public class FileSizeComparator implements Comparator<TextFile> {


    @Override
    public int compare(TextFile o1, TextFile o2) {

        int res = Integer.compare(o1.getSize(), o2.getSize());
        if (res == 0) {
            o1.getFilename().compareTo(o2.getFilename());
        }
        return res;
    }


}
