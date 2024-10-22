interface Aircraft {
    void fly();
}
class Airplane implements Aircraft {
    @Override
    public void fly() {
        System.out.println("Самолет взлетел с взлетной полосы.");
    }
}
class Helicopter implements Aircraft {
    @Override
    public void fly() {
        System.out.println("Вертолет набирает высоту.");
    }
}
class Dirigible implements Aircraft {
    @Override
    public void fly() {
        System.out.println("Дирижабль медленно плывет по воздуху.");
    }
}
interface AircraftFactory {
    Aircraft createAircraft();
}
class AirplaneFactory implements AircraftFactory {
    @Override
    public Aircraft createAircraft() {
        return new Airplane();
    }
}
class HelicopterFactory implements AircraftFactory {
    @Override
    public Aircraft createAircraft() {
        return new Helicopter();
    }
}
class DirigibleFactory implements AircraftFactory {
    @Override
    public Aircraft createAircraft() {
        return new Dirigible();
    }
}
class AircraftManager {
    private AircraftFactory factory;
    public AircraftManager(AircraftFactory factory) {
        this.factory = factory;
    }
    public void manageAircraft() {
        Aircraft aircraft = factory.createAircraft();
        aircraft.fly();
    }
}
public class Main {
    public static void main(String[] args) {
        // Управление самолетом
        AircraftManager airplaneManager = new AircraftManager(new AirplaneFactory());
        airplaneManager.manageAircraft();
        AircraftManager helicopterManager = new AircraftManager(new HelicopterFactory());
        helicopterManager.manageAircraft();
        AircraftManager dirigibleManager = new AircraftManager(new DirigibleFactory());
        dirigibleManager.manageAircraft();
    }
}
