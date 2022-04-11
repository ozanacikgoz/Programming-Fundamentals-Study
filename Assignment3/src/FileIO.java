import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO<T> implements IFileIO {
    private List<T> allCargos;

    public FileIO() {
        this.allCargos = new ArrayList<>();
    }

    @Override
    public ArrayList filereader(String cargocsv) {
        int counter = 0;
        try{
            Scanner scanner = new Scanner(new File(cargocsv));
            scanner.useDelimiter("[\r\n]+");
            while (scanner.hasNext()) {
                String line = scanner.next();
                String[] lineSplit = line.split(";");
                String trimmedLineSplit = lineSplit[0].replaceAll("[\uFEFF-\uFFFF]","");
                counter++;
                if(trimmedLineSplit.equals("Normal")){
                    if(lineSplit[1].length() != 11){
                        throw new IDNotCorrectException(counter);
                    }
                    allCargos.add((T) normalCargoConstructor(lineSplit));
                }
                if(lineSplit[0].equals("Ecommerce")) {
                    switch (lineSplit[1]) {
                        case "Amazon":
                        case "N11":
                            if (lineSplit[2].length() != 7) {
                                throw new ECommerceCargoCodeFormatException(counter);
                            }
                            break;
                        case "HepsiBurada":
                        case "Trendyol":
                            if (lineSplit[2].length() != 8) {
                                throw new ECommerceCargoCodeFormatException(counter);
                            }
                            break;
                    }
                    allCargos.add((T) eCommerceCargoConstructor(lineSplit));
                }
            }
        }
        catch (IDNotCorrectException | ECommerceCargoCodeFormatException e){
            System.out.println(e.getMessage());
        }
        catch (FileNotFoundException e){
            System.out.println("File not found.");
        }
        return (ArrayList) allCargos;
    }
    private NormalCargo normalCargoConstructor(String[] data){
        String type = data[0];
        long senderID = Long.parseLong(data[1]);
        String senderName = data[2];
        String recipientName = data[3];
        String recipientAddress = data[4];
        int weight = Integer.parseInt(data[5]);
        int width = Integer.parseInt(data[6]);
        int length = Integer.parseInt(data[7]);
        int height = Integer.parseInt(data[8]);

        return new NormalCargo(type,senderID,senderName,recipientName,recipientAddress,weight,width,length,height);
    }
    private ECommerceCargo eCommerceCargoConstructor(String[] data){
        String type=data[0];
        String e_commerce_site_name = data[1];
        T cargo_code= (T) data[2];
        int weight = Integer.parseInt(data[3]);
        int width = Integer.parseInt(data[4]);
        int length = Integer.parseInt(data[5]);
        int height = Integer.parseInt(data[6]);

        return new ECommerceCargo(type,e_commerce_site_name,cargo_code,weight,width,length,height);
    }
}