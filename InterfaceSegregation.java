interface Device {

  void turnOff();

  void turnOn();
}

interface Light {

  void Dim();

  void Brighten();
}

interface SmartSpeaker {

  void PlayMusic();

  void StopMusic();
}

class SmartBulb implements Light, Device {

  public void turnOff() {
    System.out.println("You have turned off the Bulb");
  }

  public void turnOn() {
    System.out.println("You have turned on the Bulb");
  }

  public void Dim() {
    System.out.println("You have dimmed the light");
  }

  public void Brighten() {
    System.out.println("You have Brightened up the light");
  }

}

class SmartSwitch implements Device {
  public void turnOff() {
    System.out.println("You have turned off the Switch");
  }

  public void turnOn() {
    System.out.println("You have turned on the Switch");
  }
}

class SmartSpeakerDevice implements SmartSpeaker, Device {

  public void turnOn() {
    System.out.println("You have turned on the Speaker");
  }

  public void turnOff() {
    System.out.println("You have turned off the Speaker");
  }

  public void PlayMusic() {
    System.out.println("The music is being Played");
  }

  public void StopMusic() {
    System.out.println("The music has been stopped");
  }
}

public class InterfaceSegregation {
  public static void main(String[] args) {

    SmartSpeakerDevice speaker = new SmartSpeakerDevice();
    speaker.turnOn();
    speaker.PlayMusic();
    speaker.StopMusic();
    speaker.turnOff();

    SmartSwitch Switch = new SmartSwitch();
    Switch.turnOn();
    Switch.turnOff();

    SmartBulb Bulb = new SmartBulb();
    Bulb.turnOn();
    Bulb.Dim();
    Bulb.Brighten();
    Bulb.turnOff();
  }
}