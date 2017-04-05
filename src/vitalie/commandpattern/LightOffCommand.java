package vitalie.commandpattern;

// Concrete Command
public class LightOffCommand implements Command {
    // Reference to the light
    Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.switchOff();
    }
}
