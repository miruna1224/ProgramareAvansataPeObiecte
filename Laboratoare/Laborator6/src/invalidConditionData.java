public class invalidConditionData  extends Error{
    invalidConditionData(){
        super("Not a valid Condition");
        System.out.println("Not a valid condition");
    }
    invalidConditionData(String s){
        super(s);
        System.out.println(s);
    }
}
