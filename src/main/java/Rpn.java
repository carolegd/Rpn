import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

class Rpn {
    public int calculate(String operations) {
        String[] elements = operations.split(" ");
        return calculate(asList(elements));
    }

    private int calculate(List<String> elements) {
        if (elements.size()==1){
            return Integer.parseInt(elements.get(0));
        }

        int operatorIndex = elements.indexOf("+");
        int operationResult;
        int firstOperand = Integer.parseInt(elements.get(operatorIndex - 2));
        int secondOperand = Integer.parseInt(elements.get(operatorIndex - 1));
        operationResult = firstOperand + secondOperand;

        List<String> subResult= new ArrayList<String>();
        List<String> beforeOperation = elements.subList(0, operatorIndex - 2);
        List<String> afterOperation = elements.subList(operatorIndex + 1, elements.size());
        subResult.addAll(beforeOperation);
        subResult.add(String.valueOf(operationResult));
        subResult.addAll(afterOperation);
        return calculate(subResult);

        }


}
