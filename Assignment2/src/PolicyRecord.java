import java.util.ArrayList;

public class PolicyRecord {
    private ArrayList<InsuredValue> insuredValueList;
    private ArrayList<Workplace> workplaceList;
    private ArrayList<Housing> housingList;
    private ArrayList<Person> personList;
    private ArrayList<Automobile> automobileList;
    private ArrayList<Truck> truckList;
    private ArrayList<InsuredValue> orderedInsuredValueList;

    public PolicyRecord(ArrayList<InsuredValue> insuredValueList) {
        this.insuredValueList = new ArrayList<>(insuredValueList);
        this.workplaceList = getWorkPlaceList();
        this.housingList = getHousingList();
        this.personList = getPersonList();
        this.automobileList = getAutomobileList();
        this.truckList = getTruckList();
        this.orderedInsuredValueList=getOrderedInsuredValueList();
    }

    public ArrayList<Workplace> getWorkPlaceList() {
        workplaceList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            if (insuredValueList.get(i) instanceof Workplace) {
                workplaceList.add((Workplace) insuredValueList.get(i));
            }
        }
        return workplaceList;
    }

    public ArrayList<Housing> getHousingList() {
        housingList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            if (insuredValueList.get(i) instanceof Housing) {
                housingList.add((Housing) insuredValueList.get(i));
            }
        }
        return housingList;
    }

    public ArrayList<Person> getPersonList() {
        personList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            if (insuredValueList.get(i) instanceof Person) {
                personList.add((Person) insuredValueList.get(i));
            }
        }
        return personList;
    }

    public ArrayList<Automobile> getAutomobileList() {
        automobileList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            if (insuredValueList.get(i) instanceof Automobile) {
                automobileList.add((Automobile) insuredValueList.get(i));
            }
        }
        return automobileList;
    }

    public ArrayList<Truck> getTruckList() {
        truckList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            if (insuredValueList.get(i) instanceof Truck) {
                truckList.add((Truck) insuredValueList.get(i));
            }
        }
        return truckList;
    }

    public ArrayList<InsuredValue> getOrderedInsuredValueList(){ // Gathers all arraylists that we classified from insured values into one arraylist named as orderedInsuredValueList.
        orderedInsuredValueList = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            orderedInsuredValueList.add(workplaceList.get(i));
        }
        for(int i = 0; i < 4; i++){
            orderedInsuredValueList.add(housingList.get(i));
        }
        for(int i = 0; i < 4; i++){
            orderedInsuredValueList.add(personList.get(i));
        }
        for(int i = 0; i < 4; i++){
            orderedInsuredValueList.add(automobileList.get(i));
        }
        for(int i = 0; i < 4; i++){
            orderedInsuredValueList.add(truckList.get(i));
        }
        return orderedInsuredValueList;
    }
}