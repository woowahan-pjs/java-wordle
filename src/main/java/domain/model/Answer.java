package domain.model;

public class Answer {

    private final String value;

    // 기본 생성자는 apple로 생성한다.
    public Answer(){
        this.value = "apple";
    }

    public Answer(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
