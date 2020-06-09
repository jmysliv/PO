public class DataSourceDecorator implements DataSource{
    private DataSource source;

    public DataSourceDecorator(DataSource source) {
        this.source = source;
    }

    @Override
    public void writeData(String data) {
        this.source.writeData(data);
    }

    @Override
    public String readData() {
        return this.source.readData();
    }
}
