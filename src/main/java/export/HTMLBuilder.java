package export;

public class HTMLBuilder {
    public static final String   NEXT_LINE       = "\n";
    public static final String   TAB             = "\t";

    private static final char   DELIMITER        = '"';

    public static final String HTML_START_TAG    = "<html>";
    public static final String HTML_END_TAG      = "</html>";

    public static final String BODY_START_TAG    = "<body>";
    public static final String BODY_END_TAG      = "</body>";

    private static final String HEADER_START_TAG = "<head>";
    private static final String HEADER_END_TAG   = "</head>";

    private StringBuilder document = new StringBuilder("");

    public void startHtmlDocument() {
        document.append(String.format("%s%s", HTML_START_TAG, NEXT_LINE));
    }

    public void closeHtmlDocument() {
        document.append(String.format("%s%s", NEXT_LINE, HTML_END_TAG));
    }

    public void openHeadTag() {
        document.append(String.format("%s%s", HEADER_START_TAG, NEXT_LINE));
    }

    public void closeHeadTag() {
        document.append(String.format("%s%s", HEADER_END_TAG, NEXT_LINE));
    }

    public void setStylesLink(String link) {
        String cssLink = "<link rel="+ DELIMITER +"stylesheet"+ DELIMITER +" type="+ DELIMITER +"text/css"+ DELIMITER +" href="+ DELIMITER + link + DELIMITER + ">" + NEXT_LINE;
        document.append(String.format("%s", cssLink));
    }

    public void setJavascriptLinks(String src) {
        String jsLink ="<script src="+ DELIMITER +src+ DELIMITER +"></script>"+NEXT_LINE;
        document.append(String.format("%s", jsLink));
    }

    public void openBody() {
        document.append(String.format("%s%s", BODY_START_TAG, NEXT_LINE));
    }

    public void closeBody() {
        document.append(String.format("%s%s", NEXT_LINE, BODY_END_TAG));
    }

    public void setBody(String tag) {
        document.append(String.format("%s",tag));
    }

    public void setData(String data) {
        document.append(data);
    }

    public String getDocumentResult() {
        return document.toString();
    }
}
