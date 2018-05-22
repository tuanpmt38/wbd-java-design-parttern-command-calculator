public class Calculator {
    private IOperator operator;

    public Calculator(IOperator operator){
        this.operator = operator;
    }
    public int excute (int firstnumber, int secondnumber){
        return operator.excute(firstnumber, secondnumber);
    }
}
