import java.util.ArrayList;

public interface IFileIO<T> {
    ArrayList<T> filereader(String cargocsv);
}