public class Human {
  private String name;
  private int    age;
  private String guiltyPleasure;

  public Human() {
    age = 0;
  }

  public Human(String newName) {
    name = newName;
  }

  public void eat() {
    //Much hunger is satiated here
    System.out.println(this + " is eating");
  }

  public void sleep() {
    //Much Rest happens here
    System.out.println(this + " is sleeping");
  }

  public void getOlder() {
    age += 1;
  }

  public String toString() {
    return name + ", who is " + age + " enjoys " + guiltyPleasure;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  private String getGuiltyPleasure() {
    return guiltyPleasure;
  }


}
