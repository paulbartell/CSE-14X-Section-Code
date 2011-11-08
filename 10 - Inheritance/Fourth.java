public class Fourth {
  public static class Fee extends Fo {
    public void method1() {
      System.out.println("Fee 1");
      super.method3();
    }
  }

  public static class Fo {
    public void method3() {
      method1();
    }
    public void method1() {
      System.out.println("GARR");
    }
  }

  public static void main(String[] args) {
    Fo a = new Fee();
    a.method1();
  }
}
