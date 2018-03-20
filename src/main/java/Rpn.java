class Rpn {
    public int calculate(String operations) {
        return new RpnOperation(operations).calculate();
    }
}
