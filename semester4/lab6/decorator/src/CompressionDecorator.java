public class CompressionDecorator extends DataSourceDecorator{
    public CompressionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        //compression
        super.writeData(data);
    }

    @Override
    public String readData() {
        //decompression
        return super.readData();
    }
}
