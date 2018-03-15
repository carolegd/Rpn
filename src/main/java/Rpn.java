import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

class Rpn {
    public int calculate(String operations) {
        String[] elements = operations.split(" ");
        return calculate(asList(elements));
    }

    private int calculate(List<String> elements) {
        if (elements.size() == 1) {
            return Integer.parseInt(elements.get(0));
        }

        List<String> operators = Operator.symbols();
        int operatorIndex = 0;
        Operator operator = null;
        for (int i = 0; i < elements.size(); i++) {
            if (operators.contains(elements.get(i))) {
                operatorIndex = i;
                operator = Operator.of(elements.get(i));
                break;
            }

        }

        int operationResult = operationResult(elements, operatorIndex, operator);
        List<String> subResult = toNewOperations(elements, operatorIndex, operationResult);
        return calculate(subResult);

    }

    private int operationResult(List<String> elements, int operatorIndex, Operator operator) {
        int firstOperand = Integer.parseInt(elements.get(operatorIndex - 2));
        int secondOperand = Integer.parseInt(elements.get(operatorIndex - 1));
        return operator.calculate(firstOperand, secondOperand);
    }

    private List<String> toNewOperations(List<String> elements, int operatorIndex, int operationResult) {
        List<String> subResult = new ArrayList<>();
        List<String> beforeOperation = elements.subList(0, operatorIndex - 2);
        List<String> afterOperation = elements.subList(operatorIndex + 1, elements.size());
        subResult.addAll(beforeOperation);
        subResult.add(String.valueOf(operationResult));
        subResult.addAll(afterOperation);
        return subResult;
    }


}
