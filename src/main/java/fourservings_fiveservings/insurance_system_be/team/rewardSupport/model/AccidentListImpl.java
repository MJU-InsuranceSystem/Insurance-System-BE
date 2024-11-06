package fourservings_fiveservings.insurance_system_be.team.rewardSupport.model;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author USER
 * @version 1.0
 */
public class AccidentListImpl implements AccidentList {
    public Accident accident;
    private static final ArrayList<Accident> accidentList = new ArrayList<>();
    private int generatorId = 0;

//    public AccidentListImpl() {
//        this.accidentList = new ArrayList<>();
//    }

    public void finalize() throws Throwable {
    }

    public boolean add(Accident accident) {
        if (accident != null) {
            accident.setId(generateId());
            accidentList.add(accident);
            return true;
        }
        return false;
    }

    public boolean delete(int accidentID) {
        return accidentList.removeIf(accident -> accident.getId() == accidentID);
    }

    public Accident read(int accidentID) {
        return accidentList.stream()
                .filter(accident -> accident.getId() == accidentID)
                .findFirst()
                .orElse(null);
    }

    public Accident update(int accidentID, Accident udateAccident) {
        IntStream.range(0, accidentList.size())
                .filter(i -> accidentList.get(i).getId() == accidentID)
                .findFirst()
                .ifPresent(i -> accidentList.set(i, udateAccident));
        return accidentList.stream()
                .filter(accident -> accident.getId() == accidentID)
                .findFirst()
                .orElse(null);
    }

    public List<Accident> getAllAccidents() {
        return new ArrayList<>(accidentList);
    }

    private int generateId() {
        return generatorId++;
    }
}