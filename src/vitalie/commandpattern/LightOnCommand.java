package vitalie.commandpattern;

// Concrete Command
public class LightOnCommand implements Command {
    // Reference to the light
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.switchOn();
    }
}
