package ceui.lisa.base;

public class Event {

    private String receiver;
    private Object content;

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String pReceiver) {
        receiver = pReceiver;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object pContent) {
        content = pContent;
    }
}
