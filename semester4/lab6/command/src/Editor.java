public class Editor {
    private String text;
    private int beginIndex;
    private int endIndex;

    public Editor(String text){
        this.text = text;
        this.beginIndex = 0;
        this.endIndex = -1;
    }

    public String getSelection() {
        try{
            return this.text.substring(beginIndex, endIndex);
        } catch(IndexOutOfBoundsException ignored){
            return "";
        }
    }

    public void deleteSelection(){
        try{
            this.text = this.text.substring(0, beginIndex) + this.text.substring(endIndex);
        } catch(IndexOutOfBoundsException ignored){
        }
        this.beginIndex = 0;
        this.endIndex = -1;
    }

    public void replaceSelection(String text){
        try{
            this.text = this.text.substring(0, beginIndex) + text + this.text.substring(endIndex);
        } catch(IndexOutOfBoundsException ignored){
        }
        this.beginIndex = 0;
        this.endIndex = -1;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        this.beginIndex = 0;
        this.endIndex = -1;
    }

    public void setSelection(int beginIndex, int endIndex) {
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
    }
}
