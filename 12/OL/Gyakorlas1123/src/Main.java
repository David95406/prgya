public class Main implements iAutomoso{
    public static void main(String[] args) {
        Jarmu testJarmu = new Jarmu(SZEMELYAUTO, "aaa-000", KULSO);
        System.out.println(testJarmu);

        Automoso a = new Automoso("Banki elit automoso");

        Mososor m1 = new Mososor();
        Mososor m2 = new Mososor();
        Mososor m3 = new Mososor();

        Jarmu j1 = new Jarmu(SZEMELYAUTO, "aaa-111", KULSO);
        Jarmu j2 = new Jarmu(BUSZ, "aaa-112", KULSO);
        Jarmu j3 = new Jarmu(TEHERAUTO, "aaa-113", KULSO);
        Jarmu j4 = new Jarmu(SZEMELYAUTO, "aaa-114", KULSO);

        m1.add(j1);
        m2.add(j2);
        m3.add(j3);
        m3.add(j4);

        a.add(m1);
        a.add(m2);
        a.add(m3);

        System.out.println(a);
    }
}