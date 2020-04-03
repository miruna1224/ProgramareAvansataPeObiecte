public class Todo extends Task {
    String content;
    boolean checked;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    Todo(){
        setChecked(false);
        setContent("");
    }
    Todo(String content){
        setChecked(false);
        setContent(content);
    }
    Todo(String content, boolean checked){
        setContent(content);
        setChecked(checked);
    }

    Todo(Todo x){
        setChecked(x.getChecked());
        setContent(x.getContent());
    }

    void showContent(){
        System.out.println("The task is " + getContent());
    }

    void showChecked(){
        showContent();
        if(getChecked())
            System.out.println("  That task is resolved");
        else System.out.println("   That task is not resolved");
    }
}
