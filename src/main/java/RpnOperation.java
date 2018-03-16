import java.util.ArrayDeque;
import java.util.Deque;

import static java.lang.Integer.parseInt;

class RpnOperation implements Operation {
    private final Deque<Operation> operations = new ArrayDeque<>();

    RpnOperation(String operations) {
        this(operations.split(" "));
    }

    private RpnOperation(String[] elements) {
        for (String element : elements) {
            Operation operation = operation(element);
            operations.push(operation);
        }
    }

    private Operation operation(String element) {
        return Operator.of(element)
                       .map(this::toOperation)
                       .orElse(() -> parseInt(element));
    }

    private Operation toOperation(Operator operator) {
        Operation second = operations.pop();
        Operation first = operations.pop();
        return operator.asOperation(first, second);
    }

    @Override
    public Integer calculate() {
        return operations.getFirst()
                         .calculate();
    }
}
