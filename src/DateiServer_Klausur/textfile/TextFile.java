package DateiServer_Klausur.textfile;

import java.util.Objects;

public class TextFile {

    private String filename;
    private String content;
    private int size;

    public TextFile(String filename, String content) {
        this.filename = filename;
        this.content = content;
        this.size = content.length();
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TextFile)) return false;
        TextFile textFile = (TextFile) o;
        return Objects.equals(filename, textFile.filename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filename);
    }

    public String getFilename() {
        return filename;
    }

    public String getContent() {
        return content;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "filename: " + filename + "size " + size + " \"Bytes\"";
    }
}
