public class Main {

    public static void main(String []args){
        DataSource source = new CompressionDecorator(new EncryptionDecorator(new FileDataSource("text.txt")));
        source.writeData("Siema");
        System.out.println(source.readData());
    }
}
