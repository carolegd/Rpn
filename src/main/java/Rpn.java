import java.util.List;

import static java.util.Arrays.asList;

class Rpn {
    public int calculate(String operations) {
        List<String> elements = asList(operations.split(" "));
        return new RpnOperation(elements).calculate();
    }
}
