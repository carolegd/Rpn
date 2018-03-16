import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public enum Operator {
    PLUS("+", (i, j) -> i + j),
    MINUS("-", (i, j) -> i - j),
    TIMES("x", (i, j) -> i * j),
    DIVIDE("/", (i, j) -> i / j);

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> operation;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public static Optional<Operator> of(String symbol) {
        return Stream.of(values())
                     .filter(operator -> operator.symbol.equals(symbol))
                     .findFirst();
    }

    public Operation asOperation(Operation first, Operation second) {
        return () -> operation.apply(first.calculate(), second.calculate());
    }
}
