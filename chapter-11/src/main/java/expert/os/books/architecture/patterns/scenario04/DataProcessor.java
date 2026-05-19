package expert.os.books.architecture.patterns.scenario04;

class DataProcessor {
    private final DataReader reader;

    // Dependency Injection via constructor. We didn't create the reader inside!
    public DataProcessor(DataReader reader) {
        this.reader = reader;
    }

    // We still control the flow of execution here.
    public void process() {
        String data = reader.read();
        System.out.println("Processing: " + data);
    }
}
