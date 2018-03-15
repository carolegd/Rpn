import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
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

    public static List<String> symbols() {
        return Stream.of(values()).map(operator -> operator.symbol).collect(Collectors.toList());
    }

    public static Operator of(String symbol) {
        return Stream.of(values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int calculate(int firstOperand, int secondOperand) {
        return operation.apply(firstOperand, secondOperand);
    }
}
