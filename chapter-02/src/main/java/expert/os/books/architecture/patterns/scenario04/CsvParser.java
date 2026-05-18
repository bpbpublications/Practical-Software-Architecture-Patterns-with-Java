package expert.os.books.architecture.patterns.scenario04;

class CsvParser extends DataParser {
    @Override
    protected String readData() { return "Alice,30"; }

    @Override
    protected void processData(String data) { System.out.println("Processing CSV: " + data); }
}