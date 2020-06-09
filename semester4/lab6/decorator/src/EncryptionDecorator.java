public class EncryptionDecorator extends DataSourceDecorator {
    public EncryptionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        String encrypted = AES.encrypt(data, "secret");
        super.writeData(encrypted);
    }

    @Override
    public String readData() {
        String encrypted = super.readData();
        return AES.decrypt(encrypted, "secret");
    }
}
