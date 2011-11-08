public class One {

  public static class First {
    public void method2() {
      System.out.println("First2");
    }
    public void method3() {
      method2();
    }
  }

  public static class Second extends First {
    public void method2() {
      System.out.println("Second2");
    }
  }

  public static class Third extends Second {
    public void method1() {
      System.out.println("Third1");
      super.method2();
    }
    public void method2() {
      System.out.println("Third2");
    }
  }

  public static class Fourth extends First {
    public void method1() {
      System.out.println("Fourth1");
    }
    public void method2() {
      System.out.println("Fourth2");
    }
  }

  public static void main(String[] args) {
    First  var1 = new Second();
    First  var2 = new Third();
    First  var3 = new Fourth();
    Second var4 = new Third();
    Object var5 = new Fourth();
    Object var6 = new Second();

    // var1.method2();
    // var2.method2();
    // var3.method2();
    // var4.method2();
    // var5.method2();
    // var6.method2();

    // var1.method3();
    // var2.method3();
    // var3.method3();
    // var4.method3();
    // var5.method3();
    // var6.method3();

    // ((Second) var4).method1();
    // ((Third)  var4).method1();
    // ((Second) var5).method2();
    // ((First)  var5).method3();
    // ((Third)  var5).method1();
    // ((First)  var6).method3();
    // ((Second) var6).method1();
    // ((Second  var6).method3();
  }
}









