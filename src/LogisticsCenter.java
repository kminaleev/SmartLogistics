import java.util.List;
public class LogisticsCenter {
    public void dispatch(List<ITrackable> tracked) {
        for (ITrackable vehicle : tracked) vehicle.sendStatusUpdate();
    }
    public void monitorFleet(List<ITrackable> tracked) {
        for (ITrackable vehicle : tracked)
            System.out.println(vehicle.getClass().getSimpleName() + ": " + vehicle.getCurrentCoordinates());
    }
}
