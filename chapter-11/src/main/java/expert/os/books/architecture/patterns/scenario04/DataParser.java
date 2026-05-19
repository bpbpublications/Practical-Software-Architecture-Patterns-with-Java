package expert.os.books.architecture.patterns.scenario04;


abstract class DataParser {
    // The "Hollywood Principle" method. The framework controls the flow.
    public final void parseAndProcess() {
        String data = readData(); // Framework calls our custom code
        if (data != null) {
            processData(data);    // Framework calls our custom code
        }
        cleanup();
    }

    protected abstract String readData();
    protected abstract void processData(String data);
    private void cleanup() { System.out.println("Cleaning up resources..."); }
}