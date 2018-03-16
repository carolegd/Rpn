import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

class RpnOperation implements Operation {
    private final Deque<Operation> operations = new ArrayDeque<>();

    RpnOperation(String operations) {
        this(operations.split(" "));
    }

    private RpnOperation(String[] elements) {
        for (String element: elements) {
            Operation operation = operation(element);
            operations.push(operation);
        }
    }

    private Operation operation(String element) {
        Optional<Operator> maybeOperator = Operator.of(element);
        if (maybeOperator.isPresent()) {
            Operation second = operations.pop();
            Operation first = operations.pop();
            return maybeOperator.get().asOperation(first, second);
        } else {
            return () -> Integer.parseInt(element);
        }
    }

    @Override
    public Integer calculate() {
        return operations.getFirst().calculate();
    }
}
